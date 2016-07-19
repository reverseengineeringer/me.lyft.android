package rx.internal.operators;

import java.util.List;
import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorBufferWithSize<T>
  implements Observable.Operator<List<T>, T>
{
  final int count;
  final int skip;
  
  public OperatorBufferWithSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      throw new IllegalArgumentException("count must be greater than 0");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("skip must be greater than 0");
    }
    count = paramInt1;
    skip = paramInt2;
  }
  
  public Subscriber<? super T> call(Subscriber<? super List<T>> paramSubscriber)
  {
    if (count == skip) {
      return new OperatorBufferWithSize.1(this, paramSubscriber, paramSubscriber);
    }
    return new OperatorBufferWithSize.2(this, paramSubscriber, paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSize
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */