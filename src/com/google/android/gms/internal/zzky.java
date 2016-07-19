package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzu;

@zzir
public final class zzky
{
  private final View mView;
  private Activity zzcmz;
  private boolean zzcna;
  private boolean zzcnb;
  private boolean zzcnc;
  private ViewTreeObserver.OnGlobalLayoutListener zzcnd;
  private ViewTreeObserver.OnScrollChangedListener zzcne;
  
  public zzky(Activity paramActivity, View paramView, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    zzcmz = paramActivity;
    mView = paramView;
    zzcnd = paramOnGlobalLayoutListener;
    zzcne = paramOnScrollChangedListener;
  }
  
  private void zztv()
  {
    if (!zzcna)
    {
      if (zzcnd != null)
      {
        if (zzcmz != null) {
          zzu.zzfq().zza(zzcmz, zzcnd);
        }
        zzu.zzgk().zza(mView, zzcnd);
      }
      if (zzcne != null)
      {
        if (zzcmz != null) {
          zzu.zzfq().zza(zzcmz, zzcne);
        }
        zzu.zzgk().zza(mView, zzcne);
      }
      zzcna = true;
    }
  }
  
  private void zztw()
  {
    if (zzcmz == null) {}
    while (!zzcna) {
      return;
    }
    if ((zzcnd != null) && (zzcmz != null)) {
      zzu.zzfs().zzb(zzcmz, zzcnd);
    }
    if ((zzcne != null) && (zzcmz != null)) {
      zzu.zzfq().zzb(zzcmz, zzcne);
    }
    zzcna = false;
  }
  
  public void onAttachedToWindow()
  {
    zzcnb = true;
    if (zzcnc) {
      zztv();
    }
  }
  
  public void onDetachedFromWindow()
  {
    zzcnb = false;
    zztw();
  }
  
  public void zzl(Activity paramActivity)
  {
    zzcmz = paramActivity;
  }
  
  public void zztt()
  {
    zzcnc = true;
    if (zzcnb) {
      zztv();
    }
  }
  
  public void zztu()
  {
    zzcnc = false;
    zztw();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzky
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */