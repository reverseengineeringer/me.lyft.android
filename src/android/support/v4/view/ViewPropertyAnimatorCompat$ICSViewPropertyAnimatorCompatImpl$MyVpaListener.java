package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;

class ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener
  implements ViewPropertyAnimatorListener
{
  boolean mAnimEndCalled;
  ViewPropertyAnimatorCompat mVpa;
  
  ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
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

/* Location:
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl.MyVpaListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */