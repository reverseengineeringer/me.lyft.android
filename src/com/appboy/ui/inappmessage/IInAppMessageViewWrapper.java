package com.appboy.ui.inappmessage;

import android.app.Activity;
import android.view.View;
import com.appboy.models.IInAppMessage;

public abstract interface IInAppMessageViewWrapper
{
  public abstract void close();
  
  public abstract IInAppMessage getInAppMessage();
  
  public abstract View getInAppMessageView();
  
  public abstract boolean getIsAnimatingClose();
  
  public abstract void open(Activity paramActivity);
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.IInAppMessageViewWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */