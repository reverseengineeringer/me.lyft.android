package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;

public final class CachedObservable<T>
  extends Observable<T>
{
  private final CachedObservable.CacheState<T> state;
  
  private CachedObservable(Observable.OnSubscribe<T> paramOnSubscribe, CachedObservable.CacheState<T> paramCacheState)
  {
    super(paramOnSubscribe);
    state = paramCacheState;
  }
  
  public static <T> CachedObservable<T> from(Observable<? extends T> paramObservable)
  {
    return from(paramObservable, 16);
  }
  
  public static <T> CachedObservable<T> from(Observable<? extends T> paramObservable, int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("capacityHint > 0 required");
    }
    paramObservable = new CachedObservable.CacheState(paramObservable, paramInt);
    return new CachedObservable(new CachedObservable.CachedSubscribe(paramObservable), paramObservable);
  }
  
  boolean hasObservers()
  {
    return state.producers.length != 0;
  }
  
  boolean isConnected()
  {
    return state.isConnected;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.CachedObservable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */