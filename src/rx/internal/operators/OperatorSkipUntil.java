package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

public final class OperatorSkipUntil<T, U>
  implements Observable.Operator<T, T>
{
  final Observable<U> other;
  
  public OperatorSkipUntil(Observable<U> paramObservable)
  {
    other = paramObservable;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    SerializedSubscriber localSerializedSubscriber = new SerializedSubscriber(paramSubscriber);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean();
    OperatorSkipUntil.1 local1 = new OperatorSkipUntil.1(this, localAtomicBoolean, localSerializedSubscriber);
    paramSubscriber.add(local1);
    other.unsafeSubscribe(local1);
    return new OperatorSkipUntil.2(this, paramSubscriber, localAtomicBoolean, localSerializedSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSkipUntil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */