package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class WrapperHelper
{
  private static final String TAG = StringUtils.getLogTag(WrapperHelper.class);
  
  static Class getClass(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      return localClass;
    }
    catch (ClassNotFoundException paramString)
    {
      Log.d(TAG, "getClass failed:", paramString);
      return null;
    }
    catch (Exception localException)
    {
      Log.e(TAG, paramString + " getClass failed: ", localException);
    }
    return null;
  }
  
  static Field getField(Class paramClass, String paramString)
  {
    if (paramClass == null) {
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      return null;
    }
    catch (Exception paramClass) {}
    return null;
  }
  
  static Method getMethod(Class paramClass, String paramString, Class... paramVarArgs)
  {
    if (paramClass == null) {
      return null;
    }
    try
    {
      paramClass = paramClass.getMethod(paramString, paramVarArgs);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      return null;
    }
    catch (Exception paramClass) {}
    return null;
  }
  
  static Object getValue(Object paramObject, Field paramField)
  {
    if ((paramObject == null) || (paramField == null)) {
      return null;
    }
    try
    {
      paramObject = paramField.get(paramObject);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      return null;
    }
    catch (IllegalArgumentException paramObject)
    {
      return null;
    }
    catch (Exception paramObject) {}
    return null;
  }
  
  static <T> T invoke(Object paramObject, Method paramMethod, Object... paramVarArgs)
  {
    Object localObject = null;
    if (paramMethod != null)
    {
      int i = 0;
      try
      {
        paramObject = paramMethod.invoke(paramObject, paramVarArgs);
        if (i == 0) {
          return (T)paramObject;
        }
      }
      catch (ClassCastException paramObject)
      {
        for (;;)
        {
          Log.e(TAG, paramMethod.getName() + " invoke failed: ", (Throwable)paramObject);
          i = 1;
          paramObject = localObject;
        }
      }
      catch (IllegalAccessException paramObject)
      {
        for (;;)
        {
          Log.e(TAG, paramMethod.getName() + " invoke failed: ", (Throwable)paramObject);
          i = 1;
          paramObject = localObject;
        }
      }
      catch (IllegalArgumentException paramObject)
      {
        for (;;)
        {
          Log.e(TAG, paramMethod.getName() + " invoke failed: ", (Throwable)paramObject);
          i = 1;
          paramObject = localObject;
        }
      }
      catch (InvocationTargetException paramObject)
      {
        for (;;)
        {
          Log.e(TAG, paramMethod.getName() + " invoke failed: ", (Throwable)paramObject);
          i = 1;
          paramObject = localObject;
        }
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          Log.e(TAG, paramMethod.getName() + " invoke failed: ", (Throwable)paramObject);
          i = 1;
          paramObject = localObject;
        }
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.WrapperHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */