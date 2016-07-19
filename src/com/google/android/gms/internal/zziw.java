package com.google.android.gms.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.zzu;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public final class zziw
{
  private int mOrientation = -1;
  private boolean zzawl = false;
  private String zzbfm;
  private final AdRequestInfoParcel zzbox;
  private List<String> zzbzj;
  private String zzcex;
  private String zzcey;
  private List<String> zzcez;
  private String zzcfa;
  private String zzcfb;
  private List<String> zzcfc;
  private long zzcfd = -1L;
  private boolean zzcfe = false;
  private final long zzcff = -1L;
  private long zzcfg = -1L;
  private boolean zzcfh = false;
  private boolean zzcfi = false;
  private boolean zzcfj = false;
  private boolean zzcfk = true;
  private String zzcfl = "";
  private boolean zzcfm = false;
  private RewardItemParcel zzcfn;
  private List<String> zzcfo;
  private List<String> zzcfp;
  private boolean zzcfq = false;
  private AutoClickProtectionConfigurationParcel zzcfr;
  private boolean zzcfs = false;
  private String zzcft;
  private List<String> zzcfu;
  private String zzcfv;
  private boolean zzcfw;
  private String zzcfx;
  
  public zziw(AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    zzbox = paramAdRequestInfoParcel;
  }
  
  private void zzaa(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Gws-Query-Id");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      zzcfl = ((String)paramMap.get(0));
    }
  }
  
  private void zzab(Map<String, List<String>> paramMap)
  {
    paramMap = zzd(paramMap, "X-Afma-Fluid");
    if ((paramMap != null) && (paramMap.equals("height"))) {
      zzcfm = true;
    }
  }
  
  private void zzac(Map<String, List<String>> paramMap)
  {
    zzawl = "native_express".equals(zzd(paramMap, "X-Afma-Ad-Format"));
  }
  
  private void zzad(Map<String, List<String>> paramMap)
  {
    zzcfn = RewardItemParcel.zzci(zzd(paramMap, "X-Afma-Rewards"));
  }
  
  private void zzae(Map<String, List<String>> paramMap)
  {
    if (zzcfo != null) {
      return;
    }
    zzcfo = zzf(paramMap, "X-Afma-Reward-Video-Start-Urls");
  }
  
  private void zzaf(Map<String, List<String>> paramMap)
  {
    if (zzcfp != null) {
      return;
    }
    zzcfp = zzf(paramMap, "X-Afma-Reward-Video-Complete-Urls");
  }
  
  private void zzag(Map<String, List<String>> paramMap)
  {
    zzcfq |= zzg(paramMap, "X-Afma-Use-Displayed-Impression");
  }
  
  private void zzah(Map<String, List<String>> paramMap)
  {
    zzcfs |= zzg(paramMap, "X-Afma-Auto-Collect-Location");
  }
  
  private void zzai(Map<String, List<String>> paramMap)
  {
    paramMap = zzf(paramMap, "X-Afma-Remote-Ping-Urls");
    if (paramMap != null) {
      zzcfu = paramMap;
    }
  }
  
  private void zzaj(Map<String, List<String>> paramMap)
  {
    paramMap = zzd(paramMap, "X-Afma-Auto-Protection-Configuration");
    if ((paramMap == null) || (TextUtils.isEmpty(paramMap)))
    {
      paramMap = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204").buildUpon();
      paramMap.appendQueryParameter("id", "gmob-apps-blocked-navigation");
      if (!TextUtils.isEmpty(zzcfa)) {
        paramMap.appendQueryParameter("debugDialog", zzcfa);
      }
      boolean bool = ((Boolean)zzdc.zzaye.get()).booleanValue();
      paramMap = String.valueOf(paramMap.toString());
      String str = String.valueOf("navigationURL");
      zzcfr = new AutoClickProtectionConfigurationParcel(bool, Arrays.asList(new String[] { String.valueOf(paramMap).length() + 18 + String.valueOf(str).length() + paramMap + "&" + str + "={NAVIGATION_URL}" }));
      return;
    }
    try
    {
      zzcfr = AutoClickProtectionConfigurationParcel.zzh(new JSONObject(paramMap));
      return;
    }
    catch (JSONException paramMap)
    {
      zzkh.zzd("Error parsing configuration JSON", paramMap);
      zzcfr = new AutoClickProtectionConfigurationParcel();
    }
  }
  
  private void zzak(Map<String, List<String>> paramMap)
  {
    zzcft = zzd(paramMap, "Set-Cookie");
  }
  
  private void zzal(Map<String, List<String>> paramMap)
  {
    zzcfv = zzd(paramMap, "X-Afma-Safe-Browsing");
  }
  
  static String zzd(Map<String, List<String>> paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      return (String)paramMap.get(0);
    }
    return null;
  }
  
  static long zze(Map<String, List<String>> paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (String)paramMap.get(0);
      try
      {
        float f = Float.parseFloat(paramMap);
        return (f * 1000.0F);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        zzkh.zzcy(String.valueOf(paramString).length() + 36 + String.valueOf(paramMap).length() + "Could not parse float from " + paramString + " header: " + paramMap);
      }
    }
    return -1L;
  }
  
  static List<String> zzf(Map<String, List<String>> paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (String)paramMap.get(0);
      if (paramMap != null) {
        return Arrays.asList(paramMap.trim().split("\\s+"));
      }
    }
    return null;
  }
  
  private boolean zzg(Map<String, List<String>> paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    return (paramMap != null) && (!paramMap.isEmpty()) && (Boolean.valueOf((String)paramMap.get(0)).booleanValue());
  }
  
  private void zzk(Map<String, List<String>> paramMap)
  {
    zzcex = zzd(paramMap, "X-Afma-Ad-Size");
  }
  
  private void zzl(Map<String, List<String>> paramMap)
  {
    zzcfx = zzd(paramMap, "X-Afma-Ad-Slot-Size");
  }
  
  private void zzm(Map<String, List<String>> paramMap)
  {
    paramMap = zzf(paramMap, "X-Afma-Click-Tracking-Urls");
    if (paramMap != null) {
      zzcez = paramMap;
    }
  }
  
  private void zzn(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Debug-Dialog");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      zzcfa = ((String)paramMap.get(0));
    }
  }
  
  private void zzo(Map<String, List<String>> paramMap)
  {
    paramMap = zzf(paramMap, "X-Afma-Tracking-Urls");
    if (paramMap != null) {
      zzcfc = paramMap;
    }
  }
  
  private void zzp(Map<String, List<String>> paramMap)
  {
    long l = zze(paramMap, "X-Afma-Interstitial-Timeout");
    if (l != -1L) {
      zzcfd = l;
    }
  }
  
  private void zzq(Map<String, List<String>> paramMap)
  {
    zzcfb = zzd(paramMap, "X-Afma-ActiveView");
  }
  
  private void zzr(Map<String, List<String>> paramMap)
  {
    zzcfi = "native".equals(zzd(paramMap, "X-Afma-Ad-Format"));
  }
  
  private void zzs(Map<String, List<String>> paramMap)
  {
    zzcfh |= zzg(paramMap, "X-Afma-Custom-Rendering-Allowed");
  }
  
  private void zzt(Map<String, List<String>> paramMap)
  {
    zzcfe |= zzg(paramMap, "X-Afma-Mediation");
  }
  
  private void zzu(Map<String, List<String>> paramMap)
  {
    zzcfw |= zzg(paramMap, "X-Afma-Render-In-Browser");
  }
  
  private void zzv(Map<String, List<String>> paramMap)
  {
    paramMap = zzf(paramMap, "X-Afma-Manual-Tracking-Urls");
    if (paramMap != null) {
      zzbzj = paramMap;
    }
  }
  
  private void zzw(Map<String, List<String>> paramMap)
  {
    long l = zze(paramMap, "X-Afma-Refresh-Rate");
    if (l != -1L) {
      zzcfg = l;
    }
  }
  
  private void zzx(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Orientation");
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (String)paramMap.get(0);
      if (!"portrait".equalsIgnoreCase(paramMap)) {
        break label58;
      }
      mOrientation = zzu.zzfs().zztl();
    }
    label58:
    while (!"landscape".equalsIgnoreCase(paramMap)) {
      return;
    }
    mOrientation = zzu.zzfs().zztk();
  }
  
  private void zzy(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Use-HTTPS");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      zzcfj = Boolean.valueOf((String)paramMap.get(0)).booleanValue();
    }
  }
  
  private void zzz(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Content-Url-Opted-Out");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      zzcfk = Boolean.valueOf((String)paramMap.get(0)).booleanValue();
    }
  }
  
  public void zzb(String paramString1, Map<String, List<String>> paramMap, String paramString2)
  {
    zzcey = paramString1;
    zzbfm = paramString2;
    zzj(paramMap);
  }
  
  public AdResponseParcel zzj(long paramLong)
  {
    return new AdResponseParcel(zzbox, zzcey, zzbfm, zzcez, zzcfc, zzcfd, zzcfe, -1L, zzbzj, zzcfg, mOrientation, zzcex, paramLong, zzcfa, zzcfb, zzcfh, zzcfi, zzcfj, zzcfk, false, zzcfl, zzcfm, zzawl, zzcfn, zzcfo, zzcfp, zzcfq, zzcfr, zzcfs, zzcft, zzcfu, zzcfv, zzcfw, zzcfx);
  }
  
  public void zzj(Map<String, List<String>> paramMap)
  {
    zzk(paramMap);
    zzl(paramMap);
    zzm(paramMap);
    zzn(paramMap);
    zzo(paramMap);
    zzp(paramMap);
    zzt(paramMap);
    zzv(paramMap);
    zzw(paramMap);
    zzx(paramMap);
    zzq(paramMap);
    zzy(paramMap);
    zzs(paramMap);
    zzr(paramMap);
    zzz(paramMap);
    zzaa(paramMap);
    zzab(paramMap);
    zzac(paramMap);
    zzad(paramMap);
    zzae(paramMap);
    zzaf(paramMap);
    zzag(paramMap);
    zzah(paramMap);
    zzak(paramMap);
    zzaj(paramMap);
    zzai(paramMap);
    zzal(paramMap);
    zzu(paramMap);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zziw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */