package com.facebook.login;

import android.content.Intent;
import com.facebook.FacebookCallback;
import com.facebook.internal.CallbackManagerImpl.Callback;

class LoginManager$1
  implements CallbackManagerImpl.Callback
{
  LoginManager$1(LoginManager paramLoginManager, FacebookCallback paramFacebookCallback) {}
  
  public boolean onActivityResult(int paramInt, Intent paramIntent)
  {
    return this$0.onActivityResult(paramInt, paramIntent, val$callback);
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.LoginManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */