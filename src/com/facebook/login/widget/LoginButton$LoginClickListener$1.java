package com.facebook.login.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.login.LoginManager;

class LoginButton$LoginClickListener$1
  implements DialogInterface.OnClickListener
{
  LoginButton$LoginClickListener$1(LoginButton.LoginClickListener paramLoginClickListener, LoginManager paramLoginManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    val$loginManager.logOut();
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.widget.LoginButton.LoginClickListener.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */