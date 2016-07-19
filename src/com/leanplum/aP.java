package com.leanplum;

import android.content.res.Configuration;

final class ap
  extends aI
{
  public final Object a(String paramString)
  {
    if (paramString.equals("long")) {
      return Integer.valueOf(32);
    }
    if (paramString.equals("notlong")) {
      return Integer.valueOf(16);
    }
    return null;
  }
  
  public final boolean a(Object paramObject, Configuration paramConfiguration)
  {
    return (screenLayout & 0x30) == ((Integer)paramObject).intValue();
  }
}

/* Location:
 * Qualified Name:     com.leanplum.ap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */