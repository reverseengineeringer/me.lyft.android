package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.ILyftPreferences;

public final class LyftTokenUpdateJob$$InjectAdapter
  extends Binding<LyftTokenUpdateJob>
{
  private Binding<ILyftPreferences> preferences;
  
  public LyftTokenUpdateJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.LyftTokenUpdateJob", false, LyftTokenUpdateJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", LyftTokenUpdateJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(preferences);
  }
  
  public void injectMembers(LyftTokenUpdateJob paramLyftTokenUpdateJob)
  {
    preferences = ((ILyftPreferences)preferences.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.LyftTokenUpdateJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */