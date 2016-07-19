package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;

public final class OperatorEagerConcatMap<T, R>
  implements Observable.Operator<R, T>
{
  final int bufferSize;
  final Func1<? super T, ? extends Observable<? extends R>> mapper;
  
  public OperatorEagerConcatMap(Func1<? super T, ? extends Observable<? extends R>> paramFunc1, int paramInt)
  {
    mapper = paramFunc1;
    bufferSize = paramInt;
  }
  
  public Subscriber<? super T> call(Subscriber<? super R> paramSubscriber)
  {
    paramSubscriber = new OperatorEagerConcatMap.EagerOuterSubscriber(mapper, bufferSize, paramSubscriber);
    paramSubscriber.init();
    return paramSubscriber;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorEagerConcatMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */