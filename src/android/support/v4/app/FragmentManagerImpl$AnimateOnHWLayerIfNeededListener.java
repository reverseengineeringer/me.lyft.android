package android.support.v4.app;

import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class FragmentManagerImpl$AnimateOnHWLayerIfNeededListener
  implements Animation.AnimationListener
{
  private Animation.AnimationListener mOrignalListener = null;
  private boolean mShouldRunOnHWLayer = false;
  private View mView = null;
  
  public FragmentManagerImpl$AnimateOnHWLayerIfNeededListener(View paramView, Animation paramAnimation)
  {
    if ((paramView == null) || (paramAnimation == null)) {
      return;
    }
    mView = paramView;
  }
  
  public FragmentManagerImpl$AnimateOnHWLayerIfNeededListener(View paramView, Animation paramAnimation, Animation.AnimationListener paramAnimationListener)
  {
    if ((paramView == null) || (paramAnimation == null)) {
      return;
    }
    mOrignalListener = paramAnimationListener;
    mView = paramView;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((mView != null) && (mShouldRunOnHWLayer)) {
      mView.post(new Runnable()
      {
        public void run()
        {
          ViewCompat.setLayerType(mView, 0, null);
        }
      });
    }
    if (mOrignalListener != null) {
      mOrignalListener.onAnimationEnd(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (mOrignalListener != null) {
      mOrignalListener.onAnimationRepeat(paramAnimation);
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (mView != null)
    {
      mShouldRunOnHWLayer = FragmentManagerImpl.shouldRunOnHWLayer(mView, paramAnimation);
      if (mShouldRunOnHWLayer) {
        mView.post(new Runnable()
        {
          public void run()
          {
            ViewCompat.setLayerType(mView, 2, null);
          }
        });
      }
    }
    if (mOrignalListener != null) {
      mOrignalListener.onAnimationStart(paramAnimation);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl.AnimateOnHWLayerIfNeededListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */