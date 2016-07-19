package me.lyft.android.domain.driver;

import com.lyft.android.api.dto.DriverAchievementCardDTO;
import com.lyft.android.api.dto.DriverActivityDTO;
import com.lyft.android.api.dto.DriverStatsDTO;
import java.util.Collections;
import java.util.List;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.domain.payment.MoneyMapper;
import rx.functions.Func1;

public class DriverAchievementsMapper
{
  static DriverActivities fromDriverActivityDTO(DriverActivityDTO paramDriverActivityDTO)
  {
    if (paramDriverActivityDTO == null) {
      return DriverActivities.empty();
    }
    return new DriverActivities(getType(type), (Money)Objects.firstNonNull(MoneyMapper.fromMoneyDTO(amountEarned), DriverActivities.empty().getAmountEarned()), (Integer)Objects.firstNonNull(rideCount, DriverActivities.empty().getRideCount()), (Integer)Objects.firstNonNull(timeDrivenSecs, DriverActivities.empty().getTimeDrivenSeconds()), Strings.nullOrEmptyToDefault(title, DriverActivities.empty().getTitle()), Strings.nullOrEmptyToDefault(subtitle, DriverActivities.empty().getSubtitle()));
  }
  
  public static DriverAchievements fromDto(DriverStatsDTO paramDriverStatsDTO)
  {
    new DriverAchievements(Iterables.map((List)Objects.firstNonNull(activities, Collections.emptyList()), new Func1()
    {
      public DriverActivities call(DriverActivityDTO paramAnonymousDriverActivityDTO)
      {
        return DriverAchievementsMapper.fromDriverActivityDTO(paramAnonymousDriverActivityDTO);
      }
    }), Iterables.map((List)Objects.firstNonNull(cards, Collections.emptyList()), new Func1()
    {
      public Card call(DriverAchievementCardDTO paramAnonymousDriverAchievementCardDTO)
      {
        return CardMapper.fromDto(paramAnonymousDriverAchievementCardDTO);
      }
    }));
  }
  
  private static DriverActivities.Type getType(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return DriverActivities.Type.NONE;
        if (paramString.equals("daily"))
        {
          i = 0;
          continue;
          if (paramString.equals("weekly")) {
            i = 1;
          }
        }
        break;
      }
    }
    return DriverActivities.Type.DAILY;
    return DriverActivities.Type.WEEKLY;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.DriverAchievementsMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */