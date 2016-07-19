package com.tune.crosspromo;

import android.location.Location;
import com.mobileapptracker.MATGender;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class TuneAdMetadata
{
  private Date mBirthDate;
  private Map<String, String> mCustomTargets;
  private boolean mDebugMode;
  private MATGender mGender;
  private Set<String> mKeywords;
  private double mLatitude;
  private Location mLocation;
  private double mLongitude;
  
  public Date getBirthDate()
  {
    return mBirthDate;
  }
  
  public Map<String, String> getCustomTargets()
  {
    return mCustomTargets;
  }
  
  public MATGender getGender()
  {
    return mGender;
  }
  
  public Set<String> getKeywords()
  {
    return mKeywords;
  }
  
  public double getLatitude()
  {
    return mLatitude;
  }
  
  public Location getLocation()
  {
    return mLocation;
  }
  
  public double getLongitude()
  {
    return mLongitude;
  }
  
  public boolean isInDebugMode()
  {
    return mDebugMode;
  }
}

/* Location:
 * Qualified Name:     com.tune.crosspromo.TuneAdMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */