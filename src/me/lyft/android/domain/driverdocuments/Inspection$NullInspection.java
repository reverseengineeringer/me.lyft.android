package me.lyft.android.domain.driverdocuments;

public class Inspection$NullInspection
  extends Inspection
{
  private static final NullInspection INSTANCE = new NullInspection();
  
  Inspection$NullInspection()
  {
    super(null, null, DriverDocument.Status.NONE);
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

/* Location:
 * Qualified Name:     me.lyft.android.domain.driverdocuments.Inspection.NullInspection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */