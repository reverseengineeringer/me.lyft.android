package com.jakewharton.rxrelay;

import rx.Observable.OnSubscribe;
import rx.annotations.Beta;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;

public class BehaviorRelay<T>
  extends Relay<T, T>
{
  private static final Object[] EMPTY_ARRAY = new Object[0];
  private final NotificationLite<T> nl = NotificationLite.instance();
  private final RelaySubscriptionManager<T> state;
  
  protected BehaviorRelay(Observable.OnSubscribe<T> paramOnSubscribe, RelaySubscriptionManager<T> paramRelaySubscriptionManager)
  {
    super(paramOnSubscribe);
    state = paramRelaySubscriptionManager;
  }
  
  public static <T> BehaviorRelay<T> create()
  {
    return create(null, false);
  }
  
  public static <T> BehaviorRelay<T> create(T paramT)
  {
    return create(paramT, true);
  }
  
  private static <T> BehaviorRelay<T> create(T paramT, boolean paramBoolean)
  {
    RelaySubscriptionManager localRelaySubscriptionManager = new RelaySubscriptionManager();
    if (paramBoolean) {
      localRelaySubscriptionManager.setLatest(NotificationLite.instance().next(paramT));
    }
    onAdded = new Action1()
    {
      public void call(RelaySubscriptionManager.RelayObserver<T> paramAnonymousRelayObserver)
      {
        paramAnonymousRelayObserver.emitFirst(val$state.getLatest(), val$state.nl);
      }
    };
    return new BehaviorRelay(localRelaySubscriptionManager, localRelaySubscriptionManager);
  }
  
  public void call(T paramT)
  {
    if ((state.getLatest() == null) || (state.active))
    {
      paramT = nl.next(paramT);
      RelaySubscriptionManager.RelayObserver[] arrayOfRelayObserver = state.next(paramT);
      int j = arrayOfRelayObserver.length;
      int i = 0;
      while (i < j)
      {
        arrayOfRelayObserver[i].emitNext(paramT, state.nl);
        i += 1;
      }
    }
  }
  
  @Beta
  public T getValue()
  {
    Object localObject = state.getLatest();
    if (nl.isNext(localObject)) {
      return (T)nl.getValue(localObject);
    }
    return null;
  }
  
  @Beta
  public boolean hasValue()
  {
    Object localObject = state.getLatest();
    return nl.isNext(localObject);
  }
}

/* Location:
 * Qualified Name:     com.jakewharton.rxrelay.BehaviorRelay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */