package com.facebook.appevents.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import java.util.Locale;

class SessionLogger
{
  private static final long[] INACTIVE_SECONDS_QUANTA = { 300000L, 900000L, 1800000L, 3600000L, 21600000L, 43200000L, 86400000L, 172800000L, 259200000L, 604800000L, 1209600000L, 1814400000L, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L };
  private static final String TAG = SessionLogger.class.getCanonicalName();
  
  private static int getQuantaIndex(long paramLong)
  {
    int i = 0;
    while ((i < INACTIVE_SECONDS_QUANTA.length) && (INACTIVE_SECONDS_QUANTA[i] < paramLong)) {
      i += 1;
    }
    return i;
  }
  
  public static void logActivateApp(Context paramContext, String paramString1, SourceApplicationInfo paramSourceApplicationInfo, String paramString2)
  {
    if (paramSourceApplicationInfo != null) {}
    for (paramContext = paramSourceApplicationInfo.toString();; paramContext = "Unclassified")
    {
      paramSourceApplicationInfo = new Bundle();
      paramSourceApplicationInfo.putString("fb_mobile_launch_source", paramContext);
      new InternalAppEventsLogger(paramString1, paramString2, null).logEvent("fb_mobile_activate_app", paramSourceApplicationInfo);
      return;
    }
  }
  
  private static void logClockSkewEvent()
  {
    Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
  }
  
  public static void logDeactivateApp(Context paramContext, String paramString1, SessionInfo paramSessionInfo, String paramString2)
  {
    paramContext = Long.valueOf(paramSessionInfo.getDiskRestoreTime() - paramSessionInfo.getSessionLastEventTime().longValue());
    Object localObject1 = paramContext;
    if (paramContext.longValue() < 0L)
    {
      localObject1 = Long.valueOf(0L);
      logClockSkewEvent();
    }
    Object localObject2 = Long.valueOf(paramSessionInfo.getSessionLength());
    paramContext = (Context)localObject2;
    if (((Long)localObject2).longValue() < 0L)
    {
      logClockSkewEvent();
      paramContext = Long.valueOf(0L);
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("fb_mobile_app_interruptions", paramSessionInfo.getInterruptionCount());
    ((Bundle)localObject2).putString("fb_mobile_time_between_sessions", String.format(Locale.ROOT, "session_quanta_%d", new Object[] { Integer.valueOf(getQuantaIndex(((Long)localObject1).longValue())) }));
    localObject1 = paramSessionInfo.getSourceApplicationInfo();
    if (localObject1 != null) {}
    for (localObject1 = ((SourceApplicationInfo)localObject1).toString();; localObject1 = "Unclassified")
    {
      ((Bundle)localObject2).putString("fb_mobile_launch_source", (String)localObject1);
      ((Bundle)localObject2).putLong("_logTime", paramSessionInfo.getSessionLastEventTime().longValue() / 1000L);
      new InternalAppEventsLogger(paramString1, paramString2, null).logEvent("fb_mobile_deactivate_app", paramContext.longValue() / 1000L, (Bundle)localObject2);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.internal.SessionLogger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */