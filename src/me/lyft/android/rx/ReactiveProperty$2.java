package me.lyft.android.rx;

import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.subjects.BehaviorSubject;

final class ReactiveProperty$2
  implements Observable.OnSubscribe<T>
{
  ReactiveProperty$2(BehaviorSubject paramBehaviorSubject) {}
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    val$subject.subscribe(paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.rx.ReactiveProperty.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */