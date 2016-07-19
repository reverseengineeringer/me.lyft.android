package me.lyft.android.jobs;

import com.lyft.android.api.dto.AppInfoDTO;
import com.lyft.android.api.dto.UniversalDTO;
import javax.inject.Inject;
import me.lyft.android.application.requestridetypes.IRideTypeMetaService;

public class RideTypesMetaChangedJob
  implements Job
{
  final UniversalDTO currentAppState;
  @Inject
  IRideTypeMetaService rideTypeMetaService;
  
  public RideTypesMetaChangedJob(UniversalDTO paramUniversalDTO)
  {
    currentAppState = paramUniversalDTO;
  }
  
  public void execute()
    throws Throwable
  {
    rideTypeMetaService.updateBanners(currentAppState.banners);
    if (currentAppState.appInfo != null) {
      rideTypeMetaService.updateMatchingStrings(currentAppState.appInfo.rideTypes);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.RideTypesMetaChangedJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */