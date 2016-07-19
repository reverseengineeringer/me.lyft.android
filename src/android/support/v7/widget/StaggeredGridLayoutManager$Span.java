package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;

class StaggeredGridLayoutManager$Span
{
  int mCachedEnd = Integer.MIN_VALUE;
  int mCachedStart = Integer.MIN_VALUE;
  int mDeletedSize = 0;
  final int mIndex;
  private ArrayList<View> mViews = new ArrayList();
  
  private StaggeredGridLayoutManager$Span(StaggeredGridLayoutManager paramStaggeredGridLayoutManager, int paramInt)
  {
    mIndex = paramInt;
  }
  
  void appendToSpan(View paramView)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(paramView);
    mSpan = this;
    mViews.add(paramView);
    mCachedEnd = Integer.MIN_VALUE;
    if (mViews.size() == 1) {
      mCachedStart = Integer.MIN_VALUE;
    }
    if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
      mDeletedSize += this$0.mPrimaryOrientation.getDecoratedMeasurement(paramView);
    }
  }
  
  void cacheReferenceLineAndClear(boolean paramBoolean, int paramInt)
  {
    int i;
    if (paramBoolean)
    {
      i = getEndLine(Integer.MIN_VALUE);
      clear();
      if (i != Integer.MIN_VALUE) {
        break label32;
      }
    }
    label32:
    while (((paramBoolean) && (i < this$0.mPrimaryOrientation.getEndAfterPadding())) || ((!paramBoolean) && (i > this$0.mPrimaryOrientation.getStartAfterPadding())))
    {
      return;
      i = getStartLine(Integer.MIN_VALUE);
      break;
    }
    int j = i;
    if (paramInt != Integer.MIN_VALUE) {
      j = i + paramInt;
    }
    mCachedEnd = j;
    mCachedStart = j;
  }
  
  void calculateCachedEnd()
  {
    Object localObject = (View)mViews.get(mViews.size() - 1);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams((View)localObject);
    mCachedEnd = this$0.mPrimaryOrientation.getDecoratedEnd((View)localObject);
    if (mFullSpan)
    {
      localObject = this$0.mLazySpanLookup.getFullSpanItem(localLayoutParams.getViewLayoutPosition());
      if ((localObject != null) && (mGapDir == 1)) {
        mCachedEnd += ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).getGapForSpan(mIndex);
      }
    }
  }
  
  void calculateCachedStart()
  {
    Object localObject = (View)mViews.get(0);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams((View)localObject);
    mCachedStart = this$0.mPrimaryOrientation.getDecoratedStart((View)localObject);
    if (mFullSpan)
    {
      localObject = this$0.mLazySpanLookup.getFullSpanItem(localLayoutParams.getViewLayoutPosition());
      if ((localObject != null) && (mGapDir == -1)) {
        mCachedStart -= ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).getGapForSpan(mIndex);
      }
    }
  }
  
  void clear()
  {
    mViews.clear();
    invalidateCache();
    mDeletedSize = 0;
  }
  
  public int getDeletedSize()
  {
    return mDeletedSize;
  }
  
  int getEndLine()
  {
    if (mCachedEnd != Integer.MIN_VALUE) {
      return mCachedEnd;
    }
    calculateCachedEnd();
    return mCachedEnd;
  }
  
  int getEndLine(int paramInt)
  {
    if (mCachedEnd != Integer.MIN_VALUE) {
      paramInt = mCachedEnd;
    }
    while (mViews.size() == 0) {
      return paramInt;
    }
    calculateCachedEnd();
    return mCachedEnd;
  }
  
  public View getFocusableViewAfter(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    View localView;
    if (paramInt2 == -1)
    {
      i = mViews.size();
      paramInt2 = 0;
      localObject2 = localObject1;
      if (paramInt2 < i)
      {
        localView = (View)mViews.get(paramInt2);
        localObject2 = localObject1;
        if (localView.isFocusable())
        {
          if (this$0.getPosition(localView) > paramInt1) {}
          for (int k = 1;; k = 0)
          {
            localObject2 = localObject1;
            if (k != StaggeredGridLayoutManager.access$600(this$0)) {
              break label211;
            }
            localObject1 = localView;
            paramInt2 += 1;
            break;
          }
        }
      }
    }
    else
    {
      paramInt2 = mViews.size() - 1;
      localObject1 = localObject2;
      localObject2 = localObject1;
      if (paramInt2 >= 0)
      {
        localView = (View)mViews.get(paramInt2);
        localObject2 = localObject1;
        if (localView.isFocusable())
        {
          if (this$0.getPosition(localView) > paramInt1)
          {
            i = 1;
            label166:
            if (StaggeredGridLayoutManager.access$600(this$0)) {
              break label205;
            }
          }
          label205:
          for (int j = 1;; j = 0)
          {
            localObject2 = localObject1;
            if (i != j) {
              break label211;
            }
            localObject1 = localView;
            paramInt2 -= 1;
            break;
            i = 0;
            break label166;
          }
        }
      }
    }
    label211:
    return (View)localObject2;
  }
  
  StaggeredGridLayoutManager.LayoutParams getLayoutParams(View paramView)
  {
    return (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
  }
  
  int getStartLine()
  {
    if (mCachedStart != Integer.MIN_VALUE) {
      return mCachedStart;
    }
    calculateCachedStart();
    return mCachedStart;
  }
  
  int getStartLine(int paramInt)
  {
    if (mCachedStart != Integer.MIN_VALUE) {
      paramInt = mCachedStart;
    }
    while (mViews.size() == 0) {
      return paramInt;
    }
    calculateCachedStart();
    return mCachedStart;
  }
  
  void invalidateCache()
  {
    mCachedStart = Integer.MIN_VALUE;
    mCachedEnd = Integer.MIN_VALUE;
  }
  
  void onOffset(int paramInt)
  {
    if (mCachedStart != Integer.MIN_VALUE) {
      mCachedStart += paramInt;
    }
    if (mCachedEnd != Integer.MIN_VALUE) {
      mCachedEnd += paramInt;
    }
  }
  
  void popEnd()
  {
    int i = mViews.size();
    View localView = (View)mViews.remove(i - 1);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(localView);
    mSpan = null;
    if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
      mDeletedSize -= this$0.mPrimaryOrientation.getDecoratedMeasurement(localView);
    }
    if (i == 1) {
      mCachedStart = Integer.MIN_VALUE;
    }
    mCachedEnd = Integer.MIN_VALUE;
  }
  
  void popStart()
  {
    View localView = (View)mViews.remove(0);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(localView);
    mSpan = null;
    if (mViews.size() == 0) {
      mCachedEnd = Integer.MIN_VALUE;
    }
    if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
      mDeletedSize -= this$0.mPrimaryOrientation.getDecoratedMeasurement(localView);
    }
    mCachedStart = Integer.MIN_VALUE;
  }
  
  void prependToSpan(View paramView)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(paramView);
    mSpan = this;
    mViews.add(0, paramView);
    mCachedStart = Integer.MIN_VALUE;
    if (mViews.size() == 1) {
      mCachedEnd = Integer.MIN_VALUE;
    }
    if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
      mDeletedSize += this$0.mPrimaryOrientation.getDecoratedMeasurement(paramView);
    }
  }
  
  void setLine(int paramInt)
  {
    mCachedStart = paramInt;
    mCachedEnd = paramInt;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.Span
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */