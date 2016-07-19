package bo.app;

import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import java.util.Collection;
import java.util.Collections;

public class ew
  implements ez
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, ew.class.getName() });
  private final ez b;
  private final bd c;
  
  public ew(ez paramez, bd parambd)
  {
    b = paramez;
    c = parambd;
  }
  
  private static void a(bd parambd, Throwable paramThrowable)
  {
    try
    {
      parambd.a(new bp("A database exception has occurred. Please view the stack trace for more details.", paramThrowable), bp.class);
      return;
    }
    catch (Exception parambd)
    {
      AppboyLogger.e(a, "Failed to log throwable.", parambd);
    }
  }
  
  public final cx a()
  {
    try
    {
      cx localcx = b.a();
      return localcx;
    }
    catch (Exception localException)
    {
      AppboyLogger.e(a, "Failed to get the active session from the storage.", localException);
      a(c, localException);
    }
    return null;
  }
  
  public final void a(cx paramcx)
  {
    try
    {
      b.a(paramcx);
      return;
    }
    catch (Exception paramcx)
    {
      AppboyLogger.e(a, "Failed to upsert active session in the storage.", paramcx);
      a(c, paramcx);
    }
  }
  
  public final void a(cx paramcx, cs paramcs)
  {
    try
    {
      b.a(paramcx, paramcs);
      return;
    }
    catch (Exception paramcx)
    {
      AppboyLogger.e(a, "Failed to add single event to session due to unexpected exception.", paramcx);
      a(c, paramcx);
    }
  }
  
  public final Collection<cx> b()
  {
    try
    {
      Collection localCollection = b.b();
      return localCollection;
    }
    catch (Exception localException)
    {
      AppboyLogger.e(a, "Failed to fetch all sealed sessions from the storage.", localException);
      a(c, localException);
    }
    return Collections.EMPTY_LIST;
  }
  
  public final void b(cx paramcx)
  {
    try
    {
      b.b(paramcx);
      return;
    }
    catch (Exception paramcx)
    {
      AppboyLogger.e(a, "Failed to delete the sealed session from the storage.", paramcx);
      a(c, paramcx);
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.ew
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */