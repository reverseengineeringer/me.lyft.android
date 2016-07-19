package com.leanplum;

import java.util.HashMap;
import java.util.Map;

final class am
{
  Map<an, Object> a = new HashMap();
  
  public static am a(String paramString)
  {
    am localam = new am();
    paramString = paramString.toLowerCase().split("-");
    int m = paramString.length;
    int j = 0;
    int i = 0;
    if (j >= m) {
      return localam;
    }
    String str = paramString[j];
    int k = 0;
    for (;;)
    {
      if ((k != 0) || (i >= an.values().length))
      {
        j += 1;
        break;
      }
      an localan = an.values()[i];
      Object localObject = localan.a().a(str);
      if (localObject != null)
      {
        a.put(localan, localObject);
        k = 1;
      }
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.leanplum.am
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */