package me.lyft.android.domain.driverdocuments;

import me.lyft.android.common.INullable;

public class Inspection
  extends DriverDocument
  implements INullable
{
  public Inspection(String paramString1, String paramString2, DriverDocument.Status paramStatus)
  {
    super(paramString1, paramString2, paramStatus);
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public static class NullInspection
    extends Inspection
  {
    private static final NullInspection INSTANCE = new NullInspection();
    
    NullInspection()
    {
      super(null, DriverDocument.Status.NONE);
    }
    
    public static NullInspection getInstance()
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
 * Qualified Name:     me.lyft.android.domain.driverdocuments.Inspection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */