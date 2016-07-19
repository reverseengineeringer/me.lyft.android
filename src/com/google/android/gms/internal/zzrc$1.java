package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import java.lang.ref.WeakReference;

class zzrc$1
  implements Runnable
{
  zzrc$1(zzrc paramzzrc, Result paramResult) {}
  
  public void run()
  {
    try
    {
      zzpt.sI.set(Boolean.valueOf(true));
      Object localObject1 = zzrc.zzc(vs).onSuccess(vr);
      zzrc.zzd(vs).sendMessage(zzrc.zzd(vs).obtainMessage(0, localObject1));
      zzpt.sI.set(Boolean.valueOf(false));
      zzrc.zza(vs, vr);
      localObject1 = (GoogleApiClient)zzrc.zze(vs).get();
      if (localObject1 != null) {
        ((GoogleApiClient)localObject1).zzb(vs);
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      zzrc.zzd(vs).sendMessage(zzrc.zzd(vs).obtainMessage(1, localRuntimeException));
      GoogleApiClient localGoogleApiClient1;
      return;
    }
    finally
    {
      zzpt.sI.set(Boolean.valueOf(false));
      zzrc.zza(vs, vr);
      GoogleApiClient localGoogleApiClient2 = (GoogleApiClient)zzrc.zze(vs).get();
      if (localGoogleApiClient2 != null) {
        localGoogleApiClient2.zzb(vs);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzrc.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */