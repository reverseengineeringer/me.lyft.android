package com.paypal.android.sdk;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;

final class ap
  implements Runnable
{
  ap(Context paramContext, Z paramZ) {}
  
  public final void run()
  {
    try
    {
      AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(a);
      b.V = localInfo.getId();
      return;
    }
    catch (Exception localException)
    {
      ao.a("RiskComponent.Util", localException.getLocalizedMessage(), localException);
    }
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.ap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */