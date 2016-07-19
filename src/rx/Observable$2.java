package rx;

import rx.exceptions.Exceptions;
import rx.plugins.RxJavaObservableExecutionHook;

class Observable$2
  implements Observable.OnSubscribe<R>
{
  Observable$2(Observable paramObservable, Observable.Operator paramOperator) {}
  
  public void call(Subscriber<? super R> paramSubscriber)
  {
    try
    {
      Subscriber localSubscriber = (Subscriber)Observable.access$100().onLift(val$operator).call(paramSubscriber);
      try
      {
        localSubscriber.onStart();
        this$0.onSubscribe.call(localSubscriber);
        return;
      }
      catch (Throwable localThrowable2)
      {
        Exceptions.throwIfFatal(localThrowable2);
        localSubscriber.onError(localThrowable2);
        return;
      }
      return;
    }
    catch (Throwable localThrowable1)
    {
      Exceptions.throwIfFatal(localThrowable1);
      paramSubscriber.onError(localThrowable1);
    }
  }
}

/* Location:
 * Qualified Name:     rx.Observable.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */