package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh.zza;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@zzir
public class zzjy
{
  public final int errorCode;
  public final int orientation;
  public final List<String> zzbnq;
  public final List<String> zzbnr;
  public final List<String> zzbnt;
  public final long zzbnw;
  public final zzgd zzbor;
  public final zzgo zzbos;
  public final String zzbot;
  public final zzgg zzbou;
  public final zzll zzbtq;
  public final AdRequestParcel zzcav;
  public final String zzcay;
  public final long zzccb;
  public final boolean zzccc;
  public final long zzccd;
  public final List<String> zzcce;
  public final String zzcch;
  public final RewardItemParcel zzccr;
  public final List<String> zzcct;
  public final boolean zzccu;
  public final AutoClickProtectionConfigurationParcel zzccv;
  public final JSONObject zzcii;
  public boolean zzcij;
  public final zzge zzcik;
  public final String zzcil;
  public final AdSizeParcel zzcim;
  public final List<String> zzcin;
  public final long zzcio;
  public final long zzcip;
  public final zzh.zza zzciq;
  public boolean zzcir = false;
  public boolean zzcis = false;
  
  public zzjy(AdRequestParcel paramAdRequestParcel, zzll paramzzll, List<String> paramList1, int paramInt1, List<String> paramList2, List<String> paramList3, int paramInt2, long paramLong1, String paramString1, boolean paramBoolean1, zzgd paramzzgd, zzgo paramzzgo, String paramString2, zzge paramzzge, zzgg paramzzgg, long paramLong2, AdSizeParcel paramAdSizeParcel, long paramLong3, long paramLong4, long paramLong5, String paramString3, JSONObject paramJSONObject, zzh.zza paramzza, RewardItemParcel paramRewardItemParcel, List<String> paramList4, List<String> paramList5, boolean paramBoolean2, AutoClickProtectionConfigurationParcel paramAutoClickProtectionConfigurationParcel, String paramString4, List<String> paramList6)
  {
    zzcav = paramAdRequestParcel;
    zzbtq = paramzzll;
    zzbnq = zzl(paramList1);
    errorCode = paramInt1;
    zzbnr = zzl(paramList2);
    zzcce = zzl(paramList3);
    orientation = paramInt2;
    zzbnw = paramLong1;
    zzcay = paramString1;
    zzccc = paramBoolean1;
    zzbor = paramzzgd;
    zzbos = paramzzgo;
    zzbot = paramString2;
    zzcik = paramzzge;
    zzbou = paramzzgg;
    zzccd = paramLong2;
    zzcim = paramAdSizeParcel;
    zzccb = paramLong3;
    zzcio = paramLong4;
    zzcip = paramLong5;
    zzcch = paramString3;
    zzcii = paramJSONObject;
    zzciq = paramzza;
    zzccr = paramRewardItemParcel;
    zzcin = zzl(paramList4);
    zzcct = zzl(paramList5);
    zzccu = paramBoolean2;
    zzccv = paramAutoClickProtectionConfigurationParcel;
    zzcil = paramString4;
    zzbnt = zzl(paramList6);
  }
  
  public zzjy(zza paramzza, zzll paramzzll, zzgd paramzzgd, zzgo paramzzgo, String paramString1, zzgg paramzzgg, zzh.zza paramzza1, String paramString2)
  {
    this(zzcit.zzcav, paramzzll, zzciu.zzbnq, errorCode, zzciu.zzbnr, zzciu.zzcce, zzciu.orientation, zzciu.zzbnw, zzcit.zzcay, zzciu.zzccc, paramzzgd, paramzzgo, paramString1, zzcik, paramzzgg, zzciu.zzccd, zzaoy, zzciu.zzccb, zzcio, zzcip, zzciu.zzcch, zzcii, paramzza1, zzciu.zzccr, zzciu.zzccs, zzciu.zzccs, zzciu.zzccu, zzciu.zzccv, paramString2, zzciu.zzbnt);
  }
  
  private static <T> List<T> zzl(List<T> paramList)
  {
    if (paramList == null) {
      return null;
    }
    return Collections.unmodifiableList(paramList);
  }
  
  public boolean zzho()
  {
    if ((zzbtq == null) || (zzbtq.zzuk() == null)) {
      return false;
    }
    return zzbtq.zzuk().zzho();
  }
  
  @zzir
  public static final class zza
  {
    public final int errorCode;
    public final AdSizeParcel zzaoy;
    public final JSONObject zzcii;
    public final zzge zzcik;
    public final long zzcio;
    public final long zzcip;
    public final AdRequestInfoParcel zzcit;
    public final AdResponseParcel zzciu;
    
    public zza(AdRequestInfoParcel paramAdRequestInfoParcel, AdResponseParcel paramAdResponseParcel, zzge paramzzge, AdSizeParcel paramAdSizeParcel, int paramInt, long paramLong1, long paramLong2, JSONObject paramJSONObject)
    {
      zzcit = paramAdRequestInfoParcel;
      zzciu = paramAdResponseParcel;
      zzcik = paramzzge;
      zzaoy = paramAdSizeParcel;
      errorCode = paramInt;
      zzcio = paramLong1;
      zzcip = paramLong2;
      zzcii = paramJSONObject;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */