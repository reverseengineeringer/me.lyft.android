package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzir
public final class zzha<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
  implements MediationBannerListener, MediationInterstitialListener
{
  private final zzgp zzbpo;
  
  public zzha(zzgp paramzzgp)
  {
    zzbpo = paramzzgp;
  }
  
  public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter, final AdRequest.ErrorCode paramErrorCode)
  {
    paramMediationBannerAdapter = String.valueOf(paramErrorCode);
    zzb.zzcw(String.valueOf(paramMediationBannerAdapter).length() + 47 + "Adapter called onFailedToReceiveAd with error. " + paramMediationBannerAdapter);
    if (!zzm.zziw().zzty())
    {
      zzb.zzcy("onFailedToReceiveAd must be called on the main UI thread.");
      zza.zzcnf.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzha.zza(zzha.this).onAdFailedToLoad(zzhb.zza(paramErrorCode));
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzb.zzd("Could not call onAdFailedToLoad.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      zzbpo.onAdFailedToLoad(zzhb.zza(paramErrorCode));
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzb.zzd("Could not call onAdFailedToLoad.", paramMediationBannerAdapter);
    }
  }
  
  public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter, final AdRequest.ErrorCode paramErrorCode)
  {
    paramMediationInterstitialAdapter = String.valueOf(paramErrorCode);
    zzb.zzcw(String.valueOf(paramMediationInterstitialAdapter).length() + 47 + "Adapter called onFailedToReceiveAd with error " + paramMediationInterstitialAdapter + ".");
    if (!zzm.zziw().zzty())
    {
      zzb.zzcy("onFailedToReceiveAd must be called on the main UI thread.");
      zza.zzcnf.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzha.zza(zzha.this).onAdFailedToLoad(zzhb.zza(paramErrorCode));
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzb.zzd("Could not call onAdFailedToLoad.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      zzbpo.onAdFailedToLoad(zzhb.zza(paramErrorCode));
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzb.zzd("Could not call onAdFailedToLoad.", paramMediationInterstitialAdapter);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzha
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */