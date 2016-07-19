package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;

class JoinAppGroupDialog$WebHandler
  extends FacebookDialogBase<String, JoinAppGroupDialog.Result>.FacebookDialogBase.ModeHandler
{
  private JoinAppGroupDialog$WebHandler(JoinAppGroupDialog paramJoinAppGroupDialog)
  {
    super(paramJoinAppGroupDialog);
  }
  
  public boolean canShow(String paramString, boolean paramBoolean)
  {
    return true;
  }
  
  public AppCall createAppCall(String paramString)
  {
    AppCall localAppCall = this$0.createBaseAppCall();
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    DialogPresenter.setupAppCallForWebDialog(localAppCall, "game_group_join", localBundle);
    return localAppCall;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.JoinAppGroupDialog.WebHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */