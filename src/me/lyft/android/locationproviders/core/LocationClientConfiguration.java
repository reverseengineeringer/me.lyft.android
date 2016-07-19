package me.lyft.android.locationproviders.core;

public class LocationClientConfiguration
{
  public final long fastestInterval;
  public final boolean isBackgroundUpdate;
  public final float smallestDisplacement;
  public final long updateInterval;
  
  public LocationClientConfiguration(long paramLong1, long paramLong2, float paramFloat, boolean paramBoolean)
  {
    updateInterval = paramLong1;
    fastestInterval = paramLong2;
    smallestDisplacement = paramFloat;
    isBackgroundUpdate = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.locationproviders.core.LocationClientConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */