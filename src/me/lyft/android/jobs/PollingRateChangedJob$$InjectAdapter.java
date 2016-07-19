package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.ILyftPreferences;

public final class PollingRateChangedJob$$InjectAdapter
  extends Binding<PollingRateChangedJob>
{
  private Binding<ILyftPreferences> preferences;
  
  public PollingRateChangedJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.PollingRateChangedJob", false, PollingRateChangedJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", PollingRateChangedJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(preferences);
  }
  
  public void injectMembers(PollingRateChangedJob paramPollingRateChangedJob)
  {
    preferences = ((ILyftPreferences)preferences.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.PollingRateChangedJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */