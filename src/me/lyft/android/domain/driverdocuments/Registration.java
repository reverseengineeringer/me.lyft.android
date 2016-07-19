package me.lyft.android.domain.driverdocuments;

import me.lyft.android.common.INullable;

public class Registration
  extends DriverDocument
  implements INullable
{
  public Registration(String paramString1, String paramString2, DriverDocument.Status paramStatus)
  {
    super(paramString1, paramString2, paramStatus);
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public static class NullRegistration
    extends Registration
  {
    private static final NullRegistration INSTANCE = new NullRegistration();
    
    NullRegistration()
    {
      super(null, DriverDocument.Status.NONE);
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
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driverdocuments.Registration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */