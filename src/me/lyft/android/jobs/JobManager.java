package me.lyft.android.jobs;

import dagger.ObjectGraph;
import javax.inject.Inject;
import javax.inject.Singleton;
import me.lyft.android.LyftApplication;
import me.lyft.android.logging.L;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

@Singleton
public class JobManager
{
  private final ObjectGraph applicationGraph;
  
  @Inject
  public JobManager(LyftApplication paramLyftApplication)
  {
    applicationGraph = paramLyftApplication.getApplicationGraph().plus(new Object[] { new JobModule() });
  }
  
  private <T extends Job> void executeJob(T paramT)
  {
    try
    {
      applicationGraph.inject(paramT);
      paramT.execute();
      return;
    }
    catch (Throwable localThrowable)
    {
      L.e(localThrowable, "failed to execute job:" + paramT.getClass().getSimpleName(), new Object[0]);
    }
  }
  
  private <T extends Job> void queueJob(final T paramT, final Scheduler paramScheduler)
  {
    paramScheduler = paramScheduler.createWorker();
    paramScheduler.schedule(new Action0()
    {
      public void call()
      {
        JobManager.this.executeJob(paramT);
        paramScheduler.unsubscribe();
      }
    });
  }
  
  public <T extends Job> void queueBackgroundJob(T paramT)
  {
    queueJob(paramT, Schedulers.newThread());
  }
  
  public <T extends Job> void queueImmediateJob(T paramT)
  {
    executeJob(paramT);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.JobManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */