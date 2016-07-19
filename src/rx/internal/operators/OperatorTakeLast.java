package rx.internal.operators;

import java.util.ArrayDeque;
import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorTakeLast<T>
  implements Observable.Operator<T, T>
{
  private final int count;
  
  public OperatorTakeLast(int paramInt)
  {
    if (paramInt < 0) {
      throw new IndexOutOfBoundsException("count cannot be negative");
    }
    count = paramInt;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    ArrayDeque localArrayDeque = new ArrayDeque();
    NotificationLite localNotificationLite = NotificationLite.instance();
    TakeLastQueueProducer localTakeLastQueueProducer = new TakeLastQueueProducer(localNotificationLite, localArrayDeque, paramSubscriber);
    paramSubscriber.setProducer(localTakeLastQueueProducer);
    return new OperatorTakeLast.1(this, paramSubscriber, localArrayDeque, localNotificationLite, localTakeLastQueueProducer, paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTakeLast
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */