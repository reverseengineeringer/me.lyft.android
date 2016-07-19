package me.lyft.android.domain.driver;

import java.util.Collections;

class DriverAchievements$NullDriverAchievements
  extends DriverAchievements
{
  private static final DriverAchievements INSTANCE = new NullDriverAchievements();
  
  private DriverAchievements$NullDriverAchievements()
  {
    super(Collections.emptyList(), Collections.emptyList());
  }
  
  static DriverAchievements getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.DriverAchievements.NullDriverAchievements
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */