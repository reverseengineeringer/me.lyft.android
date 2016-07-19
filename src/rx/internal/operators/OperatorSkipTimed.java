package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;

public final class OperatorSkipTimed<T>
  implements Observable.Operator<T, T>
{
  final Scheduler scheduler;
  final long time;
  final TimeUnit unit;
  
  public OperatorSkipTimed(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    time = paramLong;
    unit = paramTimeUnit;
    scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    Scheduler.Worker localWorker = scheduler.createWorker();
    paramSubscriber.add(localWorker);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean();
    localWorker.schedule(new OperatorSkipTimed.1(this, localAtomicBoolean), time, unit);
    return new OperatorSkipTimed.2(this, paramSubscriber, localAtomicBoolean, paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSkipTimed
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */