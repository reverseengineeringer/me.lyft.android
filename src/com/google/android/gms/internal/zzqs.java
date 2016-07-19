package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Message;
import com.google.android.gms.common.internal.zzab;

public final class zzqs<L>
{
  private volatile L mListener;
  private final zza vg;
  
  public void clear()
  {
    mListener = null;
  }
  
  public void zza(zzb<? super L> paramzzb)
  {
    zzab.zzb(paramzzb, "Notifier must not be null");
    paramzzb = vg.obtainMessage(1, paramzzb);
    vg.sendMessage(paramzzb);
  }
  
  void zzb(zzb<? super L> paramzzb)
  {
    Object localObject = mListener;
    if (localObject == null)
    {
      paramzzb.zzapg();
      return;
    }
    try
    {
      paramzzb.zzu(localObject);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramzzb.zzapg();
      throw localRuntimeException;
    }
  }
  
  private final class zza
    extends Handler
  {
    public void handleMessage(Message paramMessage)
    {
      boolean bool = true;
      if (what == 1) {}
      for (;;)
      {
        zzab.zzbn(bool);
        vh.zzb((zzqs.zzb)obj);
        return;
        bool = false;
      }
    }
  }
  
  public static abstract interface zzb<L>
  {
    public abstract void zzapg();
    
    public abstract void zzu(L paramL);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */