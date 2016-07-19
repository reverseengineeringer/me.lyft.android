package com.jakewharton.rxrelay;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.internal.operators.NotificationLite;
import rx.subscriptions.Subscriptions;

final class RelaySubscriptionManager<T>
  extends AtomicReference<State<T>>
  implements Observable.OnSubscribe<T>
{
  boolean active = true;
  volatile Object latest;
  final NotificationLite<T> nl = NotificationLite.instance();
  Action1<RelayObserver<T>> onAdded = Actions.empty();
  Action1<RelayObserver<T>> onStart = Actions.empty();
  
  RelaySubscriptionManager()
  {
    super(State.EMPTY);
  }
  
  private void add(RelayObserver<T> paramRelayObserver)
  {
    State localState;
    do
    {
      localState = (State)get();
    } while (!compareAndSet(localState, localState.add(paramRelayObserver)));
    onAdded.call(paramRelayObserver);
  }
  
  private void addUnsubscriber(Subscriber<? super T> paramSubscriber, final RelayObserver<T> paramRelayObserver)
  {
    paramSubscriber.add(Subscriptions.create(new Action0()
    {
      public void call()
      {
        remove(paramRelayObserver);
      }
    }));
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    RelayObserver localRelayObserver = new RelayObserver(paramSubscriber);
    addUnsubscriber(paramSubscriber, localRelayObserver);
    onStart.call(localRelayObserver);
    if (!paramSubscriber.isUnsubscribed())
    {
      add(localRelayObserver);
      if (paramSubscriber.isUnsubscribed()) {
        remove(localRelayObserver);
      }
    }
  }
  
  Object getLatest()
  {
    return latest;
  }
  
  RelayObserver<T>[] next(Object paramObject)
  {
    setLatest(paramObject);
    return getobservers;
  }
  
  RelayObserver<T>[] observers()
  {
    return getobservers;
  }
  
  void remove(RelayObserver<T> paramRelayObserver)
  {
    State localState1;
    State localState2;
    do
    {
      localState1 = (State)get();
      localState2 = localState1.remove(paramRelayObserver);
    } while ((localState2 != localState1) && (!compareAndSet(localState1, localState2)));
  }
  
  void setLatest(Object paramObject)
  {
    latest = paramObject;
  }
  
  static final class RelayObserver<T>
    implements Observer<T>
  {
    final Observer<? super T> actual;
    boolean emitting;
    boolean fastPath;
    boolean first = true;
    List<Object> queue;
    
    RelayObserver(Observer<? super T> paramObserver)
    {
      actual = paramObserver;
    }
    
    private void accept(Object paramObject, NotificationLite<T> paramNotificationLite)
    {
      if (paramObject != null) {
        paramNotificationLite.accept(actual, paramObject);
      }
    }
    
    /* Error */
    private void emitLoop(List<Object> paramList, Object paramObject, NotificationLite<T> paramNotificationLite)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 6
      //   3: iconst_0
      //   4: istore 8
      //   6: iconst_0
      //   7: istore 7
      //   9: aload_1
      //   10: ifnull +62 -> 72
      //   13: iload 7
      //   15: istore 4
      //   17: aload_1
      //   18: invokeinterface 48 1 0
      //   23: astore_1
      //   24: iload 7
      //   26: istore 4
      //   28: aload_1
      //   29: invokeinterface 54 1 0
      //   34: ifeq +38 -> 72
      //   37: iload 7
      //   39: istore 4
      //   41: aload_0
      //   42: aload_1
      //   43: invokeinterface 58 1 0
      //   48: aload_3
      //   49: invokespecial 60	com/jakewharton/rxrelay/RelaySubscriptionManager$RelayObserver:accept	(Ljava/lang/Object;Lrx/internal/operators/NotificationLite;)V
      //   52: goto -28 -> 24
      //   55: astore_1
      //   56: iload 4
      //   58: ifne +12 -> 70
      //   61: aload_0
      //   62: monitorenter
      //   63: aload_0
      //   64: iconst_0
      //   65: putfield 62	com/jakewharton/rxrelay/RelaySubscriptionManager$RelayObserver:emitting	Z
      //   68: aload_0
      //   69: monitorexit
      //   70: aload_1
      //   71: athrow
      //   72: iload 6
      //   74: istore 5
      //   76: iload 6
      //   78: ifeq +16 -> 94
      //   81: iconst_0
      //   82: istore 5
      //   84: iload 7
      //   86: istore 4
      //   88: aload_0
      //   89: aload_2
      //   90: aload_3
      //   91: invokespecial 60	com/jakewharton/rxrelay/RelaySubscriptionManager$RelayObserver:accept	(Ljava/lang/Object;Lrx/internal/operators/NotificationLite;)V
      //   94: iload 7
      //   96: istore 4
      //   98: aload_0
      //   99: monitorenter
      //   100: iload 8
      //   102: istore 4
      //   104: aload_0
      //   105: getfield 64	com/jakewharton/rxrelay/RelaySubscriptionManager$RelayObserver:queue	Ljava/util/List;
      //   108: astore_1
      //   109: iload 8
      //   111: istore 4
      //   113: aload_0
      //   114: aconst_null
      //   115: putfield 64	com/jakewharton/rxrelay/RelaySubscriptionManager$RelayObserver:queue	Ljava/util/List;
      //   118: aload_1
      //   119: ifnonnull +31 -> 150
      //   122: iload 8
      //   124: istore 4
      //   126: aload_0
      //   127: iconst_0
      //   128: putfield 62	com/jakewharton/rxrelay/RelaySubscriptionManager$RelayObserver:emitting	Z
      //   131: iconst_1
      //   132: istore 4
      //   134: aload_0
      //   135: monitorexit
      //   136: iconst_1
      //   137: ifne +12 -> 149
      //   140: aload_0
      //   141: monitorenter
      //   142: aload_0
      //   143: iconst_0
      //   144: putfield 62	com/jakewharton/rxrelay/RelaySubscriptionManager$RelayObserver:emitting	Z
      //   147: aload_0
      //   148: monitorexit
      //   149: return
      //   150: iload 8
      //   152: istore 4
      //   154: aload_0
      //   155: monitorexit
      //   156: iload 5
      //   158: istore 6
      //   160: goto -151 -> 9
      //   163: astore_1
      //   164: aload_0
      //   165: monitorexit
      //   166: aload_1
      //   167: athrow
      //   168: astore_1
      //   169: aload_0
      //   170: monitorexit
      //   171: aload_1
      //   172: athrow
      //   173: astore_1
      //   174: aload_0
      //   175: monitorexit
      //   176: aload_1
      //   177: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	178	0	this	RelayObserver
      //   0	178	1	paramList	List<Object>
      //   0	178	2	paramObject	Object
      //   0	178	3	paramNotificationLite	NotificationLite<T>
      //   15	138	4	i	int
      //   74	83	5	j	int
      //   1	158	6	k	int
      //   7	88	7	m	int
      //   4	147	8	n	int
      // Exception table:
      //   from	to	target	type
      //   17	24	55	finally
      //   28	37	55	finally
      //   41	52	55	finally
      //   88	94	55	finally
      //   98	100	55	finally
      //   166	168	55	finally
      //   104	109	163	finally
      //   113	118	163	finally
      //   126	131	163	finally
      //   134	136	163	finally
      //   154	156	163	finally
      //   164	166	163	finally
      //   142	149	168	finally
      //   169	171	168	finally
      //   63	70	173	finally
      //   174	176	173	finally
    }
    
    void emitFirst(Object paramObject, NotificationLite<T> paramNotificationLite)
    {
      boolean bool = false;
      try
      {
        if ((!first) || (emitting)) {
          return;
        }
        first = false;
        if (paramObject != null) {
          bool = true;
        }
        emitting = bool;
        if (paramObject != null)
        {
          emitLoop(null, paramObject, paramNotificationLite);
          return;
        }
      }
      finally {}
    }
    
    void emitNext(Object paramObject, NotificationLite<T> paramNotificationLite)
    {
      if (!fastPath) {}
      try
      {
        first = false;
        if (emitting)
        {
          if (queue == null) {
            queue = new ArrayList();
          }
          queue.add(paramObject);
          return;
        }
        fastPath = true;
        paramNotificationLite.accept(actual, paramObject);
        return;
      }
      finally {}
    }
    
    public void onCompleted()
    {
      throw new AssertionError();
    }
    
    public void onError(Throwable paramThrowable)
    {
      throw new AssertionError();
    }
    
    public void onNext(T paramT)
    {
      actual.onNext(paramT);
    }
  }
  
  static final class State<T>
  {
    static final State EMPTY = new State(new RelaySubscriptionManager.RelayObserver[0]);
    final RelaySubscriptionManager.RelayObserver[] observers;
    
    State(RelaySubscriptionManager.RelayObserver[] paramArrayOfRelayObserver)
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
}

/* Location:
 * Qualified Name:     com.jakewharton.rxrelay.RelaySubscriptionManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */