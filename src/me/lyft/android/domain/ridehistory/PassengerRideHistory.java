package me.lyft.android.domain.ridehistory;

import java.util.ArrayList;
import java.util.List;

public class PassengerRideHistory
{
  private boolean hasMore;
  private int limit;
  private int offset;
  private List<PassengerRideHistoryItem> rideHistory = new ArrayList();
  
  public PassengerRideHistory(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    hasMore = paramBoolean;
    limit = paramInt1;
    offset = paramInt2;
  }
  
  public static PassengerRideHistory createEmptyPassengerRideHistory()
  {
    return new PassengerRideHistory(false, 0, 0);
  }
  
  public int getLimit()
  {
    return limit;
  }
  
  public int getOffset()
  {
    return offset;
  }
  
  public List<PassengerRideHistoryItem> getRideHistory()
  {
    return rideHistory;
  }
  
  public boolean hasMore()
  {
    return hasMore;
  }
  
  public void setHasMore(boolean paramBoolean)
  {
    hasMore = paramBoolean;
  }
  
  public void setLimit(int paramInt)
  {
    limit = paramInt;
  }
  
  public void setOffset(int paramInt)
  {
    offset = paramInt;
  }
  
  public void setRideHistory(List<PassengerRideHistoryItem> paramList)
  {
    rideHistory = paramList;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ridehistory.PassengerRideHistory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */