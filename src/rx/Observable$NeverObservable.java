package rx;

class Observable$NeverObservable<T>
  extends Observable<T>
{
  Observable$NeverObservable()
  {
    super(new Observable.NeverObservable.1());
  }
  
  static <T> NeverObservable<T> instance()
  {
    return Observable.NeverObservable.Holder.INSTANCE;
  }
}

/* Location:
 * Qualified Name:     rx.Observable.NeverObservable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */