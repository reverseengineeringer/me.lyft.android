package bo.app;

import com.appboy.Constants;
import com.appboy.support.AppboyLogger;

public abstract class en<T>
{
  private static final String b = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, en.class.getName() });
  private final Object a = new Object();
  private boolean c = false;
  
  abstract T a();
  
  abstract void a(T paramT);
  
  public final T b()
  {
    synchronized (a)
    {
      if (c)
      {
        AppboyLogger.i(b, "Received call to export dirty object, but the cache was already locked.");
        return null;
      }
      c = true;
      Object localObject2 = a();
      return (T)localObject2;
    }
  }
  
  public final boolean b(T paramT)
  {
    synchronized (a)
    {
      if (!c)
      {
        AppboyLogger.w(b, String.format("Tried to confirm [%s], but the cache wasn't locked, so not doing anything.", new Object[] { String.valueOf(paramT) }));
        return false;
      }
      a(paramT);
      c = false;
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.en
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */