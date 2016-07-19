package com.facebook.login;

import android.content.Context;
import com.facebook.FacebookSdk;

class LoginManager$LoginLoggerHolder
{
  private static volatile LoginLogger logger;
  
  private static LoginLogger getLogger(Context paramContext)
  {
    if (paramContext != null) {
      if (paramContext != null) {
        break label25;
      }
    }
    for (paramContext = null;; paramContext = logger)
    {
      return paramContext;
      label25:
      try
      {
        paramContext = FacebookSdk.getApplicationContext();
        break;
      }
      finally {}
      if (logger == null) {
        logger = new LoginLogger(paramContext, FacebookSdk.getApplicationId());
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.LoginManager.LoginLoggerHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */