package com.appboy.ui.inappmessage;

import android.app.Activity;
import android.view.View;
import com.appboy.models.IInAppMessage;

public abstract interface IInAppMessageViewFactory
{
  public abstract View createInAppMessageView(Activity paramActivity, IInAppMessage paramIInAppMessage);
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.IInAppMessageViewFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */