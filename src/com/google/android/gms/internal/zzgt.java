package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@zzir
public final class zzgt
  implements MediationAdRequest
{
  private final int zzaub;
  private final boolean zzaun;
  private final int zzbpl;
  private final Date zzfp;
  private final Set<String> zzfr;
  private final boolean zzfs;
  private final Location zzft;
  
  public zzgt(Date paramDate, int paramInt1, Set<String> paramSet, Location paramLocation, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    zzfp = paramDate;
    zzaub = paramInt1;
    zzfr = paramSet;
    zzft = paramLocation;
    zzfs = paramBoolean1;
    zzbpl = paramInt2;
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
 * Qualified Name:     com.google.android.gms.internal.zzgt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */