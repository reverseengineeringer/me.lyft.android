package me.lyft.android.gcm;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import me.lyft.android.common.Strings;

public class GcmEventExecutor
  implements IGcmEventExecutor
{
  static final String EVENT_PARAM = "event";
  private Map<String, GcmEventHandler> gcmEventMap = new HashMap();
  
  public GcmEventExecutor(GcmEventHandler... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      GcmEventHandler localGcmEventHandler = paramVarArgs[i];
      String str = localGcmEventHandler.getEventName();
      if (gcmEventMap.containsKey(str)) {
        throw new IllegalArgumentException(String.format("GcmEventHandler {%s} is already registered with GcmEventExecutor. Failing.", new Object[] { str }));
      }
      gcmEventMap.put(str, localGcmEventHandler);
      i += 1;
    }
  }
  
  public void handleEvent(Context paramContext, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("event");
    if ((!Strings.isNullOrEmpty(str)) && (gcmEventMap.containsKey(str))) {
      ((GcmEventHandler)gcmEventMap.get(str)).execute(paramContext, paramMap);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.gcm.GcmEventExecutor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */