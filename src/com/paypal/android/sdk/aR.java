package com.paypal.android.sdk;

import android.os.Message;
import java.util.Map;

public class ar
  implements bh
{
  private static final String a = ar.class.getSimpleName();
  private final b b;
  private as c;
  private aq d;
  private final aw e;
  private bc f;
  
  public ar(b paramb, aq paramaq, c paramc)
  {
    b = paramb;
    d = paramaq;
    e = new aw();
    c = new as(this);
  }
  
  public final String a(be parambe)
  {
    new StringBuilder("environment:").append(d).append(" environment.getEndpoints():").append(d.c());
    if ((d != null) && (d.c() != null))
    {
      parambe = (String)d.c().get(parambe.a());
      new StringBuilder("returning:").append(parambe);
      return parambe;
    }
    return null;
  }
  
  public final void a()
  {
    f.a();
  }
  
  public final void a(ay paramay)
  {
    e.a(paramay);
  }
  
  public final void a(bc parambc)
  {
    if (f != null) {
      throw new IllegalStateException();
    }
    f = parambc;
  }
  
  public final void a(bg parambg)
  {
    parambg.m();
    aa.a().e();
    if (!parambg.a())
    {
      Message localMessage = new Message();
      what = 2;
      obj = parambg;
      c.sendMessage(localMessage);
    }
  }
  
  public final void b()
  {
    e.a();
  }
  
  public final void b(bg parambg)
  {
    f.a(parambg);
  }
  
  public final String c()
  {
    return d.a();
  }
  
  public final b d()
  {
    return b;
  }
  
  public final String e()
  {
    return d.b();
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.ar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */