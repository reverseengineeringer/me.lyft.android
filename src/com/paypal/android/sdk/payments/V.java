package com.paypal.android.sdk.payments;

import android.widget.LinearLayout;
import com.paypal.android.sdk.cc;
import com.paypal.android.sdk.cq;
import com.paypal.android.sdk.cs;
import com.paypal.android.sdk.ct;

final class v
  implements ay
{
  v(p paramp) {}
  
  public final void a(aB paramaB)
  {
    a.dismissDialog(2);
    if (b.equals("invalid_nonce"))
    {
      a.c.h.setEnabled(false);
      d.a(a, cq.a(cs.aK), 4);
      return;
    }
    a.c.h.setEnabled(true);
    d.a(a, cq.a(b), 1);
  }
  
  public final void a(Object paramObject)
  {
    if ((paramObject instanceof cc))
    {
      p.a(a, (cc)paramObject);
      return;
    }
    p.b(a);
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */