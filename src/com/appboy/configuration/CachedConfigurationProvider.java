package com.appboy.configuration;

import android.content.Context;
import android.content.res.Resources;
import com.appboy.Constants;
import com.appboy.support.PackageUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CachedConfigurationProvider
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, CachedConfigurationProvider.class.getName() });
  private final Context b;
  protected final Map<String, Object> mConfigurationCache;
  
  public CachedConfigurationProvider(Context paramContext)
  {
    b = paramContext;
    mConfigurationCache = Collections.synchronizedMap(new HashMap());
  }
  
  protected boolean getBooleanValue(String paramString, boolean paramBoolean)
  {
    if (mConfigurationCache.containsKey(paramString)) {
      return ((Boolean)mConfigurationCache.get(paramString)).booleanValue();
    }
    paramBoolean = readBooleanResourceValue(paramString, paramBoolean);
    mConfigurationCache.put(paramString, Boolean.valueOf(paramBoolean));
    return paramBoolean;
  }
  
  public int getIntValue(String paramString, int paramInt)
  {
    if (mConfigurationCache.containsKey(paramString)) {
      return ((Integer)mConfigurationCache.get(paramString)).intValue();
    }
    paramInt = readIntegerResourceValue(paramString, paramInt);
    mConfigurationCache.put(paramString, Integer.valueOf(paramInt));
    return paramInt;
  }
  
  protected String getStringValue(String paramString1, String paramString2)
  {
    if (mConfigurationCache.containsKey(paramString1)) {
      return (String)mConfigurationCache.get(paramString1);
    }
    paramString2 = readStringResourceValue(paramString1, paramString2);
    mConfigurationCache.put(paramString1, paramString2);
    return paramString2;
  }
  
  protected boolean readBooleanResourceValue(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return paramBoolean;
    }
    int i;
    try
    {
      i = b.getResources().getIdentifier(paramString, "bool", PackageUtils.getResourcePackageName(b));
      if (i == 0)
      {
        String str1 = a;
        String.format("Unable to find the boolean configuration value with key %s. Using default value '%b'.", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        return paramBoolean;
      }
    }
    catch (Exception localException)
    {
      String str2 = a;
      String.format("Unexpected exception retrieving the boolean configuration value with key %s. Using default value '%b'.", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      return paramBoolean;
    }
    boolean bool = b.getResources().getBoolean(i);
    return bool;
  }
  
  protected int readIntegerResourceValue(String paramString, int paramInt)
  {
    if (paramString == null) {
      return paramInt;
    }
    try
    {
      i = b.getResources().getIdentifier(paramString, "integer", PackageUtils.getResourcePackageName(b));
      if (i == 0)
      {
        String str1 = a;
        String.format("Unable to find the integer configuration value with key %s. Using default value '%d'.", new Object[] { paramString, Integer.valueOf(paramInt) });
        return paramInt;
      }
    }
    catch (Exception localException)
    {
      String str2 = a;
      String.format("Unexpected exception retrieving the integer configuration value with key %s. Using default value '%d'.", new Object[] { paramString, Integer.valueOf(paramInt) });
      return paramInt;
    }
    int i = b.getResources().getInteger(i);
    return i;
  }
  
  protected String[] readStringArrayResourceValue(String paramString, String[] paramArrayOfString)
  {
    if (paramString == null) {
      return paramArrayOfString;
    }
    int i;
    try
    {
      i = b.getResources().getIdentifier(paramString, "array", PackageUtils.getResourcePackageName(b));
      if (i == 0)
      {
        String str = a;
        String.format("Unable to find the string array configuration value with key %s. Using default value '%s'.", new Object[] { paramString, Arrays.toString(paramArrayOfString) });
        return paramArrayOfString;
      }
    }
    catch (Exception localException)
    {
      localObject = a;
      String.format("Unexpected exception retrieving the string array configuration value with key %s. Using default value '%s'.", new Object[] { paramString, Arrays.toString(paramArrayOfString) });
      return paramArrayOfString;
    }
    Object localObject = b.getResources().getStringArray(i);
    return (String[])localObject;
  }
  
  protected String readStringResourceValue(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2;
    }
    int i;
    try
    {
      i = b.getResources().getIdentifier(paramString1, "string", PackageUtils.getResourcePackageName(b));
      if (i == 0)
      {
        String str1 = a;
        String.format("Unable to find the boolean configuration value with key %s. Using default value '%s'.", new Object[] { paramString1, paramString2 });
        return paramString2;
      }
    }
    catch (Exception localException)
    {
      str2 = a;
      String.format("Unexpected exception retrieving the string configuration value with key %s. Using default value '%s'.", new Object[] { paramString1, paramString2 });
      return paramString2;
    }
    String str2 = b.getResources().getString(i);
    return str2;
  }
}

/* Location:
 * Qualified Name:     com.appboy.configuration.CachedConfigurationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */