package com.facebook.internal;

public abstract class FacebookDialogBase$ModeHandler
{
  protected FacebookDialogBase$ModeHandler(FacebookDialogBase paramFacebookDialogBase) {}
  
  public abstract boolean canShow(CONTENT paramCONTENT, boolean paramBoolean);
  
  public abstract AppCall createAppCall(CONTENT paramCONTENT);
  
  public Object getMode()
  {
    return FacebookDialogBase.BASE_AUTOMATIC_MODE;
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.FacebookDialogBase.ModeHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */