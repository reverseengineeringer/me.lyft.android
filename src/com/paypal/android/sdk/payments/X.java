package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class x
  implements ServiceConnection
{
  x(p paramp) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    new StringBuilder().append(p.b()).append(".onServiceConnected");
    a.a = a;
    if (a.a.a(new y(this))) {
      p.d(a);
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    a.a = null;
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */