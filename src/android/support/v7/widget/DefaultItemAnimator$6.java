package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;

class DefaultItemAnimator$6
  extends DefaultItemAnimator.VpaListenerAdapter
{
  DefaultItemAnimator$6(DefaultItemAnimator paramDefaultItemAnimator, RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationCancel(View paramView)
  {
    if (val$deltaX != 0) {
      ViewCompat.setTranslationX(paramView, 0.0F);
    }
    if (val$deltaY != 0) {
      ViewCompat.setTranslationY(paramView, 0.0F);
    }
  }
  
  public void onAnimationEnd(View paramView)
  {
    val$animation.setListener(null);
    this$0.dispatchMoveFinished(val$holder);
    DefaultItemAnimator.access$1100(this$0).remove(val$holder);
    DefaultItemAnimator.access$800(this$0);
  }
  
  public void onAnimationStart(View paramView)
  {
    this$0.dispatchMoveStarting(val$holder);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */