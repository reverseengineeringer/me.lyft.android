package me.lyft.android.rx;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class Binder$1
  implements View.OnAttachStateChangeListener
{
  Binder$1(Binder paramBinder) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this$0.detach();
    paramView.removeOnAttachStateChangeListener(Binder.access$000(this$0));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.rx.Binder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */