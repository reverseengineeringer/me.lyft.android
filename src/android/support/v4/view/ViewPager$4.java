package android.support.v4.view;

import android.graphics.Rect;
import android.view.View;

class ViewPager$4
  implements OnApplyWindowInsetsListener
{
  private final Rect mTempRect = new Rect();
  
  ViewPager$4(ViewPager paramViewPager) {}
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    paramView = ViewCompat.onApplyWindowInsets(paramView, paramWindowInsetsCompat);
    if (paramView.isConsumed()) {
      return paramView;
    }
    paramWindowInsetsCompat = mTempRect;
    left = paramView.getSystemWindowInsetLeft();
    top = paramView.getSystemWindowInsetTop();
    right = paramView.getSystemWindowInsetRight();
    bottom = paramView.getSystemWindowInsetBottom();
    int i = 0;
    int j = this$0.getChildCount();
    while (i < j)
    {
      WindowInsetsCompat localWindowInsetsCompat = ViewCompat.dispatchApplyWindowInsets(this$0.getChildAt(i), paramView);
      left = Math.min(localWindowInsetsCompat.getSystemWindowInsetLeft(), left);
      top = Math.min(localWindowInsetsCompat.getSystemWindowInsetTop(), top);
      right = Math.min(localWindowInsetsCompat.getSystemWindowInsetRight(), right);
      bottom = Math.min(localWindowInsetsCompat.getSystemWindowInsetBottom(), bottom);
      i += 1;
    }
    return paramView.replaceSystemWindowInsets(left, top, right, bottom);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewPager.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */