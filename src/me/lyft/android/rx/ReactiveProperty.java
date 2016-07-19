package me.lyft.android.rx;

import me.lyft.android.common.Objects;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;

@Deprecated
public final class ReactiveProperty<T>
  extends Subject<T, T>
{
  private static final EqualityComparator ALLOW_DUPLICATES_COMPARATOR = new EqualityComparator()
  {
    public boolean equals(Object paramAnonymousObject1, Object paramAnonymousObject2)
    {
      return false;
    }
  };
  private static final EqualityComparator DEFAULT_EQUALITY_COMPARATOR = new EqualityComparator()
  {
    public boolean equals(Object paramAnonymousObject1, Object paramAnonymousObject2)
    {
      return Objects.equals(paramAnonymousObject1, paramAnonymousObject2);
    }
  };
  private EqualityComparator<T> equalityComparator;
  private Subject<T, T> subject;
  private T value;
  
  public ReactiveProperty(Observable.OnSubscribe<T> paramOnSubscribe, Subject<T, T> paramSubject, T paramT)
  {
    super(paramOnSubscribe);
    subject = paramSubject;
    value = paramT;
  }
  
  public static <T> ReactiveProperty<T> create()
  {
    BehaviorSubject localBehaviorSubject = BehaviorSubject.create();
    new ReactiveProperty(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super T> paramAnonymousSubscriber)
      {
        val$subject.subscribe(paramAnonymousSubscriber);
      }
    }, localBehaviorSubject, null);
  }
  
  public static <T> ReactiveProperty<T> create(T paramT)
  {
    BehaviorSubject localBehaviorSubject = BehaviorSubject.create(paramT);
    new ReactiveProperty(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super T> paramAnonymousSubscriber)
      {
        val$subject.subscribe(paramAnonymousSubscriber);
      }
    }, localBehaviorSubject, paramT);
  }
  
  private EqualityComparator<T> getEqualityComparator()
  {
    return (EqualityComparator)Objects.firstNonNull(equalityComparator, DEFAULT_EQUALITY_COMPARATOR);
  }
  
  public ReactiveProperty<T> allowDuplicates()
  {
    equalityComparator = ALLOW_DUPLICATES_COMPARATOR;
    return this;
  }
  
  public T get()
  {
    return (T)value;
  }
  
  public boolean hasObservers()
  {
    return subject.hasObservers();
  }
  
  public void onCompleted()
  {
    subject.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    subject.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (!getEqualityComparator().equals(value, paramT))
    {
      value = paramT;
      subject.onNext(paramT);
    }
  }
  
  public ReactiveProperty<T> setEqualityComparator(EqualityComparator<T> paramEqualityComparator)
  {
    equalityComparator = paramEqualityComparator;
    return this;
  }
  
  public static abstract interface EqualityComparator<T>
  {
    public abstract boolean equals(T paramT1, T paramT2);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.rx.ReactiveProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */