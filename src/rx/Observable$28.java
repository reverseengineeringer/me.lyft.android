package rx;

import rx.functions.Action1;

class Observable$28
  extends Subscriber<T>
{
  Observable$28(Observable paramObservable, Action1 paramAction11, Action1 paramAction12) {}
  
  public final void onCompleted() {}
  
  public final void onError(Throwable paramThrowable)
  {
    val$onError.call(paramThrowable);
  }
  
  public final void onNext(T paramT)
  {
    val$onNext.call(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.Observable.28
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */