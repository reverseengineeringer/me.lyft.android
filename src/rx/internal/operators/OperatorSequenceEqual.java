package rx.internal.operators;

import rx.Observable;
import rx.functions.Func2;
import rx.internal.util.UtilityFunctions;

public final class OperatorSequenceEqual
{
  private static final Object LOCAL_ONCOMPLETED = new Object();
  
  private OperatorSequenceEqual()
  {
    throw new IllegalStateException("No instances!");
  }
  
  static <T> Observable<Object> materializeLite(Observable<T> paramObservable)
  {
    return Observable.concat(paramObservable.map(new OperatorSequenceEqual.1()), Observable.just(LOCAL_ONCOMPLETED));
  }
  
  public static <T> Observable<Boolean> sequenceEqual(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Func2<? super T, ? super T, Boolean> paramFunc2)
  {
    return Observable.zip(materializeLite(paramObservable1), materializeLite(paramObservable2), new OperatorSequenceEqual.2(paramFunc2)).all(UtilityFunctions.identity());
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSequenceEqual
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */