package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.share.Sharer.Result;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.model.ShareContent;

class MessageDialog$NativeHandler
  extends FacebookDialogBase<ShareContent, Sharer.Result>.FacebookDialogBase.ModeHandler
{
  private MessageDialog$NativeHandler(MessageDialog paramMessageDialog)
  {
    super(paramMessageDialog);
  }
  
  public boolean canShow(ShareContent paramShareContent, boolean paramBoolean)
  {
    return (paramShareContent != null) && (MessageDialog.canShow(paramShareContent.getClass()));
  }
  
  public AppCall createAppCall(final ShareContent paramShareContent)
  {
    ShareContentValidation.validateForMessage(paramShareContent);
    final AppCall localAppCall = this$0.createBaseAppCall();
    final boolean bool = this$0.getShouldFailOnDataError();
    MessageDialog.access$100(this$0);
    DialogPresenter.setupAppCallForNativeDialog(localAppCall, new DialogPresenter.ParameterProvider()
    {
      public Bundle getLegacyParameters()
      {
        return LegacyNativeDialogParameters.create(localAppCall.getCallId(), paramShareContent, bool);
      }
      
      public Bundle getParameters()
      {
        return NativeDialogParameters.create(localAppCall.getCallId(), paramShareContent, bool);
      }
    }, MessageDialog.access$200(paramShareContent.getClass()));
    return localAppCall;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.MessageDialog.NativeHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */