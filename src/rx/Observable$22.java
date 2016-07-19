package rx;

import rx.functions.Func0;
import rx.observables.ConnectableObservable;

class Observable$22
  implements Func0<ConnectableObservable<T>>
{
  Observable$22(Observable paramObservable) {}
  
  public ConnectableObservable<T> call()
  {
    return this$0.replay();
  }
}

/* Location:
 * Qualified Name:     rx.Observable.22
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */