package rx;

import rx.functions.Action1;

class Observable$11
  implements Observer<T>
{
  Observable$11(Observable paramObservable, Action1 paramAction1) {}
  
  public final void onCompleted() {}
  
  public final void onError(Throwable paramThrowable) {}
  
  public final void onNext(T paramT)
  {
    val$onNext.call(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.Observable.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */