package rx;

import rx.internal.producers.SingleProducer;

class Observable$7
  implements Observable.OnSubscribe<T>
{
  Observable$7(Observable paramObservable, Object paramObject) {}
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    paramSubscriber.setProducer(new SingleProducer(paramSubscriber, val$defaultValue));
  }
}

/* Location:
 * Qualified Name:     rx.Observable.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */