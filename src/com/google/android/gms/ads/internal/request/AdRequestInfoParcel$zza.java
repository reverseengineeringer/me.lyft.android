package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzir;
import java.util.List;

@zzir
public final class AdRequestInfoParcel$zza
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
  
  public AdRequestInfoParcel$zza(Bundle paramBundle1, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, VersionInfoParcel paramVersionInfoParcel, Bundle paramBundle2, List<String> paramList1, List<String> paramList2, Bundle paramBundle3, boolean paramBoolean1, Messenger paramMessenger, int paramInt1, int paramInt2, float paramFloat1, String paramString4, long paramLong, String paramString5, List<String> paramList3, String paramString6, NativeAdOptionsParcel paramNativeAdOptionsParcel, CapabilityParcel paramCapabilityParcel, String paramString7, float paramFloat2, boolean paramBoolean2, int paramInt3, int paramInt4, boolean paramBoolean3, boolean paramBoolean4, String paramString8, String paramString9, boolean paramBoolean5, int paramInt5, Bundle paramBundle4)
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

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */