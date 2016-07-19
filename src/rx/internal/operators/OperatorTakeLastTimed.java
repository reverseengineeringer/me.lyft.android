package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Subscriber;

public final class OperatorTakeLastTimed<T>
  implements Observable.Operator<T, T>
{
  private final long ageMillis;
  private final int count;
  private final Scheduler scheduler;
  
  public OperatorTakeLastTimed(int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    if (paramInt < 0) {
      throw new IndexOutOfBoundsException("count could not be negative");
    }
    ageMillis = paramTimeUnit.toMillis(paramLong);
    scheduler = paramScheduler;
    count = paramInt;
  }
  
  public OperatorTakeLastTimed(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    ageMillis = paramTimeUnit.toMillis(paramLong);
    scheduler = paramScheduler;
    count = -1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    ArrayDeque localArrayDeque1 = new ArrayDeque();
    ArrayDeque localArrayDeque2 = new ArrayDeque();
    NotificationLite localNotificationLite = NotificationLite.instance();
    TakeLastQueueProducer localTakeLastQueueProducer = new TakeLastQueueProducer(localNotificationLite, localArrayDeque1, paramSubscriber);
    paramSubscriber.setProducer(localTakeLastQueueProducer);
    return new OperatorTakeLastTimed.1(this, paramSubscriber, localArrayDeque1, localArrayDeque2, localNotificationLite, paramSubscriber, localTakeLastQueueProducer);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTakeLastTimed
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */