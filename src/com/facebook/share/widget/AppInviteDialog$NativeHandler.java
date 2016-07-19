package com.facebook.share.widget;

import android.os.Bundle;
import android.util.Log;
import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.share.model.AppInviteContent;

class AppInviteDialog$NativeHandler
  extends FacebookDialogBase<AppInviteContent, AppInviteDialog.Result>.FacebookDialogBase.ModeHandler
{
  private AppInviteDialog$NativeHandler(AppInviteDialog paramAppInviteDialog)
  {
    super(paramAppInviteDialog);
  }
  
  public boolean canShow(AppInviteContent paramAppInviteContent, boolean paramBoolean)
  {
    return AppInviteDialog.access$200();
  }
  
  public AppCall createAppCall(final AppInviteContent paramAppInviteContent)
  {
    AppCall localAppCall = this$0.createBaseAppCall();
    DialogPresenter.setupAppCallForNativeDialog(localAppCall, new DialogPresenter.ParameterProvider()
    {
      public Bundle getLegacyParameters()
      {
        Log.e("AppInviteDialog", "Attempting to present the AppInviteDialog with an outdated Facebook app on the device");
        return new Bundle();
      }
      
      public Bundle getParameters()
      {
        return AppInviteDialog.access$300(paramAppInviteContent);
      }
    }, AppInviteDialog.access$400());
    return localAppCall;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.AppInviteDialog.NativeHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */