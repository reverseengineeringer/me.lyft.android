package com.appboy.ui.inappmessage;

import android.view.View;
import android.view.View.OnClickListener;
import com.appboy.models.IInAppMessageImmersive;
import com.appboy.models.MessageButton;
import com.appboy.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import java.util.List;

class InAppMessageViewWrapper$3
  implements View.OnClickListener
{
  InAppMessageViewWrapper$3(InAppMessageViewWrapper paramInAppMessageViewWrapper) {}
  
  public void onClick(View paramView)
  {
    IInAppMessageImmersive localIInAppMessageImmersive = (IInAppMessageImmersive)InAppMessageViewWrapper.access$300(this$0);
    int i = 0;
    for (;;)
    {
      if (i < InAppMessageViewWrapper.access$500(this$0).size())
      {
        if (paramView.getId() == ((View)InAppMessageViewWrapper.access$500(this$0).get(i)).getId())
        {
          paramView = (MessageButton)localIInAppMessageImmersive.getMessageButtons().get(i);
          InAppMessageViewWrapper.access$400(this$0).onButtonClicked(new InAppMessageCloser(this$0), paramView, localIInAppMessageImmersive);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.InAppMessageViewWrapper.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */