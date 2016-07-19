package com.paypal.android.sdk;

import android.os.Build;
import android.os.Build.VERSION;
import java.util.Locale;

public class av
{
  private static final String a = av.class.getSimpleName();
  private static String b = null;
  
  public static String a(c paramc)
  {
    if (b == null)
    {
      String str = Locale.getDefault().toString().replace("_", "-");
      b = "Mozilla/5.0 (Linux; U; Android " + Build.VERSION.RELEASE + "; " + str + "; " + Build.MODEL + " " + Build.DISPLAY + ") mpl/" + paramc.a();
      new StringBuilder("UserAgent: ").append(b);
    }
    return b;
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.av
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */