package com.appboy.ui.inappmessage;

import com.appboy.models.IInAppMessage;

public class InAppMessageCloser
{
  private InAppMessageViewWrapper mInAppMessageViewWrapper;
  
  public InAppMessageCloser(InAppMessageViewWrapper paramInAppMessageViewWrapper)
  {
    mInAppMessageViewWrapper = paramInAppMessageViewWrapper;
  }
  
  public void close(boolean paramBoolean)
  {
    if (paramBoolean) {
      mInAppMessageViewWrapper.getInAppMessage().setAnimateOut(true);
    }
    for (;;)
    {
      mInAppMessageViewWrapper.close();
      return;
      mInAppMessageViewWrapper.getInAppMessage().setAnimateOut(false);
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.InAppMessageCloser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */