package rx.internal.operators;

import rx.Observable;
import rx.Single.OnSubscribe;
import rx.SingleSubscriber;

public class OnSubscribeSingle<T>
  implements Single.OnSubscribe<T>
{
  private final Observable<T> observable;
  
  public OnSubscribeSingle(Observable<T> paramObservable)
  {
    observable = paramObservable;
  }
  
  public static <T> OnSubscribeSingle<T> create(Observable<T> paramObservable)
  {
    return new OnSubscribeSingle(paramObservable);
  }
  
  public void call(SingleSubscriber<? super T> paramSingleSubscriber)
  {
    OnSubscribeSingle.1 local1 = new OnSubscribeSingle.1(this, paramSingleSubscriber);
    paramSingleSubscriber.add(local1);
    observable.unsafeSubscribe(local1);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeSingle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */