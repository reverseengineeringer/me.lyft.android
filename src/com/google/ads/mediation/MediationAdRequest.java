package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Date;
import java.util.Set;

@Deprecated
public class MediationAdRequest
{
  private final Date zzfp;
  private final AdRequest.Gender zzfq;
  private final Set<String> zzfr;
  private final boolean zzfs;
  private final Location zzft;
  
  public MediationAdRequest(Date paramDate, AdRequest.Gender paramGender, Set<String> paramSet, boolean paramBoolean, Location paramLocation)
  {
    zzfp = paramDate;
    zzfq = paramGender;
    zzfr = paramSet;
    zzfs = paramBoolean;
    zzft = paramLocation;
  }
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.MediationAdRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */