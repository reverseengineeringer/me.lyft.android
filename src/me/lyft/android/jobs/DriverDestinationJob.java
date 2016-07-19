package me.lyft.android.jobs;

import com.lyft.android.api.dto.UniversalDTO;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.driver.IDriverDestinationService;
import me.lyft.android.domain.User;

public class DriverDestinationJob
  implements Job
{
  @Inject
  IDriverDestinationService driverDestinationService;
  private final UniversalDTO universalDTO;
  @Inject
  IUserProvider userProvider;
  
  public DriverDestinationJob(UniversalDTO paramUniversalDTO)
  {
    universalDTO = paramUniversalDTO;
  }
  
  public void execute()
    throws Throwable
  {
    if (universalDTO == null) {
      return;
    }
    driverDestinationService.updateDriverDestination(userProvider.getUser().getDriverDestination());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.DriverDestinationJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */