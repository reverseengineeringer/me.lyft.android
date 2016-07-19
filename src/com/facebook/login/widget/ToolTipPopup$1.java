package com.facebook.login.widget;

import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;

class ToolTipPopup$1
  implements ViewTreeObserver.OnScrollChangedListener
{
  ToolTipPopup$1(ToolTipPopup paramToolTipPopup) {}
  
  public void onScrollChanged()
  {
    if ((ToolTipPopup.access$000(this$0).get() != null) && (ToolTipPopup.access$100(this$0) != null) && (ToolTipPopup.access$100(this$0).isShowing()))
    {
      if (ToolTipPopup.access$100(this$0).isAboveAnchor()) {
        ToolTipPopup.access$200(this$0).showBottomArrow();
      }
    }
    else {
      return;
    }
    ToolTipPopup.access$200(this$0).showTopArrow();
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.widget.ToolTipPopup.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */