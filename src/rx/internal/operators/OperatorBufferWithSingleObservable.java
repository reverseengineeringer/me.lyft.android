package rx.internal.operators;

import java.util.List;
import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.observers.SerializedSubscriber;
import rx.observers.Subscribers;

public final class OperatorBufferWithSingleObservable<T, TClosing>
  implements Observable.Operator<List<T>, T>
{
  final Func0<? extends Observable<? extends TClosing>> bufferClosingSelector;
  final int initialCapacity;
  
  public OperatorBufferWithSingleObservable(Observable<? extends TClosing> paramObservable, int paramInt)
  {
    bufferClosingSelector = new OperatorBufferWithSingleObservable.1(this, paramObservable);
    initialCapacity = paramInt;
  }
  
  public OperatorBufferWithSingleObservable(Func0<? extends Observable<? extends TClosing>> paramFunc0, int paramInt)
  {
    bufferClosingSelector = paramFunc0;
    initialCapacity = paramInt;
  }
  
  public Subscriber<? super T> call(Subscriber<? super List<T>> paramSubscriber)
  {
    try
    {
      Observable localObservable = (Observable)bufferClosingSelector.call();
      OperatorBufferWithSingleObservable.BufferingSubscriber localBufferingSubscriber = new OperatorBufferWithSingleObservable.BufferingSubscriber(this, new SerializedSubscriber(paramSubscriber));
      OperatorBufferWithSingleObservable.2 local2 = new OperatorBufferWithSingleObservable.2(this, localBufferingSubscriber);
      paramSubscriber.add(local2);
      paramSubscriber.add(localBufferingSubscriber);
      localObservable.unsafeSubscribe(local2);
      return localBufferingSubscriber;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, paramSubscriber);
    }
    return Subscribers.empty();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSingleObservable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */