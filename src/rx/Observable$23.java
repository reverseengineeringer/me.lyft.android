package rx;

import rx.functions.Func1;

class Observable$23
  implements Func1<Observable<T>, Observable<R>>
{
  Observable$23(Observable paramObservable, Func1 paramFunc1, Scheduler paramScheduler) {}
  
  public Observable<R> call(Observable<T> paramObservable)
  {
    return ((Observable)val$selector.call(paramObservable)).observeOn(val$scheduler);
  }
}

/* Location:
 * Qualified Name:     rx.Observable.23
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */