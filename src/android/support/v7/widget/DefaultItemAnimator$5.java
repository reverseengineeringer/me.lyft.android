package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;

class DefaultItemAnimator$5
  extends DefaultItemAnimator.VpaListenerAdapter
{
  DefaultItemAnimator$5(DefaultItemAnimator paramDefaultItemAnimator, RecyclerView.ViewHolder paramViewHolder, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationCancel(View paramView)
  {
    ViewCompat.setAlpha(paramView, 1.0F);
  }
  
  public void onAnimationEnd(View paramView)
  {
    val$animation.setListener(null);
    this$0.dispatchAddFinished(val$holder);
    DefaultItemAnimator.access$900(this$0).remove(val$holder);
    DefaultItemAnimator.access$800(this$0);
  }
  
  public void onAnimationStart(View paramView)
  {
    this$0.dispatchAddStarting(val$holder);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */