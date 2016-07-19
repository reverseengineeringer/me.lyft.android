package com.appboy.ui.inappmessage;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.appboy.support.AppboyLogger;
import com.appboy.ui.support.ViewUtils;

class InAppMessageViewWrapper$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  InAppMessageViewWrapper$1(InAppMessageViewWrapper paramInAppMessageViewWrapper, FrameLayout paramFrameLayout, int paramInt) {}
  
  public void onGlobalLayout()
  {
    AppboyLogger.d(InAppMessageViewWrapper.access$000(), String.format("Detected root view height of %d, display height of %d in onGlobalLayout", new Object[] { Integer.valueOf(val$frameLayout.getHeight()), Integer.valueOf(val$displayHeight) }));
    val$frameLayout.removeView(InAppMessageViewWrapper.access$100(this$0));
    InAppMessageViewWrapper.access$200(this$0, val$frameLayout, val$displayHeight);
    ViewUtils.removeOnGlobalLayoutListenerSafe(val$frameLayout.getViewTreeObserver(), this);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.InAppMessageViewWrapper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */