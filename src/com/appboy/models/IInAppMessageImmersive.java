package com.appboy.models;

import java.util.List;

public abstract interface IInAppMessageImmersive
  extends IInAppMessage
{
  public abstract int getCloseButtonColor();
  
  public abstract String getHeader();
  
  public abstract int getHeaderTextColor();
  
  public abstract List<MessageButton> getMessageButtons();
  
  public abstract boolean logButtonClick(MessageButton paramMessageButton);
  
  public abstract void setCloseButtonColor(int paramInt);
  
  public abstract void setHeader(String paramString);
  
  public abstract void setHeaderTextColor(int paramInt);
  
  public abstract void setMessageButtons(List<MessageButton> paramList);
}

/* Location:
 * Qualified Name:     com.appboy.models.IInAppMessageImmersive
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */