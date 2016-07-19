package com.facebook.appevents;

import com.facebook.internal.Utility;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class AppEventsLogger$3
  implements Runnable
{
  public void run()
  {
    Object localObject = new HashSet();
    Iterator localIterator = AppEventQueue.getKeySet().iterator();
    while (localIterator.hasNext()) {
      ((Set)localObject).add(((AccessTokenAppIdPair)localIterator.next()).getApplicationId());
    }
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      Utility.queryAppSettings((String)((Iterator)localObject).next(), true);
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.AppEventsLogger.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */