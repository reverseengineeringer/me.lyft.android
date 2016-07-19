package com.facebook.share.internal;

import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;

class LikeDialog$WebFallbackHandler
  extends FacebookDialogBase<LikeContent, LikeDialog.Result>.FacebookDialogBase.ModeHandler
{
  private LikeDialog$WebFallbackHandler(LikeDialog paramLikeDialog)
  {
    super(paramLikeDialog);
  }
  
  public boolean canShow(LikeContent paramLikeContent, boolean paramBoolean)
  {
    return (paramLikeContent != null) && (LikeDialog.canShowWebFallback());
  }
  
  public AppCall createAppCall(LikeContent paramLikeContent)
  {
    AppCall localAppCall = this$0.createBaseAppCall();
    DialogPresenter.setupAppCallForWebFallbackDialog(localAppCall, LikeDialog.access$200(paramLikeContent), LikeDialog.access$300());
    return localAppCall;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeDialog.WebFallbackHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */