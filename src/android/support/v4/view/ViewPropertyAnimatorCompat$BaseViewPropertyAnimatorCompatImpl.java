package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

class ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl
  implements ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
{
  WeakHashMap<View, Runnable> mStarterMap = null;
  
  private void postStartMessage(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
  {
    Runnable localRunnable = null;
    if (mStarterMap != null) {
      localRunnable = (Runnable)mStarterMap.get(paramView);
    }
    Object localObject = localRunnable;
    if (localRunnable == null)
    {
      localObject = new Starter(paramViewPropertyAnimatorCompat, paramView, null);
      if (mStarterMap == null) {
        mStarterMap = new WeakHashMap();
      }
      mStarterMap.put(paramView, localObject);
    }
    paramView.removeCallbacks((Runnable)localObject);
    paramView.post((Runnable)localObject);
  }
  
  private void removeStartMessage(View paramView)
  {
    if (mStarterMap != null)
    {
      Runnable localRunnable = (Runnable)mStarterMap.get(paramView);
      if (localRunnable != null) {
        paramView.removeCallbacks(localRunnable);
      }
    }
  }
  
  private void startAnimation(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
  {
    Object localObject = paramView.getTag(2113929216);
    ViewPropertyAnimatorListener localViewPropertyAnimatorListener = null;
    if ((localObject instanceof ViewPropertyAnimatorListener)) {
      localViewPropertyAnimatorListener = (ViewPropertyAnimatorListener)localObject;
    }
    localObject = ViewPropertyAnimatorCompat.access$100(paramViewPropertyAnimatorCompat);
    Runnable localRunnable = ViewPropertyAnimatorCompat.access$000(paramViewPropertyAnimatorCompat);
    ViewPropertyAnimatorCompat.access$102(paramViewPropertyAnimatorCompat, null);
    ViewPropertyAnimatorCompat.access$002(paramViewPropertyAnimatorCompat, null);
    if (localObject != null) {
      ((Runnable)localObject).run();
    }
    if (localViewPropertyAnimatorListener != null)
    {
      localViewPropertyAnimatorListener.onAnimationStart(paramView);
      localViewPropertyAnimatorListener.onAnimationEnd(paramView);
    }
    if (localRunnable != null) {
      localRunnable.run();
    }
    if (mStarterMap != null) {
      mStarterMap.remove(paramView);
    }
  }
  
  public void alpha(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, float paramFloat)
  {
    postStartMessage(paramViewPropertyAnimatorCompat, paramView);
  }
  
  public void cancel(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
  {
    postStartMessage(paramViewPropertyAnimatorCompat, paramView);
  }
  
  public void setDuration(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, long paramLong) {}
  
  public void setInterpolator(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, Interpolator paramInterpolator) {}
  
  public void setListener(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    paramView.setTag(2113929216, paramViewPropertyAnimatorListener);
  }
  
  public void setStartDelay(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, long paramLong) {}
  
  public void start(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
  {
    removeStartMessage(paramView);
    startAnimation(paramViewPropertyAnimatorCompat, paramView);
  }
  
  public void translationX(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, float paramFloat)
  {
    postStartMessage(paramViewPropertyAnimatorCompat, paramView);
  }
  
  public void translationY(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, float paramFloat)
  {
    postStartMessage(paramViewPropertyAnimatorCompat, paramView);
  }
  
  class Starter
    implements Runnable
  {
    WeakReference<View> mViewRef;
    ViewPropertyAnimatorCompat mVpa;
    
    private Starter(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
    {
      mViewRef = new WeakReference(paramView);
      mVpa = paramViewPropertyAnimatorCompat;
    }
    
    public void run()
    {
      View localView = (View)mViewRef.get();
      if (localView != null) {
        ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl.this.startAnimation(mVpa, localView);
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */