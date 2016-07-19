package rx.internal.operators;

import java.util.concurrent.Callable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.producers.SingleDelayedProducer;

public final class OnSubscribeFromCallable<T>
  implements Observable.OnSubscribe<T>
{
  private final Callable<? extends T> resultFactory;
  
  public OnSubscribeFromCallable(Callable<? extends T> paramCallable)
  {
    resultFactory = paramCallable;
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    SingleDelayedProducer localSingleDelayedProducer = new SingleDelayedProducer(paramSubscriber);
    paramSubscriber.setProducer(localSingleDelayedProducer);
    try
    {
      localSingleDelayedProducer.setValue(resultFactory.call());
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwIfFatal(localThrowable);
      paramSubscriber.onError(localThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeFromCallable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */