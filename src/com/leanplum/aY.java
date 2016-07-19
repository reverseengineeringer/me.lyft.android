package com.leanplum;

import android.content.res.Configuration;

final class ay
  extends aI
{
  public final Object a(String paramString)
  {
    if (paramString.equals("nonav")) {
      return Integer.valueOf(1);
    }
    if (paramString.equals("dpad")) {
      return Integer.valueOf(2);
    }
    if (paramString.equals("trackball")) {
      return Integer.valueOf(3);
    }
    if (paramString.equals("wheel")) {
      return Integer.valueOf(4);
    }
    return null;
  }
  
  public final boolean a(Object paramObject, Configuration paramConfiguration)
  {
    return navigation == ((Integer)paramObject).intValue();
  }
}

/* Location:
 * Qualified Name:     com.leanplum.ay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */