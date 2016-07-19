package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorAsObservable<T>
  implements Observable.Operator<T, T>
{
  public static <T> OperatorAsObservable<T> instance()
  {
    return OperatorAsObservable.Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return paramSubscriber;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorAsObservable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */