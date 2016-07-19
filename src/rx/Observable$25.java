package rx;

import rx.functions.Func1;

class Observable$25
  implements Func1<Observable<? extends Notification<?>>, Observable<?>>
{
  Observable$25(Observable paramObservable, Func1 paramFunc1) {}
  
  public Observable<?> call(Observable<? extends Notification<?>> paramObservable)
  {
    return (Observable)val$notificationHandler.call(paramObservable.map(new Observable.25.1(this)));
  }
}

/* Location:
 * Qualified Name:     rx.Observable.25
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */