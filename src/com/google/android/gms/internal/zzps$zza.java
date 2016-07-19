package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Dialog;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

class zzps$zza
  implements Runnable
{
  private zzps$zza(zzps paramzzps) {}
  
  public void run()
  {
    if (!sF.mStarted) {
      return;
    }
    if (zzps.zza(sF).hasResolution())
    {
      sF.va.startActivityForResult(GoogleApiActivity.zzb(sF.getActivity(), zzps.zza(sF).getResolution(), zzps.zzb(sF), false), 1);
      return;
    }
    if (sF.rX.isUserResolvableError(zzps.zza(sF).getErrorCode()))
    {
      sF.rX.zza(sF.getActivity(), sF.va, zzps.zza(sF).getErrorCode(), 2, sF);
      return;
    }
    if (zzps.zza(sF).getErrorCode() == 18)
    {
      final Dialog localDialog = sF.rX.zza(sF.getActivity(), sF);
      sF.rX.zza(sF.getActivity().getApplicationContext(), new zzqj.zza()
      {
        public void zzaor()
        {
          sF.zzaoq();
          if (localDialog.isShowing()) {
            localDialog.dismiss();
          }
        }
      });
      return;
    }
    sF.zza(zzps.zza(sF), zzps.zzb(sF));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzps.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */