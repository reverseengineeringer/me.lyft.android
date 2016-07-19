package rx.internal.operators;

import java.util.Collection;
import java.util.Map;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func0;
import rx.functions.Func1;

public final class OperatorToMultimap<T, K, V>
  implements Observable.Operator<Map<K, Collection<V>>, T>
{
  private final Func1<? super K, ? extends Collection<V>> collectionFactory;
  private final Func1<? super T, ? extends K> keySelector;
  private final Func0<? extends Map<K, Collection<V>>> mapFactory;
  private final Func1<? super T, ? extends V> valueSelector;
  
  public OperatorToMultimap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11)
  {
    this(paramFunc1, paramFunc11, new OperatorToMultimap.DefaultToMultimapFactory(), new OperatorToMultimap.DefaultMultimapCollectionFactory());
  }
  
  public OperatorToMultimap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11, Func0<? extends Map<K, Collection<V>>> paramFunc0)
  {
    this(paramFunc1, paramFunc11, paramFunc0, new OperatorToMultimap.DefaultMultimapCollectionFactory());
  }
  
  public OperatorToMultimap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11, Func0<? extends Map<K, Collection<V>>> paramFunc0, Func1<? super K, ? extends Collection<V>> paramFunc12)
  {
    keySelector = paramFunc1;
    valueSelector = paramFunc11;
    mapFactory = paramFunc0;
    collectionFactory = paramFunc12;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Map<K, Collection<V>>> paramSubscriber)
  {
    return new OperatorToMultimap.1(this, paramSubscriber, paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorToMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */