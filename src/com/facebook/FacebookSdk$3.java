package com.facebook;

import android.content.Context;
import com.facebook.appevents.AppEventsLogger;
import java.util.concurrent.Callable;

final class FacebookSdk$3
  implements Callable<Void>
{
  FacebookSdk$3(FacebookSdk.InitializeCallback paramInitializeCallback, Context paramContext) {}
  
  public Void call()
    throws Exception
  {
    AccessTokenManager.getInstance().loadCurrentAccessToken();
    ProfileManager.getInstance().loadCurrentProfile();
    if ((AccessToken.getCurrentAccessToken() != null) && (Profile.getCurrentProfile() == null)) {
      Profile.fetchProfileForCurrentAccessToken();
    }
    if (val$callback != null) {
      val$callback.onInitialized();
    }
    AppEventsLogger.newLogger(val$applicationContext.getApplicationContext()).flush();
    return null;
  }
}

/* Location:
 * Qualified Name:     com.facebook.FacebookSdk.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */