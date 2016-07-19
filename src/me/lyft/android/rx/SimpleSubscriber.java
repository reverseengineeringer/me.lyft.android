package me.lyft.android.rx;

import rx.Subscriber;

public class SimpleSubscriber<T>
  extends Subscriber<T>
{
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable) {}
  
  public void onNext(T paramT) {}
}

/* Location:
 * Qualified Name:     me.lyft.android.rx.SimpleSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */