package com.leanplum;

import android.content.res.Configuration;

final class ar
  extends aI
{
  public final Object a(String paramString)
  {
    if (paramString.equals("car")) {
      return Integer.valueOf(3);
    }
    if (paramString.equals("desk")) {
      return Integer.valueOf(2);
    }
    if (paramString.equals("television")) {
      return Integer.valueOf(4);
    }
    if (paramString.equals("appliance")) {
      return Integer.valueOf(5);
    }
    return null;
  }
  
  public final boolean a(Object paramObject, Configuration paramConfiguration)
  {
    return (uiMode & 0xF) == ((Integer)paramObject).intValue();
  }
}

/* Location:
 * Qualified Name:     com.leanplum.ar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */