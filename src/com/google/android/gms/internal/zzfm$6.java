package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.reward.client.zza;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.reward.client.zzd.zza;
import java.util.List;

class zzfm$6
  extends zzd.zza
{
  zzfm$6(zzfm paramzzfm) {}
  
  public void onRewardedVideoAdClosed()
    throws RemoteException
  {
    zzfm.zza(zzbjx).add(new zzfm.zza()
    {
      public void zzb(zzfn paramAnonymouszzfn)
        throws RemoteException
      {
        if (zzbkp != null) {
          zzbkp.onRewardedVideoAdClosed();
        }
      }
    });
  }
  
  public void onRewardedVideoAdFailedToLoad(final int paramInt)
    throws RemoteException
  {
    zzfm.zza(zzbjx).add(new zzfm.zza()
    {
      public void zzb(zzfn paramAnonymouszzfn)
        throws RemoteException
      {
        if (zzbkp != null) {
          zzbkp.onRewardedVideoAdFailedToLoad(paramInt);
        }
      }
    });
  }
  
  public void onRewardedVideoAdLeftApplication()
    throws RemoteException
  {
    zzfm.zza(zzbjx).add(new zzfm.zza()
    {
      public void zzb(zzfn paramAnonymouszzfn)
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
    zzfm.zza(zzbjx).add(new zzfm.zza()
    {
      public void zzb(zzfn paramAnonymouszzfn)
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
    zzfm.zza(zzbjx).add(new zzfm.zza()
    {
      public void zzb(zzfn paramAnonymouszzfn)
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
    zzfm.zza(zzbjx).add(new zzfm.zza()
    {
      public void zzb(zzfn paramAnonymouszzfn)
        throws RemoteException
      {
        if (zzbkp != null) {
          zzbkp.onRewardedVideoStarted();
        }
      }
    });
  }
  
  public void zza(final zza paramzza)
    throws RemoteException
  {
    zzfm.zza(zzbjx).add(new zzfm.zza()
    {
      public void zzb(zzfn paramAnonymouszzfn)
        throws RemoteException
      {
        if (zzbkp != null) {
          zzbkp.zza(paramzza);
        }
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfm.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */