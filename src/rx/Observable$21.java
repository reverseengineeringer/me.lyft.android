package rx;

import java.util.concurrent.TimeUnit;
import rx.functions.Func0;
import rx.observables.ConnectableObservable;

class Observable$21
  implements Func0<ConnectableObservable<T>>
{
  Observable$21(Observable paramObservable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler) {}
  
  public ConnectableObservable<T> call()
  {
    return this$0.replay(val$time, val$unit, val$scheduler);
  }
}

/* Location:
 * Qualified Name:     rx.Observable.21
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */