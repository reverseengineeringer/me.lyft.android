package com.facebook.share.internal;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.R.id;
import com.facebook.R.layout;
import com.facebook.R.string;
import com.facebook.R.style;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceShareDialogFragment
  extends DialogFragment
{
  private static final String DEVICE_SHARE_ENDPOINT = "device/share";
  private static final String REQUEST_STATE_KEY = "request_state";
  public static final String TAG = "DeviceShareDialogFragment";
  private static ScheduledThreadPoolExecutor backgroundExecutor;
  private volatile ScheduledFuture codeExpiredFuture;
  private TextView confirmationCode;
  private volatile RequestState currentRequestState;
  private Dialog dialog;
  private ProgressBar progressBar;
  private ShareContent shareContent;
  
  private void detach()
  {
    if (isAdded()) {
      getFragmentManager().beginTransaction().remove(this).commit();
    }
  }
  
  private void finishActivity(int paramInt, Intent paramIntent)
  {
    if (isAdded())
    {
      FragmentActivity localFragmentActivity = getActivity();
      localFragmentActivity.setResult(paramInt, paramIntent);
      localFragmentActivity.finish();
    }
  }
  
  private void finishActivityWithError(FacebookRequestError paramFacebookRequestError)
  {
    detach();
    Intent localIntent = new Intent();
    localIntent.putExtra("error", paramFacebookRequestError);
    finishActivity(-1, localIntent);
  }
  
  private static ScheduledThreadPoolExecutor getBackgroundExecutor()
  {
    try
    {
      if (backgroundExecutor == null) {
        backgroundExecutor = new ScheduledThreadPoolExecutor(1);
      }
      ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = backgroundExecutor;
      return localScheduledThreadPoolExecutor;
    }
    finally {}
  }
  
  private Bundle getGraphParametersForShareContent()
  {
    ShareContent localShareContent = shareContent;
    if (localShareContent == null) {}
    do
    {
      return null;
      if ((localShareContent instanceof ShareLinkContent)) {
        return WebDialogParameters.create((ShareLinkContent)localShareContent);
      }
    } while (!(localShareContent instanceof ShareOpenGraphContent));
    return WebDialogParameters.create((ShareOpenGraphContent)localShareContent);
  }
  
  private void setCurrentRequestState(RequestState paramRequestState)
  {
    currentRequestState = paramRequestState;
    confirmationCode.setText(paramRequestState.getUserCode());
    confirmationCode.setVisibility(0);
    progressBar.setVisibility(8);
    codeExpiredFuture = getBackgroundExecutor().schedule(new Runnable()
    {
      public void run()
      {
        dialog.dismiss();
      }
    }, paramRequestState.getExpiresIn(), TimeUnit.SECONDS);
  }
  
  private void startShare()
  {
    Bundle localBundle = getGraphParametersForShareContent();
    if ((localBundle == null) || (localBundle.size() == 0)) {
      finishActivityWithError(new FacebookRequestError(0, "", "Failed to get share content"));
    }
    localBundle.putString("access_token", Validate.hasAppID() + "|" + Validate.hasClientToken());
    new GraphRequest(null, "device/share", localBundle, HttpMethod.POST, new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        Object localObject = paramAnonymousGraphResponse.getError();
        if (localObject != null)
        {
          DeviceShareDialogFragment.this.finishActivityWithError((FacebookRequestError)localObject);
          return;
        }
        paramAnonymousGraphResponse = paramAnonymousGraphResponse.getJSONObject();
        localObject = new DeviceShareDialogFragment.RequestState();
        try
        {
          ((DeviceShareDialogFragment.RequestState)localObject).setUserCode(paramAnonymousGraphResponse.getString("user_code"));
          ((DeviceShareDialogFragment.RequestState)localObject).setExpiresIn(paramAnonymousGraphResponse.getLong("expires_in"));
          DeviceShareDialogFragment.this.setCurrentRequestState((DeviceShareDialogFragment.RequestState)localObject);
          return;
        }
        catch (JSONException paramAnonymousGraphResponse)
        {
          DeviceShareDialogFragment.this.finishActivityWithError(new FacebookRequestError(0, "", "Malformed server response"));
        }
      }
    }).executeAsync();
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
        dialog.dismiss();
      }
    });
    ((TextView)paramBundle.findViewById(R.id.com_facebook_device_auth_instructions)).setText(Html.fromHtml(getString(R.string.com_facebook_device_auth_instructions)));
    ((TextView)paramBundle.findViewById(R.id.com_facebook_device_dialog_title)).setText(getString(R.string.com_facebook_share_button_text));
    dialog.setContentView(paramBundle);
    startShare();
    return dialog;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (paramBundle != null)
    {
      paramViewGroup = (RequestState)paramBundle.getParcelable("request_state");
      if (paramViewGroup != null) {
        setCurrentRequestState(paramViewGroup);
      }
    }
    return paramLayoutInflater;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if (codeExpiredFuture != null) {
      codeExpiredFuture.cancel(true);
    }
    finishActivity(-1, new Intent());
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (currentRequestState != null) {
      paramBundle.putParcelable("request_state", currentRequestState);
    }
  }
  
  public void setShareContent(ShareContent paramShareContent)
  {
    shareContent = paramShareContent;
  }
  
  private static class RequestState
    implements Parcelable
  {
    public static final Parcelable.Creator<RequestState> CREATOR = new Parcelable.Creator()
    {
      public DeviceShareDialogFragment.RequestState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new DeviceShareDialogFragment.RequestState(paramAnonymousParcel);
      }
      
      public DeviceShareDialogFragment.RequestState[] newArray(int paramAnonymousInt)
      {
        return new DeviceShareDialogFragment.RequestState[paramAnonymousInt];
      }
    };
    private long expiresIn;
    private String userCode;
    
    RequestState() {}
    
    protected RequestState(Parcel paramParcel)
    {
      userCode = paramParcel.readString();
      expiresIn = paramParcel.readLong();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public long getExpiresIn()
    {
      return expiresIn;
    }
    
    public String getUserCode()
    {
      return userCode;
    }
    
    public void setExpiresIn(long paramLong)
    {
      expiresIn = paramLong;
    }
    
    public void setUserCode(String paramString)
    {
      userCode = paramString;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(userCode);
      paramParcel.writeLong(expiresIn);
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.DeviceShareDialogFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */