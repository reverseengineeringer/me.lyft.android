package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzq.zza;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzu;

@zzir
class zzfn
{
  zzq zzald;
  zzw zzbkl;
  zzhs zzbkm;
  zzdo zzbkn;
  zzp zzbko;
  zzd zzbkp;
  
  void zzc(zzl paramzzl)
  {
    if (zzald != null) {
      paramzzl.zza(new zza(zzald));
    }
    if (zzbkl != null) {
      paramzzl.zza(zzbkl);
    }
    if (zzbkm != null) {
      paramzzl.zza(zzbkm);
    }
    if (zzbkn != null) {
      paramzzl.zza(zzbkn);
    }
    if (zzbko != null) {
      paramzzl.zza(zzbko);
    }
    if (zzbkp != null) {
      paramzzl.zza(zzbkp);
    }
  }
  
  private class zza
    extends zzq.zza
  {
    zzq zzbkq;
    
    zza(zzq paramzzq)
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */