package com.facebook.appevents;

import com.facebook.FacebookSdk;

final class AppEventsLogger$PersistedAppSessionInfo$1
  implements Runnable
{
  public void run()
  {
    AppEventsLogger.PersistedAppSessionInfo.saveAppSessionInformation(FacebookSdk.getApplicationContext());
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.AppEventsLogger.PersistedAppSessionInfo.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */