package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.zzir;

@zzir
public final class zzc
  extends zzq.zza
{
  private final AdListener zzatj;
  
  public zzc(AdListener paramAdListener)
  {
    zzatj = paramAdListener;
  }
  
  public void onAdClosed()
  {
    zzatj.onAdClosed();
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    zzatj.onAdFailedToLoad(paramInt);
  }
  
  public void onAdLeftApplication()
  {
    zzatj.onAdLeftApplication();
  }
  
  public void onAdLoaded()
  {
    zzatj.onAdLoaded();
  }
  
  public void onAdOpened()
  {
    zzatj.onAdOpened();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */