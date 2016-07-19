package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.internal.producers.ProducerArbiter;
import rx.subscriptions.SerialSubscription;

public final class OperatorSwitchIfEmpty<T>
  implements Observable.Operator<T, T>
{
  private final Observable<? extends T> alternate;
  
  public OperatorSwitchIfEmpty(Observable<? extends T> paramObservable)
  {
    alternate = paramObservable;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    SerialSubscription localSerialSubscription = new SerialSubscription();
    ProducerArbiter localProducerArbiter = new ProducerArbiter();
    OperatorSwitchIfEmpty.ParentSubscriber localParentSubscriber = new OperatorSwitchIfEmpty.ParentSubscriber(paramSubscriber, localSerialSubscription, localProducerArbiter, alternate);
    localSerialSubscription.set(localParentSubscriber);
    paramSubscriber.add(localSerialSubscription);
    paramSubscriber.setProducer(localProducerArbiter);
    return localParentSubscriber;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSwitchIfEmpty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */