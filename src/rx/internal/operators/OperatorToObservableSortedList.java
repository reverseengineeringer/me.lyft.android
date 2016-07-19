package rx.internal.operators;

import java.util.Comparator;
import java.util.List;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func2;
import rx.internal.producers.SingleDelayedProducer;

public final class OperatorToObservableSortedList<T>
  implements Observable.Operator<List<T>, T>
{
  private static Comparator DEFAULT_SORT_FUNCTION = new OperatorToObservableSortedList.DefaultComparableFunction(null);
  private final int initialCapacity;
  private final Comparator<? super T> sortFunction;
  
  public OperatorToObservableSortedList(int paramInt)
  {
    sortFunction = DEFAULT_SORT_FUNCTION;
    initialCapacity = paramInt;
  }
  
  public OperatorToObservableSortedList(Func2<? super T, ? super T, Integer> paramFunc2, int paramInt)
  {
    initialCapacity = paramInt;
    sortFunction = new OperatorToObservableSortedList.1(this, paramFunc2);
  }
  
  public Subscriber<? super T> call(Subscriber<? super List<T>> paramSubscriber)
  {
    SingleDelayedProducer localSingleDelayedProducer = new SingleDelayedProducer(paramSubscriber);
    OperatorToObservableSortedList.2 local2 = new OperatorToObservableSortedList.2(this, localSingleDelayedProducer, paramSubscriber);
    paramSubscriber.add(local2);
    paramSubscriber.setProducer(localSingleDelayedProducer);
    return local2;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorToObservableSortedList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */