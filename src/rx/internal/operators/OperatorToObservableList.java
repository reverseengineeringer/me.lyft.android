package rx.internal.operators;

import java.util.List;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.internal.producers.SingleDelayedProducer;

public final class OperatorToObservableList<T>
  implements Observable.Operator<List<T>, T>
{
  public static <T> OperatorToObservableList<T> instance()
  {
    return OperatorToObservableList.Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super List<T>> paramSubscriber)
  {
    SingleDelayedProducer localSingleDelayedProducer = new SingleDelayedProducer(paramSubscriber);
    OperatorToObservableList.1 local1 = new OperatorToObservableList.1(this, localSingleDelayedProducer, paramSubscriber);
    paramSubscriber.add(local1);
    paramSubscriber.setProducer(localSingleDelayedProducer);
    return local1;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorToObservableList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */