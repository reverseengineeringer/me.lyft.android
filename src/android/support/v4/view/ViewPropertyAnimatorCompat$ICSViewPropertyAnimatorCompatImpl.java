package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

class ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl
  extends ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl
{
  WeakHashMap<View, Integer> mLayerMap = null;
  
  public void alpha(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, float paramFloat)
  {
    ViewPropertyAnimatorCompatICS.alpha(paramView, paramFloat);
  }
  
  public void cancel(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
  {
    ViewPropertyAnimatorCompatICS.cancel(paramView);
  }
  
  public void setDuration(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, long paramLong)
  {
    ViewPropertyAnimatorCompatICS.setDuration(paramView, paramLong);
  }
  
  public void setInterpolator(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, Interpolator paramInterpolator)
  {
    ViewPropertyAnimatorCompatICS.setInterpolator(paramView, paramInterpolator);
  }
  
  public void setListener(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    paramView.setTag(2113929216, paramViewPropertyAnimatorListener);
    ViewPropertyAnimatorCompatICS.setListener(paramView, new MyVpaListener(paramViewPropertyAnimatorCompat));
  }
  
  public void setStartDelay(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, long paramLong)
  {
    ViewPropertyAnimatorCompatICS.setStartDelay(paramView, paramLong);
  }
  
  public void start(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
  {
    ViewPropertyAnimatorCompatICS.start(paramView);
  }
  
  public void translationX(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, float paramFloat)
  {
    ViewPropertyAnimatorCompatICS.translationX(paramView, paramFloat);
  }
  
  public void translationY(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, float paramFloat)
  {
    ViewPropertyAnimatorCompatICS.translationY(paramView, paramFloat);
  }
  
  static class MyVpaListener
    implements ViewPropertyAnimatorListener
  {
    boolean mAnimEndCalled;
    ViewPropertyAnimatorCompat mVpa;
    
    MyVpaListener(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
    {
      mVpa = paramViewPropertyAnimatorCompat;
    }
    
    public void onAnimationCancel(View paramView)
    {
      Object localObject = paramView.getTag(2113929216);
      ViewPropertyAnimatorListener localViewPropertyAnimatorListener = null;
      if ((localObject instanceof ViewPropertyAnimatorListener)) {
        localViewPropertyAnimatorListener = (ViewPropertyAnimatorListener)localObject;
      }
      if (localViewPropertyAnimatorListener != null) {
        localViewPropertyAnimatorListener.onAnimationCancel(paramView);
      }
    }
    
    public void onAnimationEnd(View paramView)
    {
      if (ViewPropertyAnimatorCompat.access$400(mVpa) >= 0)
      {
        ViewCompat.setLayerType(paramView, ViewPropertyAnimatorCompat.access$400(mVpa), null);
        ViewPropertyAnimatorCompat.access$402(mVpa, -1);
      }
      if ((Build.VERSION.SDK_INT >= 16) || (!mAnimEndCalled))
      {
        if (ViewPropertyAnimatorCompat.access$000(mVpa) != null)
        {
          localObject1 = ViewPropertyAnimatorCompat.access$000(mVpa);
          ViewPropertyAnimatorCompat.access$002(mVpa, null);
          ((Runnable)localObject1).run();
        }
        Object localObject2 = paramView.getTag(2113929216);
        Object localObject1 = null;
        if ((localObject2 instanceof ViewPropertyAnimatorListener)) {
          localObject1 = (ViewPropertyAnimatorListener)localObject2;
        }
        if (localObject1 != null) {
          ((ViewPropertyAnimatorListener)localObject1).onAnimationEnd(paramView);
        }
        mAnimEndCalled = true;
      }
    }
    
    public void onAnimationStart(View paramView)
    {
      mAnimEndCalled = false;
      if (ViewPropertyAnimatorCompat.access$400(mVpa) >= 0) {
        ViewCompat.setLayerType(paramView, 2, null);
      }
      if (ViewPropertyAnimatorCompat.access$100(mVpa) != null)
      {
        localObject1 = ViewPropertyAnimatorCompat.access$100(mVpa);
        ViewPropertyAnimatorCompat.access$102(mVpa, null);
        ((Runnable)localObject1).run();
      }
      Object localObject2 = paramView.getTag(2113929216);
      Object localObject1 = null;
      if ((localObject2 instanceof ViewPropertyAnimatorListener)) {
        localObject1 = (ViewPropertyAnimatorListener)localObject2;
      }
      if (localObject1 != null) {
        ((ViewPropertyAnimatorListener)localObject1).onAnimationStart(paramView);
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */