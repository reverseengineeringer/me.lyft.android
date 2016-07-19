package com.appboy.ui.support;

import android.net.Uri;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UriUtils
{
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, UriUtils.class.getName() });
  
  public static Map<String, String> getQueryParameters(Uri paramUri)
  {
    if (paramUri.isOpaque())
    {
      AppboyLogger.d(TAG, "URI is not hierarchical. There are no query parameters to parse.");
      return Collections.emptyMap();
    }
    paramUri = paramUri.getEncodedQuery();
    if (paramUri == null) {
      return Collections.emptyMap();
    }
    HashMap localHashMap = new HashMap();
    int j = 0;
    int i = paramUri.indexOf('&', j);
    if (i == -1) {
      i = paramUri.length();
    }
    for (;;)
    {
      int m = paramUri.indexOf('=', j);
      int k;
      if (m <= i)
      {
        k = m;
        if (m != -1) {}
      }
      else
      {
        k = i;
      }
      if (i > j)
      {
        String str1 = paramUri.substring(j, k);
        String str2 = paramUri.substring(k + 1, i);
        localHashMap.put(Uri.decode(str1), Uri.decode(str2));
      }
      i += 1;
      j = i;
      if (i < paramUri.length()) {
        break;
      }
      return Collections.unmodifiableMap(localHashMap);
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.support.UriUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */