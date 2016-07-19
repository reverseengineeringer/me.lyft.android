package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzd.zzf;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

class zzqb$zza
  implements zzd.zzf
{
  private final Api<?> pD;
  private final int sV;
  private final WeakReference<zzqb> tH;
  
  public zzqb$zza(zzqb paramzzqb, Api<?> paramApi, int paramInt)
  {
    tH = new WeakReference(paramzzqb);
    pD = paramApi;
    sV = paramInt;
  }
  
  public void zzh(ConnectionResult paramConnectionResult)
  {
    boolean bool = false;
    zzqb localzzqb = (zzqb)tH.get();
    if (localzzqb == null) {
      return;
    }
    if (Looper.myLooper() == zzdsX.getLooper()) {
      bool = true;
    }
    zzab.zza(bool, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
    zzqb.zzc(localzzqb).lock();
    try
    {
      bool = zzqb.zza(localzzqb, 0);
      if (!bool) {
        return;
      }
      if (!paramConnectionResult.isSuccess()) {
        zzqb.zza(localzzqb, paramConnectionResult, pD, sV);
      }
      if (zzqb.zzk(localzzqb)) {
        zzqb.zzj(localzzqb);
      }
      return;
    }
    finally
    {
      zzqb.zzc(localzzqb).unlock();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqb.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */