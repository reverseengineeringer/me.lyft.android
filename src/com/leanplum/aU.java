package com.leanplum;

import android.content.res.Configuration;

final class au
  extends aI
{
  public final Object a(String paramString)
  {
    if (paramString.equals("notouch")) {
      return Integer.valueOf(1);
    }
    if (paramString.equals("finger")) {
      return Integer.valueOf(3);
    }
    return null;
  }
  
  public final boolean a(Object paramObject, Configuration paramConfiguration)
  {
    return touchscreen == ((Integer)paramObject).intValue();
  }
}

/* Location:
 * Qualified Name:     com.leanplum.au
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */