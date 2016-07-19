package com.leanplum;

import android.content.res.Configuration;
import android.util.DisplayMetrics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class at
  extends aI
{
  public final Object a(String paramString)
  {
    if (paramString.equals("ldpi")) {
      return Integer.valueOf(120);
    }
    if (paramString.equals("mdpi")) {
      return Integer.valueOf(160);
    }
    if (paramString.equals("hdpi")) {
      return Integer.valueOf(240);
    }
    if (paramString.equals("xhdpi")) {
      return Integer.valueOf(320);
    }
    if (paramString.equals("nodpi")) {
      return Integer.valueOf(0);
    }
    if (paramString.equals("tvdpi")) {
      return Integer.valueOf(213);
    }
    if (paramString.equals("xxhigh")) {
      return Integer.valueOf(480);
    }
    return null;
  }
  
  final Map<String, Object> a(Map<String, Object> paramMap, DisplayMetrics paramDisplayMetrics)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = paramMap.keySet().iterator();
    int i = Integer.MAX_VALUE;
    if (!((Iterator)localObject1).hasNext()) {
      if (localHashMap.size() == 0)
      {
        i = Integer.MIN_VALUE;
        paramDisplayMetrics = paramMap.keySet().iterator();
      }
    }
    for (;;)
    {
      if (!paramDisplayMetrics.hasNext())
      {
        return localHashMap;
        localObject2 = (String)((Iterator)localObject1).next();
        Integer localInteger = (Integer)paramMap.get(localObject2);
        j = i;
        if (localInteger.intValue() < i)
        {
          j = i;
          if (localInteger.intValue() >= densityDpi)
          {
            j = localInteger.intValue();
            localHashMap.clear();
          }
        }
        i = j;
        if (localInteger.intValue() != j) {
          break;
        }
        localHashMap.put(localObject2, localInteger);
        i = j;
        break;
      }
      localObject1 = (String)paramDisplayMetrics.next();
      Object localObject2 = (Integer)paramMap.get(localObject1);
      int j = i;
      if (((Integer)localObject2).intValue() > i)
      {
        j = ((Integer)localObject2).intValue();
        localHashMap.clear();
      }
      i = j;
      if (((Integer)localObject2).intValue() == j)
      {
        localHashMap.put(localObject1, localObject2);
        i = j;
      }
    }
  }
  
  public final boolean a(Object paramObject, Configuration paramConfiguration)
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.leanplum.at
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */