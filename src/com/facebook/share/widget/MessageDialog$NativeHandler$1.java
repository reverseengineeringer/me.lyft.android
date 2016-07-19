package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.model.ShareContent;

class MessageDialog$NativeHandler$1
  implements DialogPresenter.ParameterProvider
{
  MessageDialog$NativeHandler$1(MessageDialog.NativeHandler paramNativeHandler, AppCall paramAppCall, ShareContent paramShareContent, boolean paramBoolean) {}
  
  public Bundle getLegacyParameters()
  {
    return LegacyNativeDialogParameters.create(val$appCall.getCallId(), val$content, val$shouldFailOnDataError);
  }
  
  public Bundle getParameters()
  {
    return NativeDialogParameters.create(val$appCall.getCallId(), val$content, val$shouldFailOnDataError);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.MessageDialog.NativeHandler.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */