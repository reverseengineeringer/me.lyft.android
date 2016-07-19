package android.support.v7.widget;

import android.view.View;
import java.util.List;

class LinearLayoutManager$LayoutState
{
  int mAvailable;
  int mCurrentPosition;
  int mExtra = 0;
  boolean mInfinite;
  boolean mIsPreLayout = false;
  int mItemDirection;
  int mLastScrollDelta;
  int mLayoutDirection;
  int mOffset;
  boolean mRecycle = true;
  List<RecyclerView.ViewHolder> mScrapList = null;
  int mScrollingOffset;
  
  private View nextViewFromScrapList()
  {
    int j = mScrapList.size();
    int i = 0;
    if (i < j)
    {
      View localView = mScrapList.get(i)).itemView;
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.isItemRemoved()) {}
      while (mCurrentPosition != localLayoutParams.getViewLayoutPosition())
      {
        i += 1;
        break;
      }
      assignPositionFromScrapList(localView);
      return localView;
    }
    return null;
  }
  
  public void assignPositionFromScrapList()
  {
    assignPositionFromScrapList(null);
  }
  
  public void assignPositionFromScrapList(View paramView)
  {
    paramView = nextViewInLimitedList(paramView);
    if (paramView == null)
    {
      mCurrentPosition = -1;
      return;
    }
    mCurrentPosition = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
  }
  
  boolean hasMore(RecyclerView.State paramState)
  {
    return (mCurrentPosition >= 0) && (mCurrentPosition < paramState.getItemCount());
  }
  
  View next(RecyclerView.Recycler paramRecycler)
  {
    if (mScrapList != null) {
      return nextViewFromScrapList();
    }
    paramRecycler = paramRecycler.getViewForPosition(mCurrentPosition);
    mCurrentPosition += mItemDirection;
    return paramRecycler;
  }
  
  public View nextViewInLimitedList(View paramView)
  {
    int n = mScrapList.size();
    Object localObject1 = null;
    int j = Integer.MAX_VALUE;
    int i = 0;
    Object localObject2 = localObject1;
    if (i < n)
    {
      View localView = mScrapList.get(i)).itemView;
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      localObject2 = localObject1;
      int k = j;
      if (localView != paramView)
      {
        if (!localLayoutParams.isItemRemoved()) {
          break label99;
        }
        k = j;
        localObject2 = localObject1;
      }
      label99:
      int m;
      do
      {
        do
        {
          do
          {
            i += 1;
            localObject1 = localObject2;
            j = k;
            break;
            m = (localLayoutParams.getViewLayoutPosition() - mCurrentPosition) * mItemDirection;
            localObject2 = localObject1;
            k = j;
          } while (m < 0);
          localObject2 = localObject1;
          k = j;
        } while (m >= j);
        localObject1 = localView;
        k = m;
        localObject2 = localObject1;
      } while (m != 0);
      localObject2 = localObject1;
    }
    return (View)localObject2;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager.LayoutState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */