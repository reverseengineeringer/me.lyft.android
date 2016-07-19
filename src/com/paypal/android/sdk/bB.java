package com.paypal.android.sdk;

import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;

final class bb
  extends aL
{
  private final bg a;
  
  private bb(aY paramaY, bg parambg)
  {
    a = parambg;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    a.b(paramString1);
    aY.c();
    new StringBuilder().append(a.o()).append(" success");
  }
  
  public final void a(Throwable paramThrowable, String paramString)
  {
    a.b(paramString);
    if ((paramThrowable instanceof NoHttpResponseException))
    {
      aY.e(b).a().getConnectionManager().closeExpiredConnections();
      b.b(a);
      return;
    }
    aY.c();
    new StringBuilder().append(a.o()).append(" failure: ").append(paramThrowable.getMessage());
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.bb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */