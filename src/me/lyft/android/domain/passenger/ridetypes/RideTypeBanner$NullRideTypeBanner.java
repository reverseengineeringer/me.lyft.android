package me.lyft.android.domain.passenger.ridetypes;

public final class RideTypeBanner$NullRideTypeBanner
  extends RideTypeBanner
{
  private static final RideTypeBanner instance = new NullRideTypeBanner();
  
  public RideTypeBanner$NullRideTypeBanner()
  {
    super("", "", "", "", "");
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ridetypes.RideTypeBanner.NullRideTypeBanner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */