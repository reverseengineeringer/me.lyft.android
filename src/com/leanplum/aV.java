package com.leanplum;

import android.content.res.Configuration;

final class av
  extends aI
{
  public final Object a(String paramString)
  {
    if (paramString.equals("keysexposed")) {
      return Integer.valueOf(1);
    }
    if (paramString.equals("keyshidden")) {
      return Integer.valueOf(2);
    }
    if (paramString.equals("keyssoft")) {
      return Integer.valueOf(0);
    }
    return null;
  }
  
  public final boolean a(Object paramObject, Configuration paramConfiguration)
  {
    if (((Integer)paramObject).intValue() == 0) {
      return true;
    }
    return keyboardHidden == ((Integer)paramObject).intValue();
  }
}

/* Location:
 * Qualified Name:     com.leanplum.av
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */