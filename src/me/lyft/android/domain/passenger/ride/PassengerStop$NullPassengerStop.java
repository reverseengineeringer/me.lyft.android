package me.lyft.android.domain.passenger.ride;

public class PassengerStop$NullPassengerStop
  extends PassengerStop
{
  private static final NullPassengerStop instance = new NullPassengerStop();
  
  private PassengerStop$NullPassengerStop()
  {
    super(null, null, null, false, null);
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PassengerStop.NullPassengerStop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */