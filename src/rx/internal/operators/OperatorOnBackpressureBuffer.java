package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Action0;

public class OperatorOnBackpressureBuffer<T>
  implements Observable.Operator<T, T>
{
  private final Long capacity;
  private final Action0 onOverflow;
  
  private OperatorOnBackpressureBuffer()
  {
    capacity = null;
    onOverflow = null;
  }
  
  public OperatorOnBackpressureBuffer(long paramLong)
  {
    this(paramLong, null);
  }
  
  public OperatorOnBackpressureBuffer(long paramLong, Action0 paramAction0)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("Buffer capacity must be > 0");
    }
    capacity = Long.valueOf(paramLong);
    onOverflow = paramAction0;
  }
  
  public static <T> OperatorOnBackpressureBuffer<T> instance()
  {
    return OperatorOnBackpressureBuffer.Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorOnBackpressureBuffer.BufferSubscriber localBufferSubscriber = new OperatorOnBackpressureBuffer.BufferSubscriber(paramSubscriber, capacity, onOverflow);
    paramSubscriber.add(localBufferSubscriber);
    paramSubscriber.setProducer(localBufferSubscriber.manager());
    return localBufferSubscriber;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorOnBackpressureBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */