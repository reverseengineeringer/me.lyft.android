package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ar
  implements DialogInterface.OnClickListener
{
  ar(PayPalProfileSharingActivity paramPayPalProfileSharingActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PayPalProfileSharingActivity.b(a).a(PayPalProfileSharingActivity.a(a), true);
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.ar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */