package com.facebook.share.widget;

import android.os.Bundle;
import android.util.Log;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.share.model.AppInviteContent;

class AppInviteDialog$NativeHandler$1
  implements DialogPresenter.ParameterProvider
{
  AppInviteDialog$NativeHandler$1(AppInviteDialog.NativeHandler paramNativeHandler, AppInviteContent paramAppInviteContent) {}
  
  public Bundle getLegacyParameters()
  {
    Log.e("AppInviteDialog", "Attempting to present the AppInviteDialog with an outdated Facebook app on the device");
    return new Bundle();
  }
  
  public Bundle getParameters()
  {
    return AppInviteDialog.access$300(val$content);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.AppInviteDialog.NativeHandler.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */