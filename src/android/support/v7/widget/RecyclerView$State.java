package android.support.v7.widget;

import android.util.SparseArray;

public class RecyclerView$State
{
  private SparseArray<Object> mData;
  private int mDeletedInvisibleItemCountSincePreviousLayout = 0;
  private boolean mInPreLayout = false;
  private boolean mIsMeasuring = false;
  int mItemCount = 0;
  private int mLayoutStep = 1;
  private int mPreviousLayoutItemCount = 0;
  private boolean mRunPredictiveAnimations = false;
  private boolean mRunSimpleAnimations = false;
  private boolean mStructureChanged = false;
  private int mTargetPosition = -1;
  private boolean mTrackOldChangeHolders = false;
  
  void assertLayoutStep(int paramInt)
  {
    if ((mLayoutStep & paramInt) == 0) {
      throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(paramInt) + " but it is " + Integer.toBinaryString(mLayoutStep));
    }
  }
  
  public int getItemCount()
  {
    if (mInPreLayout) {
      return mPreviousLayoutItemCount - mDeletedInvisibleItemCountSincePreviousLayout;
    }
    return mItemCount;
  }
  
  public int getTargetScrollPosition()
  {
    return mTargetPosition;
  }
  
  public boolean hasTargetScrollPosition()
  {
    return mTargetPosition != -1;
  }
  
  public boolean isPreLayout()
  {
    return mInPreLayout;
  }
  
  public String toString()
  {
    return "State{mTargetPosition=" + mTargetPosition + ", mData=" + mData + ", mItemCount=" + mItemCount + ", mPreviousLayoutItemCount=" + mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + mStructureChanged + ", mInPreLayout=" + mInPreLayout + ", mRunSimpleAnimations=" + mRunSimpleAnimations + ", mRunPredictiveAnimations=" + mRunPredictiveAnimations + '}';
  }
  
  public boolean willRunPredictiveAnimations()
  {
    return mRunPredictiveAnimations;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView.State
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */