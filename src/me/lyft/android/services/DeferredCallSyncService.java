package me.lyft.android.services;

import android.content.Context;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job.Builder;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;
import com.firebase.jobdispatcher.RetryStrategy;
import com.firebase.jobdispatcher.Trigger;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import me.lyft.android.LyftApplication;
import me.lyft.android.infrastructure.deferred.IDeferredCallService;
import me.lyft.android.logging.L;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public class DeferredCallSyncService
  extends JobService
{
  private static final String TASK_TAG = "DeferredLyftCallSyncTask";
  @Inject
  IDeferredCallService deferredCallService;
  final AtomicBoolean needsReschedule = new AtomicBoolean(true);
  private Subscription subscription = Subscriptions.unsubscribed();
  
  private LyftApplication getLyftApplication()
  {
    return (LyftApplication)getApplication();
  }
  
  private void performSync(JobParameters paramJobParameters)
  {
    needsReschedule.set(true);
    try
    {
      deferredCallService.sync();
      boolean bool = deferredCallService.hasPendingCall();
      needsReschedule.set(bool);
      if (!subscription.isUnsubscribed()) {
        jobFinished(paramJobParameters, needsReschedule.get());
      }
      return;
    }
    catch (Exception paramJobParameters)
    {
      L.w(paramJobParameters, "Error performing sync.", new Object[0]);
    }
  }
  
  public static void scheduleUsing(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(paramContext) != 0) {}
    int i;
    do
    {
      return;
      paramContext = new FirebaseJobDispatcher(new GooglePlayDriver(paramContext));
      i = paramContext.schedule(paramContext.newJobBuilder().setService(DeferredCallSyncService.class).setTag("DeferredLyftCallSyncTask").setConstraints(new int[] { 2 }).setTrigger(Trigger.NOW).setLifetime(2).setRecurring(false).setReplaceCurrent(true).setRetryStrategy(RetryStrategy.DEFAULT_EXPONENTIAL).build());
    } while (i == 0);
    L.w("Unable to schedule DeferredLyftCallSyncTask result = " + i, new Object[0]);
  }
  
  public boolean onStartJob(final JobParameters paramJobParameters)
  {
    getLyftApplication().inject(this);
    subscription.unsubscribe();
    final Scheduler.Worker localWorker = Schedulers.io().createWorker();
    subscription = localWorker;
    localWorker.schedule(new Action0()
    {
      public void call()
      {
        if (localWorker.isUnsubscribed()) {
          return;
        }
        DeferredCallSyncService.this.performSync(paramJobParameters);
        localWorker.unsubscribe();
      }
    });
    return true;
  }
  
  public boolean onStopJob(JobParameters paramJobParameters)
  {
    subscription.unsubscribe();
    return needsReschedule.get();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.DeferredCallSyncService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */