package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class ak
  implements ServiceConnection
{
  ak(PayPalFuturePaymentActivity paramPayPalFuturePaymentActivity) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    new StringBuilder().append(PayPalFuturePaymentActivity.a()).append(".onServiceConnected");
    if (a.isFinishing()) {
      new StringBuilder().append(PayPalFuturePaymentActivity.a()).append(".onServiceConnected exit - isFinishing");
    }
    do
    {
      return;
      PayPalFuturePaymentActivity.a(a, a);
    } while (!PayPalFuturePaymentActivity.b(a).a(new al(this)));
    PayPalFuturePaymentActivity.c(a);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    PayPalFuturePaymentActivity.a(a, null);
    PayPalFuturePaymentActivity.a();
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.ak
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */