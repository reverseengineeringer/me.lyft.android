package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class zzpt$zza<R extends Result>
  extends Handler
{
  public zzpt$zza()
  {
    this(Looper.getMainLooper());
  }
  
  public zzpt$zza(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (what)
    {
    default: 
      int i = what;
      Log.wtf("BasePendingResult", 45 + "Don't know how to handle message: " + i, new Exception());
      return;
    case 1: 
      paramMessage = (Pair)obj;
      zzb((ResultCallback)first, (Result)second);
      return;
    }
    ((zzpt)obj).zzaa(Status.sj);
  }
  
  public void zza(ResultCallback<? super R> paramResultCallback, R paramR)
  {
    sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
  }
  
  public void zzaow()
  {
    removeMessages(2);
  }
  
  protected void zzb(ResultCallback<? super R> paramResultCallback, R paramR)
  {
    try
    {
      paramResultCallback.onResult(paramR);
      return;
    }
    catch (RuntimeException paramResultCallback)
    {
      zzpt.zze(paramR);
      throw paramResultCallback;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpt.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */