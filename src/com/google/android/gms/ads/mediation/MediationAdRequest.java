package com.google.android.gms.ads.mediation;

import android.location.Location;
import java.util.Date;
import java.util.Set;

public abstract interface MediationAdRequest
{
  public abstract Date getBirthday();
  
  public abstract int getGender();
  
  public abstract Set<String> getKeywords();
  
  public abstract Location getLocation();
  
  public abstract boolean isDesignedForFamilies();
  
  public abstract boolean isTesting();
  
  public abstract int taggedForChildDirectedTreatment();
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.mediation.MediationAdRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */