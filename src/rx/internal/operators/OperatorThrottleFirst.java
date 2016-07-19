package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Subscriber;

public final class OperatorThrottleFirst<T>
  implements Observable.Operator<T, T>
{
  private final Scheduler scheduler;
  private final long timeInMilliseconds;
  
  public OperatorThrottleFirst(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    timeInMilliseconds = paramTimeUnit.toMillis(paramLong);
    scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return new OperatorThrottleFirst.1(this, paramSubscriber, paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorThrottleFirst
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */