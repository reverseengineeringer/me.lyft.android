package com.google.android.gms.ads.formats;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzdw;

public abstract class NativeAdView
  extends FrameLayout
{
  private final FrameLayout zzaiz;
  private final zzdw zzaja;
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    super.bringChildToFront(zzaiz);
  }
  
  public void bringChildToFront(View paramView)
  {
    super.bringChildToFront(paramView);
    if (zzaiz != paramView) {
      super.bringChildToFront(zzaiz);
    }
  }
  
  public void removeAllViews()
  {
    super.removeAllViews();
    super.addView(zzaiz);
  }
  
  public void removeView(View paramView)
  {
    if (zzaiz == paramView) {
      return;
    }
    super.removeView(paramView);
  }
  
  public void setNativeAd(NativeAd paramNativeAd)
  {
    try
    {
      zzaja.zze((zzd)paramNativeAd.zzdh());
      return;
    }
    catch (RemoteException paramNativeAd)
    {
      zzb.zzb("Unable to call setNativeAd on delegate", paramNativeAd);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.formats.NativeAdView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */