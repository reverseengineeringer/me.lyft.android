package me.lyft.android.domain.driver;

import me.lyft.android.common.INullable;

public class DriverProfile
  implements INullable
{
  private final boolean driverShortcutEnabled;
  
  public DriverProfile(boolean paramBoolean)
  {
    driverShortcutEnabled = paramBoolean;
  }
  
  public static DriverProfile empty()
  {
    return NullDriverProfile.getInstance();
  }
  
  public boolean isDriverShortcutEnabled()
  {
    return driverShortcutEnabled;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  static class NullDriverProfile
    extends DriverProfile
  {
    private static DriverProfile INSTANCE = new NullDriverProfile();
    
    private NullDriverProfile()
    {
      super();
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
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.DriverProfile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */