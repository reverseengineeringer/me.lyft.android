package me.lyft.android.logging;

import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.lyft.android.common.Strings;

public class AndroidLogger
  implements ILogger
{
  private static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");
  private static final int CALL_STACK_INDEX = 5;
  private static final int MAX_LOG_LENGTH = 4000;
  
  static String createStackElementTag(StackTraceElement paramStackTraceElement)
  {
    paramStackTraceElement = paramStackTraceElement.getClassName();
    Matcher localMatcher = ANONYMOUS_CLASS.matcher(paramStackTraceElement);
    if (localMatcher.find()) {
      paramStackTraceElement = localMatcher.replaceAll("");
    }
    return paramStackTraceElement.substring(paramStackTraceElement.lastIndexOf('.') + 1);
  }
  
  static String createTag()
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    if (arrayOfStackTraceElement.length <= 5) {
      throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
    }
    return createStackElementTag(arrayOfStackTraceElement[5]);
  }
  
  private void logMessage(int paramInt, String paramString, Throwable paramThrowable)
  {
    String str;
    if ((paramString == null) || (paramString.length() == 0)) {
      if (paramThrowable != null)
      {
        str = Log.getStackTraceString(paramThrowable);
        paramString = createTag();
        if (str.length() >= 4000) {
          break label83;
        }
        Log.println(paramInt, paramString, str);
      }
    }
    for (;;)
    {
      return;
      str = paramString;
      if (paramThrowable == null) {
        break;
      }
      str = paramString + "\n" + Log.getStackTraceString(paramThrowable);
      break;
      label83:
      paramThrowable = str.split("\n");
      int j = paramThrowable.length;
      int i = 0;
      while (i < j)
      {
        Log.println(paramInt, paramString, paramThrowable[i]);
        i += 1;
      }
    }
  }
  
  public void d(String paramString, Object... paramVarArgs)
  {
    logMessage(3, Strings.formatString(paramString, paramVarArgs), null);
  }
  
  public void d(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    logMessage(3, Strings.formatString(paramString, paramVarArgs), paramThrowable);
  }
  
  public void e(String paramString, Object... paramVarArgs)
  {
    logMessage(6, Strings.formatString(paramString, paramVarArgs), null);
  }
  
  public void e(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    logMessage(6, Strings.formatString(paramString, paramVarArgs), paramThrowable);
  }
  
  public void i(String paramString, Object... paramVarArgs)
  {
    logMessage(4, Strings.formatString(paramString, paramVarArgs), null);
  }
  
  public void i(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    logMessage(4, Strings.formatString(paramString, paramVarArgs), paramThrowable);
  }
  
  public void v(String paramString, Object... paramVarArgs)
  {
    logMessage(2, Strings.formatString(paramString, paramVarArgs), null);
  }
  
  public void v(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    logMessage(2, Strings.formatString(paramString, paramVarArgs), paramThrowable);
  }
  
  public void w(String paramString, Object... paramVarArgs)
  {
    logMessage(5, Strings.formatString(paramString, paramVarArgs), null);
  }
  
  public void w(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    logMessage(5, Strings.formatString(paramString, paramVarArgs), paramThrowable);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.logging.AndroidLogger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */