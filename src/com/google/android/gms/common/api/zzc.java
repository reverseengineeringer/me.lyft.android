package com.google.android.gms.common.api;

import android.content.Context;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.internal.zzqt;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzc<O extends Api.ApiOptions>
{
  private final Context mContext;
  private final int mId;
  private final Api<O> pD;
  private final zzqt rE;
  private final O rF;
  private final zzpo<O> rG;
  private final zzqh rH;
  private final AtomicBoolean rJ;
  private final AtomicInteger rK;
  
  public Context getApplicationContext()
  {
    return mContext;
  }
  
  public void release()
  {
    boolean bool = true;
    if (rJ.getAndSet(true)) {
      return;
    }
    rE.release();
    zzqh localzzqh = rH;
    int i = mId;
    if (rK.get() > 0) {}
    for (;;)
    {
      localzzqh.zzd(i, bool);
      return;
      bool = false;
    }
  }
  
  public Api<O> zzanw()
  {
    return pD;
  }
  
  public O zzanx()
  {
    return rF;
  }
  
  public zzpo<O> zzany()
  {
    return rG;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */