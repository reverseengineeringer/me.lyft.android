package com.lyft.rx;

import rx.Observable;
import rx.subjects.BehaviorSubject;

public class BehaviorSubjectEvent<T>
  implements BusEvent<T>
{
  BehaviorSubject<T> subject = BehaviorSubject.create();
  
  public Observable<T> observe()
  {
    return subject.asObservable();
  }
  
  public void post(T paramT)
  {
    subject.onNext(paramT);
  }
}

/* Location:
 * Qualified Name:     com.lyft.rx.BehaviorSubjectEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */