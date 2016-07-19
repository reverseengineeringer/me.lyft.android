package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Action1;

public class OperatorDoOnRequest<T>
  implements Observable.Operator<T, T>
{
  private final Action1<Long> request;
  
  public OperatorDoOnRequest(Action1<Long> paramAction1)
  {
    request = paramAction1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorDoOnRequest.ParentSubscriber localParentSubscriber = new OperatorDoOnRequest.ParentSubscriber(paramSubscriber, null);
    paramSubscriber.setProducer(new OperatorDoOnRequest.1(this, localParentSubscriber));
    paramSubscriber.add(localParentSubscriber);
    return localParentSubscriber;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDoOnRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */