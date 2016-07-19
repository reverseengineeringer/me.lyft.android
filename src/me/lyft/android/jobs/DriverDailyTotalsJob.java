package me.lyft.android.jobs;

import com.lyft.android.api.dto.MoneyDTO;
import com.lyft.android.api.dto.UniversalDTO;
import com.lyft.android.api.dto.UserDTO;
import javax.inject.Inject;
import me.lyft.android.application.driver.IDailyTotalsRepository;
import me.lyft.android.domain.payment.MoneyMapper;

public class DriverDailyTotalsJob
  implements Job
{
  private final UniversalDTO currentAppState;
  @Inject
  IDailyTotalsRepository dailyTotalsRepository;
  
  public DriverDailyTotalsJob(UniversalDTO paramUniversalDTO)
  {
    currentAppState = paramUniversalDTO;
  }
  
  public void execute()
    throws Throwable
  {
    if (currentAppState == null) {
      return;
    }
    IDailyTotalsRepository localIDailyTotalsRepository = dailyTotalsRepository;
    if (currentAppState.user == null) {}
    for (MoneyDTO localMoneyDTO = null;; localMoneyDTO = currentAppState.user.dailyTotalFares)
    {
      localIDailyTotalsRepository.updateDailyTotal(MoneyMapper.fromMoneyDTO(localMoneyDTO));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.DriverDailyTotalsJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */