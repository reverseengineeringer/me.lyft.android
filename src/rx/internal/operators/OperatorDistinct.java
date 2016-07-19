package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;

public final class OperatorDistinct<T, U>
  implements Observable.Operator<T, T>
{
  final Func1<? super T, ? extends U> keySelector;
  
  public OperatorDistinct(Func1<? super T, ? extends U> paramFunc1)
  {
    keySelector = paramFunc1;
  }
  
  public static <T> OperatorDistinct<T, T> instance()
  {
    return OperatorDistinct.Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return new OperatorDistinct.1(this, paramSubscriber, paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDistinct
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */