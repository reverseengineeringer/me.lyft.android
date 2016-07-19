package com.google.android.gms.internal;

import java.util.concurrent.Future;

@zzir
public abstract class zzkg
  implements zzkn<Future>
{
  private volatile Thread zzcko;
  private boolean zzckp;
  private final Runnable zzw = new Runnable()
  {
    public final void run()
    {
      zzkg.zza(zzkg.this, Thread.currentThread());
      zzew();
    }
  };
  
  public zzkg()
  {
    zzckp = false;
  }
  
  public zzkg(boolean paramBoolean)
  {
    zzckp = paramBoolean;
  }
  
  public final void cancel()
  {
    onStop();
    if (zzcko != null) {
      zzcko.interrupt();
    }
  }
  
  public abstract void onStop();
  
  public abstract void zzew();
  
  public final Future zzta()
  {
    if (zzckp) {
      return zzkk.zza(1, zzw);
    }
    return zzkk.zza(zzw);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */