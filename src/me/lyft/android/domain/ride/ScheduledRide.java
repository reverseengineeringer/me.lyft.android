package me.lyft.android.domain.ride;

import me.lyft.android.common.INullable;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.NullLocation;
import me.lyft.android.domain.time.Time;

public class ScheduledRide
  implements INullable
{
  private final Location destination;
  private final String id;
  private final Location pickup;
  private final Time pickupTime;
  private final String requestRideType;
  private final String rideTypeLabel;
  
  public ScheduledRide(Location paramLocation1, Location paramLocation2, String paramString1, String paramString2, String paramString3, Time paramTime)
  {
    pickup = paramLocation1;
    destination = paramLocation2;
    requestRideType = paramString1;
    rideTypeLabel = paramString2;
    id = paramString3;
    pickupTime = paramTime;
  }
  
  public static ScheduledRide empty()
  {
    return NullScheduledRide.INSTANCE;
  }
  
  public Location getDestination()
  {
    return destination;
  }
  
  public String getId()
  {
    return id;
  }
  
  public Location getPickup()
  {
    return pickup;
  }
  
  public Time getPickupTime()
  {
    return pickupTime;
  }
  
  public String getRequestRideType()
  {
    return requestRideType;
  }
  
  public String getRideTypeLabel()
  {
    return rideTypeLabel;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  private static final class NullScheduledRide
    extends ScheduledRide
  {
    static final ScheduledRide INSTANCE = new NullScheduledRide(NullLocation.getInstance(), NullLocation.getInstance(), "", "", "", Time.empty());
    
    public NullScheduledRide(Location paramLocation1, Location paramLocation2, String paramString1, String paramString2, String paramString3, Time paramTime)
    {
      super(paramLocation2, paramString1, paramString2, paramString3, paramTime);
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ride.ScheduledRide
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */