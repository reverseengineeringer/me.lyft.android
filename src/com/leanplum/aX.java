package com.leanplum;

import android.content.res.Configuration;

final class ax
  extends aI
{
  public final Object a(String paramString)
  {
    if (paramString.equals("navexposed")) {
      return Integer.valueOf(1);
    }
    if (paramString.equals("navhidden")) {
      return Integer.valueOf(2);
    }
    return null;
  }
  
  public final boolean a(Object paramObject, Configuration paramConfiguration)
  {
    return navigationHidden == ((Integer)paramObject).intValue();
  }
}

/* Location:
 * Qualified Name:     com.leanplum.ax
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */