package com.mobileapptracker;

import android.content.Context;
import android.provider.Settings.Secure;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

class MATParameters$GetGAID
  implements Runnable
{
  private final WeakReference<Context> weakContext;
  
  public MATParameters$GetGAID(MATParameters paramMATParameters, Context paramContext)
  {
    weakContext = new WeakReference(paramContext);
  }
  
  public void run()
  {
    int i = 1;
    try
    {
      Object localObject = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getDeclaredMethod("getAdvertisingIdInfo", new Class[] { Context.class }).invoke(null, new Object[] { weakContext.get() });
      String str = (String)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getDeclaredMethod("getId", new Class[0]).invoke(localObject, new Object[0]);
      boolean bool = ((Boolean)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getDeclaredMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(localObject, new Object[0])).booleanValue();
      if (access$000this$0).params == null)
      {
        this$0.setGoogleAdvertisingId(str);
        if (!bool) {
          break label147;
        }
      }
      for (;;)
      {
        this$0.setGoogleAdTrackingLimited(Integer.toString(i));
        MATParameters.access$000(this$0).setGoogleAdvertisingId(str, bool);
        return;
        label147:
        i = 0;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Log.d("MobileAppTracker", "MAT SDK failed to get Google Advertising Id, collecting ANDROID_ID instead");
      if (access$000this$0).params == null) {
        this$0.setAndroidId(Settings.Secure.getString(((Context)weakContext.get()).getContentResolver(), "android_id"));
      }
      MATParameters.access$000(this$0).setAndroidId(Settings.Secure.getString(((Context)weakContext.get()).getContentResolver(), "android_id"));
    }
  }
}

/* Location:
 * Qualified Name:     com.mobileapptracker.MATParameters.GetGAID
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */