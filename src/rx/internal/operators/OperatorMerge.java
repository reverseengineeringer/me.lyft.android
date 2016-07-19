package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorMerge<T>
  implements Observable.Operator<T, Observable<? extends T>>
{
  final boolean delayErrors;
  final int maxConcurrent;
  
  private OperatorMerge(boolean paramBoolean, int paramInt)
  {
    delayErrors = paramBoolean;
    maxConcurrent = paramInt;
  }
  
  public static <T> OperatorMerge<T> instance(boolean paramBoolean)
  {
    if (paramBoolean) {
      return OperatorMerge.HolderDelayErrors.INSTANCE;
    }
    return OperatorMerge.HolderNoDelay.INSTANCE;
  }
  
  public static <T> OperatorMerge<T> instance(boolean paramBoolean, int paramInt)
  {
    if (paramInt == Integer.MAX_VALUE) {
      return instance(paramBoolean);
    }
    return new OperatorMerge(paramBoolean, paramInt);
  }
  
  public Subscriber<Observable<? extends T>> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorMerge.MergeSubscriber localMergeSubscriber = new OperatorMerge.MergeSubscriber(paramSubscriber, delayErrors, maxConcurrent);
    OperatorMerge.MergeProducer localMergeProducer = new OperatorMerge.MergeProducer(localMergeSubscriber);
    producer = localMergeProducer;
    paramSubscriber.add(localMergeSubscriber);
    paramSubscriber.setProducer(localMergeProducer);
    return localMergeSubscriber;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorMerge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */