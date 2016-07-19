package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerView$ItemAnimator
{
  private long mAddDuration = 120L;
  private long mChangeDuration = 250L;
  private ArrayList<ItemAnimatorFinishedListener> mFinishedListeners = new ArrayList();
  private ItemAnimatorListener mListener = null;
  private long mMoveDuration = 250L;
  private long mRemoveDuration = 120L;
  
  static int buildAdapterChangeFlagsForAnimations(RecyclerView.ViewHolder paramViewHolder)
  {
    int j = RecyclerView.ViewHolder.access$6500(paramViewHolder) & 0xE;
    if (paramViewHolder.isInvalid()) {
      return 4;
    }
    int i = j;
    if ((j & 0x4) == 0)
    {
      int k = paramViewHolder.getOldPosition();
      int m = paramViewHolder.getAdapterPosition();
      i = j;
      if (k != -1)
      {
        i = j;
        if (m != -1)
        {
          i = j;
          if (k != m) {
            i = j | 0x800;
          }
        }
      }
    }
    return i;
  }
  
  public abstract boolean animateAppearance(RecyclerView.ViewHolder paramViewHolder, ItemHolderInfo paramItemHolderInfo1, ItemHolderInfo paramItemHolderInfo2);
  
  public abstract boolean animateChange(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, ItemHolderInfo paramItemHolderInfo1, ItemHolderInfo paramItemHolderInfo2);
  
  public abstract boolean animateDisappearance(RecyclerView.ViewHolder paramViewHolder, ItemHolderInfo paramItemHolderInfo1, ItemHolderInfo paramItemHolderInfo2);
  
  public abstract boolean animatePersistence(RecyclerView.ViewHolder paramViewHolder, ItemHolderInfo paramItemHolderInfo1, ItemHolderInfo paramItemHolderInfo2);
  
  public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder paramViewHolder)
  {
    return true;
  }
  
  public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder paramViewHolder, List<Object> paramList)
  {
    return canReuseUpdatedViewHolder(paramViewHolder);
  }
  
  public final void dispatchAnimationFinished(RecyclerView.ViewHolder paramViewHolder)
  {
    onAnimationFinished(paramViewHolder);
    if (mListener != null) {
      mListener.onAnimationFinished(paramViewHolder);
    }
  }
  
  public final void dispatchAnimationsFinished()
  {
    int j = mFinishedListeners.size();
    int i = 0;
    while (i < j)
    {
      ((ItemAnimatorFinishedListener)mFinishedListeners.get(i)).onAnimationsFinished();
      i += 1;
    }
    mFinishedListeners.clear();
  }
  
  public abstract void endAnimation(RecyclerView.ViewHolder paramViewHolder);
  
  public abstract void endAnimations();
  
  public long getAddDuration()
  {
    return mAddDuration;
  }
  
  public long getChangeDuration()
  {
    return mChangeDuration;
  }
  
  public long getMoveDuration()
  {
    return mMoveDuration;
  }
  
  public long getRemoveDuration()
  {
    return mRemoveDuration;
  }
  
  public abstract boolean isRunning();
  
  public ItemHolderInfo obtainHolderInfo()
  {
    return new ItemHolderInfo();
  }
  
  public void onAnimationFinished(RecyclerView.ViewHolder paramViewHolder) {}
  
  public ItemHolderInfo recordPostLayoutInformation(RecyclerView.State paramState, RecyclerView.ViewHolder paramViewHolder)
  {
    return obtainHolderInfo().setFrom(paramViewHolder);
  }
  
  public ItemHolderInfo recordPreLayoutInformation(RecyclerView.State paramState, RecyclerView.ViewHolder paramViewHolder, int paramInt, List<Object> paramList)
  {
    return obtainHolderInfo().setFrom(paramViewHolder);
  }
  
  public abstract void runPendingAnimations();
  
  void setListener(ItemAnimatorListener paramItemAnimatorListener)
  {
    mListener = paramItemAnimatorListener;
  }
  
  public static abstract interface ItemAnimatorFinishedListener
  {
    public abstract void onAnimationsFinished();
  }
  
  static abstract interface ItemAnimatorListener
  {
    public abstract void onAnimationFinished(RecyclerView.ViewHolder paramViewHolder);
  }
  
  public static class ItemHolderInfo
  {
    public int bottom;
    public int left;
    public int right;
    public int top;
    
    public ItemHolderInfo setFrom(RecyclerView.ViewHolder paramViewHolder)
    {
      return setFrom(paramViewHolder, 0);
    }
    
    public ItemHolderInfo setFrom(RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      paramViewHolder = itemView;
      left = paramViewHolder.getLeft();
      top = paramViewHolder.getTop();
      right = paramViewHolder.getRight();
      bottom = paramViewHolder.getBottom();
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView.ItemAnimator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */