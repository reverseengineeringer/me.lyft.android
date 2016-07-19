package rx.internal.operators;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

public final class OnSubscribeRange
  implements Observable.OnSubscribe<Integer>
{
  private final int end;
  private final int start;
  
  public OnSubscribeRange(int paramInt1, int paramInt2)
  {
    start = paramInt1;
    end = paramInt2;
  }
  
  public void call(Subscriber<? super Integer> paramSubscriber)
  {
    paramSubscriber.setProducer(new OnSubscribeRange.RangeProducer(paramSubscriber, start, end, null));
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeRange
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */