package me.lyft.android.logging;

import me.lyft.android.analytics.studies.AppAnalytics;
import me.lyft.android.common.Strings;

public class AnalyticsLogger
  implements ILogger
{
  static void trackError(String paramString, Object... paramVarArgs)
  {
    try
    {
      AppAnalytics.trackAppError(AndroidLogger.createTag(), Strings.formatString(paramString, paramVarArgs));
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void d(String paramString, Object... paramVarArgs) {}
  
  public void d(Throwable paramThrowable, String paramString, Object... paramVarArgs) {}
  
  public void e(String paramString, Object... paramVarArgs)
  {
    trackError(paramString, paramVarArgs);
  }
  
  public void e(Throwable paramThrowable, String paramString, Object... paramVarArgs) {}
  
  public void i(String paramString, Object... paramVarArgs) {}
  
  public void i(Throwable paramThrowable, String paramString, Object... paramVarArgs) {}
  
  public void v(String paramString, Object... paramVarArgs) {}
  
  public void v(Throwable paramThrowable, String paramString, Object... paramVarArgs) {}
  
  public void w(String paramString, Object... paramVarArgs) {}
  
  public void w(Throwable paramThrowable, String paramString, Object... paramVarArgs) {}
}

/* Location:
 * Qualified Name:     me.lyft.android.logging.AnalyticsLogger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */