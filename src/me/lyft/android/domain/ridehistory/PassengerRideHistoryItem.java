package me.lyft.android.domain.ridehistory;

import java.util.UUID;
import me.lyft.android.common.INullable;

public class PassengerRideHistoryItem
  implements INullable
{
  private final String distanceMiles;
  private final String driverPhotoUrl;
  private final String id;
  private final boolean isBusinessRide;
  private final String pickupTime;
  private final String rideDuration;
  private final String rideTypeLabel;
  private final String totalMoney;
  
  public PassengerRideHistoryItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    id = paramString1;
    driverPhotoUrl = paramString2;
    totalMoney = paramString3;
    distanceMiles = paramString4;
    rideDuration = paramString5;
    pickupTime = paramString6;
    rideTypeLabel = paramString7;
    isBusinessRide = paramBoolean;
  }
  
  public static PassengerRideHistoryItem empty()
  {
    return NullPassengerRideHistoryItem.INSTANCE;
  }
  
  public String getDistance()
  {
    return distanceMiles;
  }
  
  public String getDriverPhotoUrl()
  {
    return driverPhotoUrl;
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getPickupTime()
  {
    return pickupTime;
  }
  
  public String getRideDuration()
  {
    return rideDuration;
  }
  
  public String getRideTypeLabel()
  {
    return rideTypeLabel;
  }
  
  public String getTotalMoney()
  {
    return totalMoney;
  }
  
  public boolean isBusinessRide()
  {
    return isBusinessRide;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  private static class NullPassengerRideHistoryItem
    extends PassengerRideHistoryItem
  {
    private static final PassengerRideHistoryItem INSTANCE = new NullPassengerRideHistoryItem();
    
    private NullPassengerRideHistoryItem()
    {
      super("", "", "", "", "", "", false);
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ridehistory.PassengerRideHistoryItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */