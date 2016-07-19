package com.appboy.support;

import android.content.Context;
import com.appboy.Constants;

public class PermissionUtils
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, PermissionUtils.class.getName() });
  
  public static boolean hasPermission(Context paramContext, String paramString)
  {
    try
    {
      int i = paramContext.checkCallingOrSelfPermission(paramString);
      return i == 0;
    }
    catch (Throwable paramContext)
    {
      AppboyLogger.e(a, String.format("Failure checking permission %s", new Object[] { paramString }), paramContext);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.appboy.support.PermissionUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */