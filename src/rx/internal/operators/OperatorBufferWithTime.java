package rx.internal.operators;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.Subscription;
import rx.observers.SerializedSubscriber;

public final class OperatorBufferWithTime<T>
  implements Observable.Operator<List<T>, T>
{
  final int count;
  final Scheduler scheduler;
  final long timeshift;
  final long timespan;
  final TimeUnit unit;
  
  public OperatorBufferWithTime(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, int paramInt, Scheduler paramScheduler)
  {
    timespan = paramLong1;
    timeshift = paramLong2;
    unit = paramTimeUnit;
    count = paramInt;
    scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super List<T>> paramSubscriber)
  {
    Scheduler.Worker localWorker = scheduler.createWorker();
    Object localObject = new SerializedSubscriber(paramSubscriber);
    if (timespan == timeshift)
    {
      localObject = new OperatorBufferWithTime.ExactSubscriber(this, (Subscriber)localObject, localWorker);
      ((OperatorBufferWithTime.ExactSubscriber)localObject).add(localWorker);
      paramSubscriber.add((Subscription)localObject);
      ((OperatorBufferWithTime.ExactSubscriber)localObject).scheduleExact();
      return (Subscriber<? super T>)localObject;
    }
    localObject = new OperatorBufferWithTime.InexactSubscriber(this, (Subscriber)localObject, localWorker);
    ((OperatorBufferWithTime.InexactSubscriber)localObject).add(localWorker);
    paramSubscriber.add((Subscription)localObject);
    ((OperatorBufferWithTime.InexactSubscriber)localObject).startNewChunk();
    ((OperatorBufferWithTime.InexactSubscriber)localObject).scheduleChunk();
    return (Subscriber<? super T>)localObject;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorBufferWithTime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */