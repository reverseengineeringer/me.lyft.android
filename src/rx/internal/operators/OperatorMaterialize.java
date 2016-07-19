package rx.internal.operators;

import rx.Notification;
import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorMaterialize<T>
  implements Observable.Operator<Notification<T>, T>
{
  public static <T> OperatorMaterialize<T> instance()
  {
    return OperatorMaterialize.Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Notification<T>> paramSubscriber)
  {
    OperatorMaterialize.ParentSubscriber localParentSubscriber = new OperatorMaterialize.ParentSubscriber(paramSubscriber);
    paramSubscriber.add(localParentSubscriber);
    paramSubscriber.setProducer(new OperatorMaterialize.1(this, localParentSubscriber));
    return localParentSubscriber;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorMaterialize
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */