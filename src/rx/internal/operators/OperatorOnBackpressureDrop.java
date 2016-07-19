package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Action1;

public class OperatorOnBackpressureDrop<T>
  implements Observable.Operator<T, T>
{
  private final Action1<? super T> onDrop;
  
  private OperatorOnBackpressureDrop()
  {
    this(null);
  }
  
  public OperatorOnBackpressureDrop(Action1<? super T> paramAction1)
  {
    onDrop = paramAction1;
  }
  
  public static <T> OperatorOnBackpressureDrop<T> instance()
  {
    return OperatorOnBackpressureDrop.Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    AtomicLong localAtomicLong = new AtomicLong();
    paramSubscriber.setProducer(new OperatorOnBackpressureDrop.1(this, localAtomicLong));
    return new OperatorOnBackpressureDrop.2(this, paramSubscriber, paramSubscriber, localAtomicLong);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorOnBackpressureDrop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */