package com.facebook.share.widget;

import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.share.model.AppInviteContent;

class AppInviteDialog$WebFallbackHandler
  extends FacebookDialogBase<AppInviteContent, AppInviteDialog.Result>.FacebookDialogBase.ModeHandler
{
  private AppInviteDialog$WebFallbackHandler(AppInviteDialog paramAppInviteDialog)
  {
    super(paramAppInviteDialog);
  }
  
  public boolean canShow(AppInviteContent paramAppInviteContent, boolean paramBoolean)
  {
    return AppInviteDialog.access$500();
  }
  
  public AppCall createAppCall(AppInviteContent paramAppInviteContent)
  {
    AppCall localAppCall = this$0.createBaseAppCall();
    DialogPresenter.setupAppCallForWebFallbackDialog(localAppCall, AppInviteDialog.access$300(paramAppInviteContent), AppInviteDialog.access$400());
    return localAppCall;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.AppInviteDialog.WebFallbackHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */