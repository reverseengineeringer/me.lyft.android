package com.facebook.share.internal;

import android.os.Bundle;
import android.util.Log;
import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;

class LikeDialog$NativeHandler
  extends FacebookDialogBase<LikeContent, LikeDialog.Result>.FacebookDialogBase.ModeHandler
{
  private LikeDialog$NativeHandler(LikeDialog paramLikeDialog)
  {
    super(paramLikeDialog);
  }
  
  public boolean canShow(LikeContent paramLikeContent, boolean paramBoolean)
  {
    return (paramLikeContent != null) && (LikeDialog.canShowNativeDialog());
  }
  
  public AppCall createAppCall(final LikeContent paramLikeContent)
  {
    AppCall localAppCall = this$0.createBaseAppCall();
    DialogPresenter.setupAppCallForNativeDialog(localAppCall, new DialogPresenter.ParameterProvider()
    {
      public Bundle getLegacyParameters()
      {
        Log.e("LikeDialog", "Attempting to present the Like Dialog with an outdated Facebook app on the device");
        return new Bundle();
      }
      
      public Bundle getParameters()
      {
        return LikeDialog.access$200(paramLikeContent);
      }
    }, LikeDialog.access$300());
    return localAppCall;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeDialog.NativeHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */