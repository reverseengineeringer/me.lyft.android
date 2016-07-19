package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class zzqf$zzb
  extends Handler
{
  zzqf$zzb(zzqf paramzzqf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (what)
    {
    default: 
      int i = what;
      Log.w("GACStateManager", 31 + "Unknown message id: " + i);
      return;
    case 1: 
      ((zzqf.zza)obj).zzd(ut);
      return;
    }
    throw ((RuntimeException)obj);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqf.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */