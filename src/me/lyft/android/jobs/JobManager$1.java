package me.lyft.android.jobs;

import rx.Scheduler.Worker;
import rx.functions.Action0;

class JobManager$1
  implements Action0
{
  JobManager$1(JobManager paramJobManager, Job paramJob, Scheduler.Worker paramWorker) {}
  
  public void call()
  {
    JobManager.access$000(this$0, val$job);
    val$worker.unsubscribe();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.JobManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */