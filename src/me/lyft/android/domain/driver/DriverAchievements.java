package me.lyft.android.domain.driver;

import java.util.Collections;
import java.util.List;
import me.lyft.android.common.INullable;

public class DriverAchievements
  implements INullable
{
  private final List<DriverActivities> activities;
  private final List<Card> cards;
  
  public DriverAchievements(List<DriverActivities> paramList, List<Card> paramList1)
  {
    activities = paramList;
    cards = paramList1;
  }
  
  public static DriverAchievements empty()
  {
    return NullDriverAchievements.getInstance();
  }
  
  public List<DriverActivities> getActivities()
  {
    return activities;
  }
  
  public List<Card> getCards()
  {
    return cards;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  private static class NullDriverAchievements
    extends DriverAchievements
  {
    private static final DriverAchievements INSTANCE = new NullDriverAchievements();
    
    private NullDriverAchievements()
    {
      super(Collections.emptyList());
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
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.DriverAchievements
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */