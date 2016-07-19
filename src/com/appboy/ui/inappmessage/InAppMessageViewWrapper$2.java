package com.appboy.ui.inappmessage;

import android.view.View;
import android.view.View.OnClickListener;
import com.appboy.models.IInAppMessageImmersive;
import com.appboy.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import java.util.List;

class InAppMessageViewWrapper$2
  implements View.OnClickListener
{
  InAppMessageViewWrapper$2(InAppMessageViewWrapper paramInAppMessageViewWrapper) {}
  
  public void onClick(View paramView)
  {
    if ((InAppMessageViewWrapper.access$300(this$0) instanceof IInAppMessageImmersive))
    {
      paramView = (IInAppMessageImmersive)InAppMessageViewWrapper.access$300(this$0);
      if ((paramView.getMessageButtons() == null) || (paramView.getMessageButtons().size() == 0)) {
        InAppMessageViewWrapper.access$400(this$0).onClicked(new InAppMessageCloser(this$0), InAppMessageViewWrapper.access$100(this$0), InAppMessageViewWrapper.access$300(this$0));
      }
      return;
    }
    InAppMessageViewWrapper.access$400(this$0).onClicked(new InAppMessageCloser(this$0), InAppMessageViewWrapper.access$100(this$0), InAppMessageViewWrapper.access$300(this$0));
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.InAppMessageViewWrapper.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */