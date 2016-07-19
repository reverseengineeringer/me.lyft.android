package android.support.v4.animation;

import android.os.Build.VERSION;
import android.view.View;

public final class AnimatorCompatHelper
{
  private static final AnimatorProvider IMPL = new DonutAnimatorCompatProvider();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 12)
    {
      IMPL = new HoneycombMr1AnimatorCompatProvider();
      return;
    }
  }
  
  public static void clearInterpolator(View paramView)
  {
    IMPL.clearInterpolator(paramView);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.animation.AnimatorCompatHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */