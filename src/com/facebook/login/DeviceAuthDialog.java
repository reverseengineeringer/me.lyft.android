package com.facebook.login;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.R.id;
import com.facebook.R.layout;
import com.facebook.R.string;
import com.facebook.R.style;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.PermissionsPair;
import com.facebook.internal.Validate;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceAuthDialog
  extends DialogFragment
{
  private static final String DEVICE_LOGIN_ENDPOINT = "device/login";
  private static final String DEVICE_LOGIN_STATUS_ENDPOINT = "device/login_status";
  private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED = 1349173;
  private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING = 1349174;
  private static final int LOGIN_ERROR_SUBCODE_CODE_EXPIRED = 1349152;
  private static final int LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING = 1349172;
  private static final String REQUEST_STATE_KEY = "request_state";
  private AtomicBoolean completed = new AtomicBoolean();
  private TextView confirmationCode;
  private volatile GraphRequestAsyncTask currentGraphRequestPoll;
  private volatile RequestState currentRequestState;
  private DeviceAuthMethodHandler deviceAuthMethodHandler;
  private Dialog dialog;
  private boolean isBeingDestroyed = false;
  private ProgressBar progressBar;
  private volatile ScheduledFuture scheduledPoll;
  
  private GraphRequest getPollRequest()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("code", currentRequestState.getRequestCode());
    new GraphRequest(null, "device/login_status", localBundle, HttpMethod.POST, new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        if (completed.get()) {
          return;
        }
        FacebookRequestError localFacebookRequestError = paramAnonymousGraphResponse.getError();
        if (localFacebookRequestError != null)
        {
          switch (localFacebookRequestError.getSubErrorCode())
          {
          default: 
            DeviceAuthDialog.this.onError(paramAnonymousGraphResponse.getError().getException());
            return;
          case 1349172: 
          case 1349174: 
            DeviceAuthDialog.this.schedulePoll();
            return;
          }
          DeviceAuthDialog.this.onCancel();
          return;
        }
        try
        {
          paramAnonymousGraphResponse = paramAnonymousGraphResponse.getJSONObject();
          DeviceAuthDialog.this.onSuccess(paramAnonymousGraphResponse.getString("access_token"));
          return;
        }
        catch (JSONException paramAnonymousGraphResponse)
        {
          DeviceAuthDialog.this.onError(new FacebookException(paramAnonymousGraphResponse));
        }
      }
    });
  }
  
  private void onCancel()
  {
    if (!completed.compareAndSet(false, true)) {
      return;
    }
    if (deviceAuthMethodHandler != null) {
      deviceAuthMethodHandler.onCancel();
    }
    dialog.dismiss();
  }
  
  private void onError(FacebookException paramFacebookException)
  {
    if (!completed.compareAndSet(false, true)) {
      return;
    }
    deviceAuthMethodHandler.onError(paramFacebookException);
    dialog.dismiss();
  }
  
  private void onSuccess(final String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("fields", "id,permissions");
    new GraphRequest(new AccessToken(paramString, FacebookSdk.getApplicationId(), "0", null, null, null, null, null), "me", localBundle, HttpMethod.GET, new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        if (completed.get()) {
          return;
        }
        if (paramAnonymousGraphResponse.getError() != null)
        {
          DeviceAuthDialog.this.onError(paramAnonymousGraphResponse.getError().getException());
          return;
        }
        try
        {
          Object localObject = paramAnonymousGraphResponse.getJSONObject();
          paramAnonymousGraphResponse = ((JSONObject)localObject).getString("id");
          localObject = Utility.handlePermissionResponse((JSONObject)localObject);
          deviceAuthMethodHandler.onSuccess(paramString, FacebookSdk.getApplicationId(), paramAnonymousGraphResponse, ((Utility.PermissionsPair)localObject).getGrantedPermissions(), ((Utility.PermissionsPair)localObject).getDeclinedPermissions(), AccessTokenSource.DEVICE_AUTH, null, null);
          dialog.dismiss();
          return;
        }
        catch (JSONException paramAnonymousGraphResponse)
        {
          DeviceAuthDialog.this.onError(new FacebookException(paramAnonymousGraphResponse));
        }
      }
    }).executeAsync();
  }
  
  private void poll()
  {
    currentRequestState.setLastPoll(new Date().getTime());
    currentGraphRequestPoll = getPollRequest().executeAsync();
  }
  
  private void schedulePoll()
  {
    scheduledPoll = DeviceAuthMethodHandler.getBackgroundExecutor().schedule(new Runnable()
    {
      public void run()
      {
        DeviceAuthDialog.this.poll();
      }
    }, currentRequestState.getInterval(), TimeUnit.SECONDS);
  }
  
  private void setCurrentRequestState(RequestState paramRequestState)
  {
    currentRequestState = paramRequestState;
    confirmationCode.setText(paramRequestState.getUserCode());
    confirmationCode.setVisibility(0);
    progressBar.setVisibility(8);
    if (paramRequestState.withinLastRefreshWindow())
    {
      schedulePoll();
      return;
    }
    poll();
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    dialog = new Dialog(getActivity(), R.style.com_facebook_auth_dialog);
    paramBundle = getActivity().getLayoutInflater().inflate(R.layout.com_facebook_device_auth_dialog_fragment, null);
    progressBar = ((ProgressBar)paramBundle.findViewById(R.id.progress_bar));
    confirmationCode = ((TextView)paramBundle.findViewById(R.id.confirmation_code));
    ((Button)paramBundle.findViewById(R.id.cancel_button)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DeviceAuthDialog.this.onCancel();
      }
    });
    ((TextView)paramBundle.findViewById(R.id.com_facebook_device_auth_instructions)).setText(Html.fromHtml(getString(R.string.com_facebook_device_auth_instructions)));
    dialog.setContentView(paramBundle);
    return dialog;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    deviceAuthMethodHandler = ((DeviceAuthMethodHandler)((LoginFragment)((FacebookActivity)getActivity()).getCurrentFragment()).getLoginClient().getCurrentHandler());
    if (paramBundle != null)
    {
      paramViewGroup = (RequestState)paramBundle.getParcelable("request_state");
      if (paramViewGroup != null) {
        setCurrentRequestState(paramViewGroup);
      }
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    isBeingDestroyed = true;
    completed.set(true);
    super.onDestroy();
    if (currentGraphRequestPoll != null) {
      currentGraphRequestPoll.cancel(true);
    }
    if (scheduledPoll != null) {
      scheduledPoll.cancel(true);
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if (!isBeingDestroyed) {
      onCancel();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (currentRequestState != null) {
      paramBundle.putParcelable("request_state", currentRequestState);
    }
  }
  
  public void startLogin(LoginClient.Request paramRequest)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("scope", TextUtils.join(",", paramRequest.getPermissions()));
    paramRequest = paramRequest.getDeviceRedirectUriString();
    if (paramRequest != null) {
      localBundle.putString("redirect_uri", paramRequest);
    }
    localBundle.putString("access_token", Validate.hasAppID() + "|" + Validate.hasClientToken());
    new GraphRequest(null, "device/login", localBundle, HttpMethod.POST, new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        if (paramAnonymousGraphResponse.getError() != null)
        {
          DeviceAuthDialog.this.onError(paramAnonymousGraphResponse.getError().getException());
          return;
        }
        paramAnonymousGraphResponse = paramAnonymousGraphResponse.getJSONObject();
        DeviceAuthDialog.RequestState localRequestState = new DeviceAuthDialog.RequestState();
        try
        {
          localRequestState.setUserCode(paramAnonymousGraphResponse.getString("user_code"));
          localRequestState.setRequestCode(paramAnonymousGraphResponse.getString("code"));
          localRequestState.setInterval(paramAnonymousGraphResponse.getLong("interval"));
          DeviceAuthDialog.this.setCurrentRequestState(localRequestState);
          return;
        }
        catch (JSONException paramAnonymousGraphResponse)
        {
          DeviceAuthDialog.this.onError(new FacebookException(paramAnonymousGraphResponse));
        }
      }
    }).executeAsync();
  }
  
  private static class RequestState
    implements Parcelable
  {
    public static final Parcelable.Creator<RequestState> CREATOR = new Parcelable.Creator()
    {
      public DeviceAuthDialog.RequestState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new DeviceAuthDialog.RequestState(paramAnonymousParcel);
      }
      
      public DeviceAuthDialog.RequestState[] newArray(int paramAnonymousInt)
      {
        return new DeviceAuthDialog.RequestState[paramAnonymousInt];
      }
    };
    private long interval;
    private long lastPoll;
    private String requestCode;
    private String userCode;
    
    RequestState() {}
    
    protected RequestState(Parcel paramParcel)
    {
      userCode = paramParcel.readString();
      requestCode = paramParcel.readString();
      interval = paramParcel.readLong();
      lastPoll = paramParcel.readLong();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public long getInterval()
    {
      return interval;
    }
    
    public String getRequestCode()
    {
      return requestCode;
    }
    
    public String getUserCode()
    {
      return userCode;
    }
    
    public void setInterval(long paramLong)
    {
      interval = paramLong;
    }
    
    public void setLastPoll(long paramLong)
    {
      lastPoll = paramLong;
    }
    
    public void setRequestCode(String paramString)
    {
      requestCode = paramString;
    }
    
    public void setUserCode(String paramString)
    {
      userCode = paramString;
    }
    
    public boolean withinLastRefreshWindow()
    {
      if (lastPoll == 0L) {}
      while (new Date().getTime() - lastPoll - interval * 1000L >= 0L) {
        return false;
      }
      return true;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(userCode);
      paramParcel.writeString(requestCode);
      paramParcel.writeLong(interval);
      paramParcel.writeLong(lastPoll);
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.DeviceAuthDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */