package com.appboy.support;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BundleUtils
{
  public static Bundle mapToBundle(Map<String, String> paramMap)
  {
    Bundle localBundle = new Bundle();
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localBundle.putString((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    return localBundle;
  }
}

/* Location:
 * Qualified Name:     com.appboy.support.BundleUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */