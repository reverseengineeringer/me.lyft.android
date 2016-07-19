package com.leanplum;

import android.content.res.Configuration;

final class az
  extends aI
{
  public final Object a(String paramString)
  {
    if (paramString.startsWith("mnc")) {
      return Integer.getInteger(paramString.substring(3));
    }
    return null;
  }
  
  public final boolean a(Object paramObject, Configuration paramConfiguration)
  {
    return mnc == ((Integer)paramObject).intValue();
  }
}

/* Location:
 * Qualified Name:     com.leanplum.az
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */