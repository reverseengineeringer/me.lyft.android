package me.lyft.android.domain.ride;

import me.lyft.android.common.INullable;
import me.lyft.android.common.Strings;

public class RideType
  implements INullable
{
  private final String type;
  
  private RideType(String paramString)
  {
    type = paramString;
  }
  
  public static RideType empty()
  {
    return NullRideType.getInstance();
  }
  
  public static RideType getInstance(String paramString)
  {
    if (Strings.isNullOrEmpty(paramString)) {
      return empty();
    }
    return new RideType(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof RideType))
    {
      paramObject = (RideType)paramObject;
      return Strings.equalsIgnoreCase(type, type);
    }
    return false;
  }
  
  public String getType()
  {
    return type;
  }
  
  public boolean isCarpool()
  {
    return Strings.equalsIgnoreCase(type, "lyft_carpool");
  }
  
  public boolean isCourier()
  {
    return Strings.equalsIgnoreCase(type, "lyft_line");
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public boolean isPlus()
  {
    return Strings.equalsIgnoreCase(type, "lyft_plus");
  }
  
  public boolean isStandard()
  {
    return Strings.equalsIgnoreCase(type, "lyft");
  }
  
  private static class NullRideType
    extends RideType
  {
    private static final RideType INSTANCE = new NullRideType();
    
    private NullRideType()
    {
      super(null);
    }
    
    public static RideType getInstance()
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
 * Qualified Name:     me.lyft.android.domain.ride.RideType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */