package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzq.zza;
import com.google.android.gms.ads.internal.zzu;
import java.util.List;

class zzfm$1
  extends zzq.zza
{
  zzfm$1(zzfm paramzzfm) {}
  
  public void onAdClosed()
    throws RemoteException
  {
    zzfm.zza(zzbjx).add(new zzfm.zza()
    {
      public void zzb(zzfn paramAnonymouszzfn)
        throws RemoteException
      {
        if (zzald != null) {
          zzald.onAdClosed();
        }
        zzu.zzgb().zzlq();
      }
    });
  }
  
  public void onAdFailedToLoad(final int paramInt)
    throws RemoteException
  {
    zzfm.zza(zzbjx).add(new zzfm.zza()
    {
      public void zzb(zzfn paramAnonymouszzfn)
        throws RemoteException
      {
        if (zzald != null) {
          zzald.onAdFailedToLoad(paramInt);
        }
      }
    });
    zzkh.v("Pooled interstitial failed to load.");
  }
  
  public void onAdLeftApplication()
    throws RemoteException
  {
    zzfm.zza(zzbjx).add(new zzfm.zza()
    {
      public void zzb(zzfn paramAnonymouszzfn)
        throws RemoteException
      {
        if (zzald != null) {
          zzald.onAdLeftApplication();
        }
      }
    });
  }
  
  public void onAdLoaded()
    throws RemoteException
  {
    zzfm.zza(zzbjx).add(new zzfm.zza()
    {
      public void zzb(zzfn paramAnonymouszzfn)
        throws RemoteException
      {
        if (zzald != null) {
          zzald.onAdLoaded();
        }
      }
    });
    zzkh.v("Pooled interstitial loaded.");
  }
  
  public void onAdOpened()
    throws RemoteException
  {
    zzfm.zza(zzbjx).add(new zzfm.zza()
    {
      public void zzb(zzfn paramAnonymouszzfn)
        throws RemoteException
      {
        if (zzald != null) {
          zzald.onAdOpened();
        }
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfm.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */