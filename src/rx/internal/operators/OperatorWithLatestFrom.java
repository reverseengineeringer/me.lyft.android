package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func2;
import rx.observers.SerializedSubscriber;

public final class OperatorWithLatestFrom<T, U, R>
  implements Observable.Operator<R, T>
{
  static final Object EMPTY = new Object();
  final Observable<? extends U> other;
  final Func2<? super T, ? super U, ? extends R> resultSelector;
  
  public OperatorWithLatestFrom(Observable<? extends U> paramObservable, Func2<? super T, ? super U, ? extends R> paramFunc2)
  {
    other = paramObservable;
    resultSelector = paramFunc2;
  }
  
  public Subscriber<? super T> call(Subscriber<? super R> paramSubscriber)
  {
    SerializedSubscriber localSerializedSubscriber = new SerializedSubscriber(paramSubscriber, false);
    paramSubscriber.add(localSerializedSubscriber);
    Object localObject = new AtomicReference(EMPTY);
    paramSubscriber = new OperatorWithLatestFrom.1(this, localSerializedSubscriber, true, (AtomicReference)localObject, localSerializedSubscriber);
    localObject = new OperatorWithLatestFrom.2(this, (AtomicReference)localObject, localSerializedSubscriber);
    localSerializedSubscriber.add(paramSubscriber);
    localSerializedSubscriber.add((Subscription)localObject);
    other.unsafeSubscribe((Subscriber)localObject);
    return paramSubscriber;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWithLatestFrom
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */