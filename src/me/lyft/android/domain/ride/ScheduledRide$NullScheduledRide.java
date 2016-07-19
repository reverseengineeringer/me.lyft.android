package me.lyft.android.domain.ride;

import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.NullLocation;
import me.lyft.android.domain.time.Time;

final class ScheduledRide$NullScheduledRide
  extends ScheduledRide
{
  static final ScheduledRide INSTANCE = new NullScheduledRide(NullLocation.getInstance(), NullLocation.getInstance(), "", "", "", Time.empty());
  
  public ScheduledRide$NullScheduledRide(Location paramLocation1, Location paramLocation2, String paramString1, String paramString2, String paramString3, Time paramTime)
  {
    super(paramLocation1, paramLocation2, paramString1, paramString2, paramString3, paramTime);
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ride.ScheduledRide.NullScheduledRide
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */