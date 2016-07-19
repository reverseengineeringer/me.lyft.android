package rx;

class Observable$ThrowObservable<T>
  extends Observable<T>
{
  public Observable$ThrowObservable(Throwable paramThrowable)
  {
    super(new Observable.ThrowObservable.1(paramThrowable));
  }
}

/* Location:
 * Qualified Name:     rx.Observable.ThrowObservable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */