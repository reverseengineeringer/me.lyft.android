package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;

public final class OperatorWindowWithTime<T>
  implements Observable.Operator<Observable<T>, T>
{
  static final Object NEXT_SUBJECT = new Object();
  static final NotificationLite<Object> nl = NotificationLite.instance();
  final Scheduler scheduler;
  final int size;
  final long timeshift;
  final long timespan;
  final TimeUnit unit;
  
  public OperatorWindowWithTime(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, int paramInt, Scheduler paramScheduler)
  {
    timespan = paramLong1;
    timeshift = paramLong2;
    unit = paramTimeUnit;
    size = paramInt;
    scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Observable<T>> paramSubscriber)
  {
    Scheduler.Worker localWorker = scheduler.createWorker();
    if (timespan == timeshift)
    {
      paramSubscriber = new OperatorWindowWithTime.ExactSubscriber(this, paramSubscriber, localWorker);
      paramSubscriber.add(localWorker);
      paramSubscriber.scheduleExact();
      return paramSubscriber;
    }
    paramSubscriber = new OperatorWindowWithTime.InexactSubscriber(this, paramSubscriber, localWorker);
    paramSubscriber.add(localWorker);
    paramSubscriber.startNewChunk();
    paramSubscriber.scheduleChunk();
    return paramSubscriber;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithTime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */