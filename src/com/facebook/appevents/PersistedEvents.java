package com.facebook.appevents;

import java.util.HashMap;
import java.util.List;

public class PersistedEvents
  extends HashMap<AccessTokenAppIdPair, List<AppEvent>>
{
  public PersistedEvents() {}
  
  public PersistedEvents(HashMap<AccessTokenAppIdPair, List<AppEvent>> paramHashMap)
  {
    super(paramHashMap);
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.PersistedEvents
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */