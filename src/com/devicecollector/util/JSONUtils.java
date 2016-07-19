package com.devicecollector.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class JSONUtils
{
  public static String JSONifyMap(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("{");
      int i = 1;
      Iterator localIterator = paramMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (i == 0) {
          localStringBuffer.append(", ");
        }
        for (;;)
        {
          localStringBuffer.append("\"" + str + "\":\"" + (String)paramMap.get(str) + "\"");
          break;
          i = 0;
        }
      }
      localStringBuffer.append("}");
      return localStringBuffer.toString();
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.devicecollector.util.JSONUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */