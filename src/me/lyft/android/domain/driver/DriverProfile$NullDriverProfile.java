package me.lyft.android.domain.driver;

class DriverProfile$NullDriverProfile
  extends DriverProfile
{
  private static DriverProfile INSTANCE = new NullDriverProfile();
  
  private DriverProfile$NullDriverProfile()
  {
    super(false);
  }
  
  public static DriverProfile getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.DriverProfile.NullDriverProfile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */