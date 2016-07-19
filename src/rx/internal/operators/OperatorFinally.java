package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Action0;

public final class OperatorFinally<T>
  implements Observable.Operator<T, T>
{
  final Action0 action;
  
  public OperatorFinally(Action0 paramAction0)
  {
    if (paramAction0 == null) {
      throw new NullPointerException("Action can not be null");
    }
    action = paramAction0;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return new OperatorFinally.1(this, paramSubscriber, paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorFinally
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */