package com.paypal.android.sdk.payments;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

final class am
  implements aA
{
  am(PayPalFuturePaymentActivity paramPayPalFuturePaymentActivity) {}
  
  public final void a()
  {
    Date localDate = Calendar.getInstance().getTime();
    if (PayPalFuturePaymentActivity.d(a).compareTo(localDate) > 0)
    {
      long l = PayPalFuturePaymentActivity.d(a).getTime() - localDate.getTime();
      PayPalFuturePaymentActivity.a();
      new StringBuilder("Delaying ").append(l).append(" milliseconds so user doesn't see flicker.");
      PayPalFuturePaymentActivity.a(a, new Timer());
      PayPalFuturePaymentActivity.f(a).schedule(new an(this), l);
      return;
    }
    PayPalFuturePaymentActivity.e(a);
  }
  
  public final void a(aB paramaB)
  {
    d.a(a, paramaB, 1, 2, 3);
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.am
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */