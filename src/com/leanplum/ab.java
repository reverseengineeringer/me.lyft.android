package com.leanplum;

import android.content.res.Configuration;
import java.util.Locale;

final class aB
  extends aI
{
  public final Object a(String paramString)
  {
    if (paramString.length() == 2) {
      return paramString;
    }
    return null;
  }
  
  public final boolean a(Object paramObject, Configuration paramConfiguration)
  {
    return locale.getLanguage().equals(paramObject);
  }
}

/* Location:
 * Qualified Name:     com.leanplum.aB
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */