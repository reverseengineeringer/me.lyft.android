package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzap;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzir;

@zzir
public final class VideoController
{
  private final Object zzail = new Object();
  private com.google.android.gms.ads.internal.client.zzab zzaim;
  private VideoLifecycleCallbacks zzain;
  
  public void setVideoLifecycleCallbacks(VideoLifecycleCallbacks paramVideoLifecycleCallbacks)
  {
    com.google.android.gms.common.internal.zzab.zzb(paramVideoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
    synchronized (zzail)
    {
      zzain = paramVideoLifecycleCallbacks;
      if (zzaim == null) {
        return;
      }
    }
    try
    {
      zzaim.zza(new zzap(paramVideoLifecycleCallbacks));
      return;
      paramVideoLifecycleCallbacks = finally;
      throw paramVideoLifecycleCallbacks;
    }
    catch (RemoteException paramVideoLifecycleCallbacks)
    {
      for (;;)
      {
        zzb.zzb("Unable to call setVideoLifecycleCallbacks on video controller.", paramVideoLifecycleCallbacks);
      }
    }
  }
  
  public void zza(com.google.android.gms.ads.internal.client.zzab paramzzab)
  {
    synchronized (zzail)
    {
      zzaim = paramzzab;
      if (zzain != null) {
        setVideoLifecycleCallbacks(zzain);
      }
      return;
    }
  }
  
  public static abstract class VideoLifecycleCallbacks
  {
    public void onVideoEnd() {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.VideoController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */