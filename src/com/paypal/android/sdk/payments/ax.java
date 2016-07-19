package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.bn;
import com.paypal.android.sdk.bu;
import com.paypal.android.sdk.bx;

final class ax
  implements aA
{
  ax(PayPalService paramPayPalService) {}
  
  public final void a()
  {
    if ((!PayPalService.a(a).i()) && (a.a != null))
    {
      a.doDeleteTokenizedCreditCard(a.d().c.a(), a.a.e());
      a.a = null;
    }
  }
  
  public final void a(aB paramaB) {}
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.ax
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */