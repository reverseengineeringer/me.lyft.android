package me.lyft.android.logging;

import java.util.Iterator;
import java.util.List;

final class L$1
  implements ILogger
{
  public void d(String paramString, Object... paramVarArgs)
  {
    Iterator localIterator = L.loggers.iterator();
    while (localIterator.hasNext()) {
      ((ILogger)localIterator.next()).d(paramString, paramVarArgs);
    }
  }
  
  public void d(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    Iterator localIterator = L.loggers.iterator();
    while (localIterator.hasNext()) {
      ((ILogger)localIterator.next()).d(paramThrowable, paramString, paramVarArgs);
    }
  }
  
  public void e(String paramString, Object... paramVarArgs)
  {
    Iterator localIterator = L.loggers.iterator();
    while (localIterator.hasNext()) {
      ((ILogger)localIterator.next()).e(paramString, paramVarArgs);
    }
  }
  
  public void e(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    Iterator localIterator = L.loggers.iterator();
    while (localIterator.hasNext()) {
      ((ILogger)localIterator.next()).e(paramThrowable, paramString, paramVarArgs);
    }
  }
  
  public void i(String paramString, Object... paramVarArgs)
  {
    Iterator localIterator = L.loggers.iterator();
    while (localIterator.hasNext()) {
      ((ILogger)localIterator.next()).i(paramString, paramVarArgs);
    }
  }
  
  public void i(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    Iterator localIterator = L.loggers.iterator();
    while (localIterator.hasNext()) {
      ((ILogger)localIterator.next()).i(paramThrowable, paramString, paramVarArgs);
    }
  }
  
  public void v(String paramString, Object... paramVarArgs)
  {
    Iterator localIterator = L.loggers.iterator();
    while (localIterator.hasNext()) {
      ((ILogger)localIterator.next()).v(paramString, paramVarArgs);
    }
  }
  
  public void v(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    Iterator localIterator = L.loggers.iterator();
    while (localIterator.hasNext()) {
      ((ILogger)localIterator.next()).v(paramThrowable, paramString, paramVarArgs);
    }
  }
  
  public void w(String paramString, Object... paramVarArgs)
  {
    Iterator localIterator = L.loggers.iterator();
    while (localIterator.hasNext()) {
      ((ILogger)localIterator.next()).w(paramString, paramVarArgs);
    }
  }
  
  public void w(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    Iterator localIterator = L.loggers.iterator();
    while (localIterator.hasNext()) {
      ((ILogger)localIterator.next()).w(paramThrowable, paramString, paramVarArgs);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.logging.L.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */