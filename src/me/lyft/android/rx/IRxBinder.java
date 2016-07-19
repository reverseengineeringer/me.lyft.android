package me.lyft.android.rx;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

public abstract interface IRxBinder
{
  public abstract void attach();
  
  public abstract <T> Subscription bindAction(Observable<T> paramObservable, Action1<T> paramAction1);
  
  public abstract <T> Subscription bindAsyncCall(Observable<T> paramObservable, AsyncCall<T> paramAsyncCall);
  
  public abstract void detach();
  
  public abstract boolean isAttached();
}

/* Location:
 * Qualified Name:     me.lyft.android.rx.IRxBinder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */