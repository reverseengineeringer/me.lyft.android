package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

class ScrollerCompat$ScrollerCompatImplBase
  implements ScrollerCompat.ScrollerCompatImpl
{
  public void abortAnimation(Object paramObject)
  {
    ((Scroller)paramObject).abortAnimation();
  }
  
  public boolean computeScrollOffset(Object paramObject)
  {
    return ((Scroller)paramObject).computeScrollOffset();
  }
  
  public Object createScroller(Context paramContext, Interpolator paramInterpolator)
  {
    if (paramInterpolator != null) {
      return new Scroller(paramContext, paramInterpolator);
    }
    return new Scroller(paramContext);
  }
  
  public void fling(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    ((Scroller)paramObject).fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public float getCurrVelocity(Object paramObject)
  {
    return 0.0F;
  }
  
  public int getCurrX(Object paramObject)
  {
    return ((Scroller)paramObject).getCurrX();
  }
  
  public int getCurrY(Object paramObject)
  {
    return ((Scroller)paramObject).getCurrY();
  }
  
  public int getFinalX(Object paramObject)
  {
    return ((Scroller)paramObject).getFinalX();
  }
  
  public int getFinalY(Object paramObject)
  {
    return ((Scroller)paramObject).getFinalY();
  }
  
  public boolean isFinished(Object paramObject)
  {
    return ((Scroller)paramObject).isFinished();
  }
  
  public void startScroll(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ((Scroller)paramObject).startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.ScrollerCompat.ScrollerCompatImplBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */