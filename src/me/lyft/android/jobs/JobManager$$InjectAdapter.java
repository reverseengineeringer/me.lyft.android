package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.LyftApplication;

public final class JobManager$$InjectAdapter
  extends Binding<JobManager>
{
  private Binding<LyftApplication> application;
  
  public JobManager$$InjectAdapter()
  {
    super("me.lyft.android.jobs.JobManager", "members/me.lyft.android.jobs.JobManager", true, JobManager.class);
  }
  
  public void attach(Linker paramLinker)
  {
    application = paramLinker.requestBinding("me.lyft.android.LyftApplication", JobManager.class, getClass().getClassLoader());
  }
  
  public JobManager get()
  {
    return new JobManager((LyftApplication)application.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(application);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.JobManager..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */