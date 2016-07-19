package me.lyft.android.domain.location;

public class NullLocation
  extends Location
{
  private static final NullLocation INSTANCE = new NullLocation();
  
  private NullLocation()
  {
    super(0.0D, 0.0D, "defaultLocation");
    setAccuracy(Double.valueOf(9999.0D));
    setBearing(Double.valueOf(0.0D));
    setSpeed(Double.valueOf(0.0D));
    setTime(Long.valueOf(0L));
  }
  
  public static Location getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
  
  public String toString()
  {
    return "NullLocation{}";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.location.NullLocation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */