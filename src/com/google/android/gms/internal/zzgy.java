package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzir
public final class zzgy
  implements NativeMediationAdRequest
{
  private final NativeAdOptionsParcel zzali;
  private final List<String> zzalj;
  private final int zzaub;
  private final boolean zzaun;
  private final int zzbpl;
  private final Date zzfp;
  private final Set<String> zzfr;
  private final boolean zzfs;
  private final Location zzft;
  
  public zzgy(Date paramDate, int paramInt1, Set<String> paramSet, Location paramLocation, boolean paramBoolean1, int paramInt2, NativeAdOptionsParcel paramNativeAdOptionsParcel, List<String> paramList, boolean paramBoolean2)
  {
    zzfp = paramDate;
    zzaub = paramInt1;
    zzfr = paramSet;
    zzft = paramLocation;
    zzfs = paramBoolean1;
    zzbpl = paramInt2;
    zzali = paramNativeAdOptionsParcel;
    zzalj = paramList;
    zzaun = paramBoolean2;
  }
  
  public Date getBirthday()
  {
    return zzfp;
  }
  
  public int getGender()
  {
    return zzaub;
  }
  
  public Set<String> getKeywords()
  {
    return zzfr;
  }
  
  public Location getLocation()
  {
    return zzft;
  }
  
  public NativeAdOptions getNativeAdOptions()
  {
    if (zzali == null) {
      return null;
    }
    return new NativeAdOptions.Builder().setReturnUrlsForImageAssets(zzali.zzbgt).setImageOrientation(zzali.zzbgu).setRequestMultipleImages(zzali.zzbgv).build();
  }
  
  public boolean isAppInstallAdRequested()
  {
    return (zzalj != null) && (zzalj.contains("2"));
  }
  
  public boolean isContentAdRequested()
  {
    return (zzalj != null) && (zzalj.contains("1"));
  }
  
  public boolean isDesignedForFamilies()
  {
    return zzaun;
  }
  
  public boolean isTesting()
  {
    return zzfs;
  }
  
  public int taggedForChildDirectedTreatment()
  {
    return zzbpl;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */