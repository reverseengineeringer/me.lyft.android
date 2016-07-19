package com.appboy.events;

import com.appboy.models.IInAppMessage;

public final class InAppMessageEvent
{
  private final IInAppMessage a;
  private final String b;
  
  public InAppMessageEvent(IInAppMessage paramIInAppMessage, String paramString)
  {
    b = paramString;
    if (paramIInAppMessage == null) {
      throw new NullPointerException();
    }
    a = paramIInAppMessage;
  }
  
  public final IInAppMessage getInAppMessage()
  {
    return a;
  }
  
  public final String getUserId()
  {
    return b;
  }
}

/* Location:
 * Qualified Name:     com.appboy.events.InAppMessageEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */