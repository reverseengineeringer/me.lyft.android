package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class f
  implements DialogInterface.OnClickListener
{
  f(Activity paramActivity, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a.removeDialog(b);
    a.finish();
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */