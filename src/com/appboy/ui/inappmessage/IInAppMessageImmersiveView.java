package com.appboy.ui.inappmessage;

import android.view.View;
import java.util.List;

public abstract interface IInAppMessageImmersiveView
  extends IInAppMessageView
{
  public abstract List<View> getMessageButtonViews();
  
  public abstract View getMessageCloseButtonView();
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.IInAppMessageImmersiveView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */