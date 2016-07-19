package me.lyft.android.rx;

import rx.Subscriber;
import rx.subscriptions.Subscriptions;

public class AsyncCall<T>
  extends Subscriber<T>
{
  public AsyncCall()
  {
    add(Subscriptions.create(new AsyncCall.1(this)));
  }
  
  public final void onCompleted()
  {
    unsubscribe();
  }
  
  public final void onError(Throwable paramThrowable)
  {
    if (!isUnsubscribed()) {
      onFail(paramThrowable);
    }
    unsubscribe();
  }
  
  public void onFail(Throwable paramThrowable) {}
  
  public final void onNext(T paramT)
  {
    if (!isUnsubscribed()) {
      onSuccess(paramT);
    }
    unsubscribe();
  }
  
  public void onSuccess(T paramT) {}
  
  public void onUnsubscribe() {}
}

/* Location:
 * Qualified Name:     me.lyft.android.rx.AsyncCall
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */