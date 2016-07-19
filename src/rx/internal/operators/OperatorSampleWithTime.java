package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;

public final class OperatorSampleWithTime<T>
  implements Observable.Operator<T, T>
{
  final Scheduler scheduler;
  final long time;
  final TimeUnit unit;
  
  public OperatorSampleWithTime(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    time = paramLong;
    unit = paramTimeUnit;
    scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    Object localObject = new SerializedSubscriber(paramSubscriber);
    Scheduler.Worker localWorker = scheduler.createWorker();
    paramSubscriber.add(localWorker);
    localObject = new OperatorSampleWithTime.SamplerSubscriber((Subscriber)localObject);
    paramSubscriber.add((Subscription)localObject);
    localWorker.schedulePeriodically((Action0)localObject, time, time, unit);
    return (Subscriber<? super T>)localObject;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSampleWithTime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */