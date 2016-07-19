package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.common.api.zzc;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

final class zzqh$zza
  extends PhantomReference<zzc<?>>
{
  private final int sn;
  
  public zzqh$zza(zzc paramzzc, int paramInt, ReferenceQueue<zzc<?>> paramReferenceQueue)
  {
    super(paramInt, localReferenceQueue);
    sn = paramReferenceQueue;
  }
  
  public void zzaqd()
  {
    zzqh.zza(uG).sendMessage(zzqh.zza(uG).obtainMessage(2, sn, 2));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqh.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */