package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;

class zzvv$zzc$1
  extends zzvv.zza
{
  zzvv$zzc$1(zzvv.zzc paramzzc) {}
  
  public void zza(Status paramStatus, GoogleNowAuthState paramGoogleNowAuthState)
  {
    if (zzvv.zzc.zza(aue)) {
      Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
    }
    aue.zzc(new zzvv.zzd(paramStatus, paramGoogleNowAuthState));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzvv.zzc.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */