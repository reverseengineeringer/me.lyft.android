package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class aj
  implements DialogInterface.OnClickListener
{
  aj(PayPalFuturePaymentActivity paramPayPalFuturePaymentActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PayPalFuturePaymentActivity.b(a).a(PayPalFuturePaymentActivity.a(a), true);
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.aj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */