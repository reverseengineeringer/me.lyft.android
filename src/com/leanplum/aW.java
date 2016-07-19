package com.leanplum;

import android.content.res.Configuration;

final class aw
  extends aI
{
  public final Object a(String paramString)
  {
    if (paramString.equals("nokeys")) {
      return Integer.valueOf(1);
    }
    if (paramString.equals("qwerty")) {
      return Integer.valueOf(2);
    }
    if (paramString.equals("12key")) {
      return Integer.valueOf(3);
    }
    return null;
  }
  
  public final boolean a(Object paramObject, Configuration paramConfiguration)
  {
    return keyboard == ((Integer)paramObject).intValue();
  }
}

/* Location:
 * Qualified Name:     com.leanplum.aw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */