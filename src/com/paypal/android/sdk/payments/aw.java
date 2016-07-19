package com.paypal.android.sdk.payments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class aw
  extends BroadcastReceiver
{
  aw(PayPalService paramPayPalService) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    PayPalService.v();
    new StringBuilder("received broadcast: ").append(paramIntent.getAction());
    if (paramIntent.getAction().equals("com.paypal.android.sdk.clearAllUserData")) {
      a.h();
    }
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.aw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */