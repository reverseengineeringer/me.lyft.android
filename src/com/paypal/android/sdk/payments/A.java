package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.bY;
import com.paypal.android.sdk.cc;

class a
{
  private static final String a = a.class.getSimpleName();
  private aB b;
  private Object c;
  private ay d;
  
  private void b(ay paramay)
  {
    paramay.a(c);
    if ((!(c instanceof bY)) && (!(c instanceof cc))) {}
    for (int i = 1;; i = 0)
    {
      c = null;
      if (i != 0) {
        d = null;
      }
      return;
    }
  }
  
  final void a()
  {
    if (c == null) {
      c = "success";
    }
    if (d != null) {
      b(d);
    }
  }
  
  final void a(aB paramaB)
  {
    if (d != null)
    {
      d.a(paramaB);
      return;
    }
    b = paramaB;
  }
  
  final void a(ay paramay)
  {
    if (c != null)
    {
      b(paramay);
      return;
    }
    if (b != null)
    {
      paramay.a(b);
      b = null;
      d = null;
      return;
    }
    d = paramay;
  }
  
  final void a(Object paramObject)
  {
    c = paramObject;
  }
  
  final void b()
  {
    d = null;
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */