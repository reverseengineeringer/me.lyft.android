package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.share.Sharer.Result;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;

class ShareDialog$WebShareHandler
  extends FacebookDialogBase<ShareContent, Sharer.Result>.FacebookDialogBase.ModeHandler
{
  private ShareDialog$WebShareHandler(ShareDialog paramShareDialog)
  {
    super(paramShareDialog);
  }
  
  private String getActionName(ShareContent paramShareContent)
  {
    if ((paramShareContent instanceof ShareLinkContent)) {
      return "share";
    }
    if ((paramShareContent instanceof ShareOpenGraphContent)) {
      return "share_open_graph";
    }
    return null;
  }
  
  public boolean canShow(ShareContent paramShareContent, boolean paramBoolean)
  {
    return (paramShareContent != null) && (ShareDialog.access$700(paramShareContent.getClass()));
  }
  
  public AppCall createAppCall(ShareContent paramShareContent)
  {
    ShareDialog.access$500(this$0, ShareDialog.access$800(this$0), paramShareContent, ShareDialog.Mode.WEB);
    AppCall localAppCall = this$0.createBaseAppCall();
    ShareContentValidation.validateForWebShare(paramShareContent);
    if ((paramShareContent instanceof ShareLinkContent)) {}
    for (Bundle localBundle = WebDialogParameters.create((ShareLinkContent)paramShareContent);; localBundle = WebDialogParameters.create((ShareOpenGraphContent)paramShareContent))
    {
      DialogPresenter.setupAppCallForWebDialog(localAppCall, getActionName(paramShareContent), localBundle);
      return localAppCall;
    }
  }
  
  public Object getMode()
  {
    return ShareDialog.Mode.WEB;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.ShareDialog.WebShareHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */