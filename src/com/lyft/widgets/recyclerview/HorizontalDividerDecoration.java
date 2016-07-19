package com.lyft.widgets.recyclerview;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class HorizontalDividerDecoration
  extends RecyclerView.ItemDecoration
{
  private Drawable dividerDrawable;
  
  public HorizontalDividerDecoration(Drawable paramDrawable)
  {
    dividerDrawable = paramDrawable;
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int j = paramRecyclerView.getPaddingLeft();
    int k = paramRecyclerView.getWidth();
    int m = paramRecyclerView.getPaddingRight();
    int n = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < n - 1)
    {
      paramState = paramRecyclerView.getChildAt(i);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramState.getLayoutParams();
      int i1 = paramState.getBottom() + bottomMargin;
      int i2 = dividerDrawable.getIntrinsicHeight();
      dividerDrawable.setBounds(j, i1, k - m, i1 + i2);
      dividerDrawable.draw(paramCanvas);
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.recyclerview.HorizontalDividerDecoration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */