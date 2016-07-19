package com.appboy.ui.inappmessage.listeners;

import android.view.View;
import com.appboy.models.IInAppMessage;
import com.appboy.models.IInAppMessageImmersive;
import com.appboy.models.MessageButton;
import com.appboy.ui.inappmessage.InAppMessageCloser;

public abstract interface IInAppMessageViewLifecycleListener
{
  public abstract void afterClosed(IInAppMessage paramIInAppMessage);
  
  public abstract void afterOpened(View paramView, IInAppMessage paramIInAppMessage);
  
  public abstract void beforeClosed(View paramView, IInAppMessage paramIInAppMessage);
  
  public abstract void beforeOpened(View paramView, IInAppMessage paramIInAppMessage);
  
  public abstract void onButtonClicked(InAppMessageCloser paramInAppMessageCloser, MessageButton paramMessageButton, IInAppMessageImmersive paramIInAppMessageImmersive);
  
  public abstract void onClicked(InAppMessageCloser paramInAppMessageCloser, View paramView, IInAppMessage paramIInAppMessage);
  
  public abstract void onDismissed(View paramView, IInAppMessage paramIInAppMessage);
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */