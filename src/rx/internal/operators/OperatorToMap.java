package rx.internal.operators;

import java.util.Map;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func0;
import rx.functions.Func1;

public final class OperatorToMap<T, K, V>
  implements Observable.Operator<Map<K, V>, T>
{
  private final Func1<? super T, ? extends K> keySelector;
  private final Func0<? extends Map<K, V>> mapFactory;
  private final Func1<? super T, ? extends V> valueSelector;
  
  public OperatorToMap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11)
  {
    this(paramFunc1, paramFunc11, new OperatorToMap.DefaultToMapFactory());
  }
  
  public OperatorToMap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11, Func0<? extends Map<K, V>> paramFunc0)
  {
    keySelector = paramFunc1;
    valueSelector = paramFunc11;
    mapFactory = paramFunc0;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Map<K, V>> paramSubscriber)
  {
    return new OperatorToMap.1(this, paramSubscriber, paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorToMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */