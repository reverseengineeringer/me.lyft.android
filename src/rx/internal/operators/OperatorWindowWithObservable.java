package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorWindowWithObservable<T, U>
  implements Observable.Operator<Observable<T>, T>
{
  static final Object NEXT_SUBJECT = new Object();
  static final NotificationLite<Object> nl = NotificationLite.instance();
  final Observable<U> other;
  
  public OperatorWindowWithObservable(Observable<U> paramObservable)
  {
    other = paramObservable;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Observable<T>> paramSubscriber)
  {
    OperatorWindowWithObservable.SourceSubscriber localSourceSubscriber = new OperatorWindowWithObservable.SourceSubscriber(paramSubscriber);
    OperatorWindowWithObservable.BoundarySubscriber localBoundarySubscriber = new OperatorWindowWithObservable.BoundarySubscriber(paramSubscriber, localSourceSubscriber);
    paramSubscriber.add(localSourceSubscriber);
    paramSubscriber.add(localBoundarySubscriber);
    localSourceSubscriber.replaceWindow();
    other.unsafeSubscribe(localBoundarySubscriber);
    return localSourceSubscriber;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithObservable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */