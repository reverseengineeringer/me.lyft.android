package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.appboy.support.AppboyLogger;
import java.lang.reflect.Method;

final class cf
  implements Runnable
{
  cf(ce paramce) {}
  
  public final void run()
  {
    Method localMethod1;
    try
    {
      ce.a(a.a.getBoolean("ac", false));
      Object localObject = fm.a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[] { Context.class });
      if (localObject == null) {
        return;
      }
      localObject = fm.a(null, (Method)localObject, new Object[] { ce.a(a) });
      if ((!(localObject instanceof Integer)) || (((Integer)localObject).intValue() != 0)) {
        return;
      }
      localObject = fm.a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[] { Context.class });
      if (localObject == null) {
        return;
      }
      localObject = fm.a(null, (Method)localObject, new Object[] { ce.a(a) });
      if (localObject == null) {
        return;
      }
      localMethod1 = fm.a(localObject.getClass(), "getId", new Class[0]);
      Method localMethod2 = fm.a(localObject.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
      if ((localMethod1 == null) || (localMethod2 == null)) {
        return;
      }
      if (((Boolean)fm.a(localObject, localMethod2, new Object[0])).booleanValue())
      {
        AppboyLogger.i(ce.g(), "Google Play Services limit ad tracking enabled. User is opted out of interest-based ads. Not requesting Advertising Id.");
        return;
      }
    }
    catch (Exception localException)
    {
      AppboyLogger.e(ce.g(), "Failed to get ad id.", localException);
      return;
    }
    ce.a(a, (String)fm.a(localException, localMethod1, new Object[0]));
  }
}

/* Location:
 * Qualified Name:     bo.app.cf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */