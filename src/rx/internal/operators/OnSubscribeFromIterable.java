package rx.internal.operators;

import java.util.Iterator;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

public final class OnSubscribeFromIterable<T>
  implements Observable.OnSubscribe<T>
{
  final Iterable<? extends T> is;
  
  public OnSubscribeFromIterable(Iterable<? extends T> paramIterable)
  {
    if (paramIterable == null) {
      throw new NullPointerException("iterable must not be null");
    }
    is = paramIterable;
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    Iterator localIterator = is.iterator();
    if ((!localIterator.hasNext()) && (!paramSubscriber.isUnsubscribed()))
    {
      paramSubscriber.onCompleted();
      return;
    }
    paramSubscriber.setProducer(new OnSubscribeFromIterable.IterableProducer(paramSubscriber, localIterator, null));
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeFromIterable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */