package com.google.android.gms.ads.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import java.lang.ref.WeakReference;

@zzir
public class zzr
{
  private final zza zzamz;
  private AdRequestParcel zzana;
  private boolean zzanb = false;
  private boolean zzanc = false;
  private long zzand = 0L;
  private final Runnable zzw;
  
  public zzr(zza paramzza)
  {
    this(paramzza, new zza(zzkl.zzclg));
  }
  
  zzr(zza paramzza, zza paramzza1)
  {
    zzamz = paramzza1;
    zzw = new Runnable()
    {
      public void run()
      {
        zzr.zza(zzr.this, false);
        zza localzza = (zza)zzane.get();
        if (localzza != null) {
          localzza.zzd(zzr.zza(zzr.this));
        }
      }
    };
  }
  
  public void cancel()
  {
    zzanb = false;
    zzamz.removeCallbacks(zzw);
  }
  
  public void pause()
  {
    zzanc = true;
    if (zzanb) {
      zzamz.removeCallbacks(zzw);
    }
  }
  
  public void resume()
  {
    zzanc = false;
    if (zzanb)
    {
      zzanb = false;
      zza(zzana, zzand);
    }
  }
  
  public void zza(AdRequestParcel paramAdRequestParcel, long paramLong)
  {
    if (zzanb) {
      zzkh.zzcy("An ad refresh is already scheduled.");
    }
    do
    {
      return;
      zzana = paramAdRequestParcel;
      zzanb = true;
      zzand = paramLong;
    } while (zzanc);
    zzkh.zzcx(65 + "Scheduling ad refresh " + paramLong + " milliseconds from now.");
    zzamz.postDelayed(zzw, paramLong);
  }
  
  public boolean zzfc()
  {
    return zzanb;
  }
  
  public void zzg(AdRequestParcel paramAdRequestParcel)
  {
    zza(paramAdRequestParcel, 60000L);
  }
  
  public static class zza
  {
    private final Handler mHandler;
    
    public zza(Handler paramHandler)
    {
      mHandler = paramHandler;
    }
    
    public boolean postDelayed(Runnable paramRunnable, long paramLong)
    {
      return mHandler.postDelayed(paramRunnable, paramLong);
    }
    
    public void removeCallbacks(Runnable paramRunnable)
    {
      mHandler.removeCallbacks(paramRunnable);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */