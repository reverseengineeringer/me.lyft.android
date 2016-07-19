package com.facebook.share.widget;

import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.AppGroupCreationContent;

class CreateAppGroupDialog$WebHandler
  extends FacebookDialogBase<AppGroupCreationContent, CreateAppGroupDialog.Result>.FacebookDialogBase.ModeHandler
{
  private CreateAppGroupDialog$WebHandler(CreateAppGroupDialog paramCreateAppGroupDialog)
  {
    super(paramCreateAppGroupDialog);
  }
  
  public boolean canShow(AppGroupCreationContent paramAppGroupCreationContent, boolean paramBoolean)
  {
    return true;
  }
  
  public AppCall createAppCall(AppGroupCreationContent paramAppGroupCreationContent)
  {
    AppCall localAppCall = this$0.createBaseAppCall();
    DialogPresenter.setupAppCallForWebDialog(localAppCall, "game_group_create", WebDialogParameters.create(paramAppGroupCreationContent));
    return localAppCall;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.CreateAppGroupDialog.WebHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */