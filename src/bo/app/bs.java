package bo.app;

import com.appboy.Constants;
import com.appboy.support.AppboyLogger;

public class bs
  implements Thread.UncaughtExceptionHandler
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, bs.class.getName() });
  private final bd b;
  
  public bs(bd parambd)
  {
    b = parambd;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      AppboyLogger.w(a, "Uncaught exception from thread. Publishing as Throwable event", paramThrowable);
      b.a(paramThrowable, Throwable.class);
      return;
    }
    catch (Exception paramThread)
    {
      AppboyLogger.w(a, "Failed to log throwable.", paramThread);
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.bs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */