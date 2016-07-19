package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsIntent.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

@zzir
public class zzhc
  implements MediationInterstitialAdapter
{
  private Uri mUri;
  private Activity zzbpy;
  private zzdq zzbpz;
  private MediationInterstitialListener zzbqa;
  
  public static boolean zzp(Context paramContext)
  {
    return zzdq.zzo(paramContext);
  }
  
  public void onDestroy()
  {
    zzb.zzcw("Destroying AdMobCustomTabsAdapter adapter.");
    try
    {
      zzbpz.zzd(zzbpy);
      return;
    }
    catch (Exception localException)
    {
      zzb.zzb("Exception while unbinding from CustomTabsService.", localException);
    }
  }
  
  public void onPause()
  {
    zzb.zzcw("Pausing AdMobCustomTabsAdapter adapter.");
  }
  
  public void onResume()
  {
    zzb.zzcw("Resuming AdMobCustomTabsAdapter adapter.");
  }
  
  public void requestInterstitialAd(Context paramContext, MediationInterstitialListener paramMediationInterstitialListener, Bundle paramBundle1, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    zzbqa = paramMediationInterstitialListener;
    if (zzbqa == null)
    {
      zzb.zzcy("Listener not set for mediation. Returning.");
      return;
    }
    if (!(paramContext instanceof Activity))
    {
      zzb.zzcy("AdMobCustomTabs can only work with Activity context. Bailing out.");
      zzbqa.onAdFailedToLoad(this, 0);
      return;
    }
    if (!zzp(paramContext))
    {
      zzb.zzcy("Default browser does not support custom tabs. Bailing out.");
      zzbqa.onAdFailedToLoad(this, 0);
      return;
    }
    paramMediationInterstitialListener = paramBundle1.getString("tab_url");
    if (TextUtils.isEmpty(paramMediationInterstitialListener))
    {
      zzb.zzcy("The tab_url retrieved from mediation metadata is empty. Bailing out.");
      zzbqa.onAdFailedToLoad(this, 0);
      return;
    }
    zzbpy = ((Activity)paramContext);
    mUri = Uri.parse(paramMediationInterstitialListener);
    zzbpz = new zzdq();
    paramContext = new zzdq.zza()
    {
      public void zzkn()
      {
        zzb.zzcw("Hinting CustomTabsService for the load of the new url.");
      }
      
      public void zzko()
      {
        zzb.zzcw("Disconnecting from CustomTabs service.");
      }
    };
    zzbpz.zza(paramContext);
    zzbpz.zze(zzbpy);
    zzbqa.onAdLoaded(this);
  }
  
  public void showInterstitial()
  {
    final Object localObject = new CustomTabsIntent.Builder(zzbpz.zzkl()).build();
    intent.setData(mUri);
    localObject = new AdOverlayInfoParcel(new AdLauncherIntentInfoParcel(intent), null, new zzg()
    {
      public void onPause()
      {
        zzb.zzcw("AdMobCustomTabsAdapter overlay is paused.");
      }
      
      public void onResume()
      {
        zzb.zzcw("AdMobCustomTabsAdapter overlay is resumed.");
      }
      
      public void zzdy()
      {
        zzb.zzcw("AdMobCustomTabsAdapter overlay is closed.");
        zzhc.zza(zzhc.this).onAdClosed(zzhc.this);
        zzhc.zzc(zzhc.this).zzd(zzhc.zzb(zzhc.this));
      }
      
      public void zzdz()
      {
        zzb.zzcw("Opening AdMobCustomTabsAdapter overlay.");
        zzhc.zza(zzhc.this).onAdOpened(zzhc.this);
      }
    }, null, new VersionInfoParcel(0, 0, false));
    zzkl.zzclg.post(new Runnable()
    {
      public void run()
      {
        zzu.zzfo().zza(zzhc.zzb(zzhc.this), localObject);
      }
    });
    zzu.zzft().zzaf(false);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */