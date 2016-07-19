package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzp.zza;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzq.zza;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.client.zzw.zza;
import com.google.android.gms.ads.internal.reward.client.zza;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.reward.client.zzd.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzir
class zzfm
{
  private final List<zza> zzala = new LinkedList();
  
  void zza(final zzfn paramzzfn)
  {
    Handler localHandler = zzkl.zzclg;
    Iterator localIterator = zzala.iterator();
    while (localIterator.hasNext()) {
      localHandler.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzbkj.zzb(paramzzfn);
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzkh.zzd("Could not propagate interstitial ad event.", localRemoteException);
          }
        }
      });
    }
  }
  
  void zzc(zzl paramzzl)
  {
    paramzzl.zza(new zzq.zza()
    {
      public void onAdClosed()
        throws RemoteException
      {
        zzfm.zza(zzfm.this).add(new zzfm.zza()
        {
          public void zzb(zzfn paramAnonymous2zzfn)
            throws RemoteException
          {
            if (zzald != null) {
              zzald.onAdClosed();
            }
            zzu.zzgb().zzlq();
          }
        });
      }
      
      public void onAdFailedToLoad(final int paramAnonymousInt)
        throws RemoteException
      {
        zzfm.zza(zzfm.this).add(new zzfm.zza()
        {
          public void zzb(zzfn paramAnonymous2zzfn)
            throws RemoteException
          {
            if (zzald != null) {
              zzald.onAdFailedToLoad(paramAnonymousInt);
            }
          }
        });
        zzkh.v("Pooled interstitial failed to load.");
      }
      
      public void onAdLeftApplication()
        throws RemoteException
      {
        zzfm.zza(zzfm.this).add(new zzfm.zza()
        {
          public void zzb(zzfn paramAnonymous2zzfn)
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
        zzfm.zza(zzfm.this).add(new zzfm.zza()
        {
          public void zzb(zzfn paramAnonymous2zzfn)
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
        zzfm.zza(zzfm.this).add(new zzfm.zza()
        {
          public void zzb(zzfn paramAnonymous2zzfn)
            throws RemoteException
          {
            if (zzald != null) {
              zzald.onAdOpened();
            }
          }
        });
      }
    });
    paramzzl.zza(new zzw.zza()
    {
      public void onAppEvent(final String paramAnonymousString1, final String paramAnonymousString2)
        throws RemoteException
      {
        zzfm.zza(zzfm.this).add(new zzfm.zza()
        {
          public void zzb(zzfn paramAnonymous2zzfn)
            throws RemoteException
          {
            if (zzbkl != null) {
              zzbkl.onAppEvent(paramAnonymousString1, paramAnonymousString2);
            }
          }
        });
      }
    });
    paramzzl.zza(new zzhs.zza()
    {
      public void zza(final zzhr paramAnonymouszzhr)
        throws RemoteException
      {
        zzfm.zza(zzfm.this).add(new zzfm.zza()
        {
          public void zzb(zzfn paramAnonymous2zzfn)
            throws RemoteException
          {
            if (zzbkm != null) {
              zzbkm.zza(paramAnonymouszzhr);
            }
          }
        });
      }
    });
    paramzzl.zza(new zzdo.zza()
    {
      public void zza(final zzdn paramAnonymouszzdn)
        throws RemoteException
      {
        zzfm.zza(zzfm.this).add(new zzfm.zza()
        {
          public void zzb(zzfn paramAnonymous2zzfn)
            throws RemoteException
          {
            if (zzbkn != null) {
              zzbkn.zza(paramAnonymouszzdn);
            }
          }
        });
      }
    });
    paramzzl.zza(new zzp.zza()
    {
      public void onAdClicked()
        throws RemoteException
      {
        zzfm.zza(zzfm.this).add(new zzfm.zza()
        {
          public void zzb(zzfn paramAnonymous2zzfn)
            throws RemoteException
          {
            if (zzbko != null) {
              zzbko.onAdClicked();
            }
          }
        });
      }
    });
    paramzzl.zza(new zzd.zza()
    {
      public void onRewardedVideoAdClosed()
        throws RemoteException
      {
        zzfm.zza(zzfm.this).add(new zzfm.zza()
        {
          public void zzb(zzfn paramAnonymous2zzfn)
            throws RemoteException
          {
            if (zzbkp != null) {
              zzbkp.onRewardedVideoAdClosed();
            }
          }
        });
      }
      
      public void onRewardedVideoAdFailedToLoad(final int paramAnonymousInt)
        throws RemoteException
      {
        zzfm.zza(zzfm.this).add(new zzfm.zza()
        {
          public void zzb(zzfn paramAnonymous2zzfn)
            throws RemoteException
          {
            if (zzbkp != null) {
              zzbkp.onRewardedVideoAdFailedToLoad(paramAnonymousInt);
            }
          }
        });
      }
      
      public void onRewardedVideoAdLeftApplication()
        throws RemoteException
      {
        zzfm.zza(zzfm.this).add(new zzfm.zza()
        {
          public void zzb(zzfn paramAnonymous2zzfn)
            throws RemoteException
          {
            if (zzbkp != null) {
              zzbkp.onRewardedVideoAdLeftApplication();
            }
          }
        });
      }
      
      public void onRewardedVideoAdLoaded()
        throws RemoteException
      {
        zzfm.zza(zzfm.this).add(new zzfm.zza()
        {
          public void zzb(zzfn paramAnonymous2zzfn)
            throws RemoteException
          {
            if (zzbkp != null) {
              zzbkp.onRewardedVideoAdLoaded();
            }
          }
        });
      }
      
      public void onRewardedVideoAdOpened()
        throws RemoteException
      {
        zzfm.zza(zzfm.this).add(new zzfm.zza()
        {
          public void zzb(zzfn paramAnonymous2zzfn)
            throws RemoteException
          {
            if (zzbkp != null) {
              zzbkp.onRewardedVideoAdOpened();
            }
          }
        });
      }
      
      public void onRewardedVideoStarted()
        throws RemoteException
      {
        zzfm.zza(zzfm.this).add(new zzfm.zza()
        {
          public void zzb(zzfn paramAnonymous2zzfn)
            throws RemoteException
          {
            if (zzbkp != null) {
              zzbkp.onRewardedVideoStarted();
            }
          }
        });
      }
      
      public void zza(final zza paramAnonymouszza)
        throws RemoteException
      {
        zzfm.zza(zzfm.this).add(new zzfm.zza()
        {
          public void zzb(zzfn paramAnonymous2zzfn)
            throws RemoteException
          {
            if (zzbkp != null) {
              zzbkp.zza(paramAnonymouszza);
            }
          }
        });
      }
    });
  }
  
  static abstract interface zza
  {
    public abstract void zzb(zzfn paramzzfn)
      throws RemoteException;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */