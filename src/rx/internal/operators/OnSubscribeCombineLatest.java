package rx.internal.operators;

import java.util.List;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.FuncN;
import rx.internal.util.RxRingBuffer;

public final class OnSubscribeCombineLatest<T, R>
  implements Observable.OnSubscribe<R>
{
  final FuncN<? extends R> combinator;
  final List<? extends Observable<? extends T>> sources;
  
  public OnSubscribeCombineLatest(List<? extends Observable<? extends T>> paramList, FuncN<? extends R> paramFuncN)
  {
    sources = paramList;
    combinator = paramFuncN;
    if (paramList.size() > RxRingBuffer.SIZE) {
      throw new IllegalArgumentException("More than RxRingBuffer.SIZE sources to combineLatest is not supported.");
    }
  }
  
  public void call(Subscriber<? super R> paramSubscriber)
  {
    if (sources.isEmpty())
    {
      paramSubscriber.onCompleted();
      return;
    }
    if (sources.size() == 1)
    {
      paramSubscriber.setProducer(new OnSubscribeCombineLatest.SingleSourceProducer(paramSubscriber, (Observable)sources.get(0), combinator));
      return;
    }
    paramSubscriber.setProducer(new OnSubscribeCombineLatest.MultiSourceProducer(paramSubscriber, sources, combinator));
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeCombineLatest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */