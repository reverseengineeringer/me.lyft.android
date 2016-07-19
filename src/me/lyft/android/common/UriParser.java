package me.lyft.android.common;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class UriParser
{
  private static final String ENCODING = "UTF-8";
  
  public static boolean isLyftUri(String paramString)
  {
    return "lyft".equals(parseScheme(paramString));
  }
  
  public static boolean isWebUri(String paramString)
  {
    paramString = parseScheme(paramString);
    return ("http".equals(paramString)) || ("https".equals(paramString));
  }
  
  public static Map<String, String> parseParams(String paramString)
  {
    if (paramString.isEmpty()) {
      paramString = Collections.emptyMap();
    }
    String[] arrayOfString;
    HashMap localHashMap;
    int j;
    int i;
    do
    {
      return paramString;
      arrayOfString = paramString.split("&");
      localHashMap = new HashMap(arrayOfString.length);
      j = arrayOfString.length;
      i = 0;
      paramString = localHashMap;
    } while (i >= j);
    for (paramString = arrayOfString[i];; paramString = null)
    {
      try
      {
        paramString = paramString.split("=");
        String str = URLDecoder.decode(paramString[0], "UTF-8");
        if (paramString.length <= 1) {
          continue;
        }
        paramString = URLDecoder.decode(paramString[1], "UTF-8");
        localHashMap.put(str, paramString);
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;) {}
      }
      i += 1;
      break;
    }
  }
  
  public static Map<String, String> parseParamsFromUri(String paramString)
  {
    paramString = paramString.split("\\?");
    if (paramString.length <= 1) {
      return Collections.emptyMap();
    }
    return parseParams(paramString[1]);
  }
  
  public static String parseScheme(String paramString)
  {
    int i = paramString.indexOf(':');
    if (i == -1) {
      return null;
    }
    return paramString.substring(0, i);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.UriParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */