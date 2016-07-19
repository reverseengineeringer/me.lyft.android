package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public final class ScrollerCompat
{
  ScrollerCompatImpl mImpl;
  Object mScroller;
  
  private ScrollerCompat(int paramInt, Context paramContext, Interpolator paramInterpolator)
  {
    if (paramInt >= 14) {
      mImpl = new ScrollerCompatImplIcs();
    }
    for (;;)
    {
      mScroller = mImpl.createScroller(paramContext, paramInterpolator);
      return;
      if (paramInt >= 9) {
        mImpl = new ScrollerCompatImplGingerbread();
      } else {
        mImpl = new ScrollerCompatImplBase();
      }
    }
  }
  
  public static ScrollerCompat create(Context paramContext, Interpolator paramInterpolator)
  {
    return new ScrollerCompat(Build.VERSION.SDK_INT, paramContext, paramInterpolator);
  }
  
  public void abortAnimation()
  {
    mImpl.abortAnimation(mScroller);
  }
  
  public boolean computeScrollOffset()
  {
    return mImpl.computeScrollOffset(mScroller);
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    mImpl.fling(mScroller, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public float getCurrVelocity()
  {
    return mImpl.getCurrVelocity(mScroller);
  }
  
  public int getCurrX()
  {
    return mImpl.getCurrX(mScroller);
  }
  
  public int getCurrY()
  {
    return mImpl.getCurrY(mScroller);
  }
  
  public int getFinalX()
  {
    return mImpl.getFinalX(mScroller);
  }
  
  public int getFinalY()
  {
    return mImpl.getFinalY(mScroller);
  }
  
  public boolean isFinished()
  {
    return mImpl.isFinished(mScroller);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    mImpl.startScroll(mScroller, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  static abstract interface ScrollerCompatImpl
  {
    public abstract void abortAnimation(Object paramObject);
    
    public abstract boolean computeScrollOffset(Object paramObject);
    
    public abstract Object createScroller(Context paramContext, Interpolator paramInterpolator);
    
    public abstract void fling(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
    
    public abstract float getCurrVelocity(Object paramObject);
    
    public abstract int getCurrX(Object paramObject);
    
    public abstract int getCurrY(Object paramObject);
    
    public abstract int getFinalX(Object paramObject);
    
    public abstract int getFinalY(Object paramObject);
    
    public abstract boolean isFinished(Object paramObject);
    
    public abstract void startScroll(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  }
  
  static class ScrollerCompatImplBase
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
  
  static class ScrollerCompatImplGingerbread
    implements ScrollerCompat.ScrollerCompatImpl
  {
    public void abortAnimation(Object paramObject)
    {
      ScrollerCompatGingerbread.abortAnimation(paramObject);
    }
    
    public boolean computeScrollOffset(Object paramObject)
    {
      return ScrollerCompatGingerbread.computeScrollOffset(paramObject);
    }
    
    public Object createScroller(Context paramContext, Interpolator paramInterpolator)
    {
      return ScrollerCompatGingerbread.createScroller(paramContext, paramInterpolator);
    }
    
    public void fling(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      ScrollerCompatGingerbread.fling(paramObject, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    }
    
    public float getCurrVelocity(Object paramObject)
    {
      return 0.0F;
    }
    
    public int getCurrX(Object paramObject)
    {
      return ScrollerCompatGingerbread.getCurrX(paramObject);
    }
    
    public int getCurrY(Object paramObject)
    {
      return ScrollerCompatGingerbread.getCurrY(paramObject);
    }
    
    public int getFinalX(Object paramObject)
    {
      return ScrollerCompatGingerbread.getFinalX(paramObject);
    }
    
    public int getFinalY(Object paramObject)
    {
      return ScrollerCompatGingerbread.getFinalY(paramObject);
    }
    
    public boolean isFinished(Object paramObject)
    {
      return ScrollerCompatGingerbread.isFinished(paramObject);
    }
    
    public void startScroll(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      ScrollerCompatGingerbread.startScroll(paramObject, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  static class ScrollerCompatImplIcs
    extends ScrollerCompat.ScrollerCompatImplGingerbread
  {
    public float getCurrVelocity(Object paramObject)
    {
      return ScrollerCompatIcs.getCurrVelocity(paramObject);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.ScrollerCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */