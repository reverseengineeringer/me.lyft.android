package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.Subscription;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

class OperatorTimeoutBase<T>
  implements Observable.Operator<T, T>
{
  private final OperatorTimeoutBase.FirstTimeoutStub<T> firstTimeoutStub;
  private final Observable<? extends T> other;
  private final Scheduler scheduler;
  private final OperatorTimeoutBase.TimeoutStub<T> timeoutStub;
  
  OperatorTimeoutBase(OperatorTimeoutBase.FirstTimeoutStub<T> paramFirstTimeoutStub, OperatorTimeoutBase.TimeoutStub<T> paramTimeoutStub, Observable<? extends T> paramObservable, Scheduler paramScheduler)
  {
    firstTimeoutStub = paramFirstTimeoutStub;
    timeoutStub = paramTimeoutStub;
    other = paramObservable;
    scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    Scheduler.Worker localWorker = scheduler.createWorker();
    paramSubscriber.add(localWorker);
    SerialSubscription localSerialSubscription = new SerialSubscription();
    paramSubscriber.add(localSerialSubscription);
    paramSubscriber = new OperatorTimeoutBase.TimeoutSubscriber(new SerializedSubscriber(paramSubscriber), timeoutStub, localSerialSubscription, other, localWorker, null);
    localSerialSubscription.set((Subscription)firstTimeoutStub.call(paramSubscriber, Long.valueOf(0L), localWorker));
    return paramSubscriber;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTimeoutBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */