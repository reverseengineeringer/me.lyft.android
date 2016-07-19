package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public final class zzd$zzg
  extends zzt.zza
{
  private zzd xx;
  private final int xy;
  
  public zzd$zzg(zzd paramzzd, int paramInt)
  {
    xx = paramzzd;
    xy = paramInt;
  }
  
  private void zzasd()
  {
    xx = null;
  }
  
  public void zza(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    zzab.zzb(xx, "onPostInitComplete can be called only once per call to getRemoteService");
    xx.zza(paramInt, paramIBinder, paramBundle, xy);
    zzasd();
  }
  
  public void zzb(int paramInt, Bundle paramBundle)
  {
    Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzd.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */