package rx;

import rx.functions.Func0;
import rx.observables.ConnectableObservable;

class Observable$17
  implements Func0<ConnectableObservable<T>>
{
  Observable$17(Observable paramObservable, int paramInt) {}
  
  public ConnectableObservable<T> call()
  {
    return this$0.replay(val$bufferSize);
  }
}

/* Location:
 * Qualified Name:     rx.Observable.17
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */