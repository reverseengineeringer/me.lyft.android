package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.observables.ConnectableObservable;

public final class OperatorReplay<T>
  extends ConnectableObservable<T>
{
  static final Func0 DEFAULT_UNBOUNDED_FACTORY = new OperatorReplay.1();
  final Func0<? extends OperatorReplay.ReplayBuffer<T>> bufferFactory;
  final AtomicReference<OperatorReplay.ReplaySubscriber<T>> current;
  final Observable<? extends T> source;
  
  private OperatorReplay(Observable.OnSubscribe<T> paramOnSubscribe, Observable<? extends T> paramObservable, AtomicReference<OperatorReplay.ReplaySubscriber<T>> paramAtomicReference, Func0<? extends OperatorReplay.ReplayBuffer<T>> paramFunc0)
  {
    super(paramOnSubscribe);
    source = paramObservable;
    current = paramAtomicReference;
    bufferFactory = paramFunc0;
  }
  
  public static <T> ConnectableObservable<T> create(Observable<? extends T> paramObservable)
  {
    return create(paramObservable, DEFAULT_UNBOUNDED_FACTORY);
  }
  
  public static <T> ConnectableObservable<T> create(Observable<? extends T> paramObservable, int paramInt)
  {
    if (paramInt == Integer.MAX_VALUE) {
      return create(paramObservable);
    }
    return create(paramObservable, new OperatorReplay.5(paramInt));
  }
  
  public static <T> ConnectableObservable<T> create(Observable<? extends T> paramObservable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return create(paramObservable, paramLong, paramTimeUnit, paramScheduler, Integer.MAX_VALUE);
  }
  
  public static <T> ConnectableObservable<T> create(Observable<? extends T> paramObservable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, int paramInt)
  {
    return create(paramObservable, new OperatorReplay.6(paramInt, paramTimeUnit.toMillis(paramLong), paramScheduler));
  }
  
  static <T> ConnectableObservable<T> create(Observable<? extends T> paramObservable, Func0<? extends OperatorReplay.ReplayBuffer<T>> paramFunc0)
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return new OperatorReplay(new OperatorReplay.7(localAtomicReference, paramFunc0), paramObservable, localAtomicReference, paramFunc0);
  }
  
  public static <T, U, R> Observable<R> multicastSelector(Func0<? extends ConnectableObservable<U>> paramFunc0, Func1<? super Observable<U>, ? extends Observable<R>> paramFunc1)
  {
    return Observable.create(new OperatorReplay.2(paramFunc0, paramFunc1));
  }
  
  public static <T> ConnectableObservable<T> observeOn(ConnectableObservable<T> paramConnectableObservable, Scheduler paramScheduler)
  {
    return new OperatorReplay.4(new OperatorReplay.3(paramConnectableObservable.observeOn(paramScheduler)), paramConnectableObservable);
  }
  
  public void connect(Action1<? super Subscription> paramAction1)
  {
    OperatorReplay.ReplaySubscriber localReplaySubscriber2;
    OperatorReplay.ReplaySubscriber localReplaySubscriber1;
    do
    {
      localReplaySubscriber2 = (OperatorReplay.ReplaySubscriber)current.get();
      if (localReplaySubscriber2 != null)
      {
        localReplaySubscriber1 = localReplaySubscriber2;
        if (!localReplaySubscriber2.isUnsubscribed()) {
          break;
        }
      }
      localReplaySubscriber1 = new OperatorReplay.ReplaySubscriber(current, (OperatorReplay.ReplayBuffer)bufferFactory.call());
      localReplaySubscriber1.init();
    } while (!current.compareAndSet(localReplaySubscriber2, localReplaySubscriber1));
    if ((!shouldConnect.get()) && (shouldConnect.compareAndSet(false, true))) {}
    for (int i = 1;; i = 0)
    {
      paramAction1.call(localReplaySubscriber1);
      if (i != 0) {
        source.unsafeSubscribe(localReplaySubscriber1);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorReplay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */