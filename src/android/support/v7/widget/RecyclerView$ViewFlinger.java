package android.support.v7.widget;

import android.support.v4.os.TraceCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ScrollerCompat;
import android.view.animation.Interpolator;
import java.util.ArrayList;

class RecyclerView$ViewFlinger
  implements Runnable
{
  private boolean mEatRunOnAnimationRequest = false;
  private Interpolator mInterpolator = RecyclerView.access$3000();
  private int mLastFlingX;
  private int mLastFlingY;
  private boolean mReSchedulePostAnimationCallback = false;
  private ScrollerCompat mScroller;
  
  public RecyclerView$ViewFlinger(RecyclerView paramRecyclerView)
  {
    mScroller = ScrollerCompat.create(paramRecyclerView.getContext(), RecyclerView.access$3000());
  }
  
  private int computeScrollDuration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = Math.abs(paramInt1);
    int k = Math.abs(paramInt2);
    int i;
    if (j > k)
    {
      i = 1;
      paramInt3 = (int)Math.sqrt(paramInt3 * paramInt3 + paramInt4 * paramInt4);
      paramInt2 = (int)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
      if (i == 0) {
        break label140;
      }
    }
    label140:
    for (paramInt1 = this$0.getWidth();; paramInt1 = this$0.getHeight())
    {
      paramInt4 = paramInt1 / 2;
      float f3 = Math.min(1.0F, 1.0F * paramInt2 / paramInt1);
      float f1 = paramInt4;
      float f2 = paramInt4;
      f3 = distanceInfluenceForSnapDuration(f3);
      if (paramInt3 <= 0) {
        break label151;
      }
      paramInt1 = Math.round(1000.0F * Math.abs((f1 + f2 * f3) / paramInt3)) * 4;
      return Math.min(paramInt1, 2000);
      i = 0;
      break;
    }
    label151:
    if (i != 0) {}
    for (paramInt2 = j;; paramInt2 = k)
    {
      paramInt1 = (int)((paramInt2 / paramInt1 + 1.0F) * 300.0F);
      break;
    }
  }
  
  private void disableRunOnAnimationRequests()
  {
    mReSchedulePostAnimationCallback = false;
    mEatRunOnAnimationRequest = true;
  }
  
  private float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.4712389167638204D));
  }
  
  private void enableRunOnAnimationRequests()
  {
    mEatRunOnAnimationRequest = false;
    if (mReSchedulePostAnimationCallback) {
      postOnAnimation();
    }
  }
  
  public void fling(int paramInt1, int paramInt2)
  {
    RecyclerView.access$3900(this$0, 2);
    mLastFlingY = 0;
    mLastFlingX = 0;
    mScroller.fling(0, 0, paramInt1, paramInt2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
    postOnAnimation();
  }
  
  void postOnAnimation()
  {
    if (mEatRunOnAnimationRequest)
    {
      mReSchedulePostAnimationCallback = true;
      return;
    }
    this$0.removeCallbacks(this);
    ViewCompat.postOnAnimation(this$0, this);
  }
  
  public void run()
  {
    if (this$0.mLayout == null)
    {
      stop();
      return;
    }
    disableRunOnAnimationRequests();
    RecyclerView.access$400(this$0);
    ScrollerCompat localScrollerCompat = mScroller;
    RecyclerView.SmoothScroller localSmoothScroller = this$0.mLayout.mSmoothScroller;
    int i4;
    int i5;
    int n;
    int i;
    int i3;
    int m;
    int i1;
    int j;
    int i2;
    int k;
    if (localScrollerCompat.computeScrollOffset())
    {
      int i6 = localScrollerCompat.getCurrX();
      int i7 = localScrollerCompat.getCurrY();
      i4 = i6 - mLastFlingX;
      i5 = i7 - mLastFlingY;
      n = 0;
      i = 0;
      i3 = 0;
      m = 0;
      mLastFlingX = i6;
      mLastFlingY = i7;
      i1 = 0;
      j = 0;
      i2 = 0;
      k = 0;
      if (RecyclerView.access$3100(this$0) != null)
      {
        this$0.eatRequestLayout();
        RecyclerView.access$3200(this$0);
        TraceCompat.beginSection("RV Scroll");
        if (i4 != 0)
        {
          i = this$0.mLayout.scrollHorizontallyBy(i4, this$0.mRecycler, this$0.mState);
          j = i4 - i;
        }
        if (i5 != 0)
        {
          m = this$0.mLayout.scrollVerticallyBy(i5, this$0.mRecycler, this$0.mState);
          k = i5 - m;
        }
        TraceCompat.endSection();
        RecyclerView.access$3300(this$0);
        RecyclerView.access$3400(this$0);
        this$0.resumeRequestLayout(false);
        n = i;
        i1 = j;
        i2 = k;
        i3 = m;
        if (localSmoothScroller != null)
        {
          n = i;
          i1 = j;
          i2 = k;
          i3 = m;
          if (!localSmoothScroller.isPendingInitialRun())
          {
            n = i;
            i1 = j;
            i2 = k;
            i3 = m;
            if (localSmoothScroller.isRunning())
            {
              n = this$0.mState.getItemCount();
              if (n != 0) {
                break label667;
              }
              localSmoothScroller.stop();
              i3 = m;
              i2 = k;
              i1 = j;
              n = i;
            }
          }
        }
      }
      if (!RecyclerView.access$3600(this$0).isEmpty()) {
        this$0.invalidate();
      }
      if (ViewCompat.getOverScrollMode(this$0) != 2) {
        RecyclerView.access$3700(this$0, i4, i5);
      }
      if ((i1 != 0) || (i2 != 0))
      {
        k = (int)localScrollerCompat.getCurrVelocity();
        i = 0;
        if (i1 != i6)
        {
          if (i1 >= 0) {
            break label744;
          }
          i = -k;
        }
        label418:
        j = 0;
        if (i2 != i7)
        {
          if (i2 >= 0) {
            break label759;
          }
          j = -k;
        }
        label435:
        if (ViewCompat.getOverScrollMode(this$0) != 2) {
          this$0.absorbGlows(i, j);
        }
        if (((i != 0) || (i1 == i6) || (localScrollerCompat.getFinalX() == 0)) && ((j != 0) || (i2 == i7) || (localScrollerCompat.getFinalY() == 0))) {
          localScrollerCompat.abortAnimation();
        }
      }
      if ((n != 0) || (i3 != 0)) {
        this$0.dispatchOnScrolled(n, i3);
      }
      if (!RecyclerView.access$3800(this$0)) {
        this$0.invalidate();
      }
      if ((i5 == 0) || (!this$0.mLayout.canScrollVertically()) || (i3 != i5)) {
        break label774;
      }
      i = 1;
      label563:
      if ((i4 == 0) || (!this$0.mLayout.canScrollHorizontally()) || (n != i4)) {
        break label779;
      }
      j = 1;
      label590:
      if (((i4 != 0) || (i5 != 0)) && (j == 0) && (i == 0)) {
        break label784;
      }
      i = 1;
      label610:
      if ((!localScrollerCompat.isFinished()) && (i != 0)) {
        break label789;
      }
      RecyclerView.access$3900(this$0, 0);
    }
    for (;;)
    {
      if (localSmoothScroller != null)
      {
        if (localSmoothScroller.isPendingInitialRun()) {
          RecyclerView.SmoothScroller.access$3500(localSmoothScroller, 0, 0);
        }
        if (!mReSchedulePostAnimationCallback) {
          localSmoothScroller.stop();
        }
      }
      enableRunOnAnimationRequests();
      return;
      label667:
      if (localSmoothScroller.getTargetPosition() >= n)
      {
        localSmoothScroller.setTargetPosition(n - 1);
        RecyclerView.SmoothScroller.access$3500(localSmoothScroller, i4 - j, i5 - k);
        n = i;
        i1 = j;
        i2 = k;
        i3 = m;
        break;
      }
      RecyclerView.SmoothScroller.access$3500(localSmoothScroller, i4 - j, i5 - k);
      n = i;
      i1 = j;
      i2 = k;
      i3 = m;
      break;
      label744:
      if (i1 > 0)
      {
        i = k;
        break label418;
      }
      i = 0;
      break label418;
      label759:
      if (i2 > 0)
      {
        j = k;
        break label435;
      }
      j = 0;
      break label435;
      label774:
      i = 0;
      break label563;
      label779:
      j = 0;
      break label590;
      label784:
      i = 0;
      break label610;
      label789:
      postOnAnimation();
    }
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2)
  {
    smoothScrollBy(paramInt1, paramInt2, 0, 0);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3)
  {
    smoothScrollBy(paramInt1, paramInt2, paramInt3, RecyclerView.access$3000());
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    smoothScrollBy(paramInt1, paramInt2, computeScrollDuration(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    if (mInterpolator != paramInterpolator)
    {
      mInterpolator = paramInterpolator;
      mScroller = ScrollerCompat.create(this$0.getContext(), paramInterpolator);
    }
    RecyclerView.access$3900(this$0, 2);
    mLastFlingY = 0;
    mLastFlingX = 0;
    mScroller.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
    postOnAnimation();
  }
  
  public void stop()
  {
    this$0.removeCallbacks(this);
    mScroller.abortAnimation();
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView.ViewFlinger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */