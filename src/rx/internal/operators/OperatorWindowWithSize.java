package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorWindowWithSize<T>
  implements Observable.Operator<Observable<T>, T>
{
  final int size;
  final int skip;
  
  public OperatorWindowWithSize(int paramInt1, int paramInt2)
  {
    size = paramInt1;
    skip = paramInt2;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Observable<T>> paramSubscriber)
  {
    if (skip == size)
    {
      paramSubscriber = new OperatorWindowWithSize.ExactSubscriber(this, paramSubscriber);
      paramSubscriber.init();
      return paramSubscriber;
    }
    paramSubscriber = new OperatorWindowWithSize.InexactSubscriber(this, paramSubscriber);
    paramSubscriber.init();
    return paramSubscriber;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithSize
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */