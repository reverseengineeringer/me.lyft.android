package com.paypal.android.sdk;

import android.content.Context;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class d
{
  private static final String a = d.class.getSimpleName();
  private static final ExecutorService b = Executors.newCachedThreadPool();
  private static aa c;
  
  public static final String a(Context paramContext, b paramb, String paramString)
  {
    if (c == null) {
      try
      {
        aa localaa = aa.a();
        c = localaa;
        paramContext = localaa.a(paramContext, paramb.e(), a.b, paramString, null, false, null, null);
        b.submit(new e());
        new StringBuilder("Init risk component: ").append(aa.c());
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        Log.e("paypal.sdk", "An internal component failed to initialize: " + paramContext.getMessage());
        return null;
      }
    }
    paramContext = c.f();
    new StringBuilder("risk component already initialized, returning new pairing id:").append(paramContext);
    return paramContext;
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */