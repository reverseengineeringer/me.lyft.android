package me.lyft.android.rx;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class RxUIBinder
  extends RxBinder
{
  public <T> Subscription bindAction(Observable<T> paramObservable, Action1<T> paramAction1)
  {
    return super.bindAction(paramObservable.observeOn(AndroidSchedulers.mainThread()), paramAction1);
  }
  
  public <T> Subscription bindAsyncCall(Observable<T> paramObservable, AsyncCall<T> paramAsyncCall)
  {
    return super.bindAsyncCall(paramObservable.observeOn(AndroidSchedulers.mainThread()), paramAsyncCall);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.rx.RxUIBinder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */