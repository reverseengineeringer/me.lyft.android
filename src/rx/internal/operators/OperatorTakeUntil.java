package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

public final class OperatorTakeUntil<T, E>
  implements Observable.Operator<T, T>
{
  private final Observable<? extends E> other;
  
  public OperatorTakeUntil(Observable<? extends E> paramObservable)
  {
    other = paramObservable;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    SerializedSubscriber localSerializedSubscriber = new SerializedSubscriber(paramSubscriber, false);
    OperatorTakeUntil.1 local1 = new OperatorTakeUntil.1(this, localSerializedSubscriber, false, localSerializedSubscriber);
    OperatorTakeUntil.2 local2 = new OperatorTakeUntil.2(this, local1);
    localSerializedSubscriber.add(local1);
    localSerializedSubscriber.add(local2);
    paramSubscriber.add(localSerializedSubscriber);
    other.unsafeSubscribe(local2);
    return local1;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTakeUntil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */