package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.dynamic.zze;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzjj
  extends zzb
  implements zzjm
{
  private static final zzgm zzchk = new zzgm();
  private final Map<String, zzjq> zzchl = new HashMap();
  private boolean zzchm;
  
  public zzjj(Context paramContext, zzd paramzzd, AdSizeParcel paramAdSizeParcel, zzgn paramzzgn, VersionInfoParcel paramVersionInfoParcel)
  {
    super(paramContext, paramAdSizeParcel, null, paramzzgn, paramVersionInfoParcel, paramzzd);
  }
  
  private zzjy.zza zze(zzjy.zza paramzza)
  {
    zzkh.v("Creating mediation ad response for non-mediated rewarded ad.");
    try
    {
      Object localObject1 = zziu.zzc(zzciu).toString();
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("pubid", zzcit.zzaos);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = new zzge(Arrays.asList(new zzgd[] { new zzgd((String)localObject1, null, Arrays.asList(new String[] { "com.google.ads.mediation.admob.AdMobAdapter" }), null, null, Collections.emptyList(), Collections.emptyList(), (String)localObject2, null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList()) }), -1L, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, "", -1L, 0, 1, null, 0, -1, -1L, false);
      return new zzjy.zza(zzcit, zzciu, (zzge)localObject1, zzaoy, errorCode, zzcio, zzcip, zzcii);
    }
    catch (JSONException localJSONException)
    {
      zzkh.zzb("Unable to generate ad state for non-mediated rewarded video.", localJSONException);
    }
    return zzf(paramzza);
  }
  
  private zzjy.zza zzf(zzjy.zza paramzza)
  {
    return new zzjy.zza(zzcit, zzciu, null, zzaoy, 0, zzcio, zzcip, zzcii);
  }
  
  public void destroy()
  {
    zzab.zzhj("destroy must be called on the main UI thread.");
    Iterator localIterator = zzchl.keySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          zzjq localzzjq = (zzjq)zzchl.get(str);
          if ((localzzjq != null) && (localzzjq.zzrv() != null)) {
            localzzjq.zzrv().destroy();
          }
        }
        catch (RemoteException localRemoteException)
        {
          str = String.valueOf(str);
          if (str.length() != 0) {}
          for (str = "Fail to destroy adapter: ".concat(str);; str = new String("Fail to destroy adapter: "))
          {
            zzkh.zzcy(str);
            break;
          }
        }
      }
    }
  }
  
  public boolean isLoaded()
  {
    zzab.zzhj("isLoaded must be called on the main UI thread.");
    return (zzajs.zzaow == null) && (zzajs.zzaox == null) && (zzajs.zzaoz != null) && (!zzchm);
  }
  
  public void onContextChanged(Context paramContext)
  {
    Iterator localIterator = zzchl.values().iterator();
    while (localIterator.hasNext())
    {
      zzjq localzzjq = (zzjq)localIterator.next();
      try
      {
        localzzjq.zzrv().zzj(zze.zzae(paramContext));
      }
      catch (RemoteException localRemoteException)
      {
        zzkh.zzb("Unable to call Adapter.onContextChanged.", localRemoteException);
      }
    }
  }
  
  public void onRewardedVideoAdClosed()
  {
    zzds();
  }
  
  public void onRewardedVideoAdLeftApplication()
  {
    zzdt();
  }
  
  public void onRewardedVideoAdOpened()
  {
    zza(zzajs.zzaoz, false);
    zzdu();
  }
  
  public void onRewardedVideoStarted()
  {
    if ((zzajs.zzaoz != null) && (zzajs.zzaoz.zzbor != null)) {
      zzu.zzgf().zza(zzajs.zzagf, zzajs.zzaou.zzcs, zzajs.zzaoz, zzajs.zzaos, false, zzajs.zzaoz.zzbor.zzbnh);
    }
    zzdw();
  }
  
  public void pause()
  {
    zzab.zzhj("pause must be called on the main UI thread.");
    Iterator localIterator = zzchl.keySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          zzjq localzzjq = (zzjq)zzchl.get(str);
          if ((localzzjq != null) && (localzzjq.zzrv() != null)) {
            localzzjq.zzrv().pause();
          }
        }
        catch (RemoteException localRemoteException)
        {
          str = String.valueOf(str);
          if (str.length() != 0) {}
          for (str = "Fail to pause adapter: ".concat(str);; str = new String("Fail to pause adapter: "))
          {
            zzkh.zzcy(str);
            break;
          }
        }
      }
    }
  }
  
  public void resume()
  {
    zzab.zzhj("resume must be called on the main UI thread.");
    Iterator localIterator = zzchl.keySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          zzjq localzzjq = (zzjq)zzchl.get(str);
          if ((localzzjq != null) && (localzzjq.zzrv() != null)) {
            localzzjq.zzrv().resume();
          }
        }
        catch (RemoteException localRemoteException)
        {
          str = String.valueOf(str);
          if (str.length() != 0) {}
          for (str = "Fail to resume adapter: ".concat(str);; str = new String("Fail to resume adapter: "))
          {
            zzkh.zzcy(str);
            break;
          }
        }
      }
    }
  }
  
  public void zza(RewardedVideoAdRequestParcel paramRewardedVideoAdRequestParcel)
  {
    zzab.zzhj("loadAd must be called on the main UI thread.");
    if (TextUtils.isEmpty(zzaos))
    {
      zzkh.zzcy("Invalid ad unit id. Aborting.");
      return;
    }
    zzchm = false;
    zzajs.zzaos = zzaos;
    super.zzb(zzcav);
  }
  
  public void zza(final zzjy.zza paramzza, zzdk paramzzdk)
  {
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
    zzajs.zzapa = paramzza;
    if (zzcik == null) {
      zzajs.zzapa = zze(paramzza);
    }
    zzajs.zzapu = 0;
    zzajs.zzaox = zzu.zzfp().zza(zzajs.zzagf, zzajs.zzapa, this);
  }
  
  protected boolean zza(AdRequestParcel paramAdRequestParcel, zzjy paramzzjy, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean zza(zzjy paramzzjy1, zzjy paramzzjy2)
  {
    return true;
  }
  
  public void zzc(RewardItemParcel paramRewardItemParcel)
  {
    if ((zzajs.zzaoz != null) && (zzajs.zzaoz.zzbor != null)) {
      zzu.zzgf().zza(zzajs.zzagf, zzajs.zzaou.zzcs, zzajs.zzaoz, zzajs.zzaos, false, zzajs.zzaoz.zzbor.zzbni);
    }
    RewardItemParcel localRewardItemParcel = paramRewardItemParcel;
    if (zzajs.zzaoz != null)
    {
      localRewardItemParcel = paramRewardItemParcel;
      if (zzajs.zzaoz.zzcik != null)
      {
        localRewardItemParcel = paramRewardItemParcel;
        if (!TextUtils.isEmpty(zzajs.zzaoz.zzcik.zzbnx)) {
          localRewardItemParcel = new RewardItemParcel(zzajs.zzaoz.zzcik.zzbnx, zzajs.zzaoz.zzcik.zzbny);
        }
      }
    }
    zza(localRewardItemParcel);
  }
  
  public zzjq zzcg(String paramString)
  {
    Object localObject1 = (zzjq)zzchl.get(paramString);
    Object localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = zzajz;
      if ("com.google.ads.mediation.admob.AdMobAdapter".equals(paramString))
      {
        localObject2 = zzchk;
        localObject2 = new zzjq(((zzgn)localObject2).zzbn(paramString), this);
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          zzchl.put(paramString, localObject2);
          return (zzjq)localObject2;
        }
        catch (Exception localException2)
        {
          localObject1 = localException1;
          Object localObject3 = localException2;
          continue;
        }
        localException1 = localException1;
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0)
        {
          paramString = "Fail to instantiate adapter ".concat(paramString);
          zzkh.zzd(paramString, localException1);
          return (zzjq)localObject1;
        }
        paramString = new String("Fail to instantiate adapter ");
      }
    }
  }
  
  public void zzrr()
  {
    zzab.zzhj("showAd must be called on the main UI thread.");
    if (!isLoaded()) {
      zzkh.zzcy("The reward video has not loaded.");
    }
    zzjq localzzjq;
    do
    {
      return;
      zzchm = true;
      localzzjq = zzcg(zzajs.zzaoz.zzbot);
    } while ((localzzjq == null) || (localzzjq.zzrv() == null));
    try
    {
      localzzjq.zzrv().showVideo();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzkh.zzd("Could not call showVideo.", localRemoteException);
    }
  }
  
  public void zzrs()
  {
    onAdClicked();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */