package com.paypal.android.sdk;

import java.util.Locale;

public final class bk
  implements bR
{
  private static volatile bk a;
  
  public static bk a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bk();
      }
      return a;
    }
    finally {}
  }
  
  public final String a(String paramString)
  {
    return paramString;
  }
  
  public final Locale b()
  {
    return Locale.getDefault();
  }
  
  public final f c()
  {
    return new f(Locale.getDefault().getCountry());
  }
  
  public final f d()
  {
    return c();
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.bk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */