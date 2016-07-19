package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;

public class OperatorIgnoreElements<T>
  implements Observable.Operator<T, T>
{
  public static <T> OperatorIgnoreElements<T> instance()
  {
    return OperatorIgnoreElements.Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorIgnoreElements.1 local1 = new OperatorIgnoreElements.1(this, paramSubscriber);
    paramSubscriber.add(local1);
    return local1;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorIgnoreElements
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */