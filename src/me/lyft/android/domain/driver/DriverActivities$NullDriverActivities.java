package me.lyft.android.domain.driver;

import me.lyft.android.domain.payment.NullMoney;

class DriverActivities$NullDriverActivities
  extends DriverActivities
{
  private static final DriverActivities instance = new NullDriverActivities();
  
  private DriverActivities$NullDriverActivities()
  {
    super(DriverActivities.Type.NONE, NullMoney.getInstance(), Integer.valueOf(0), Integer.valueOf(0), "", "");
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.DriverActivities.NullDriverActivities
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */