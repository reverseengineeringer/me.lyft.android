package me.lyft.android.rx;

import java.util.concurrent.atomic.AtomicBoolean;
import me.lyft.android.common.Strings;
import me.lyft.android.logging.L;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

public class RxBinder
  implements IRxBinder
{
  final AtomicBoolean attached = new AtomicBoolean(false);
  final CompositeSubscription compositeSubscription = new CompositeSubscription();
  
  private void logIllegalAttachedState()
  {
    IllegalStateException localIllegalStateException = new IllegalStateException("Cannot bind with detached binder");
    Object localObject = localIllegalStateException.getStackTrace();
    if (localObject.length > 2) {
      localObject = localObject[2];
    }
    for (localObject = Strings.formatString("Class:%s Method:%s Line:%d", new Object[] { ((StackTraceElement)localObject).getClassName(), ((StackTraceElement)localObject).getMethodName(), Integer.valueOf(((StackTraceElement)localObject).getLineNumber()) });; localObject = "Unknown stacktrace")
    {
      L.e(localIllegalStateException, (String)localObject, new Object[0]);
      return;
    }
  }
  
  public void attach()
  {
    attached.set(true);
  }
  
  public <T> Subscription bindAction(Observable<T> paramObservable, Action1<T> paramAction1)
  {
    if (!attached.get())
    {
      logIllegalAttachedState();
      return Subscriptions.unsubscribed();
    }
    paramObservable = paramObservable.subscribe(paramAction1);
    compositeSubscription.add(paramObservable);
    return paramObservable;
  }
  
  public <T> Subscription bindAsyncCall(Observable<T> paramObservable, AsyncCall<T> paramAsyncCall)
  {
    if (!attached.get())
    {
      logIllegalAttachedState();
      return Subscriptions.unsubscribed();
    }
    paramObservable = paramObservable.subscribe(paramAsyncCall);
    compositeSubscription.add(paramObservable);
    return paramObservable;
  }
  
  public void detach()
  {
    compositeSubscription.clear();
    attached.set(false);
  }
  
  public boolean isAttached()
  {
    return attached.get();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.rx.RxBinder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */