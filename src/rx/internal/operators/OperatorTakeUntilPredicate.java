package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;

public final class OperatorTakeUntilPredicate<T>
  implements Observable.Operator<T, T>
{
  private final Func1<? super T, Boolean> stopPredicate;
  
  public OperatorTakeUntilPredicate(Func1<? super T, Boolean> paramFunc1)
  {
    stopPredicate = paramFunc1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorTakeUntilPredicate.ParentSubscriber localParentSubscriber = new OperatorTakeUntilPredicate.ParentSubscriber(this, paramSubscriber, null);
    paramSubscriber.add(localParentSubscriber);
    paramSubscriber.setProducer(new OperatorTakeUntilPredicate.1(this, localParentSubscriber));
    return localParentSubscriber;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTakeUntilPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */