package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observables.ConnectableObservable;

public final class OperatorPublish<T>
  extends ConnectableObservable<T>
{
  final AtomicReference<OperatorPublish.PublishSubscriber<T>> current;
  final Observable<? extends T> source;
  
  private OperatorPublish(Observable.OnSubscribe<T> paramOnSubscribe, Observable<? extends T> paramObservable, AtomicReference<OperatorPublish.PublishSubscriber<T>> paramAtomicReference)
  {
    super(paramOnSubscribe);
    source = paramObservable;
    current = paramAtomicReference;
  }
  
  public static <T, R> Observable<R> create(Observable<? extends T> paramObservable, Func1<? super Observable<T>, ? extends Observable<R>> paramFunc1)
  {
    return create(new OperatorPublish.2(paramObservable, paramFunc1));
  }
  
  public static <T> ConnectableObservable<T> create(Observable<? extends T> paramObservable)
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return new OperatorPublish(new OperatorPublish.1(localAtomicReference), paramObservable, localAtomicReference);
  }
  
  public void connect(Action1<? super Subscription> paramAction1)
  {
    OperatorPublish.PublishSubscriber localPublishSubscriber2;
    OperatorPublish.PublishSubscriber localPublishSubscriber1;
    do
    {
      localPublishSubscriber2 = (OperatorPublish.PublishSubscriber)current.get();
      if (localPublishSubscriber2 != null)
      {
        localPublishSubscriber1 = localPublishSubscriber2;
        if (!localPublishSubscriber2.isUnsubscribed()) {
          break;
        }
      }
      localPublishSubscriber1 = new OperatorPublish.PublishSubscriber(current);
      localPublishSubscriber1.init();
    } while (!current.compareAndSet(localPublishSubscriber2, localPublishSubscriber1));
    if ((!shouldConnect.get()) && (shouldConnect.compareAndSet(false, true))) {}
    for (int i = 1;; i = 0)
    {
      paramAction1.call(localPublishSubscriber1);
      if (i != 0) {
        source.unsafeSubscribe(localPublishSubscriber1);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorPublish
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */