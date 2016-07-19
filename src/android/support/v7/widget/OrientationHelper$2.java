package android.support.v7.widget;

import android.view.View;

final class OrientationHelper$2
  extends OrientationHelper
{
  OrientationHelper$2(RecyclerView.LayoutManager paramLayoutManager)
  {
    super(paramLayoutManager, null);
  }
  
  public int getDecoratedEnd(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return mLayoutManager.getDecoratedBottom(paramView) + bottomMargin;
  }
  
  public int getDecoratedMeasurement(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return mLayoutManager.getDecoratedMeasuredHeight(paramView) + topMargin + bottomMargin;
  }
  
  public int getDecoratedMeasurementInOther(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return mLayoutManager.getDecoratedMeasuredWidth(paramView) + leftMargin + rightMargin;
  }
  
  public int getDecoratedStart(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return mLayoutManager.getDecoratedTop(paramView) - topMargin;
  }
  
  public int getEnd()
  {
    return mLayoutManager.getHeight();
  }
  
  public int getEndAfterPadding()
  {
    return mLayoutManager.getHeight() - mLayoutManager.getPaddingBottom();
  }
  
  public int getEndPadding()
  {
    return mLayoutManager.getPaddingBottom();
  }
  
  public int getMode()
  {
    return mLayoutManager.getHeightMode();
  }
  
  public int getModeInOther()
  {
    return mLayoutManager.getWidthMode();
  }
  
  public int getStartAfterPadding()
  {
    return mLayoutManager.getPaddingTop();
  }
  
  public int getTotalSpace()
  {
    return mLayoutManager.getHeight() - mLayoutManager.getPaddingTop() - mLayoutManager.getPaddingBottom();
  }
  
  public void offsetChildren(int paramInt)
  {
    mLayoutManager.offsetChildrenVertical(paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.OrientationHelper.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */