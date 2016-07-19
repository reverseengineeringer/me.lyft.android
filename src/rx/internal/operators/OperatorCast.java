package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;

public class OperatorCast<T, R>
  implements Observable.Operator<R, T>
{
  private final Class<R> castClass;
  
  public OperatorCast(Class<R> paramClass)
  {
    castClass = paramClass;
  }
  
  public Subscriber<? super T> call(Subscriber<? super R> paramSubscriber)
  {
    return new OperatorCast.1(this, paramSubscriber, paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorCast
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */