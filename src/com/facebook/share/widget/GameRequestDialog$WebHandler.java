package com.facebook.share.widget;

import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.share.internal.GameRequestValidation;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.GameRequestContent;

class GameRequestDialog$WebHandler
  extends FacebookDialogBase<GameRequestContent, GameRequestDialog.Result>.FacebookDialogBase.ModeHandler
{
  private GameRequestDialog$WebHandler(GameRequestDialog paramGameRequestDialog)
  {
    super(paramGameRequestDialog);
  }
  
  public boolean canShow(GameRequestContent paramGameRequestContent, boolean paramBoolean)
  {
    return true;
  }
  
  public AppCall createAppCall(GameRequestContent paramGameRequestContent)
  {
    GameRequestValidation.validate(paramGameRequestContent);
    AppCall localAppCall = this$0.createBaseAppCall();
    DialogPresenter.setupAppCallForWebDialog(localAppCall, "apprequests", WebDialogParameters.create(paramGameRequestContent));
    return localAppCall;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.GameRequestDialog.WebHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */