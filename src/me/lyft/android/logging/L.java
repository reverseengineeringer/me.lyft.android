package me.lyft.android.logging;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class L
{
  private static final ILogger log = new ILogger()
  {
    public void d(String paramAnonymousString, Object... paramAnonymousVarArgs)
    {
      Iterator localIterator = L.loggers.iterator();
      while (localIterator.hasNext()) {
        ((ILogger)localIterator.next()).d(paramAnonymousString, paramAnonymousVarArgs);
      }
    }
    
    public void d(Throwable paramAnonymousThrowable, String paramAnonymousString, Object... paramAnonymousVarArgs)
    {
      Iterator localIterator = L.loggers.iterator();
      while (localIterator.hasNext()) {
        ((ILogger)localIterator.next()).d(paramAnonymousThrowable, paramAnonymousString, paramAnonymousVarArgs);
      }
    }
    
    public void e(String paramAnonymousString, Object... paramAnonymousVarArgs)
    {
      Iterator localIterator = L.loggers.iterator();
      while (localIterator.hasNext()) {
        ((ILogger)localIterator.next()).e(paramAnonymousString, paramAnonymousVarArgs);
      }
    }
    
    public void e(Throwable paramAnonymousThrowable, String paramAnonymousString, Object... paramAnonymousVarArgs)
    {
      Iterator localIterator = L.loggers.iterator();
      while (localIterator.hasNext()) {
        ((ILogger)localIterator.next()).e(paramAnonymousThrowable, paramAnonymousString, paramAnonymousVarArgs);
      }
    }
    
    public void i(String paramAnonymousString, Object... paramAnonymousVarArgs)
    {
      Iterator localIterator = L.loggers.iterator();
      while (localIterator.hasNext()) {
        ((ILogger)localIterator.next()).i(paramAnonymousString, paramAnonymousVarArgs);
      }
    }
    
    public void i(Throwable paramAnonymousThrowable, String paramAnonymousString, Object... paramAnonymousVarArgs)
    {
      Iterator localIterator = L.loggers.iterator();
      while (localIterator.hasNext()) {
        ((ILogger)localIterator.next()).i(paramAnonymousThrowable, paramAnonymousString, paramAnonymousVarArgs);
      }
    }
    
    public void v(String paramAnonymousString, Object... paramAnonymousVarArgs)
    {
      Iterator localIterator = L.loggers.iterator();
      while (localIterator.hasNext()) {
        ((ILogger)localIterator.next()).v(paramAnonymousString, paramAnonymousVarArgs);
      }
    }
    
    public void v(Throwable paramAnonymousThrowable, String paramAnonymousString, Object... paramAnonymousVarArgs)
    {
      Iterator localIterator = L.loggers.iterator();
      while (localIterator.hasNext()) {
        ((ILogger)localIterator.next()).v(paramAnonymousThrowable, paramAnonymousString, paramAnonymousVarArgs);
      }
    }
    
    public void w(String paramAnonymousString, Object... paramAnonymousVarArgs)
    {
      Iterator localIterator = L.loggers.iterator();
      while (localIterator.hasNext()) {
        ((ILogger)localIterator.next()).w(paramAnonymousString, paramAnonymousVarArgs);
      }
    }
    
    public void w(Throwable paramAnonymousThrowable, String paramAnonymousString, Object... paramAnonymousVarArgs)
    {
      Iterator localIterator = L.loggers.iterator();
      while (localIterator.hasNext()) {
        ((ILogger)localIterator.next()).w(paramAnonymousThrowable, paramAnonymousString, paramAnonymousVarArgs);
      }
    }
  };
  static final List<ILogger> loggers = new CopyOnWriteArrayList();
  
  public static void add(ILogger paramILogger)
  {
    loggers.add(paramILogger);
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    log.d(paramString, paramVarArgs);
  }
  
  public static void d(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    log.d(paramThrowable, paramString, paramVarArgs);
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    log.e(paramString, paramVarArgs);
  }
  
  public static void e(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    log.e(paramThrowable, paramString, paramVarArgs);
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    log.i(paramString, paramVarArgs);
  }
  
  public static void i(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    log.i(paramThrowable, paramString, paramVarArgs);
  }
  
  public static void remove(ILogger paramILogger)
  {
    int i = 0;
    int j = loggers.size();
    while (i < j)
    {
      if (loggers.get(i) == paramILogger)
      {
        loggers.remove(i);
        return;
      }
      i += 1;
    }
    throw new IllegalArgumentException("Cannot remove log that was not added: " + paramILogger);
  }
  
  public static void removeAll()
  {
    loggers.clear();
  }
  
  public static void v(String paramString, Object... paramVarArgs)
  {
    log.v(paramString, paramVarArgs);
  }
  
  public static void v(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    log.v(paramThrowable, paramString, paramVarArgs);
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    log.w(paramString, paramVarArgs);
  }
  
  public static void w(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    log.w(paramThrowable, paramString, paramVarArgs);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.logging.L
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */