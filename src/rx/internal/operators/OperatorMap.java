package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;

public final class OperatorMap<T, R>
  implements Observable.Operator<R, T>
{
  private final Func1<? super T, ? extends R> transformer;
  
  public OperatorMap(Func1<? super T, ? extends R> paramFunc1)
  {
    transformer = paramFunc1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super R> paramSubscriber)
  {
    return new OperatorMap.1(this, paramSubscriber, paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */