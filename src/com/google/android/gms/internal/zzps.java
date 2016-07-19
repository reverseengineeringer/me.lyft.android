package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

public abstract class zzps
  extends zzqo
  implements DialogInterface.OnCancelListener
{
  protected boolean mStarted;
  protected final GoogleApiAvailability rX;
  protected boolean sB;
  private ConnectionResult sC;
  private int sD = -1;
  private final Handler sE = new Handler(Looper.getMainLooper());
  
  protected zzps(zzqp paramzzqp)
  {
    this(paramzzqp, GoogleApiAvailability.getInstance());
  }
  
  zzps(zzqp paramzzqp, GoogleApiAvailability paramGoogleApiAvailability)
  {
    super(paramzzqp);
    rX = paramGoogleApiAvailability;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    int j = 1;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      if (paramInt1 != 0)
      {
        zzaoq();
        return;
      }
      break;
    case 2: 
      label30:
      j = rX.isGooglePlayServicesAvailable(getActivity());
      if (j != 0) {}
      break;
    }
    for (paramInt2 = i;; paramInt2 = 0)
    {
      paramInt1 = paramInt2;
      if (sC.getErrorCode() != 18) {
        break label30;
      }
      paramInt1 = paramInt2;
      if (j != 18) {
        break label30;
      }
      return;
      paramInt1 = j;
      if (paramInt2 == -1) {
        break label30;
      }
      if (paramInt2 != 0) {
        break;
      }
      if (paramIntent != null) {}
      for (paramInt1 = paramIntent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);; paramInt1 = 13)
      {
        sC = new ConnectionResult(paramInt1, null);
        break;
        zza(sC, sD);
        return;
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    zza(new ConnectionResult(13, null), sD);
    zzaoq();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      sB = paramBundle.getBoolean("resolving_error", false);
      if (sB)
      {
        sD = paramBundle.getInt("failed_client_id", -1);
        sC = new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution"));
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("resolving_error", sB);
    if (sB)
    {
      paramBundle.putInt("failed_client_id", sD);
      paramBundle.putInt("failed_status", sC.getErrorCode());
      paramBundle.putParcelable("failed_resolution", sC.getResolution());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    mStarted = true;
  }
  
  public void onStop()
  {
    super.onStop();
    mStarted = false;
  }
  
  protected abstract void zza(ConnectionResult paramConnectionResult, int paramInt);
  
  protected abstract void zzaol();
  
  protected void zzaoq()
  {
    sD = -1;
    sB = false;
    sC = null;
    zzaol();
  }
  
  public void zzb(ConnectionResult paramConnectionResult, int paramInt)
  {
    if (!sB)
    {
      sB = true;
      sD = paramInt;
      sC = paramConnectionResult;
      sE.post(new zza(null));
    }
  }
  
  private class zza
    implements Runnable
  {
    private zza() {}
    
    public void run()
    {
      if (!mStarted) {
        return;
      }
      if (zzps.zza(zzps.this).hasResolution())
      {
        va.startActivityForResult(GoogleApiActivity.zzb(getActivity(), zzps.zza(zzps.this).getResolution(), zzps.zzb(zzps.this), false), 1);
        return;
      }
      if (rX.isUserResolvableError(zzps.zza(zzps.this).getErrorCode()))
      {
        rX.zza(getActivity(), va, zzps.zza(zzps.this).getErrorCode(), 2, zzps.this);
        return;
      }
      if (zzps.zza(zzps.this).getErrorCode() == 18)
      {
        final Dialog localDialog = rX.zza(getActivity(), zzps.this);
        rX.zza(getActivity().getApplicationContext(), new zzqj.zza()
        {
          public void zzaor()
          {
            zzaoq();
            if (localDialog.isShowing()) {
              localDialog.dismiss();
            }
          }
        });
        return;
      }
      zza(zzps.zza(zzps.this), zzps.zzb(zzps.this));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzps
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */