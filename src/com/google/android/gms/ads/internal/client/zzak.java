package com.google.android.gms.ads.internal.client;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhw;

public class zzak
  extends zzu.zza
{
  private zzq zzald;
  
  public void destroy() {}
  
  public String getMediationAdapterClassName()
  {
    return null;
  }
  
  public boolean isLoading()
  {
    return false;
  }
  
  public boolean isReady()
  {
    return false;
  }
  
  public void pause() {}
  
  public void resume() {}
  
  public void setManualImpressionsEnabled(boolean paramBoolean) {}
  
  public void setUserId(String paramString) {}
  
  public void showInterstitial() {}
  
  public void stopLoading() {}
  
  public void zza(AdSizeParcel paramAdSizeParcel) {}
  
  public void zza(VideoOptionsParcel paramVideoOptionsParcel) {}
  
  public void zza(zzp paramzzp) {}
  
  public void zza(zzq paramzzq)
  {
    zzald = paramzzq;
  }
  
  public void zza(zzw paramzzw) {}
  
  public void zza(zzy paramzzy) {}
  
  public void zza(com.google.android.gms.ads.internal.reward.client.zzd paramzzd) {}
  
  public void zza(zzdo paramzzdo) {}
  
  public void zza(zzhs paramzzhs) {}
  
  public void zza(zzhw paramzzhw, String paramString) {}
  
  public boolean zzb(AdRequestParcel paramAdRequestParcel)
  {
    zzb.e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
    zza.zzcnf.post(new Runnable()
    {
      public void run()
      {
        if (zzak.zza(zzak.this) != null) {}
        try
        {
          zzak.zza(zzak.this).onAdFailedToLoad(1);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          zzb.zzd("Could not notify onAdFailedToLoad event.", localRemoteException);
        }
      }
    });
    return false;
  }
  
  public com.google.android.gms.dynamic.zzd zzdn()
  {
    return null;
  }
  
  public AdSizeParcel zzdo()
  {
    return null;
  }
  
  public void zzdq() {}
  
  public zzab zzdr()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzak
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */