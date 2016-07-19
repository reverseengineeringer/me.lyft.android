package me.lyft.android.jobs;

import javax.inject.Inject;
import me.lyft.android.application.IAppInfoService;
import me.lyft.android.rx.SimpleSubscriber;
import rx.Observable;

public class LoadAppInfoJob
  implements Job
{
  @Inject
  IAppInfoService appInfoService;
  private String deepLink;
  
  public LoadAppInfoJob(String paramString)
  {
    deepLink = paramString;
  }
  
  public void execute()
    throws Throwable
  {
    appInfoService.loadAppInfo(deepLink).subscribe(new SimpleSubscriber());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.LoadAppInfoJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */