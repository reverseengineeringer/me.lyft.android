package me.lyft.android.common;

import java.io.IOException;
import java.io.InterruptedIOException;

public class ExceptionUtils
{
  @SafeVarargs
  public static boolean isAssignableFrom(Throwable paramThrowable, Class<? extends Throwable>... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if (paramVarArgs[i].isAssignableFrom(paramThrowable.getClass())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean isInterruptedException(Throwable paramThrowable)
  {
    if (paramThrowable.getCause() == null) {}
    for (;;)
    {
      return isAssignableFrom(paramThrowable, new Class[] { InterruptedException.class, InterruptedIOException.class });
      paramThrowable = paramThrowable.getCause();
    }
  }
  
  public static boolean isNetworkException(Throwable paramThrowable)
  {
    return isAssignableFrom(paramThrowable, new Class[] { IOException.class });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.ExceptionUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */