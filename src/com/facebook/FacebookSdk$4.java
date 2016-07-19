package com.facebook;

import android.content.Context;

final class FacebookSdk$4
  implements Runnable
{
  FacebookSdk$4(Context paramContext, String paramString) {}
  
  public void run()
  {
    FacebookSdk.publishInstallAndWaitForResponse(val$applicationContext, val$applicationId);
  }
}

/* Location:
 * Qualified Name:     com.facebook.FacebookSdk.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */