package rx.internal.operators;

import rx.Observable.Operator;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Timestamped;

public final class OperatorTimestamp<T>
  implements Observable.Operator<Timestamped<T>, T>
{
  private final Scheduler scheduler;
  
  public OperatorTimestamp(Scheduler paramScheduler)
  {
    scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Timestamped<T>> paramSubscriber)
  {
    return new OperatorTimestamp.1(this, paramSubscriber, paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTimestamp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */