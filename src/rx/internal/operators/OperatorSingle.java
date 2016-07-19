package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorSingle<T>
  implements Observable.Operator<T, T>
{
  private final T defaultValue;
  private final boolean hasDefaultValue;
  
  private OperatorSingle()
  {
    this(false, null);
  }
  
  public OperatorSingle(T paramT)
  {
    this(true, paramT);
  }
  
  private OperatorSingle(boolean paramBoolean, T paramT)
  {
    hasDefaultValue = paramBoolean;
    defaultValue = paramT;
  }
  
  public static <T> OperatorSingle<T> instance()
  {
    return OperatorSingle.Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorSingle.ParentSubscriber localParentSubscriber = new OperatorSingle.ParentSubscriber(paramSubscriber, hasDefaultValue, defaultValue);
    paramSubscriber.setProducer(new OperatorSingle.1(this, localParentSubscriber));
    paramSubscriber.add(localParentSubscriber);
    return localParentSubscriber;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSingle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */