package bo.app;

import com.appboy.Constants;
import com.appboy.support.AppboyLogger;

public class cq<T>
{
  private static final String c = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, cq.class.getName() });
  volatile boolean a = false;
  volatile boolean b = false;
  private T d;
  private final Object e = new Object();
  
  public cq(T paramT, boolean paramBoolean)
  {
    b = paramBoolean;
    d = paramT;
  }
  
  public final T a()
  {
    try
    {
      Object localObject1 = d;
      return (T)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public final void a(T paramT)
  {
    try
    {
      d = paramT;
      return;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  public final void b()
  {
    synchronized (e)
    {
      if (a) {
        AppboyLogger.e(c, "Warning: called dispatch() on field already in dispatch.  Please report this to Appboy.");
      }
      a = true;
      return;
    }
  }
  
  public final void c()
  {
    synchronized (e)
    {
      a = false;
      if (b) {
        AppboyLogger.e(c, "Erroneously got processSuccessfulDispatch call in DispatchOnceField with mHasSentSuccessfully already true. Please report this to Appboy.");
      }
      b = true;
      return;
    }
  }
  
  public final void d()
  {
    synchronized (e)
    {
      a = false;
      if (b) {
        AppboyLogger.e(c, "Erroneously got processFailedDispatch call in DispatchOnceField with mHasSentSuccessfully already true. Please report this to Appboy.");
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.cq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */