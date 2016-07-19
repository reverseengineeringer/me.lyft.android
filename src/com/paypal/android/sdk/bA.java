package com.paypal.android.sdk;

import android.util.Log;
import java.io.IOException;
import java.util.Locale;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;

final class ba
  extends aL
{
  private final bg a;
  
  private ba(aY paramaY, bg parambg)
  {
    a = parambg;
  }
  
  private String a(String paramString)
  {
    Locale localLocale = Locale.US;
    String str1 = a.o() + " PayPal Debug-ID: %s [%s, %s]";
    String str2 = aY.b(b);
    StringBuilder localStringBuilder = new StringBuilder().append(aY.c(b).a()).append(";");
    aY.c(b);
    return String.format(localLocale, str1, new Object[] { paramString, str2, "release" });
  }
  
  public final void a(String paramString1, String paramString2)
  {
    try
    {
      a.b(paramString1);
      a.c(paramString2);
      aY.c();
      new StringBuilder().append(a.o()).append(" success. response: ").append(a.h());
      if (R.c(paramString2)) {
        Log.w("paypal.sdk", a(paramString2));
      }
      if (a.r()) {
        aY.a(a);
      }
      aY.a(b).a(a);
      return;
    }
    catch (Throwable paramString1)
    {
      Log.e("paypal.sdk", "exception in response handler", paramString1);
      throw paramString1;
    }
  }
  
  public final void a(Throwable paramThrowable, String paramString1, String paramString2)
  {
    try
    {
      a.b(paramString1);
      if (R.c(paramString2)) {
        Log.w("paypal.sdk", a(paramString2));
      }
      if ((paramThrowable instanceof NoHttpResponseException))
      {
        aY.d(b).a().getConnectionManager().closeExpiredConnections();
        b.b(a);
        return;
      }
      aY.a(b, a, (IOException)paramThrowable);
      return;
    }
    catch (Throwable paramThrowable)
    {
      Log.e("paypal.sdk", "exception in response handler", paramThrowable);
      throw paramThrowable;
    }
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.ba
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */