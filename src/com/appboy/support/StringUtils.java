package com.appboy.support;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.appboy.Constants;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import org.json.JSONArray;

public final class StringUtils
{
  public static final String EMPTY_STRING = "";
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, StringUtils.class.getName() });
  
  public static String MD5(String paramString)
  {
    try
    {
      paramString = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
      StringBuffer localStringBuffer = new StringBuffer();
      int i = 0;
      while (i < paramString.length)
      {
        localStringBuffer.append(Integer.toHexString(paramString[i] & 0xFF | 0x100).substring(1, 3));
        i += 1;
      }
      paramString = localStringBuffer.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      AppboyLogger.i(a, "Failed to calculate MD5 hash", paramString);
    }
    return null;
  }
  
  public static String checkNotNullOrEmpty(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("Provided String must be non-null.");
    }
    if (paramString.length() == 0) {
      throw new IllegalArgumentException("Provided String must be non-empty.");
    }
    return paramString;
  }
  
  public static int countOccurrences(String paramString1, String paramString2)
  {
    return paramString1.split(paramString2, -1).length - 1;
  }
  
  public static String emptyToNull(String paramString)
  {
    String str = paramString;
    if (paramString.trim().equals("")) {
      str = null;
    }
    return str;
  }
  
  public static String getCacheFileSuffix(String paramString1, String paramString2)
  {
    if (paramString1 == null) {}
    for (Object localObject = "null";; localObject = paramString1.toString())
    {
      String str = MD5((String)localObject);
      localObject = str;
      if (str == null) {
        localObject = Integer.toString(paramString1.hashCode());
      }
      return "." + (String)localObject + "." + paramString2;
    }
  }
  
  public static String getOptionalStringResource(Resources paramResources, int paramInt, String paramString)
  {
    try
    {
      paramResources = paramResources.getString(paramInt);
      return paramResources;
    }
    catch (Resources.NotFoundException paramResources) {}
    return paramString;
  }
  
  public static boolean isNullOrBlank(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
  
  public static boolean isNullOrEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static String join(Collection<String> paramCollection, String paramString)
  {
    if (paramCollection == null) {
      return "";
    }
    return join((String[])paramCollection.toArray(new String[paramCollection.size()]), paramString);
  }
  
  public static String join(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString == null) || (paramString == null)) {
      paramArrayOfString = "";
    }
    Object localObject;
    do
    {
      do
      {
        return paramArrayOfString;
        localObject = new StringBuilder();
        int j = paramArrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = paramArrayOfString[i];
          if (str != null) {
            ((StringBuilder)localObject).append(str).append(paramString);
          }
          i += 1;
        }
        localObject = ((StringBuilder)localObject).toString();
        paramArrayOfString = (String[])localObject;
      } while (localObject == null);
      paramArrayOfString = (String[])localObject;
    } while (!((String)localObject).endsWith(paramString));
    return ((String)localObject).substring(0, ((String)localObject).length() - paramString.length());
  }
  
  public static HashSet<String> jsonArrayToHashSet(JSONArray paramJSONArray)
  {
    HashSet localHashSet = new HashSet();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        localHashSet.add(paramJSONArray.get(i).toString());
        i += 1;
      }
    }
    return localHashSet;
  }
  
  public static HashSet<String> stringArrayToHashSet(String[] paramArrayOfString)
  {
    return new HashSet(Arrays.asList(paramArrayOfString));
  }
  
  public static String stringArrayToJsonString(String[] paramArrayOfString)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramArrayOfString == null) {
      return null;
    }
    if (paramArrayOfString.length == 0) {
      return "[]";
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localJSONArray.put(paramArrayOfString[i]);
      i += 1;
    }
    return localJSONArray.toString();
  }
}

/* Location:
 * Qualified Name:     com.appboy.support.StringUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */