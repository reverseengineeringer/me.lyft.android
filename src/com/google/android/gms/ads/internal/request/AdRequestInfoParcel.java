package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;
import java.util.Collections;
import java.util.List;

@zzir
public final class AdRequestInfoParcel
  extends AbstractSafeParcelable
{
  public static final zzf CREATOR = new zzf();
  public final ApplicationInfo applicationInfo;
  public final int versionCode;
  public final String zzaor;
  public final String zzaos;
  public final VersionInfoParcel zzaou;
  public final AdSizeParcel zzaoy;
  public final NativeAdOptionsParcel zzapm;
  public final List<String> zzapq;
  public final boolean zzbnu;
  public final Bundle zzcau;
  public final AdRequestParcel zzcav;
  public final PackageInfo zzcaw;
  public final String zzcax;
  public final String zzcay;
  public final String zzcaz;
  public final Bundle zzcba;
  public final int zzcbb;
  public final Bundle zzcbc;
  public final boolean zzcbd;
  public final Messenger zzcbe;
  public final int zzcbf;
  public final int zzcbg;
  public final float zzcbh;
  public final String zzcbi;
  public final long zzcbj;
  public final String zzcbk;
  public final List<String> zzcbl;
  public final List<String> zzcbm;
  public final long zzcbn;
  public final CapabilityParcel zzcbo;
  public final String zzcbp;
  public final float zzcbq;
  public final int zzcbr;
  public final int zzcbs;
  public final boolean zzcbt;
  public final boolean zzcbu;
  public final String zzcbv;
  public final boolean zzcbw;
  public final String zzcbx;
  public final int zzcby;
  public final Bundle zzcbz;
  
  AdRequestInfoParcel(int paramInt1, Bundle paramBundle1, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, VersionInfoParcel paramVersionInfoParcel, Bundle paramBundle2, int paramInt2, List<String> paramList1, Bundle paramBundle3, boolean paramBoolean1, Messenger paramMessenger, int paramInt3, int paramInt4, float paramFloat1, String paramString5, long paramLong1, String paramString6, List<String> paramList2, String paramString7, NativeAdOptionsParcel paramNativeAdOptionsParcel, List<String> paramList3, long paramLong2, CapabilityParcel paramCapabilityParcel, String paramString8, float paramFloat2, boolean paramBoolean2, int paramInt5, int paramInt6, boolean paramBoolean3, boolean paramBoolean4, String paramString9, String paramString10, boolean paramBoolean5, int paramInt7, Bundle paramBundle4)
  {
    versionCode = paramInt1;
    zzcau = paramBundle1;
    zzcav = paramAdRequestParcel;
    zzaoy = paramAdSizeParcel;
    zzaos = paramString1;
    applicationInfo = paramApplicationInfo;
    zzcaw = paramPackageInfo;
    zzcax = paramString2;
    zzcay = paramString3;
    zzcaz = paramString4;
    zzaou = paramVersionInfoParcel;
    zzcba = paramBundle2;
    zzcbb = paramInt2;
    zzapq = paramList1;
    if (paramList3 == null)
    {
      paramBundle1 = Collections.emptyList();
      zzcbm = paramBundle1;
      zzcbc = paramBundle3;
      zzcbd = paramBoolean1;
      zzcbe = paramMessenger;
      zzcbf = paramInt3;
      zzcbg = paramInt4;
      zzcbh = paramFloat1;
      zzcbi = paramString5;
      zzcbj = paramLong1;
      zzcbk = paramString6;
      if (paramList2 != null) {
        break label273;
      }
    }
    label273:
    for (paramBundle1 = Collections.emptyList();; paramBundle1 = Collections.unmodifiableList(paramList2))
    {
      zzcbl = paramBundle1;
      zzaor = paramString7;
      zzapm = paramNativeAdOptionsParcel;
      zzcbn = paramLong2;
      zzcbo = paramCapabilityParcel;
      zzcbp = paramString8;
      zzcbq = paramFloat2;
      zzcbw = paramBoolean2;
      zzcbr = paramInt5;
      zzcbs = paramInt6;
      zzcbt = paramBoolean3;
      zzcbu = paramBoolean4;
      zzcbv = paramString9;
      zzcbx = paramString10;
      zzbnu = paramBoolean5;
      zzcby = paramInt7;
      zzcbz = paramBundle4;
      return;
      paramBundle1 = Collections.unmodifiableList(paramList3);
      break;
    }
  }
  
  public AdRequestInfoParcel(Bundle paramBundle1, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, VersionInfoParcel paramVersionInfoParcel, Bundle paramBundle2, int paramInt1, List<String> paramList1, List<String> paramList2, Bundle paramBundle3, boolean paramBoolean1, Messenger paramMessenger, int paramInt2, int paramInt3, float paramFloat1, String paramString5, long paramLong1, String paramString6, List<String> paramList3, String paramString7, NativeAdOptionsParcel paramNativeAdOptionsParcel, long paramLong2, CapabilityParcel paramCapabilityParcel, String paramString8, float paramFloat2, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, boolean paramBoolean4, String paramString9, String paramString10, boolean paramBoolean5, int paramInt6, Bundle paramBundle4)
  {
    this(18, paramBundle1, paramAdRequestParcel, paramAdSizeParcel, paramString1, paramApplicationInfo, paramPackageInfo, paramString2, paramString3, paramString4, paramVersionInfoParcel, paramBundle2, paramInt1, paramList1, paramBundle3, paramBoolean1, paramMessenger, paramInt2, paramInt3, paramFloat1, paramString5, paramLong1, paramString6, paramList3, paramString7, paramNativeAdOptionsParcel, paramList2, paramLong2, paramCapabilityParcel, paramString8, paramFloat2, paramBoolean2, paramInt4, paramInt5, paramBoolean3, paramBoolean4, paramString9, paramString10, paramBoolean5, paramInt6, paramBundle4);
  }
  
  public AdRequestInfoParcel(zza paramzza, String paramString, long paramLong)
  {
    this(zzcau, zzcav, zzaoy, zzaos, applicationInfo, zzcaw, paramString, zzcay, zzcaz, zzaou, zzcba, zzcbb, zzapq, zzcbm, zzcbc, zzcbd, zzcbe, zzcbf, zzcbg, zzcbh, zzcbi, zzcbj, zzcbk, zzcbl, zzaor, zzapm, paramLong, zzcbo, zzcbp, zzcbq, zzcbw, zzcbr, zzcbs, zzcbt, zzcbu, zzcbv, zzcbx, zzbnu, zzcby, zzcbz);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  @zzir
  public static final class zza
  {
    public final ApplicationInfo applicationInfo;
    public final String zzaor;
    public final String zzaos;
    public final VersionInfoParcel zzaou;
    public final AdSizeParcel zzaoy;
    public final NativeAdOptionsParcel zzapm;
    public final List<String> zzapq;
    public final boolean zzbnu;
    public final Bundle zzcau;
    public final AdRequestParcel zzcav;
    public final PackageInfo zzcaw;
    public final String zzcay;
    public final String zzcaz;
    public final Bundle zzcba;
    public final int zzcbb;
    public final Bundle zzcbc;
    public final boolean zzcbd;
    public final Messenger zzcbe;
    public final int zzcbf;
    public final int zzcbg;
    public final float zzcbh;
    public final String zzcbi;
    public final long zzcbj;
    public final String zzcbk;
    public final List<String> zzcbl;
    public final List<String> zzcbm;
    public final CapabilityParcel zzcbo;
    public final String zzcbp;
    public final float zzcbq;
    public final int zzcbr;
    public final int zzcbs;
    public final boolean zzcbt;
    public final boolean zzcbu;
    public final String zzcbv;
    public final boolean zzcbw;
    public final String zzcbx;
    public final int zzcby;
    public final Bundle zzcbz;
    
    public zza(Bundle paramBundle1, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, VersionInfoParcel paramVersionInfoParcel, Bundle paramBundle2, List<String> paramList1, List<String> paramList2, Bundle paramBundle3, boolean paramBoolean1, Messenger paramMessenger, int paramInt1, int paramInt2, float paramFloat1, String paramString4, long paramLong, String paramString5, List<String> paramList3, String paramString6, NativeAdOptionsParcel paramNativeAdOptionsParcel, CapabilityParcel paramCapabilityParcel, String paramString7, float paramFloat2, boolean paramBoolean2, int paramInt3, int paramInt4, boolean paramBoolean3, boolean paramBoolean4, String paramString8, String paramString9, boolean paramBoolean5, int paramInt5, Bundle paramBundle4)
    {
      zzcau = paramBundle1;
      zzcav = paramAdRequestParcel;
      zzaoy = paramAdSizeParcel;
      zzaos = paramString1;
      applicationInfo = paramApplicationInfo;
      zzcaw = paramPackageInfo;
      zzcay = paramString2;
      zzcaz = paramString3;
      zzaou = paramVersionInfoParcel;
      zzcba = paramBundle2;
      zzcbd = paramBoolean1;
      zzcbe = paramMessenger;
      zzcbf = paramInt1;
      zzcbg = paramInt2;
      zzcbh = paramFloat1;
      if ((paramList1 != null) && (paramList1.size() > 0))
      {
        zzcbb = 3;
        zzapq = paramList1;
        zzcbm = paramList2;
        zzcbc = paramBundle3;
        zzcbi = paramString4;
        zzcbj = paramLong;
        zzcbk = paramString5;
        zzcbl = paramList3;
        zzaor = paramString6;
        zzapm = paramNativeAdOptionsParcel;
        zzcbo = paramCapabilityParcel;
        zzcbp = paramString7;
        zzcbq = paramFloat2;
        zzcbw = paramBoolean2;
        zzcbr = paramInt3;
        zzcbs = paramInt4;
        zzcbt = paramBoolean3;
        zzcbu = paramBoolean4;
        zzcbv = paramString8;
        zzcbx = paramString9;
        zzbnu = paramBoolean5;
        zzcby = paramInt5;
        zzcbz = paramBundle4;
        return;
      }
      if (zzauu) {}
      for (zzcbb = 4;; zzcbb = 0)
      {
        zzapq = null;
        zzcbm = null;
        break;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.AdRequestInfoParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */