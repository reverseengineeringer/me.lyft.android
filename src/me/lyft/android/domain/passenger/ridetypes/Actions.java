package me.lyft.android.domain.passenger.ridetypes;

import me.lyft.android.common.INullable;

public class Actions
  implements INullable
{
  private final String destinationActiveColor;
  private final String destinationColor;
  private final String destinationLabel;
  private final String pickupActiveColor;
  private final String pickupColor;
  private final String pickupLabel;
  private final String requestActiveColor;
  private final String requestColor;
  private final String requestLabel;
  
  public Actions(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    pickupLabel = paramString1;
    pickupColor = paramString2;
    pickupActiveColor = paramString3;
    destinationLabel = paramString4;
    destinationColor = paramString5;
    destinationActiveColor = paramString6;
    requestLabel = paramString7;
    requestColor = paramString8;
    requestActiveColor = paramString9;
  }
  
  public static Actions empty()
  {
    return NullActions.getInstance();
  }
  
  public String getDestinationActiveColor()
  {
    return destinationActiveColor;
  }
  
  public String getDestinationColor()
  {
    return destinationColor;
  }
  
  public String getDestinationLabel()
  {
    return destinationLabel;
  }
  
  public String getPickupActiveColor()
  {
    return pickupActiveColor;
  }
  
  public String getPickupColor()
  {
    return pickupColor;
  }
  
  public String getPickupLabel()
  {
    return pickupLabel;
  }
  
  public String getRequestActiveColor()
  {
    return requestActiveColor;
  }
  
  public String getRequestColor()
  {
    return requestColor;
  }
  
  public String getRequestLabel()
  {
    return requestLabel;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  static class NullActions
    extends Actions
  {
    private static final Actions INSTANCE = new NullActions();
    
    private NullActions()
    {
      super("", "", "", "", "", "", "", "");
    }
    
    static Actions getInstance()
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
 * Qualified Name:     me.lyft.android.domain.passenger.ridetypes.Actions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */