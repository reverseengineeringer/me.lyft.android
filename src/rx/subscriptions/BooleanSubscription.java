package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.functions.Action0;

public final class BooleanSubscription
  implements Subscription
{
  static final Action0 EMPTY_ACTION = new BooleanSubscription.1();
  final AtomicReference<Action0> actionRef;
  
  public BooleanSubscription()
  {
    actionRef = new AtomicReference();
  }
  
  private BooleanSubscription(Action0 paramAction0)
  {
    actionRef = new AtomicReference(paramAction0);
  }
  
  public static BooleanSubscription create()
  {
    return new BooleanSubscription();
  }
  
  public static BooleanSubscription create(Action0 paramAction0)
  {
    return new BooleanSubscription(paramAction0);
  }
  
  public boolean isUnsubscribed()
  {
    return actionRef.get() == EMPTY_ACTION;
  }
  
  public final void unsubscribe()
  {
    if ((Action0)actionRef.get() != EMPTY_ACTION)
    {
      Action0 localAction0 = (Action0)actionRef.getAndSet(EMPTY_ACTION);
      if ((localAction0 != null) && (localAction0 != EMPTY_ACTION)) {
        localAction0.call();
      }
    }
  }
}

/* Location:
 * Qualified Name:     rx.subscriptions.BooleanSubscription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */