package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;

class DefaultItemAnimator$7
  extends DefaultItemAnimator.VpaListenerAdapter
{
  DefaultItemAnimator$7(DefaultItemAnimator paramDefaultItemAnimator, DefaultItemAnimator.ChangeInfo paramChangeInfo, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationEnd(View paramView)
  {
    val$oldViewAnim.setListener(null);
    ViewCompat.setAlpha(paramView, 1.0F);
    ViewCompat.setTranslationX(paramView, 0.0F);
    ViewCompat.setTranslationY(paramView, 0.0F);
    this$0.dispatchChangeFinished(val$changeInfo.oldHolder, true);
    DefaultItemAnimator.access$1300(this$0).remove(val$changeInfo.oldHolder);
    DefaultItemAnimator.access$800(this$0);
  }
  
  public void onAnimationStart(View paramView)
  {
    this$0.dispatchChangeStarting(val$changeInfo.oldHolder, true);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */