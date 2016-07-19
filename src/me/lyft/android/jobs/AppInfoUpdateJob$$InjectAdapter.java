package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.IAppInfoService;

public final class AppInfoUpdateJob$$InjectAdapter
  extends Binding<AppInfoUpdateJob>
{
  private Binding<IAppInfoService> appInfoService;
  
  public AppInfoUpdateJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.AppInfoUpdateJob", false, AppInfoUpdateJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    appInfoService = paramLinker.requestBinding("me.lyft.android.application.IAppInfoService", AppInfoUpdateJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(appInfoService);
  }
  
  public void injectMembers(AppInfoUpdateJob paramAppInfoUpdateJob)
  {
    appInfoService = ((IAppInfoService)appInfoService.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.AppInfoUpdateJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */