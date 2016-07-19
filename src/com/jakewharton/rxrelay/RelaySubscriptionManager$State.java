package com.jakewharton.rxrelay;

final class RelaySubscriptionManager$State<T>
{
  static final State EMPTY = new State(new RelaySubscriptionManager.RelayObserver[0]);
  final RelaySubscriptionManager.RelayObserver[] observers;
  
  RelaySubscriptionManager$State(RelaySubscriptionManager.RelayObserver[] paramArrayOfRelayObserver)
  {
    observers = paramArrayOfRelayObserver;
  }
  
  State add(RelaySubscriptionManager.RelayObserver paramRelayObserver)
  {
    int i = observers.length;
    RelaySubscriptionManager.RelayObserver[] arrayOfRelayObserver = new RelaySubscriptionManager.RelayObserver[i + 1];
    System.arraycopy(observers, 0, arrayOfRelayObserver, 0, i);
    arrayOfRelayObserver[i] = paramRelayObserver;
    return new State(arrayOfRelayObserver);
  }
  
  State remove(RelaySubscriptionManager.RelayObserver paramRelayObserver)
  {
    RelaySubscriptionManager.RelayObserver[] arrayOfRelayObserver2 = observers;
    int m = arrayOfRelayObserver2.length;
    State localState;
    if ((m == 1) && (arrayOfRelayObserver2[0] == paramRelayObserver)) {
      localState = EMPTY;
    }
    RelaySubscriptionManager.RelayObserver[] arrayOfRelayObserver1;
    int j;
    RelaySubscriptionManager.RelayObserver localRelayObserver;
    do
    {
      do
      {
        return localState;
        localState = this;
      } while (m == 0);
      arrayOfRelayObserver1 = new RelaySubscriptionManager.RelayObserver[m - 1];
      j = 0;
      i = 0;
      if (j >= m) {
        break;
      }
      localRelayObserver = arrayOfRelayObserver2[j];
      if (localRelayObserver == paramRelayObserver) {
        break label146;
      }
      localState = this;
    } while (i == m - 1);
    int k = i + 1;
    arrayOfRelayObserver1[i] = localRelayObserver;
    int i = k;
    label146:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        return EMPTY;
      }
      paramRelayObserver = arrayOfRelayObserver1;
      if (i < m - 1)
      {
        paramRelayObserver = new RelaySubscriptionManager.RelayObserver[i];
        System.arraycopy(arrayOfRelayObserver1, 0, paramRelayObserver, 0, i);
      }
      return new State(paramRelayObserver);
    }
  }
}

/* Location:
 * Qualified Name:     com.jakewharton.rxrelay.RelaySubscriptionManager.State
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */