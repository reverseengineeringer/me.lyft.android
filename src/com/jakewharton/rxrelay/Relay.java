package com.jakewharton.rxrelay;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.functions.Action1;

public abstract class Relay<T, R>
  extends Observable<R>
  implements Action1<T>
{
  protected Relay(Observable.OnSubscribe<R> paramOnSubscribe)
  {
    super(paramOnSubscribe);
  }
}

/* Location:
 * Qualified Name:     com.jakewharton.rxrelay.Relay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */