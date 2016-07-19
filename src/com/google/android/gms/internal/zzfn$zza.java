package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzq.zza;
import com.google.android.gms.ads.internal.zzu;

class zzfn$zza
  extends zzq.zza
{
  zzq zzbkq;
  
  zzfn$zza(zzfn paramzzfn, zzq paramzzq)
  {
    zzbkq = paramzzq;
  }
  
  public void onAdClosed()
    throws RemoteException
  {
    zzbkq.onAdClosed();
    zzu.zzgb().zzlq();
  }
  
  public void onAdFailedToLoad(int paramInt)
    throws RemoteException
  {
    zzbkq.onAdFailedToLoad(paramInt);
  }
  
  public void onAdLeftApplication()
    throws RemoteException
  {
    zzbkq.onAdLeftApplication();
  }
  
  public void onAdLoaded()
    throws RemoteException
  {
    zzbkq.onAdLoaded();
  }
  
  public void onAdOpened()
    throws RemoteException
  {
    zzbkq.onAdOpened();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfn.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */