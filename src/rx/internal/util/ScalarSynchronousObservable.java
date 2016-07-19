package rx.internal.util;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Func1;
import rx.internal.schedulers.EventLoopsScheduler;

public final class ScalarSynchronousObservable<T>
  extends Observable<T>
{
  private final T t;
  
  protected ScalarSynchronousObservable(T paramT)
  {
    super(new ScalarSynchronousObservable.1(paramT));
    t = paramT;
  }
  
  public static final <T> ScalarSynchronousObservable<T> create(T paramT)
  {
    return new ScalarSynchronousObservable(paramT);
  }
  
  public T get()
  {
    return (T)t;
  }
  
  public <R> Observable<R> scalarFlatMap(Func1<? super T, ? extends Observable<? extends R>> paramFunc1)
  {
    return create(new ScalarSynchronousObservable.2(this, paramFunc1));
  }
  
  public Observable<T> scalarScheduleOn(Scheduler paramScheduler)
  {
    if ((paramScheduler instanceof EventLoopsScheduler)) {
      return create(new ScalarSynchronousObservable.DirectScheduledEmission((EventLoopsScheduler)paramScheduler, t));
    }
    return create(new ScalarSynchronousObservable.NormalScheduledEmission(paramScheduler, t));
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.ScalarSynchronousObservable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */