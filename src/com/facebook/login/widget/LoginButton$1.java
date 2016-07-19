package com.facebook.login.widget;

import android.app.Activity;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.FetchedAppSettings;

class LoginButton$1
  implements Runnable
{
  LoginButton$1(LoginButton paramLoginButton, String paramString) {}
  
  public void run()
  {
    final Utility.FetchedAppSettings localFetchedAppSettings = Utility.queryAppSettings(val$appId, false);
    LoginButton.access$100(this$0).runOnUiThread(new Runnable()
    {
      public void run()
      {
        LoginButton.access$000(this$0, localFetchedAppSettings);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.widget.LoginButton.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */