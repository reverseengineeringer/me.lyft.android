package rx.internal.operators;

import java.util.List;
import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;
import rx.observers.SerializedSubscriber;

public final class OperatorBufferWithStartEndObservable<T, TOpening, TClosing>
  implements Observable.Operator<List<T>, T>
{
  final Func1<? super TOpening, ? extends Observable<? extends TClosing>> bufferClosing;
  final Observable<? extends TOpening> bufferOpening;
  
  public OperatorBufferWithStartEndObservable(Observable<? extends TOpening> paramObservable, Func1<? super TOpening, ? extends Observable<? extends TClosing>> paramFunc1)
  {
    bufferOpening = paramObservable;
    bufferClosing = paramFunc1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super List<T>> paramSubscriber)
  {
    OperatorBufferWithStartEndObservable.BufferingSubscriber localBufferingSubscriber = new OperatorBufferWithStartEndObservable.BufferingSubscriber(this, new SerializedSubscriber(paramSubscriber));
    OperatorBufferWithStartEndObservable.1 local1 = new OperatorBufferWithStartEndObservable.1(this, localBufferingSubscriber);
    paramSubscriber.add(local1);
    paramSubscriber.add(localBufferingSubscriber);
    bufferOpening.unsafeSubscribe(local1);
    return localBufferingSubscriber;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorBufferWithStartEndObservable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */