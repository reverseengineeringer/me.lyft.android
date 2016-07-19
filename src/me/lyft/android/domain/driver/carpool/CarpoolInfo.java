package me.lyft.android.domain.driver.carpool;

import java.util.concurrent.TimeUnit;
import me.lyft.android.common.INullable;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.NullLocation;
import me.lyft.android.domain.time.Time;

public class CarpoolInfo
  implements INullable
{
  private static final long LEAVE_SOON_MILLIS = TimeUnit.MINUTES.toMillis(5L);
  private final Time arriveByTime;
  private final Location endLocation;
  private final Time leaveByTime;
  private final Time startDrivingTime;
  private final Location startLocation;
  
  public CarpoolInfo(Location paramLocation1, Location paramLocation2, Time paramTime1, Time paramTime2, Time paramTime3)
  {
    startLocation = paramLocation1;
    endLocation = paramLocation2;
    startDrivingTime = paramTime1;
    leaveByTime = paramTime2;
    arriveByTime = paramTime3;
  }
  
  public static CarpoolInfo empty()
  {
    return NullCarpoolInfo.INSTANCE;
  }
  
  public Time getArriveByTime()
  {
    return arriveByTime;
  }
  
  public long getCountdownMillis()
  {
    long l2 = getLeaveByTime().getTimestamp() - System.currentTimeMillis();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    return l1;
  }
  
  public Location getEndLocation()
  {
    return endLocation;
  }
  
  public Time getLeaveByTime()
  {
    return leaveByTime;
  }
  
  public Time getStartDrivingTime()
  {
    return startDrivingTime;
  }
  
  public Location getStartLocation()
  {
    return startLocation;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public boolean leaveNow()
  {
    return getLeaveByTime().getTimestamp() - System.currentTimeMillis() < 0L;
  }
  
  public boolean leaveSoon()
  {
    return getLeaveByTime().getTimestamp() - System.currentTimeMillis() < LEAVE_SOON_MILLIS;
  }
  
  public boolean startDriving()
  {
    return startDrivingTime.getTimestamp() - System.currentTimeMillis() < 0L;
  }
  
  private static class NullCarpoolInfo
    extends CarpoolInfo
  {
    private static final CarpoolInfo INSTANCE = new NullCarpoolInfo();
    
    public NullCarpoolInfo()
    {
      super(NullLocation.getInstance(), Time.empty(), Time.empty(), Time.empty());
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.carpool.CarpoolInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */