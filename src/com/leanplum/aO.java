package com.leanplum;

import android.content.res.Configuration;

final class ao
  extends aI
{
  public final Object a(String paramString)
  {
    if (paramString.startsWith("mcc")) {
      return Integer.getInteger(paramString.substring(3));
    }
    return null;
  }
  
  public final boolean a(Object paramObject, Configuration paramConfiguration)
  {
    return mcc == ((Integer)paramObject).intValue();
  }
}

/* Location:
 * Qualified Name:     com.leanplum.ao
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */