package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.ThinAdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.zzf;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzu.zza;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zza.zza;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzco;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzde;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzeo;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhw;
import com.google.android.gms.internal.zzig.zza;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjh;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzjy.zza;
import com.google.android.gms.internal.zzjz;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlm;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

@zzir
public abstract class zza
  extends zzu.zza
  implements com.google.android.gms.ads.internal.client.zza, com.google.android.gms.ads.internal.overlay.zzp, zza.zza, zzeo, zzig.zza, zzkd
{
  protected zzdk zzajn;
  protected zzdi zzajo;
  protected zzdi zzajp;
  protected boolean zzajq = false;
  protected final zzr zzajr;
  protected final zzv zzajs;
  protected transient AdRequestParcel zzajt;
  protected final zzcg zzaju;
  protected final zzd zzajv;
  
  zza(zzv paramzzv, zzr paramzzr, zzd paramzzd)
  {
    zzajs = paramzzv;
    if (paramzzr != null) {}
    for (;;)
    {
      zzajr = paramzzr;
      zzajv = paramzzd;
      zzu.zzfq().zzad(zzajs.zzagf);
      zzu.zzft().zzb(zzajs.zzagf, zzajs.zzaou);
      zzaju = zzu.zzft().zzsv();
      zzdl();
      return;
      paramzzr = new zzr(this);
    }
  }
  
  private AdRequestParcel zza(AdRequestParcel paramAdRequestParcel)
  {
    AdRequestParcel localAdRequestParcel = paramAdRequestParcel;
    if (zzi.zzcl(zzajs.zzagf))
    {
      localAdRequestParcel = paramAdRequestParcel;
      if (zzats != null) {
        localAdRequestParcel = new zzf(paramAdRequestParcel).zza(null).zzig();
      }
    }
    return localAdRequestParcel;
  }
  
  private TimerTask zza(final Timer paramTimer, final CountDownLatch paramCountDownLatch)
  {
    new TimerTask()
    {
      public void run()
      {
        if (((Integer)zzdc.zzbcj.get()).intValue() != paramCountDownLatch.getCount())
        {
          zzkh.zzcw("Stopping method tracing");
          Debug.stopMethodTracing();
          if (paramCountDownLatch.getCount() == 0L)
          {
            paramTimer.cancel();
            return;
          }
        }
        String str = String.valueOf(zzajs.zzagf.getPackageName()).concat("_adsTrace_");
        try
        {
          zzkh.zzcw("Starting method tracing");
          paramCountDownLatch.countDown();
          long l = zzu.zzfu().currentTimeMillis();
          Debug.startMethodTracing(String.valueOf(str).length() + 20 + str + l, ((Integer)zzdc.zzbck.get()).intValue());
          return;
        }
        catch (Exception localException)
        {
          zzkh.zzd("Exception occurred while starting method tracing.", localException);
        }
      }
    };
  }
  
  private void zzdl()
  {
    if (((Boolean)zzdc.zzbch.get()).booleanValue())
    {
      Timer localTimer = new Timer();
      localTimer.schedule(zza(localTimer, new CountDownLatch(((Integer)zzdc.zzbcj.get()).intValue())), 0L, ((Long)zzdc.zzbci.get()).longValue());
    }
  }
  
  public void destroy()
  {
    com.google.android.gms.common.internal.zzab.zzhj("destroy must be called on the main UI thread.");
    zzajr.cancel();
    zzaju.zzj(zzajs.zzaoz);
    zzajs.destroy();
  }
  
  public boolean isLoading()
  {
    return zzajq;
  }
  
  public boolean isReady()
  {
    com.google.android.gms.common.internal.zzab.zzhj("isLoaded must be called on the main UI thread.");
    return (zzajs.zzaow == null) && (zzajs.zzaox == null) && (zzajs.zzaoz != null);
  }
  
  public void onAdClicked()
  {
    if (zzajs.zzaoz == null) {
      zzkh.zzcy("Ad state was null when trying to ping click URLs.");
    }
    do
    {
      return;
      zzkh.zzcw("Pinging click URLs.");
      zzajs.zzapb.zzsa();
      if (zzajs.zzaoz.zzbnq != null) {
        zzu.zzfq().zza(zzajs.zzagf, zzajs.zzaou.zzcs, zzajs.zzaoz.zzbnq);
      }
    } while (zzajs.zzapc == null);
    try
    {
      zzajs.zzapc.onAdClicked();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzkh.zzd("Could not notify onAdClicked event.", localRemoteException);
    }
  }
  
  public void onAppEvent(String paramString1, String paramString2)
  {
    if (zzajs.zzape != null) {}
    try
    {
      zzajs.zzape.onAppEvent(paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      zzkh.zzd("Could not call the AppEventListener.", paramString1);
    }
  }
  
  public void pause()
  {
    com.google.android.gms.common.internal.zzab.zzhj("pause must be called on the main UI thread.");
  }
  
  public void resume()
  {
    com.google.android.gms.common.internal.zzab.zzhj("resume must be called on the main UI thread.");
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
  }
  
  public void setUserId(String paramString)
  {
    zzkh.zzcy("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
  }
  
  public void stopLoading()
  {
    com.google.android.gms.common.internal.zzab.zzhj("stopLoading must be called on the main UI thread.");
    zzajq = false;
    zzajs.zzi(true);
  }
  
  Bundle zza(zzco paramzzco)
  {
    Object localObject2;
    if (paramzzco == null)
    {
      localObject2 = null;
      return (Bundle)localObject2;
    }
    if (paramzzco.zzid()) {
      paramzzco.wakeup();
    }
    paramzzco = paramzzco.zzib();
    Object localObject3;
    label62:
    Object localObject1;
    if (paramzzco != null)
    {
      localObject2 = paramzzco.zzhr();
      localObject3 = paramzzco.zzhs();
      paramzzco = String.valueOf(paramzzco.toString());
      if (paramzzco.length() != 0)
      {
        paramzzco = "In AdManager: loadAd, ".concat(paramzzco);
        zzkh.zzcw(paramzzco);
        paramzzco = (zzco)localObject3;
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          zzu.zzft().zzcn((String)localObject2);
          localObject1 = localObject2;
        }
      }
    }
    for (paramzzco = (zzco)localObject3;; paramzzco = null)
    {
      if (localObject1 == null) {
        break label160;
      }
      localObject3 = new Bundle(1);
      ((Bundle)localObject3).putString("fingerprint", (String)localObject1);
      localObject2 = localObject3;
      if (((String)localObject1).equals(paramzzco)) {
        break;
      }
      ((Bundle)localObject3).putString("v_fp", paramzzco);
      return (Bundle)localObject3;
      paramzzco = new String("In AdManager: loadAd, ");
      break label62;
      localObject1 = zzu.zzft().zzsq();
    }
    label160:
    return null;
  }
  
  public void zza(AdSizeParcel paramAdSizeParcel)
  {
    com.google.android.gms.common.internal.zzab.zzhj("setAdSize must be called on the main UI thread.");
    zzajs.zzaoy = paramAdSizeParcel;
    if ((zzajs.zzaoz != null) && (zzajs.zzaoz.zzbtq != null) && (zzajs.zzapu == 0)) {
      zzajs.zzaoz.zzbtq.zza(paramAdSizeParcel);
    }
    if (zzajs.zzaov == null) {
      return;
    }
    if (zzajs.zzaov.getChildCount() > 1) {
      zzajs.zzaov.removeView(zzajs.zzaov.getNextView());
    }
    zzajs.zzaov.setMinimumWidth(widthPixels);
    zzajs.zzaov.setMinimumHeight(heightPixels);
    zzajs.zzaov.requestLayout();
  }
  
  public void zza(VideoOptionsParcel paramVideoOptionsParcel)
  {
    com.google.android.gms.common.internal.zzab.zzhj("setVideoOptions must be called on the main UI thread.");
    zzajs.zzapn = paramVideoOptionsParcel;
  }
  
  public void zza(com.google.android.gms.ads.internal.client.zzp paramzzp)
  {
    com.google.android.gms.common.internal.zzab.zzhj("setAdListener must be called on the main UI thread.");
    zzajs.zzapc = paramzzp;
  }
  
  public void zza(zzq paramzzq)
  {
    com.google.android.gms.common.internal.zzab.zzhj("setAdListener must be called on the main UI thread.");
    zzajs.zzapd = paramzzq;
  }
  
  public void zza(zzw paramzzw)
  {
    com.google.android.gms.common.internal.zzab.zzhj("setAppEventListener must be called on the main UI thread.");
    zzajs.zzape = paramzzw;
  }
  
  public void zza(zzy paramzzy)
  {
    com.google.android.gms.common.internal.zzab.zzhj("setCorrelationIdProvider must be called on the main UI thread");
    zzajs.zzapf = paramzzy;
  }
  
  public void zza(com.google.android.gms.ads.internal.reward.client.zzd paramzzd)
  {
    com.google.android.gms.common.internal.zzab.zzhj("setRewardedVideoAdListener can only be called from the UI thread.");
    zzajs.zzapp = paramzzd;
  }
  
  protected void zza(RewardItemParcel paramRewardItemParcel)
  {
    if (zzajs.zzapp == null) {
      return;
    }
    String str = "";
    int i = 0;
    if (paramRewardItemParcel != null) {}
    try
    {
      str = type;
      i = zzcih;
      zzajs.zzapp.zza(new zzjh(str, i));
      return;
    }
    catch (RemoteException paramRewardItemParcel)
    {
      zzkh.zzd("Could not call RewardedVideoAdListener.onRewarded().", paramRewardItemParcel);
    }
  }
  
  public void zza(zzdo paramzzdo)
  {
    throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
  }
  
  public void zza(zzhs paramzzhs)
  {
    throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
  }
  
  public void zza(zzhw paramzzhw, String paramString)
  {
    throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
  }
  
  public void zza(zzjy.zza paramzza)
  {
    if ((zzciu.zzccg != -1L) && (!TextUtils.isEmpty(zzciu.zzccp)))
    {
      long l = zzs(zzciu.zzccp);
      if (l != -1L)
      {
        zzdi localzzdi = zzajn.zzc(l + zzciu.zzccg);
        zzajn.zza(localzzdi, new String[] { "stc" });
      }
    }
    zzajn.zzas(zzciu.zzccp);
    zzajn.zza(zzajo, new String[] { "arf" });
    zzajp = zzajn.zzkg();
    zzajn.zzh("gqi", zzciu.zzccq);
    zzajs.zzaow = null;
    zzajs.zzapa = paramzza;
    zza(paramzza, zzajn);
  }
  
  protected abstract void zza(zzjy.zza paramzza, zzdk paramzzdk);
  
  public void zza(HashSet<zzjz> paramHashSet)
  {
    zzajs.zza(paramHashSet);
  }
  
  protected abstract boolean zza(AdRequestParcel paramAdRequestParcel, zzdk paramzzdk);
  
  boolean zza(zzjy paramzzjy)
  {
    return false;
  }
  
  protected abstract boolean zza(zzjy paramzzjy1, zzjy paramzzjy2);
  
  protected void zzb(View paramView)
  {
    zzajs.zzaov.addView(paramView, zzu.zzfs().zztn());
  }
  
  public void zzb(zzjy paramzzjy)
  {
    zzajn.zza(zzajp, new String[] { "awr" });
    zzajs.zzaox = null;
    if ((errorCode != -2) && (errorCode != 3)) {
      zzu.zzft().zzb(zzajs.zzgl());
    }
    if (errorCode == -1)
    {
      zzajq = false;
      return;
    }
    if (zza(paramzzjy)) {
      zzkh.zzcw("Ad refresh scheduled.");
    }
    if (errorCode != -2)
    {
      zzh(errorCode);
      return;
    }
    if (zzajs.zzaps == null) {
      zzajs.zzaps = new zzke(zzajs.zzaos);
    }
    zzaju.zzi(zzajs.zzaoz);
    zzdk localzzdk;
    if (zza(zzajs.zzaoz, paramzzjy))
    {
      zzajs.zzaoz = paramzzjy;
      zzajs.zzgu();
      localzzdk = zzajn;
      if (!zzajs.zzaoz.zzho()) {
        break label394;
      }
      str = "1";
      label203:
      localzzdk.zzh("is_mraid", str);
      localzzdk = zzajn;
      if (!zzajs.zzaoz.zzccc) {
        break label401;
      }
      str = "1";
      label233:
      localzzdk.zzh("is_mediation", str);
      if ((zzajs.zzaoz.zzbtq != null) && (zzajs.zzaoz.zzbtq.zzuk() != null))
      {
        localzzdk = zzajn;
        if (!zzajs.zzaoz.zzbtq.zzuk().zzuz()) {
          break label408;
        }
      }
    }
    label394:
    label401:
    label408:
    for (String str = "1";; str = "0")
    {
      localzzdk.zzh("is_delay_pl", str);
      zzajn.zza(zzajo, new String[] { "ttc" });
      if (zzu.zzft().zzsm() != null) {
        zzu.zzft().zzsm().zza(zzajn);
      }
      if (zzajs.zzgp()) {
        zzdv();
      }
      if (zzbnt == null) {
        break;
      }
      zzu.zzfq().zza(zzajs.zzagf, zzbnt);
      return;
      str = "0";
      break label203;
      str = "0";
      break label233;
    }
  }
  
  public boolean zzb(AdRequestParcel paramAdRequestParcel)
  {
    com.google.android.gms.common.internal.zzab.zzhj("loadAd must be called on the main UI thread.");
    paramAdRequestParcel = zza(paramAdRequestParcel);
    if ((zzajs.zzaow != null) || (zzajs.zzaox != null))
    {
      if (zzajt != null) {
        zzkh.zzcy("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
      }
      for (;;)
      {
        zzajt = paramAdRequestParcel;
        return false;
        zzkh.zzcy("Loading already in progress, saving this object for future refreshes.");
      }
    }
    zzkh.zzcx("Starting ad request.");
    zzdm();
    zzajo = zzajn.zzkg();
    if (!zzatn)
    {
      String str = String.valueOf(zzm.zziw().zzaq(zzajs.zzagf));
      zzkh.zzcx(String.valueOf(str).length() + 71 + "Use AdRequest.Builder.addTestDevice(\"" + str + "\") to get test ads on this device.");
    }
    zzajq = zza(paramAdRequestParcel, zzajn);
    return zzajq;
  }
  
  protected void zzc(zzjy paramzzjy)
  {
    if (paramzzjy == null) {
      zzkh.zzcy("Ad state was null when trying to ping impression URLs.");
    }
    do
    {
      return;
      zzkh.zzcw("Pinging Impression URLs.");
      zzajs.zzapb.zzrz();
    } while ((zzbnr == null) || (zzcir));
    zzu.zzfq().zza(zzajs.zzagf, zzajs.zzaou.zzcs, zzbnr);
    zzcir = true;
  }
  
  protected boolean zzc(AdRequestParcel paramAdRequestParcel)
  {
    if (zzajs.zzaov == null) {
      return false;
    }
    paramAdRequestParcel = zzajs.zzaov.getParent();
    if (!(paramAdRequestParcel instanceof View)) {
      return false;
    }
    paramAdRequestParcel = (View)paramAdRequestParcel;
    return zzu.zzfq().zza(paramAdRequestParcel, paramAdRequestParcel.getContext());
  }
  
  public void zzd(AdRequestParcel paramAdRequestParcel)
  {
    if (zzc(paramAdRequestParcel))
    {
      zzb(paramAdRequestParcel);
      return;
    }
    zzkh.zzcx("Ad is not visible. Not refreshing ad.");
    zzajr.zzg(paramAdRequestParcel);
  }
  
  public void zzdm()
  {
    zzajn = new zzdk(((Boolean)zzdc.zzazc.get()).booleanValue(), "load_ad", zzajs.zzaoy.zzaup);
    zzajo = new zzdi(-1L, null, null);
    zzajp = new zzdi(-1L, null, null);
  }
  
  public com.google.android.gms.dynamic.zzd zzdn()
  {
    com.google.android.gms.common.internal.zzab.zzhj("getAdFrame must be called on the main UI thread.");
    return com.google.android.gms.dynamic.zze.zzae(zzajs.zzaov);
  }
  
  public AdSizeParcel zzdo()
  {
    com.google.android.gms.common.internal.zzab.zzhj("getAdSize must be called on the main UI thread.");
    if (zzajs.zzaoy == null) {
      return null;
    }
    return new ThinAdSizeParcel(zzajs.zzaoy);
  }
  
  public void zzdp()
  {
    zzdt();
  }
  
  public void zzdq()
  {
    com.google.android.gms.common.internal.zzab.zzhj("recordManualImpression must be called on the main UI thread.");
    if (zzajs.zzaoz == null) {
      zzkh.zzcy("Ad state was null when trying to ping manual tracking URLs.");
    }
    do
    {
      return;
      zzkh.zzcw("Pinging manual tracking URLs.");
    } while ((zzajs.zzaoz.zzcce == null) || (zzajs.zzaoz.zzcis));
    zzu.zzfq().zza(zzajs.zzagf, zzajs.zzaou.zzcs, zzajs.zzaoz.zzcce);
    zzajs.zzaoz.zzcis = true;
  }
  
  public com.google.android.gms.ads.internal.client.zzab zzdr()
  {
    return null;
  }
  
  protected void zzds()
  {
    zzkh.zzcx("Ad closing.");
    if (zzajs.zzapd != null) {}
    try
    {
      zzajs.zzapd.onAdClosed();
      if (zzajs.zzapp == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      for (;;)
      {
        try
        {
          zzajs.zzapp.onRewardedVideoAdClosed();
          return;
        }
        catch (RemoteException localRemoteException2)
        {
          zzkh.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdClosed().", localRemoteException2);
        }
        localRemoteException1 = localRemoteException1;
        zzkh.zzd("Could not call AdListener.onAdClosed().", localRemoteException1);
      }
    }
  }
  
  protected void zzdt()
  {
    zzkh.zzcx("Ad leaving application.");
    if (zzajs.zzapd != null) {}
    try
    {
      zzajs.zzapd.onAdLeftApplication();
      if (zzajs.zzapp == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      for (;;)
      {
        try
        {
          zzajs.zzapp.onRewardedVideoAdLeftApplication();
          return;
        }
        catch (RemoteException localRemoteException2)
        {
          zzkh.zzd("Could not call  RewardedVideoAdListener.onRewardedVideoAdLeftApplication().", localRemoteException2);
        }
        localRemoteException1 = localRemoteException1;
        zzkh.zzd("Could not call AdListener.onAdLeftApplication().", localRemoteException1);
      }
    }
  }
  
  protected void zzdu()
  {
    zzkh.zzcx("Ad opening.");
    if (zzajs.zzapd != null) {}
    try
    {
      zzajs.zzapd.onAdOpened();
      if (zzajs.zzapp == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      for (;;)
      {
        try
        {
          zzajs.zzapp.onRewardedVideoAdOpened();
          return;
        }
        catch (RemoteException localRemoteException2)
        {
          zzkh.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdOpened().", localRemoteException2);
        }
        localRemoteException1 = localRemoteException1;
        zzkh.zzd("Could not call AdListener.onAdOpened().", localRemoteException1);
      }
    }
  }
  
  protected void zzdv()
  {
    zzkh.zzcx("Ad finished loading.");
    zzajq = false;
    if (zzajs.zzapd != null) {}
    try
    {
      zzajs.zzapd.onAdLoaded();
      if (zzajs.zzapp == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      for (;;)
      {
        try
        {
          zzajs.zzapp.onRewardedVideoAdLoaded();
          return;
        }
        catch (RemoteException localRemoteException2)
        {
          zzkh.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdLoaded().", localRemoteException2);
        }
        localRemoteException1 = localRemoteException1;
        zzkh.zzd("Could not call AdListener.onAdLoaded().", localRemoteException1);
      }
    }
  }
  
  protected void zzdw()
  {
    if (zzajs.zzapp == null) {
      return;
    }
    try
    {
      zzajs.zzapp.onRewardedVideoStarted();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzkh.zzd("Could not call RewardedVideoAdListener.onVideoStarted().", localRemoteException);
    }
  }
  
  protected void zzh(int paramInt)
  {
    zzkh.zzcy(30 + "Failed to load ad: " + paramInt);
    zzajq = false;
    if (zzajs.zzapd != null) {}
    try
    {
      zzajs.zzapd.onAdFailedToLoad(paramInt);
      if (zzajs.zzapp == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      for (;;)
      {
        try
        {
          zzajs.zzapp.onRewardedVideoAdFailedToLoad(paramInt);
          return;
        }
        catch (RemoteException localRemoteException2)
        {
          zzkh.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdFailedToLoad().", localRemoteException2);
        }
        localRemoteException1 = localRemoteException1;
        zzkh.zzd("Could not call AdListener.onAdFailedToLoad().", localRemoteException1);
      }
    }
  }
  
  long zzs(String paramString)
  {
    int k = paramString.indexOf("ufe");
    int j = paramString.indexOf(',', k);
    int i = j;
    if (j == -1) {
      i = paramString.length();
    }
    try
    {
      long l = Long.parseLong(paramString.substring(k + 4, i));
      return l;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      zzkh.zzcy("Invalid index for Url fetch time in CSI latency info.");
      return -1L;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        zzkh.zzcy("Cannot find valid format of Url fetch time in CSI latency info.");
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */