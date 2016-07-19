package com.google.android.gms.ads.internal.overlay;

import android.os.Handler;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkl;

@zzir
class zzy
  implements Runnable
{
  private boolean mCancelled = false;
  private zzk zzbwj;
  
  zzy(zzk paramzzk)
  {
    zzbwj = paramzzk;
  }
  
  public void cancel()
  {
    mCancelled = true;
    zzkl.zzclg.removeCallbacks(this);
  }
  
  public void run()
  {
    if (!mCancelled)
    {
      zzbwj.zzoq();
      zzpm();
    }
  }
  
  public void zzpm()
  {
    zzkl.zzclg.postDelayed(this, 250L);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */