package com.facebook.appevents;

final class AppEventQueue$6
  implements Runnable
{
  AppEventQueue$6(AccessTokenAppIdPair paramAccessTokenAppIdPair, SessionEventsState paramSessionEventsState) {}
  
  public void run()
  {
    AppEventStore.persistEvents(val$accessTokenAppId, val$appEvents);
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.AppEventQueue.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */