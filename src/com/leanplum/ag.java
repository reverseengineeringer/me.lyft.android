package com.leanplum;

import android.content.res.Configuration;
import android.util.DisplayMetrics;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class aG
  extends aI
{
  public final Object a(String paramString)
  {
    if ((paramString.startsWith("h")) && (paramString.endsWith("dp"))) {
      return Integer.getInteger(paramString.substring(1, paramString.length() - 2));
    }
    return null;
  }
  
  final Map<String, Object> a(Map<String, Object> paramMap, DisplayMetrics paramDisplayMetrics)
  {
    paramDisplayMetrics = new HashMap();
    Iterator localIterator = paramMap.keySet().iterator();
    int i = Integer.MIN_VALUE;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return paramDisplayMetrics;
      }
      String str = (String)localIterator.next();
      Integer localInteger = (Integer)paramMap.get(str);
      int j = i;
      if (localInteger.intValue() > i)
      {
        j = localInteger.intValue();
        paramDisplayMetrics.clear();
      }
      i = j;
      if (localInteger.intValue() == j)
      {
        paramDisplayMetrics.put(str, localInteger);
        i = j;
      }
    }
  }
  
  public final boolean a(Object paramObject, Configuration paramConfiguration)
  {
    try
    {
      int i = ((Integer)paramConfiguration.getClass().getField("screenHeightDp").get(paramConfiguration)).intValue();
      int j = ((Integer)paramObject).intValue();
      return i >= j;
    }
    catch (Exception paramObject)
    {
      ((Exception)paramObject).printStackTrace();
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.leanplum.aG
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */