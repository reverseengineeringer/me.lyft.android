package rx;

import java.util.concurrent.TimeUnit;
import rx.functions.Action0;
import rx.subscriptions.MultipleAssignmentSubscription;

public abstract class Scheduler$Worker
  implements Subscription
{
  public long now()
  {
    return System.currentTimeMillis();
  }
  
  public abstract Subscription schedule(Action0 paramAction0);
  
  public abstract Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit);
  
  public Subscription schedulePeriodically(Action0 paramAction0, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    paramLong2 = paramTimeUnit.toNanos(paramLong2);
    long l1 = TimeUnit.MILLISECONDS.toNanos(now());
    long l2 = paramTimeUnit.toNanos(paramLong1);
    MultipleAssignmentSubscription localMultipleAssignmentSubscription1 = new MultipleAssignmentSubscription();
    paramAction0 = new Scheduler.Worker.1(this, localMultipleAssignmentSubscription1, paramAction0, l1 + l2, paramLong2);
    MultipleAssignmentSubscription localMultipleAssignmentSubscription2 = new MultipleAssignmentSubscription();
    localMultipleAssignmentSubscription1.set(localMultipleAssignmentSubscription2);
    localMultipleAssignmentSubscription2.set(schedule(paramAction0, paramLong1, paramTimeUnit));
    return localMultipleAssignmentSubscription1;
  }
}

/* Location:
 * Qualified Name:     rx.Scheduler.Worker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */