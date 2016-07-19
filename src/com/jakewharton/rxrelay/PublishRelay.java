package com.jakewharton.rxrelay;

import rx.Observable.OnSubscribe;

public class PublishRelay<T>
  extends Relay<T, T>
{
  private final RelaySubscriptionManager<T> state;
  
  protected PublishRelay(Observable.OnSubscribe<T> paramOnSubscribe, RelaySubscriptionManager<T> paramRelaySubscriptionManager)
  {
    super(paramOnSubscribe);
    state = paramRelaySubscriptionManager;
  }
  
  public static <T> PublishRelay<T> create()
  {
    RelaySubscriptionManager localRelaySubscriptionManager = new RelaySubscriptionManager();
    return new PublishRelay(localRelaySubscriptionManager, localRelaySubscriptionManager);
  }
  
  public void call(T paramT)
  {
    RelaySubscriptionManager.RelayObserver[] arrayOfRelayObserver = state.observers();
    int j = arrayOfRelayObserver.length;
    int i = 0;
    while (i < j)
    {
      arrayOfRelayObserver[i].onNext(paramT);
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.jakewharton.rxrelay.PublishRelay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */