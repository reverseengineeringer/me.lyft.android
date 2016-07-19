package me.lyft.android.application.ridehistory;

import java.util.HashMap;
import java.util.Map;

public enum PassengerRideHistoryType
{
  private static final Map<Integer, PassengerRideHistoryType> lookup;
  public final int pagePosition;
  
  static
  {
    BUSINESS = new PassengerRideHistoryType("BUSINESS", 2, 2);
    $VALUES = new PassengerRideHistoryType[] { ALL, PERSONAL, BUSINESS };
    lookup = new HashMap();
    PassengerRideHistoryType[] arrayOfPassengerRideHistoryType = values();
    int j = arrayOfPassengerRideHistoryType.length;
    int i = 0;
    while (i < j)
    {
      PassengerRideHistoryType localPassengerRideHistoryType = arrayOfPassengerRideHistoryType[i];
      lookup.put(Integer.valueOf(pagePosition), localPassengerRideHistoryType);
      i += 1;
    }
  }
  
  private PassengerRideHistoryType(int paramInt)
  {
    pagePosition = paramInt;
  }
  
  public static PassengerRideHistoryType get(int paramInt)
  {
    return (PassengerRideHistoryType)lookup.get(Integer.valueOf(paramInt));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ridehistory.PassengerRideHistoryType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */