package com.leanplum;

import android.content.res.Configuration;

final class as
  extends aI
{
  public final Object a(String paramString)
  {
    if (paramString.equals("night")) {
      return Integer.valueOf(32);
    }
    if (paramString.equals("notnight")) {
      return Integer.valueOf(16);
    }
    return null;
  }
  
  public final boolean a(Object paramObject, Configuration paramConfiguration)
  {
    return (uiMode & 0x30) == ((Integer)paramObject).intValue();
  }
}

/* Location:
 * Qualified Name:     com.leanplum.as
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */