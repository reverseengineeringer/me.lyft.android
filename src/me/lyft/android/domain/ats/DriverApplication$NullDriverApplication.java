package me.lyft.android.domain.ats;

public class DriverApplication$NullDriverApplication
  extends DriverApplication
{
  private static final DriverApplication INSTANCE = new NullDriverApplication();
  
  private DriverApplication$NullDriverApplication()
  {
    super(null, null, null, null, null);
  }
  
  public static DriverApplication getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ats.DriverApplication.NullDriverApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */