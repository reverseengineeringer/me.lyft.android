package rx;

class Observable$1
  implements Observable.OnSubscribe<T>
{
  Observable$1(Observable paramObservable) {}
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    paramSubscriber.add(Observable.access$000(paramSubscriber, this$0));
  }
}

/* Location:
 * Qualified Name:     rx.Observable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */