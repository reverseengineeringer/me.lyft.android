package com.facebook.login.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.R.string;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.LoginAuthorizationType;
import com.facebook.login.LoginManager;

public class LoginButton$LoginClickListener
  implements View.OnClickListener
{
  protected LoginButton$LoginClickListener(LoginButton paramLoginButton) {}
  
  protected LoginManager getLoginManager()
  {
    LoginManager localLoginManager = LoginManager.getInstance();
    localLoginManager.setDefaultAudience(this$0.getDefaultAudience());
    localLoginManager.setLoginBehavior(this$0.getLoginBehavior());
    return localLoginManager;
  }
  
  public void onClick(View paramView)
  {
    LoginButton.access$300(this$0, paramView);
    paramView = AccessToken.getCurrentAccessToken();
    AppEventsLogger localAppEventsLogger;
    Bundle localBundle;
    if (paramView != null)
    {
      performLogout(this$0.getContext());
      localAppEventsLogger = AppEventsLogger.newLogger(this$0.getContext());
      localBundle = new Bundle();
      if (paramView == null) {
        break label83;
      }
    }
    label83:
    for (int i = 0;; i = 1)
    {
      localBundle.putInt("logging_in", i);
      localAppEventsLogger.logSdkEvent(LoginButton.access$400(this$0), null, localBundle);
      return;
      performLogin();
      break;
    }
  }
  
  protected void performLogin()
  {
    LoginManager localLoginManager = getLoginManager();
    if (LoginAuthorizationType.PUBLISH.equals(LoginButton.LoginButtonProperties.access$600(LoginButton.access$500(this$0))))
    {
      if (this$0.getFragment() != null)
      {
        localLoginManager.logInWithPublishPermissions(this$0.getFragment(), LoginButton.LoginButtonProperties.access$700(LoginButton.access$500(this$0)));
        return;
      }
      if (this$0.getNativeFragment() != null)
      {
        localLoginManager.logInWithPublishPermissions(this$0.getNativeFragment(), LoginButton.LoginButtonProperties.access$700(LoginButton.access$500(this$0)));
        return;
      }
      localLoginManager.logInWithPublishPermissions(LoginButton.access$800(this$0), LoginButton.LoginButtonProperties.access$700(LoginButton.access$500(this$0)));
      return;
    }
    if (this$0.getFragment() != null)
    {
      localLoginManager.logInWithReadPermissions(this$0.getFragment(), LoginButton.LoginButtonProperties.access$700(LoginButton.access$500(this$0)));
      return;
    }
    if (this$0.getNativeFragment() != null)
    {
      localLoginManager.logInWithReadPermissions(this$0.getNativeFragment(), LoginButton.LoginButtonProperties.access$700(LoginButton.access$500(this$0)));
      return;
    }
    localLoginManager.logInWithReadPermissions(LoginButton.access$900(this$0), LoginButton.LoginButtonProperties.access$700(LoginButton.access$500(this$0)));
  }
  
  protected void performLogout(Context paramContext)
  {
    final LoginManager localLoginManager = getLoginManager();
    if (LoginButton.access$1000(this$0))
    {
      String str1 = this$0.getResources().getString(R.string.com_facebook_loginview_log_out_action);
      String str2 = this$0.getResources().getString(R.string.com_facebook_loginview_cancel_action);
      Object localObject = Profile.getCurrentProfile();
      if ((localObject != null) && (((Profile)localObject).getName() != null)) {}
      for (localObject = String.format(this$0.getResources().getString(R.string.com_facebook_loginview_logged_in_as), new Object[] { ((Profile)localObject).getName() });; localObject = this$0.getResources().getString(R.string.com_facebook_loginview_logged_in_using_facebook))
      {
        paramContext = new AlertDialog.Builder(paramContext);
        paramContext.setMessage((CharSequence)localObject).setCancelable(true).setPositiveButton(str1, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            localLoginManager.logOut();
          }
        }).setNegativeButton(str2, null);
        paramContext.create().show();
        return;
      }
    }
    localLoginManager.logOut();
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.widget.LoginButton.LoginClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */