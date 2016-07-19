package rx.internal.operators;

import rx.Observable.Operator;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.ImmediateScheduler;
import rx.schedulers.TrampolineScheduler;

public final class OperatorObserveOn<T>
  implements Observable.Operator<T, T>
{
  private final Scheduler scheduler;
  
  public OperatorObserveOn(Scheduler paramScheduler)
  {
    scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    if ((scheduler instanceof ImmediateScheduler)) {}
    while ((scheduler instanceof TrampolineScheduler)) {
      return paramSubscriber;
    }
    paramSubscriber = new OperatorObserveOn.ObserveOnSubscriber(scheduler, paramSubscriber);
    paramSubscriber.init();
    return paramSubscriber;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorObserveOn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */