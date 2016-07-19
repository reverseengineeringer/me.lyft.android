package com.paypal.android.sdk.payments;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

final class at
  implements aA
{
  at(PayPalProfileSharingActivity paramPayPalProfileSharingActivity) {}
  
  public final void a()
  {
    Date localDate = Calendar.getInstance().getTime();
    if (PayPalProfileSharingActivity.d(a).compareTo(localDate) > 0)
    {
      long l = PayPalProfileSharingActivity.d(a).getTime() - localDate.getTime();
      PayPalProfileSharingActivity.a();
      new StringBuilder("Delaying ").append(l).append(" miliseconds so user doesn't see flicker.");
      PayPalProfileSharingActivity.a(a, new Timer());
      PayPalProfileSharingActivity.e(a).schedule(new au(this), l);
      return;
    }
    PayPalProfileSharingActivity.c(a);
  }
  
  public final void a(aB paramaB)
  {
    d.a(a, paramaB, 1, 2, 3);
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.at
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */