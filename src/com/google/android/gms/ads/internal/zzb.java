package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import android.util.DisplayMetrics;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.purchase.zzc;
import com.google.android.gms.ads.internal.purchase.zzf;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.ads.internal.purchase.zzj;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzfg;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzgf;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzgo;
import com.google.android.gms.internal.zzhp;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhw;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzjz;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzll;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;

@zzir
public abstract class zzb
  extends zza
  implements com.google.android.gms.ads.internal.overlay.zzg, zzj, zzs, zzev, zzgf
{
  private final Messenger mMessenger;
  protected final zzgn zzajz;
  protected transient boolean zzaka;
  
  public zzb(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzgn paramzzgn, VersionInfoParcel paramVersionInfoParcel, zzd paramzzd)
  {
    this(new zzv(paramContext, paramAdSizeParcel, paramString, paramVersionInfoParcel), paramzzgn, null, paramzzd);
  }
  
  protected zzb(zzv paramzzv, zzgn paramzzgn, zzr paramzzr, zzd paramzzd)
  {
    super(paramzzv, paramzzr, paramzzd);
    zzajz = paramzzgn;
    mMessenger = new Messenger(new zzhp(zzajs.zzagf));
    zzaka = false;
  }
  
  private AdRequestInfoParcel.zza zza(AdRequestParcel paramAdRequestParcel, Bundle paramBundle, zzka paramzzka)
  {
    ApplicationInfo localApplicationInfo = zzajs.zzagf.getApplicationInfo();
    DisplayMetrics localDisplayMetrics;
    Object localObject1;
    String str2;
    String str3;
    long l1;
    String str4;
    Bundle localBundle;
    ArrayList localArrayList;
    PackageInfo localPackageInfo2;
    try
    {
      PackageInfo localPackageInfo1 = zzajs.zzagf.getPackageManager().getPackageInfo(packageName, 0);
      localDisplayMetrics = zzajs.zzagf.getResources().getDisplayMetrics();
      Object localObject2 = null;
      localObject1 = localObject2;
      if (zzajs.zzaov != null)
      {
        localObject1 = localObject2;
        if (zzajs.zzaov.getParent() != null)
        {
          localObject1 = new int[2];
          zzajs.zzaov.getLocationOnScreen((int[])localObject1);
          int k = localObject1[0];
          int m = localObject1[1];
          int n = zzajs.zzaov.getWidth();
          int i1 = zzajs.zzaov.getHeight();
          int j = 0;
          i = j;
          if (zzajs.zzaov.isShown())
          {
            i = j;
            if (k + n > 0)
            {
              i = j;
              if (m + i1 > 0)
              {
                i = j;
                if (k <= widthPixels)
                {
                  i = j;
                  if (m <= heightPixels) {
                    i = 1;
                  }
                }
              }
            }
          }
          localObject1 = new Bundle(5);
          ((Bundle)localObject1).putInt("x", k);
          ((Bundle)localObject1).putInt("y", m);
          ((Bundle)localObject1).putInt("width", n);
          ((Bundle)localObject1).putInt("height", i1);
          ((Bundle)localObject1).putInt("visible", i);
        }
      }
      str2 = zzu.zzft().zzsk();
      zzajs.zzapb = new zzjz(str2, zzajs.zzaos);
      zzajs.zzapb.zzq(paramAdRequestParcel);
      str3 = zzu.zzfq().zza(zzajs.zzagf, zzajs.zzaov, zzajs.zzaoy);
      l2 = 0L;
      l1 = l2;
      if (zzajs.zzapf == null) {}
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      try
      {
        l1 = zzajs.zzapf.getValue();
        str4 = UUID.randomUUID().toString();
        localBundle = zzu.zzft().zza(zzajs.zzagf, this, str2);
        localArrayList = new ArrayList();
        int i = 0;
        while (i < zzajs.zzapl.size())
        {
          localArrayList.add((String)zzajs.zzapl.keyAt(i));
          i += 1;
          continue;
          localNameNotFoundException = localNameNotFoundException;
          localPackageInfo2 = null;
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          long l2;
          zzkh.zzcy("Cannot get correlation id, default to 0.");
          l1 = l2;
        }
      }
    }
    boolean bool1;
    if (zzajs.zzapg != null)
    {
      bool1 = true;
      if ((zzajs.zzaph == null) || (!zzu.zzft().zzsw())) {
        break label813;
      }
    }
    label813:
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool3 = zzajv.zzakl.zzr(zzajs.zzagf);
      String str1 = "";
      Object localObject3 = str1;
      if (((Boolean)zzdc.zzbdl.get()).booleanValue())
      {
        zzkh.zzcw("Getting webview cookie from CookieManager.");
        CookieManager localCookieManager = zzu.zzfs().zzao(zzajs.zzagf);
        localObject3 = str1;
        if (localCookieManager != null) {
          localObject3 = localCookieManager.getCookie("googleads.g.doubleclick.net");
        }
      }
      str1 = null;
      if (paramzzka != null) {
        str1 = paramzzka.zzsh();
      }
      return new AdRequestInfoParcel.zza((Bundle)localObject1, paramAdRequestParcel, zzajs.zzaoy, zzajs.zzaos, localApplicationInfo, localPackageInfo2, str2, zzu.zzft().getSessionId(), zzajs.zzaou, localBundle, zzajs.zzapq, localArrayList, paramBundle, zzu.zzft().zzso(), mMessenger, widthPixels, heightPixels, density, str3, l1, str4, zzdc.zzjx(), zzajs.zzaor, zzajs.zzapm, new CapabilityParcel(bool1, bool2, bool3), zzajs.zzgt(), zzu.zzfq().zzey(), zzu.zzfq().zzfa(), zzu.zzfq().zzam(zzajs.zzagf), zzu.zzfq().zzn(zzajs.zzaov), zzajs.zzagf instanceof Activity, zzu.zzft().zzss(), (String)localObject3, str1, zzu.zzft().zzst(), zzu.zzgj().zzlm(), zzu.zzfq().zztj());
      bool1 = false;
      break;
    }
  }
  
  public String getMediationAdapterClassName()
  {
    if (zzajs.zzaoz == null) {
      return null;
    }
    return zzajs.zzaoz.zzbot;
  }
  
  public void onAdClicked()
  {
    if (zzajs.zzaoz == null)
    {
      zzkh.zzcy("Ad state was null when trying to ping click URLs.");
      return;
    }
    if ((zzajs.zzaoz.zzcik != null) && (zzajs.zzaoz.zzcik.zzbnq != null)) {
      zzu.zzgf().zza(zzajs.zzagf, zzajs.zzaou.zzcs, zzajs.zzaoz, zzajs.zzaos, false, zzajs.zzaoz.zzcik.zzbnq);
    }
    if ((zzajs.zzaoz.zzbor != null) && (zzajs.zzaoz.zzbor.zzbnd != null)) {
      zzu.zzgf().zza(zzajs.zzagf, zzajs.zzaou.zzcs, zzajs.zzaoz, zzajs.zzaos, false, zzajs.zzaoz.zzbor.zzbnd);
    }
    super.onAdClicked();
  }
  
  public void onPause()
  {
    zzaju.zzk(zzajs.zzaoz);
  }
  
  public void onResume()
  {
    zzaju.zzl(zzajs.zzaoz);
  }
  
  public void pause()
  {
    zzab.zzhj("pause must be called on the main UI thread.");
    if ((zzajs.zzaoz != null) && (zzajs.zzaoz.zzbtq != null) && (zzajs.zzgp())) {
      zzu.zzfs().zzj(zzajs.zzaoz.zzbtq);
    }
    if ((zzajs.zzaoz != null) && (zzajs.zzaoz.zzbos != null)) {}
    try
    {
      zzajs.zzaoz.zzbos.pause();
      zzaju.zzk(zzajs.zzaoz);
      zzajr.pause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzkh.zzcy("Could not pause mediation adapter.");
      }
    }
  }
  
  public void recordImpression()
  {
    zza(zzajs.zzaoz, false);
  }
  
  public void resume()
  {
    zzab.zzhj("resume must be called on the main UI thread.");
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (zzajs.zzaoz != null)
    {
      localObject1 = localObject2;
      if (zzajs.zzaoz.zzbtq != null) {
        localObject1 = zzajs.zzaoz.zzbtq;
      }
    }
    if ((localObject1 != null) && (zzajs.zzgp())) {
      zzu.zzfs().zzk(zzajs.zzaoz.zzbtq);
    }
    if ((zzajs.zzaoz != null) && (zzajs.zzaoz.zzbos != null)) {}
    try
    {
      zzajs.zzaoz.zzbos.resume();
      if ((localObject1 == null) || (!((zzll)localObject1).zzuq())) {
        zzajr.resume();
      }
      zzaju.zzl(zzajs.zzaoz);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzkh.zzcy("Could not resume mediation adapter.");
      }
    }
  }
  
  public void showInterstitial()
  {
    throw new IllegalStateException("showInterstitial is not supported for current ad type");
  }
  
  public void zza(zzhs paramzzhs)
  {
    zzab.zzhj("setInAppPurchaseListener must be called on the main UI thread.");
    zzajs.zzapg = paramzzhs;
  }
  
  public void zza(zzhw paramzzhw, String paramString)
  {
    zzab.zzhj("setPlayStorePurchaseParams must be called on the main UI thread.");
    zzajs.zzapr = new zzk(paramString);
    zzajs.zzaph = paramzzhw;
    if ((!zzu.zzft().zzsn()) && (paramzzhw != null)) {
      paramzzhw = (Future)new zzc(zzajs.zzagf, zzajs.zzaph, zzajs.zzapr).zzpz();
    }
  }
  
  protected void zza(zzjy paramzzjy, boolean paramBoolean)
  {
    if (paramzzjy == null) {
      zzkh.zzcy("Ad state was null when trying to ping impression URLs.");
    }
    do
    {
      return;
      super.zzc(paramzzjy);
      if ((zzcik != null) && (zzcik.zzbnr != null)) {
        zzu.zzgf().zza(zzajs.zzagf, zzajs.zzaou.zzcs, paramzzjy, zzajs.zzaos, paramBoolean, zzcik.zzbnr);
      }
    } while ((zzbor == null) || (zzbor.zzbne == null));
    zzu.zzgf().zza(zzajs.zzagf, zzajs.zzaou.zzcs, paramzzjy, zzajs.zzaos, paramBoolean, zzbor.zzbne);
  }
  
  public void zza(String paramString, ArrayList<String> paramArrayList)
  {
    paramArrayList = new com.google.android.gms.ads.internal.purchase.zzd(paramString, paramArrayList, zzajs.zzagf, zzajs.zzaou.zzcs);
    if (zzajs.zzapg == null)
    {
      zzkh.zzcy("InAppPurchaseListener is not set. Try to launch default purchase flow.");
      if (!com.google.android.gms.ads.internal.client.zzm.zziw().zzar(zzajs.zzagf))
      {
        zzkh.zzcy("Google Play Service unavailable, cannot launch default purchase flow.");
        return;
      }
      if (zzajs.zzaph == null)
      {
        zzkh.zzcy("PlayStorePurchaseListener is not set.");
        return;
      }
      if (zzajs.zzapr == null)
      {
        zzkh.zzcy("PlayStorePurchaseVerifier is not initialized.");
        return;
      }
      if (zzajs.zzapv)
      {
        zzkh.zzcy("An in-app purchase request is already in progress, abort");
        return;
      }
      zzajs.zzapv = true;
      try
      {
        if (!zzajs.zzaph.isValidPurchase(paramString))
        {
          zzajs.zzapv = false;
          return;
        }
      }
      catch (RemoteException paramString)
      {
        zzkh.zzcy("Could not start In-App purchase.");
        zzajs.zzapv = false;
        return;
      }
      zzu.zzga().zza(zzajs.zzagf, zzajs.zzaou.zzcnq, new GInAppPurchaseManagerInfoParcel(zzajs.zzagf, zzajs.zzapr, paramArrayList, this));
      return;
    }
    try
    {
      zzajs.zzapg.zza(paramArrayList);
      return;
    }
    catch (RemoteException paramString)
    {
      zzkh.zzcy("Could not start In-App purchase.");
    }
  }
  
  public void zza(String paramString, boolean paramBoolean, int paramInt, final Intent paramIntent, zzf paramzzf)
  {
    try
    {
      if (zzajs.zzaph != null) {
        zzajs.zzaph.zza(new com.google.android.gms.ads.internal.purchase.zzg(zzajs.zzagf, paramString, paramBoolean, paramInt, paramIntent, paramzzf));
      }
      zzkl.zzclg.postDelayed(new Runnable()
      {
        public void run()
        {
          int i = zzu.zzga().zzd(paramIntent);
          zzu.zzga();
          if ((i == 0) && (zzajs.zzaoz != null) && (zzajs.zzaoz.zzbtq != null) && (zzajs.zzaoz.zzbtq.zzui() != null)) {
            zzajs.zzaoz.zzbtq.zzui().close();
          }
          zzajs.zzapv = false;
        }
      }, 500L);
      return;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        zzkh.zzcy("Fail to invoke PlayStorePurchaseListener.");
      }
    }
  }
  
  public boolean zza(AdRequestParcel paramAdRequestParcel, zzdk paramzzdk)
  {
    Object localObject = null;
    if (!zzdx()) {
      return false;
    }
    Bundle localBundle = zza(zzu.zzft().zzaa(zzajs.zzagf));
    zzajr.cancel();
    zzajs.zzapu = 0;
    zzka localzzka;
    if (((Boolean)zzdc.zzbcr.get()).booleanValue())
    {
      localzzka = zzu.zzft().zzsu();
      zzg localzzg = zzu.zzgi();
      Context localContext = zzajs.zzagf;
      VersionInfoParcel localVersionInfoParcel = zzajs.zzaou;
      if (localzzka == null) {
        localzzg.zza(localContext, localVersionInfoParcel, false, localzzka, (String)localObject, zzajs.zzaos);
      }
    }
    for (localObject = localzzka;; localObject = null)
    {
      paramAdRequestParcel = zza(paramAdRequestParcel, localBundle, (zzka)localObject);
      paramzzdk.zzh("seq_num", zzcay);
      paramzzdk.zzh("request_id", zzcbk);
      paramzzdk.zzh("session_id", zzcaz);
      if (zzcaw != null) {
        paramzzdk.zzh("app_version", String.valueOf(zzcaw.versionCode));
      }
      zzajs.zzaow = zzu.zzfm().zza(zzajs.zzagf, paramAdRequestParcel, zzajs.zzaot, this);
      return true;
      localObject = localzzka.zzsi();
      break;
    }
  }
  
  protected boolean zza(AdRequestParcel paramAdRequestParcel, zzjy paramzzjy, boolean paramBoolean)
  {
    if ((!paramBoolean) && (zzajs.zzgp()))
    {
      if (zzbnw <= 0L) {
        break label43;
      }
      zzajr.zza(paramAdRequestParcel, zzbnw);
    }
    for (;;)
    {
      return zzajr.zzfc();
      label43:
      if ((zzcik != null) && (zzcik.zzbnw > 0L)) {
        zzajr.zza(paramAdRequestParcel, zzcik.zzbnw);
      } else if ((!zzccc) && (errorCode == 2)) {
        zzajr.zzg(paramAdRequestParcel);
      }
    }
  }
  
  boolean zza(zzjy paramzzjy)
  {
    boolean bool = false;
    Object localObject;
    if (zzajt != null)
    {
      localObject = zzajt;
      zzajt = null;
    }
    for (;;)
    {
      return zza((AdRequestParcel)localObject, paramzzjy, bool);
      AdRequestParcel localAdRequestParcel = zzcav;
      localObject = localAdRequestParcel;
      if (extras != null)
      {
        bool = extras.getBoolean("_noRefresh", false);
        localObject = localAdRequestParcel;
      }
    }
  }
  
  protected boolean zza(zzjy paramzzjy1, zzjy paramzzjy2)
  {
    int i = 0;
    if ((paramzzjy1 != null) && (zzbou != null)) {
      zzbou.zza(null);
    }
    if (zzbou != null) {
      zzbou.zza(this);
    }
    int j;
    if (zzcik != null)
    {
      j = zzcik.zzboc;
      i = zzcik.zzbod;
    }
    for (;;)
    {
      zzajs.zzaps.zzh(j, i);
      return true;
      j = 0;
    }
  }
  
  public void zzb(zzjy paramzzjy)
  {
    super.zzb(paramzzjy);
    if (zzbor != null)
    {
      zzkh.zzcw("Pinging network fill URLs.");
      zzu.zzgf().zza(zzajs.zzagf, zzajs.zzaou.zzcs, paramzzjy, zzajs.zzaos, false, zzbor.zzbnf);
      if ((zzcik.zzbnt != null) && (zzcik.zzbnt.size() > 0))
      {
        zzkh.zzcw("Pinging urls remotely");
        zzu.zzfq().zza(zzajs.zzagf, zzcik.zzbnt);
      }
    }
    if ((errorCode == 3) && (zzcik != null) && (zzcik.zzbns != null))
    {
      zzkh.zzcw("Pinging no fill URLs.");
      zzu.zzgf().zza(zzajs.zzagf, zzajs.zzaou.zzcs, paramzzjy, zzajs.zzaos, false, zzcik.zzbns);
    }
  }
  
  protected boolean zzc(AdRequestParcel paramAdRequestParcel)
  {
    return (super.zzc(paramAdRequestParcel)) && (!zzaka);
  }
  
  protected boolean zzdx()
  {
    boolean bool = true;
    if ((!zzu.zzfq().zza(zzajs.zzagf.getPackageManager(), zzajs.zzagf.getPackageName(), "android.permission.INTERNET")) || (!zzu.zzfq().zzac(zzajs.zzagf))) {
      bool = false;
    }
    return bool;
  }
  
  public void zzdy()
  {
    zzaju.zzi(zzajs.zzaoz);
    zzaka = false;
    zzds();
    zzajs.zzapb.zzsb();
  }
  
  public void zzdz()
  {
    zzaka = true;
    zzdu();
  }
  
  public void zzea()
  {
    onAdClicked();
  }
  
  public void zzeb()
  {
    zzdy();
  }
  
  public void zzec()
  {
    zzdp();
  }
  
  public void zzed()
  {
    zzdz();
  }
  
  public void zzee()
  {
    if (zzajs.zzaoz != null)
    {
      String str = zzajs.zzaoz.zzbot;
      zzkh.zzcy(String.valueOf(str).length() + 74 + "Mediation adapter " + str + " refreshed, but mediation adapters should never refresh.");
    }
    zza(zzajs.zzaoz, true);
    zzdv();
  }
  
  public void zzef()
  {
    recordImpression();
  }
  
  public void zzeg()
  {
    zzu.zzfq().runOnUiThread(new Runnable()
    {
      public void run()
      {
        zzajr.pause();
      }
    });
  }
  
  public void zzeh()
  {
    zzu.zzfq().runOnUiThread(new Runnable()
    {
      public void run()
      {
        zzajr.resume();
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */