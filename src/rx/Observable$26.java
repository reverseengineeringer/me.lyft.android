package rx;

import rx.exceptions.OnErrorNotImplementedException;

class Observable$26
  extends Subscriber<T>
{
  Observable$26(Observable paramObservable) {}
  
  public final void onCompleted() {}
  
  public final void onError(Throwable paramThrowable)
  {
    throw new OnErrorNotImplementedException(paramThrowable);
  }
  
  public final void onNext(T paramT) {}
}

/* Location:
 * Qualified Name:     rx.Observable.26
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */