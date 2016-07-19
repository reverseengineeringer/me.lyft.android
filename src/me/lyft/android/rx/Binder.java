package me.lyft.android.rx;

import android.util.Log;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

@Deprecated
public class Binder
{
  private final String TAG = Binder.class.getSimpleName();
  private boolean detached;
  private View.OnAttachStateChangeListener onAttachStateChangeListener = new View.OnAttachStateChangeListener()
  {
    public void onViewAttachedToWindow(View paramAnonymousView) {}
    
    public void onViewDetachedFromWindow(View paramAnonymousView)
    {
      detach();
      paramAnonymousView.removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }
  };
  final CompositeSubscription subscriptions = new CompositeSubscription();
  
  @Deprecated
  public Binder()
  {
    detached = false;
  }
  
  private Binder(View paramView)
  {
    paramView.addOnAttachStateChangeListener(onAttachStateChangeListener);
  }
  
  @Deprecated
  public static Binder attach(View paramView)
  {
    if (paramView.getParent() == null) {
      throw new IllegalStateException("You should attach inside view onAttachedToWindow");
    }
    return new Binder(paramView);
  }
  
  public <T> Subscription bind(Observable<T> paramObservable, Observer<T> paramObserver)
  {
    if (subscriptions.isUnsubscribed()) {
      Log.e(TAG, "Cannot bind with detached binder");
    }
    paramObservable = paramObservable.observeOn(MainThreadScheduler.mainThread()).subscribe(paramObserver);
    subscriptions.add(paramObservable);
    return paramObservable;
  }
  
  public <T> Subscription bind(Observable<T> paramObservable, Action1<T> paramAction1)
  {
    if (detached) {
      Log.e(TAG, "Cannot bind with detached binder");
    }
    paramObservable = paramObservable.observeOn(MainThreadScheduler.mainThread()).subscribe(paramAction1);
    subscriptions.add(paramObservable);
    return paramObservable;
  }
  
  public void detach()
  {
    detached = true;
    subscriptions.clear();
  }
  
  public void remove(Subscription paramSubscription)
  {
    subscriptions.remove(paramSubscription);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.rx.Binder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */