package com.lyft.rx;

import rx.Observable;
import rx.subjects.PublishSubject;

public class PublishSubjectEvent<T>
  implements BusEvent<T>
{
  PublishSubject<T> subject = PublishSubject.create();
  
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
 * Qualified Name:     com.lyft.rx.PublishSubjectEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */