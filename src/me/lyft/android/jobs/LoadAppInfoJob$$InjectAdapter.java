package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.IAppInfoService;

public final class LoadAppInfoJob$$InjectAdapter
  extends Binding<LoadAppInfoJob>
{
  private Binding<IAppInfoService> appInfoService;
  
  public LoadAppInfoJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.LoadAppInfoJob", false, LoadAppInfoJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    appInfoService = paramLinker.requestBinding("me.lyft.android.application.IAppInfoService", LoadAppInfoJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(appInfoService);
  }
  
  public void injectMembers(LoadAppInfoJob paramLoadAppInfoJob)
  {
    appInfoService = ((IAppInfoService)appInfoService.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.LoadAppInfoJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */