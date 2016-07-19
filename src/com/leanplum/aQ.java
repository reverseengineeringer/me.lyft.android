package com.leanplum;

import android.content.res.Configuration;

final class aq
  extends aI
{
  public final Object a(String paramString)
  {
    if (paramString.equals("port")) {
      return Integer.valueOf(1);
    }
    if (paramString.equals("land")) {
      return Integer.valueOf(2);
    }
    return null;
  }
  
  public final boolean a(Object paramObject, Configuration paramConfiguration)
  {
    return orientation == ((Integer)paramObject).intValue();
  }
}

/* Location:
 * Qualified Name:     com.leanplum.aq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */