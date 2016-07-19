package rx.internal.operators;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.Observable.OnSubscribe;

public final class OnSubscribeToObservableFuture
{
  private OnSubscribeToObservableFuture()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Observable.OnSubscribe<T> toObservableFuture(Future<? extends T> paramFuture)
  {
    return new OnSubscribeToObservableFuture.ToObservableFuture(paramFuture);
  }
  
  public static <T> Observable.OnSubscribe<T> toObservableFuture(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    return new OnSubscribeToObservableFuture.ToObservableFuture(paramFuture, paramLong, paramTimeUnit);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeToObservableFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */