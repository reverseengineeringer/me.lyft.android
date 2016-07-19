package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.driver.IDailyTotalsRepository;

public final class DriverDailyTotalsJob$$InjectAdapter
  extends Binding<DriverDailyTotalsJob>
{
  private Binding<IDailyTotalsRepository> dailyTotalsRepository;
  
  public DriverDailyTotalsJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.DriverDailyTotalsJob", false, DriverDailyTotalsJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    dailyTotalsRepository = paramLinker.requestBinding("me.lyft.android.application.driver.IDailyTotalsRepository", DriverDailyTotalsJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(dailyTotalsRepository);
  }
  
  public void injectMembers(DriverDailyTotalsJob paramDriverDailyTotalsJob)
  {
    dailyTotalsRepository = ((IDailyTotalsRepository)dailyTotalsRepository.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.DriverDailyTotalsJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */