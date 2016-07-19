package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;

public final class OperatorMapNotification<T, R>
  implements Observable.Operator<R, T>
{
  private final Func0<? extends R> onCompleted;
  private final Func1<? super Throwable, ? extends R> onError;
  private final Func1<? super T, ? extends R> onNext;
  
  public OperatorMapNotification(Func1<? super T, ? extends R> paramFunc1, Func1<? super Throwable, ? extends R> paramFunc11, Func0<? extends R> paramFunc0)
  {
    onNext = paramFunc1;
    onError = paramFunc11;
    onCompleted = paramFunc0;
  }
  
  public Subscriber<? super T> call(Subscriber<? super R> paramSubscriber)
  {
    OperatorMapNotification.MapNotificationSubscriber localMapNotificationSubscriber = new OperatorMapNotification.MapNotificationSubscriber(this, new ProducerArbiter(), paramSubscriber, null);
    paramSubscriber.add(localMapNotificationSubscriber);
    localMapNotificationSubscriber.init();
    return localMapNotificationSubscriber;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorMapNotification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */