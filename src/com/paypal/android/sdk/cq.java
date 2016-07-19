package com.paypal.android.sdk;

import java.util.Set;

public final class cq
{
  public static boolean a;
  private static final i b = new i(cs.class, x.a);
  private static Set c = new cr();
  
  public static String a(cs paramcs)
  {
    return b.a(paramcs);
  }
  
  public static String a(String paramString)
  {
    if (paramString.equals(aA.b.toString())) {
      return b.a(cs.aJ);
    }
    if (paramString.equals(aA.a.toString())) {
      return b.a("INTERNAL_SERVICE_ERROR", cs.aP);
    }
    if (paramString.equals(aA.c.toString())) {
      return b.a(cs.bt);
    }
    return b.a(paramString, cs.aP);
  }
  
  public static void b(String paramString)
  {
    b.a(paramString);
    if ((R.c(paramString)) && (c.contains(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public static String c(String paramString)
  {
    String str2 = b.a();
    String str1 = str2;
    if (!str2.contains("_")) {
      str1 = str2 + "_" + paramString;
    }
    return str1;
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.cq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */