package me.lyft.android.infrastructure.googleplay;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.wallet.Wallet;
import com.google.android.gms.wallet.Wallet.WalletOptions.Builder;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.infrastructure.activity.ActivityService;
import me.lyft.android.utils.ActivityResult;

public class GoogleApiProvider
  extends ActivityService
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, IGoogleApiProvider
{
  private static final String STATE_RESOLVING_ERROR = "resolving_error";
  private GoogleApiClient googleApiClient;
  private final ILyftPreferences lyftPreferences;
  private boolean resolvingError = false;
  
  public GoogleApiProvider(ILyftPreferences paramILyftPreferences)
  {
    lyftPreferences = paramILyftPreferences;
  }
  
  public boolean checkGooglePlayServicesAvailable()
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getCurrentActivity());
    if (i == 0) {
      return true;
    }
    showGooglePlayErrorDialog(i);
    return false;
  }
  
  public GoogleApiClient getApi()
  {
    return googleApiClient;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    boolean bool = true;
    super.onActivityCreated(paramActivity, paramBundle);
    int i;
    if (lyftPreferences.isProductionEnvironment())
    {
      i = 1;
      googleApiClient = new GoogleApiClient.Builder(paramActivity).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(Wallet.API, new Wallet.WalletOptions.Builder().setEnvironment(i).setTheme(1).build()).addApi(LocationServices.API).addApi(Places.GEO_DATA_API).addApi(Places.PLACE_DETECTION_API).build();
      if ((paramBundle == null) || (!paramBundle.getBoolean("resolving_error", false))) {
        break label114;
      }
    }
    for (;;)
    {
      resolvingError = bool;
      return;
      i = 3;
      break;
      label114:
      bool = false;
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    googleApiClient = null;
  }
  
  public void onActivityResult(Activity paramActivity, ActivityResult paramActivityResult)
  {
    super.onActivityResult(paramActivity, paramActivityResult);
    if (paramActivityResult.getRequestCode() == 17)
    {
      resolvingError = false;
      if ((paramActivityResult.getResultCode() == -1) && (!googleApiClient.isConnecting()) && (!googleApiClient.isConnected())) {
        googleApiClient.connect();
      }
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivitySaveInstanceState(paramActivity, paramBundle);
    paramBundle.putBoolean("resolving_error", resolvingError);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    super.onActivityStarted(paramActivity);
    googleApiClient.connect();
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    googleApiClient.disconnect();
  }
  
  public void onConnected(Bundle paramBundle) {}
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    if (resolvingError) {
      return;
    }
    if (paramConnectionResult.hasResolution()) {
      try
      {
        resolvingError = true;
        paramConnectionResult.startResolutionForResult(getCurrentActivity(), 17);
        return;
      }
      catch (IntentSender.SendIntentException paramConnectionResult)
      {
        googleApiClient.connect();
        return;
      }
    }
    showGooglePlayErrorDialog(paramConnectionResult.getErrorCode());
    resolvingError = true;
  }
  
  public void onConnectionSuspended(int paramInt) {}
  
  public void showGooglePlayErrorDialog(int paramInt)
  {
    Dialog localDialog = GooglePlayServicesUtil.getErrorDialog(paramInt, getCurrentActivity(), 17);
    localDialog.setCancelable(true);
    localDialog.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        getCurrentActivity().finish();
      }
    });
    localDialog.show();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googleplay.GoogleApiProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */