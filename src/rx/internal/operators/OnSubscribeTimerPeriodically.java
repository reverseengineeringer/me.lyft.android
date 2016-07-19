package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable.OnSubscribe;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;

public final class OnSubscribeTimerPeriodically
  implements Observable.OnSubscribe<Long>
{
  final long initialDelay;
  final long period;
  final Scheduler scheduler;
  final TimeUnit unit;
  
  public OnSubscribeTimerPeriodically(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    initialDelay = paramLong1;
    period = paramLong2;
    unit = paramTimeUnit;
    scheduler = paramScheduler;
  }
  
  public void call(Subscriber<? super Long> paramSubscriber)
  {
    Scheduler.Worker localWorker = scheduler.createWorker();
    paramSubscriber.add(localWorker);
    localWorker.schedulePeriodically(new OnSubscribeTimerPeriodically.1(this, paramSubscriber, localWorker), initialDelay, period, unit);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeTimerPeriodically
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */