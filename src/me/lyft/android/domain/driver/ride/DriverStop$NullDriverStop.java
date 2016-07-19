package me.lyft.android.domain.driver.ride;

public class DriverStop$NullDriverStop
  extends DriverStop
{
  private static final NullDriverStop instance = new NullDriverStop();
  
  private DriverStop$NullDriverStop()
  {
    super(null, null, null, null, false, null);
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.ride.DriverStop.NullDriverStop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */