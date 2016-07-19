package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.zzir;

@zzir
public class zzo
  extends AdListener
{
  private final Object lock = new Object();
  private AdListener zzavp;
  
  public void onAdClosed()
  {
    synchronized (lock)
    {
      if (zzavp != null) {
        zzavp.onAdClosed();
      }
      return;
    }
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    synchronized (lock)
    {
      if (zzavp != null) {
        zzavp.onAdFailedToLoad(paramInt);
      }
      return;
    }
  }
  
  public void onAdLeftApplication()
  {
    synchronized (lock)
    {
      if (zzavp != null) {
        zzavp.onAdLeftApplication();
      }
      return;
    }
  }
  
  public void onAdLoaded()
  {
    synchronized (lock)
    {
      if (zzavp != null) {
        zzavp.onAdLoaded();
      }
      return;
    }
  }
  
  public void onAdOpened()
  {
    synchronized (lock)
    {
      if (zzavp != null) {
        zzavp.onAdOpened();
      }
      return;
    }
  }
  
  public void zza(AdListener paramAdListener)
  {
    synchronized (lock)
    {
      zzavp = paramAdListener;
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */