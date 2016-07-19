package me.lyft.android.jobs;

import com.lyft.android.api.dto.AppInfoDTO;
import javax.inject.Inject;
import me.lyft.android.application.IAppInfoService;

public class AppInfoUpdateJob
  implements Job
{
  private final AppInfoDTO appInfo;
  @Inject
  IAppInfoService appInfoService;
  
  public AppInfoUpdateJob(AppInfoDTO paramAppInfoDTO)
  {
    appInfo = paramAppInfoDTO;
  }
  
  public void execute()
    throws Throwable
  {
    if (appInfo != null) {
      appInfoService.updateAppInfo(appInfo);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.AppInfoUpdateJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */