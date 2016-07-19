package me.lyft.android.domain.ride;

class RideStatus$NullRideStatus
  extends RideStatus
{
  private static final RideStatus INSTANCE = new NullRideStatus();
  
  private RideStatus$NullRideStatus()
  {
    super(RideStatus.Status.IDLE, 0L);
  }
  
  public static RideStatus getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ride.RideStatus.NullRideStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */