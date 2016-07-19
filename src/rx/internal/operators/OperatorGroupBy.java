package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;
import rx.observables.GroupedObservable;

public class OperatorGroupBy<T, K, R>
  implements Observable.Operator<GroupedObservable<K, R>, T>
{
  private static final Func1<Object, Object> IDENTITY = new OperatorGroupBy.1();
  private static final Object NULL_KEY = new Object();
  final Func1<? super T, ? extends K> keySelector;
  final Func1<? super T, ? extends R> valueSelector;
  
  public OperatorGroupBy(Func1<? super T, ? extends K> paramFunc1)
  {
    this(paramFunc1, IDENTITY);
  }
  
  public OperatorGroupBy(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends R> paramFunc11)
  {
    keySelector = paramFunc1;
    valueSelector = paramFunc11;
  }
  
  public Subscriber<? super T> call(Subscriber<? super GroupedObservable<K, R>> paramSubscriber)
  {
    return new OperatorGroupBy.GroupBySubscriber(keySelector, valueSelector, paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorGroupBy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */