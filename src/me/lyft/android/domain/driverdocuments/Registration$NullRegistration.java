package me.lyft.android.domain.driverdocuments;

public class Registration$NullRegistration
  extends Registration
{
  private static final NullRegistration INSTANCE = new NullRegistration();
  
  Registration$NullRegistration()
  {
    super(null, null, DriverDocument.Status.NONE);
  }
  
  public static NullRegistration getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driverdocuments.Registration.NullRegistration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */