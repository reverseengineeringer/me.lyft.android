package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

public final class OperatorConcat<T>
  implements Observable.Operator<T, Observable<? extends T>>
{
  public static <T> OperatorConcat<T> instance()
  {
    return OperatorConcat.Holder.INSTANCE;
  }
  
  public Subscriber<? super Observable<? extends T>> call(Subscriber<? super T> paramSubscriber)
  {
    Object localObject = new SerializedSubscriber(paramSubscriber);
    SerialSubscription localSerialSubscription = new SerialSubscription();
    paramSubscriber.add(localSerialSubscription);
    localObject = new OperatorConcat.ConcatSubscriber((Subscriber)localObject, localSerialSubscription);
    paramSubscriber.setProducer(new OperatorConcat.ConcatProducer((OperatorConcat.ConcatSubscriber)localObject));
    return (Subscriber<? super Observable<? extends T>>)localObject;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorConcat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */