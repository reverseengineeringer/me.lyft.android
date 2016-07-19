package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

class ViewParentCompat$ViewParentCompatStubImpl
  implements ViewParentCompat.ViewParentCompatImpl
{
  public boolean onNestedFling(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if ((paramViewParent instanceof NestedScrollingParent)) {
      return ((NestedScrollingParent)paramViewParent).onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
    }
    return false;
  }
  
  public boolean onNestedPreFling(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2)
  {
    if ((paramViewParent instanceof NestedScrollingParent)) {
      return ((NestedScrollingParent)paramViewParent).onNestedPreFling(paramView, paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public void onNestedPreScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if ((paramViewParent instanceof NestedScrollingParent)) {
      ((NestedScrollingParent)paramViewParent).onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
    }
  }
  
  public void onNestedScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramViewParent instanceof NestedScrollingParent)) {
      ((NestedScrollingParent)paramViewParent).onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onNestedScrollAccepted(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt)
  {
    if ((paramViewParent instanceof NestedScrollingParent)) {
      ((NestedScrollingParent)paramViewParent).onNestedScrollAccepted(paramView1, paramView2, paramInt);
    }
  }
  
  public boolean onStartNestedScroll(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt)
  {
    if ((paramViewParent instanceof NestedScrollingParent)) {
      return ((NestedScrollingParent)paramViewParent).onStartNestedScroll(paramView1, paramView2, paramInt);
    }
    return false;
  }
  
  public void onStopNestedScroll(ViewParent paramViewParent, View paramView)
  {
    if ((paramViewParent instanceof NestedScrollingParent)) {
      ((NestedScrollingParent)paramViewParent).onStopNestedScroll(paramView);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewParentCompat.ViewParentCompatStubImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */