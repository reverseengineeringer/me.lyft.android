package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class zzqd$zza
  extends Handler
{
  zzqd$zza(zzqd paramzzqd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (what)
    {
    default: 
      int i = what;
      Log.w("GoogleApiClientImpl", 31 + "Unknown message id: " + i);
      return;
    case 1: 
      zzqd.zzb(ug);
      return;
    }
    zzqd.zza(ug);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqd.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */