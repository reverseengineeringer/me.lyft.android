package me.lyft.android.domain.driver;

import com.lyft.android.api.dto.DriverAchievementCardDTO;
import rx.functions.Func1;

final class DriverAchievementsMapper$2
  implements Func1<DriverAchievementCardDTO, Card>
{
  public Card call(DriverAchievementCardDTO paramDriverAchievementCardDTO)
  {
    return CardMapper.fromDto(paramDriverAchievementCardDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.DriverAchievementsMapper.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */