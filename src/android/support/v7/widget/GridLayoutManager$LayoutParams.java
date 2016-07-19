package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class GridLayoutManager$LayoutParams
  extends RecyclerView.LayoutParams
{
  private int mSpanIndex = -1;
  private int mSpanSize = 0;
  
  public GridLayoutManager$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public GridLayoutManager$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GridLayoutManager$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public GridLayoutManager$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public int getSpanIndex()
  {
    return mSpanIndex;
  }
  
  public int getSpanSize()
  {
    return mSpanSize;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.GridLayoutManager.LayoutParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */