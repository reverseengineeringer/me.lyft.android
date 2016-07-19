package me.lyft.android.domain.driver.carpool;

import me.lyft.android.domain.location.NullLocation;
import me.lyft.android.domain.time.Time;

class CarpoolInfo$NullCarpoolInfo
  extends CarpoolInfo
{
  private static final CarpoolInfo INSTANCE = new NullCarpoolInfo();
  
  public CarpoolInfo$NullCarpoolInfo()
  {
    super(NullLocation.getInstance(), NullLocation.getInstance(), Time.empty(), Time.empty(), Time.empty());
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.carpool.CarpoolInfo.NullCarpoolInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */