package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;

public final class OnSubscribeDelaySubscriptionWithSelector<T, U>
  implements Observable.OnSubscribe<T>
{
  final Observable<? extends T> source;
  final Func0<? extends Observable<U>> subscriptionDelay;
  
  public OnSubscribeDelaySubscriptionWithSelector(Observable<? extends T> paramObservable, Func0<? extends Observable<U>> paramFunc0)
  {
    source = paramObservable;
    subscriptionDelay = paramFunc0;
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    try
    {
      ((Observable)subscriptionDelay.call()).take(1).unsafeSubscribe(new OnSubscribeDelaySubscriptionWithSelector.1(this, paramSubscriber));
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, paramSubscriber);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeDelaySubscriptionWithSelector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */