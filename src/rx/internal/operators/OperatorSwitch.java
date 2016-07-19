package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorSwitch<T>
  implements Observable.Operator<T, Observable<? extends T>>
{
  public static <T> OperatorSwitch<T> instance()
  {
    return OperatorSwitch.Holder.INSTANCE;
  }
  
  public Subscriber<? super Observable<? extends T>> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorSwitch.SwitchSubscriber localSwitchSubscriber = new OperatorSwitch.SwitchSubscriber(paramSubscriber);
    paramSubscriber.add(localSwitchSubscriber);
    return localSwitchSubscriber;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSwitch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */