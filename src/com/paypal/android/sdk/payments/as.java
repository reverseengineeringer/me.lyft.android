package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.Calendar;

final class as
  implements ServiceConnection
{
  as(PayPalProfileSharingActivity paramPayPalProfileSharingActivity) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    new StringBuilder().append(PayPalProfileSharingActivity.class.getSimpleName()).append(".onServiceConnected");
    if (a.isFinishing())
    {
      new StringBuilder().append(PayPalProfileSharingActivity.class.getSimpleName()).append(".onServiceConnected exit - isFinishing");
      return;
    }
    PayPalProfileSharingActivity.a(a, a);
    if (PayPalProfileSharingActivity.b(a).e() == null)
    {
      Log.e(PayPalProfileSharingActivity.a(), "Service state invalid.  Did you start the PayPalService?");
      a.setResult(2);
      a.finish();
      return;
    }
    paramComponentName = new av(a.getIntent(), PayPalProfileSharingActivity.b(a).e(), true);
    if (!paramComponentName.d())
    {
      Log.e(PayPalProfileSharingActivity.a(), "Service extras invalid.  Please see the docs.");
      a.setResult(2);
      a.finish();
      return;
    }
    if (!paramComponentName.e())
    {
      Log.e(PayPalProfileSharingActivity.a(), "Extras invalid.  Please see the docs.");
      a.setResult(2);
      a.finish();
      return;
    }
    if (PayPalProfileSharingActivity.b(a).j())
    {
      PayPalProfileSharingActivity.c(a);
      return;
    }
    paramComponentName = Calendar.getInstance();
    paramComponentName.add(13, 1);
    PayPalProfileSharingActivity.a(a, paramComponentName.getTime());
    PayPalProfileSharingActivity.b(a).a(PayPalProfileSharingActivity.a(a), false);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    PayPalProfileSharingActivity.a(a, null);
    PayPalProfileSharingActivity.a();
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.as
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */