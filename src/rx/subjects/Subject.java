package rx.subjects;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;

public abstract class Subject<T, R>
  extends Observable<R>
  implements Observer<T>
{
  protected Subject(Observable.OnSubscribe<R> paramOnSubscribe)
  {
    super(paramOnSubscribe);
  }
  
  public abstract boolean hasObservers();
  
  public final SerializedSubject<T, R> toSerialized()
  {
    if (getClass() == SerializedSubject.class) {
      return (SerializedSubject)this;
    }
    return new SerializedSubject(this);
  }
}

/* Location:
 * Qualified Name:     rx.subjects.Subject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */