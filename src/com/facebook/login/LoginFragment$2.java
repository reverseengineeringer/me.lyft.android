package com.facebook.login;

import android.view.View;
import com.facebook.R.id;

class LoginFragment$2
  implements LoginClient.BackgroundProcessingListener
{
  LoginFragment$2(LoginFragment paramLoginFragment, View paramView) {}
  
  public void onBackgroundProcessingStarted()
  {
    val$view.findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(0);
  }
  
  public void onBackgroundProcessingStopped()
  {
    val$view.findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(8);
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.LoginFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */