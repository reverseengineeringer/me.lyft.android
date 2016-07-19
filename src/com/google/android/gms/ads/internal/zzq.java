package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzg;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.formats.zzh.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzgo;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzgs;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzjy.zza;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import java.util.List;

@zzir
public class zzq
  extends zzb
{
  public zzq(Context paramContext, zzd paramzzd, AdSizeParcel paramAdSizeParcel, String paramString, zzgn paramzzgn, VersionInfoParcel paramVersionInfoParcel)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramzzgn, paramVersionInfoParcel, paramzzd);
  }
  
  private static com.google.android.gms.ads.internal.formats.zzd zza(zzgr paramzzgr)
    throws RemoteException
  {
    String str1 = paramzzgr.getHeadline();
    List localList = paramzzgr.getImages();
    String str2 = paramzzgr.getBody();
    if (paramzzgr.zzkw() != null) {}
    for (zzdu localzzdu = paramzzgr.zzkw();; localzzdu = null) {
      return new com.google.android.gms.ads.internal.formats.zzd(str1, localList, str2, localzzdu, paramzzgr.getCallToAction(), paramzzgr.getStarRating(), paramzzgr.getStore(), paramzzgr.getPrice(), null, paramzzgr.getExtras());
    }
  }
  
  private static zze zza(zzgs paramzzgs)
    throws RemoteException
  {
    String str1 = paramzzgs.getHeadline();
    List localList = paramzzgs.getImages();
    String str2 = paramzzgs.getBody();
    if (paramzzgs.zzla() != null) {}
    for (zzdu localzzdu = paramzzgs.zzla();; localzzdu = null) {
      return new zze(str1, localList, str2, localzzdu, paramzzgs.getCallToAction(), paramzzgs.getAdvertiser(), null, paramzzgs.getExtras());
    }
  }
  
  private void zza(final com.google.android.gms.ads.internal.formats.zzd paramzzd)
  {
    zzkl.zzclg.post(new Runnable()
    {
      public void run()
      {
        try
        {
          if (zzajs.zzapi != null) {
            zzajs.zzapi.zza(paramzzd);
          }
          return;
        }
        catch (RemoteException localRemoteException)
        {
          zzkh.zzd("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", localRemoteException);
        }
      }
    });
  }
  
  private void zza(final zze paramzze)
  {
    zzkl.zzclg.post(new Runnable()
    {
      public void run()
      {
        try
        {
          if (zzajs.zzapj != null) {
            zzajs.zzapj.zza(paramzze);
          }
          return;
        }
        catch (RemoteException localRemoteException)
        {
          zzkh.zzd("Could not call OnContentAdLoadedListener.onContentAdLoaded().", localRemoteException);
        }
      }
    });
  }
  
  private void zza(final zzjy paramzzjy, final String paramString)
  {
    zzkl.zzclg.post(new Runnable()
    {
      public void run()
      {
        try
        {
          ((zzeh)zzajs.zzapl.get(paramString)).zza((zzf)paramzzjyzzciq);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          zzkh.zzd("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", localRemoteException);
        }
      }
    });
  }
  
  public void pause()
  {
    throw new IllegalStateException("Native Ad DOES NOT support pause().");
  }
  
  public void resume()
  {
    throw new IllegalStateException("Native Ad DOES NOT support resume().");
  }
  
  public void showInterstitial()
  {
    throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
  }
  
  public void zza(SimpleArrayMap<String, zzeh> paramSimpleArrayMap)
  {
    zzab.zzhj("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
    zzajs.zzapl = paramSimpleArrayMap;
  }
  
  public void zza(zzh paramzzh)
  {
    if (zzajs.zzaoz.zzcii != null) {
      zzu.zzft().zzsv().zza(zzajs.zzaoy, zzajs.zzaoz, paramzzh);
    }
  }
  
  public void zza(zzdo paramzzdo)
  {
    throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
  }
  
  public void zza(zzhs paramzzhs)
  {
    throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
  }
  
  public void zza(final zzjy.zza paramzza, zzdk paramzzdk)
  {
    if (zzaoy != null) {
      zzajs.zzaoy = zzaoy;
    }
    if (errorCode != -2)
    {
      zzkl.zzclg.post(new Runnable()
      {
        public void run()
        {
          zzb(new zzjy(paramzza, null, null, null, null, null, null, null));
        }
      });
      return;
    }
    zzajs.zzapu = 0;
    zzajs.zzaox = zzu.zzfp().zza(zzajs.zzagf, this, paramzza, zzajs.zzaot, null, zzajz, this, paramzzdk);
    paramzza = String.valueOf(zzajs.zzaox.getClass().getName());
    if (paramzza.length() != 0) {}
    for (paramzza = "AdRenderer: ".concat(paramzza);; paramzza = new String("AdRenderer: "))
    {
      zzkh.zzcw(paramzza);
      return;
    }
  }
  
  protected boolean zza(AdRequestParcel paramAdRequestParcel, zzjy paramzzjy, boolean paramBoolean)
  {
    return zzajr.zzfc();
  }
  
  protected boolean zza(zzjy paramzzjy1, zzjy paramzzjy2)
  {
    Object localObject2 = null;
    zzb(null);
    if (!zzajs.zzgp()) {
      throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
    }
    if (zzccc) {}
    for (;;)
    {
      try
      {
        if (zzbos == null) {
          continue;
        }
        localObject1 = zzbos.zzmq();
        if (zzbos != null) {
          localObject2 = zzbos.zzmr();
        }
        if ((localObject1 == null) || (zzajs.zzapi == null)) {
          continue;
        }
        localObject2 = zza((zzgr)localObject1);
        ((com.google.android.gms.ads.internal.formats.zzd)localObject2).zzb(new zzg(zzajs.zzagf, this, zzajs.zzaot, (zzgr)localObject1));
        zza((com.google.android.gms.ads.internal.formats.zzd)localObject2);
      }
      catch (RemoteException localRemoteException)
      {
        Object localObject1;
        zzkh.zzd("Failed to get native ad mapper", localRemoteException);
        continue;
        zzkh.zzcy("No matching mapper/listener for retrieved native ad template.");
        zzh(0);
        return false;
      }
      return super.zza(paramzzjy1, paramzzjy2);
      localObject1 = null;
      continue;
      if ((localObject2 != null) && (zzajs.zzapj != null))
      {
        localObject1 = zza((zzgs)localObject2);
        ((zze)localObject1).zzb(new zzg(zzajs.zzagf, this, zzajs.zzaot, (zzgs)localObject2));
        zza((zze)localObject1);
      }
      else
      {
        zzh.zza localzza = zzciq;
        if (((localzza instanceof zze)) && (zzajs.zzapj != null))
        {
          zza((zze)zzciq);
        }
        else if (((localzza instanceof com.google.android.gms.ads.internal.formats.zzd)) && (zzajs.zzapi != null))
        {
          zza((com.google.android.gms.ads.internal.formats.zzd)zzciq);
        }
        else
        {
          if ((!(localzza instanceof zzf)) || (zzajs.zzapl == null) || (zzajs.zzapl.get(((zzf)localzza).getCustomTemplateId()) == null)) {
            break;
          }
          zza(paramzzjy2, ((zzf)localzza).getCustomTemplateId());
        }
      }
    }
    zzkh.zzcy("No matching listener for retrieved native ad template.");
    zzh(0);
    return false;
  }
  
  public void zzb(SimpleArrayMap<String, zzeg> paramSimpleArrayMap)
  {
    zzab.zzhj("setOnCustomClickListener must be called on the main UI thread.");
    zzajs.zzapk = paramSimpleArrayMap;
  }
  
  public void zzb(NativeAdOptionsParcel paramNativeAdOptionsParcel)
  {
    zzab.zzhj("setNativeAdOptions must be called on the main UI thread.");
    zzajs.zzapm = paramNativeAdOptionsParcel;
  }
  
  public void zzb(zzee paramzzee)
  {
    zzab.zzhj("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
    zzajs.zzapi = paramzzee;
  }
  
  public void zzb(zzef paramzzef)
  {
    zzab.zzhj("setOnContentAdLoadedListener must be called on the main UI thread.");
    zzajs.zzapj = paramzzef;
  }
  
  public void zzb(List<String> paramList)
  {
    zzab.zzhj("setNativeTemplates must be called on the main UI thread.");
    zzajs.zzapq = paramList;
  }
  
  public SimpleArrayMap<String, zzeh> zzfb()
  {
    zzab.zzhj("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
    return zzajs.zzapl;
  }
  
  public zzeg zzv(String paramString)
  {
    zzab.zzhj("getOnCustomClickListener must be called on the main UI thread.");
    return (zzeg)zzajs.zzapk.get(paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */