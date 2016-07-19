package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;
import java.util.Collections;
import java.util.List;

@zzir
public final class AdResponseParcel
  extends AbstractSafeParcelable
{
  public static final zzh CREATOR = new zzh();
  public String body;
  public final int errorCode;
  public final int orientation;
  public final int versionCode;
  public final boolean zzaus;
  public final boolean zzaut;
  public final boolean zzauu;
  public final List<String> zzbnq;
  public final List<String> zzbnr;
  public final List<String> zzbnt;
  public final boolean zzbnu;
  public final long zzbnw;
  private AdRequestInfoParcel zzbox;
  public final String zzbts;
  public final boolean zzcbd;
  public final boolean zzcbu;
  public String zzcbv;
  public final long zzccb;
  public final boolean zzccc;
  public final long zzccd;
  public final List<String> zzcce;
  public final String zzccf;
  public final long zzccg;
  public final String zzcch;
  public final boolean zzcci;
  public final String zzccj;
  public final String zzcck;
  public final boolean zzccl;
  public final boolean zzccm;
  public final boolean zzccn;
  public LargeParcelTeleporter zzcco;
  public String zzccp;
  public final String zzccq;
  public final RewardItemParcel zzccr;
  public final List<String> zzccs;
  public final List<String> zzcct;
  public final boolean zzccu;
  public final AutoClickProtectionConfigurationParcel zzccv;
  public final String zzccw;
  public final String zzccx;
  
  public AdResponseParcel(int paramInt)
  {
    this(18, null, null, null, paramInt, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, null, false, null);
  }
  
  public AdResponseParcel(int paramInt, long paramLong)
  {
    this(18, null, null, null, paramInt, null, -1L, false, -1L, null, paramLong, -1, null, -1L, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, null, false, null);
  }
  
  AdResponseParcel(int paramInt1, String paramString1, String paramString2, List<String> paramList1, int paramInt2, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt3, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, LargeParcelTeleporter paramLargeParcelTeleporter, String paramString7, String paramString8, boolean paramBoolean8, boolean paramBoolean9, RewardItemParcel paramRewardItemParcel, List<String> paramList4, List<String> paramList5, boolean paramBoolean10, AutoClickProtectionConfigurationParcel paramAutoClickProtectionConfigurationParcel, boolean paramBoolean11, String paramString9, List<String> paramList6, String paramString10, boolean paramBoolean12, String paramString11)
  {
    versionCode = paramInt1;
    zzbts = paramString1;
    body = paramString2;
    if (paramList1 != null)
    {
      paramString1 = Collections.unmodifiableList(paramList1);
      zzbnq = paramString1;
      errorCode = paramInt2;
      if (paramList2 == null) {
        break label321;
      }
      paramString1 = Collections.unmodifiableList(paramList2);
      label52:
      zzbnr = paramString1;
      zzccb = paramLong1;
      zzccc = paramBoolean1;
      zzccd = paramLong2;
      if (paramList3 == null) {
        break label326;
      }
    }
    label321:
    label326:
    for (paramString1 = Collections.unmodifiableList(paramList3);; paramString1 = null)
    {
      zzcce = paramString1;
      zzbnw = paramLong3;
      orientation = paramInt3;
      zzccf = paramString3;
      zzccg = paramLong4;
      zzcch = paramString4;
      zzcci = paramBoolean2;
      zzccj = paramString5;
      zzcck = paramString6;
      zzccl = paramBoolean3;
      zzaus = paramBoolean4;
      zzcbd = paramBoolean5;
      zzccm = paramBoolean6;
      zzccn = paramBoolean7;
      zzcco = paramLargeParcelTeleporter;
      zzccp = paramString7;
      zzccq = paramString8;
      if ((body == null) && (zzcco != null))
      {
        paramString1 = (StringParcel)zzcco.zza(StringParcel.CREATOR);
        if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.zzrf()))) {
          body = paramString1.zzrf();
        }
      }
      zzaut = paramBoolean8;
      zzauu = paramBoolean9;
      zzccr = paramRewardItemParcel;
      zzccs = paramList4;
      zzcct = paramList5;
      zzccu = paramBoolean10;
      zzccv = paramAutoClickProtectionConfigurationParcel;
      zzcbu = paramBoolean11;
      zzcbv = paramString9;
      zzbnt = paramList6;
      zzccw = paramString10;
      zzbnu = paramBoolean12;
      zzccx = paramString11;
      return;
      paramString1 = null;
      break;
      paramString1 = null;
      break label52;
    }
  }
  
  public AdResponseParcel(AdRequestInfoParcel paramAdRequestInfoParcel, String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt, String paramString3, long paramLong4, String paramString4, String paramString5, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, String paramString6, boolean paramBoolean7, boolean paramBoolean8, RewardItemParcel paramRewardItemParcel, List<String> paramList4, List<String> paramList5, boolean paramBoolean9, AutoClickProtectionConfigurationParcel paramAutoClickProtectionConfigurationParcel, boolean paramBoolean10, String paramString7, List<String> paramList6, String paramString8, boolean paramBoolean11, String paramString9)
  {
    this(18, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean1, paramLong2, paramList3, paramLong3, paramInt, paramString3, paramLong4, paramString4, false, null, paramString5, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, null, null, paramString6, paramBoolean7, paramBoolean8, paramRewardItemParcel, paramList4, paramList5, paramBoolean9, paramAutoClickProtectionConfigurationParcel, paramBoolean10, paramString7, paramList6, paramString8, paramBoolean11, paramString9);
    zzbox = paramAdRequestInfoParcel;
  }
  
  public AdResponseParcel(AdRequestInfoParcel paramAdRequestInfoParcel, String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, String paramString7, boolean paramBoolean8, boolean paramBoolean9, RewardItemParcel paramRewardItemParcel, List<String> paramList4, List<String> paramList5, boolean paramBoolean10, AutoClickProtectionConfigurationParcel paramAutoClickProtectionConfigurationParcel, boolean paramBoolean11, String paramString8, List<String> paramList6, String paramString9, boolean paramBoolean12, String paramString10)
  {
    this(18, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean1, paramLong2, paramList3, paramLong3, paramInt, paramString3, paramLong4, paramString4, paramBoolean2, paramString5, paramString6, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, paramBoolean7, null, null, paramString7, paramBoolean8, paramBoolean9, paramRewardItemParcel, paramList4, paramList5, paramBoolean10, paramAutoClickProtectionConfigurationParcel, paramBoolean11, paramString8, paramList6, paramString9, paramBoolean12, paramString10);
    zzbox = paramAdRequestInfoParcel;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if ((zzbox != null) && (zzbox.versionCode >= 9) && (!TextUtils.isEmpty(body)))
    {
      zzcco = new LargeParcelTeleporter(new StringParcel(body));
      body = null;
    }
    zzh.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.AdResponseParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */