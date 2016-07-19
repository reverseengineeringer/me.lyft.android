package rx.subjects;

import rx.observers.SerializedObserver;

public class SerializedSubject<T, R>
  extends Subject<T, R>
{
  private final Subject<T, R> actual;
  private final SerializedObserver<T> observer;
  
  public SerializedSubject(Subject<T, R> paramSubject)
  {
    super(new SerializedSubject.1(paramSubject));
    actual = paramSubject;
    observer = new SerializedObserver(paramSubject);
  }
  
  public boolean hasObservers()
  {
    return actual.hasObservers();
  }
  
  public void onCompleted()
  {
    observer.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    observer.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    observer.onNext(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.subjects.SerializedSubject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */