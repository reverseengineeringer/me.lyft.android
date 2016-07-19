package com.jakewharton.rxrelay;

import rx.functions.Action1;

final class BehaviorRelay$1
  implements Action1<RelaySubscriptionManager.RelayObserver<T>>
{
  BehaviorRelay$1(RelaySubscriptionManager paramRelaySubscriptionManager) {}
  
  public void call(RelaySubscriptionManager.RelayObserver<T> paramRelayObserver)
  {
    paramRelayObserver.emitFirst(val$state.getLatest(), val$state.nl);
  }
}

/* Location:
 * Qualified Name:     com.jakewharton.rxrelay.BehaviorRelay.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */