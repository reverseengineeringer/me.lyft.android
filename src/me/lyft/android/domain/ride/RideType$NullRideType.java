package me.lyft.android.domain.ride;

class RideType$NullRideType
  extends RideType
{
  private static final RideType INSTANCE = new NullRideType();
  
  private RideType$NullRideType()
  {
    super("lyft", null);
  }
  
  public static RideType getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ride.RideType.NullRideType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */