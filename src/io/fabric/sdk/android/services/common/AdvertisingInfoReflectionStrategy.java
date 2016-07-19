package io.fabric.sdk.android.services.common;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.lang.reflect.Method;

class AdvertisingInfoReflectionStrategy
  implements AdvertisingInfoStrategy
{
  private final Context context;
  
  public AdvertisingInfoReflectionStrategy(Context paramContext)
  {
    context = paramContext.getApplicationContext();
  }
  
  private String getAdvertisingId()
  {
    try
    {
      String str = (String)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(getInfo(), new Object[0]);
      return str;
    }
    catch (Exception localException)
    {
      Fabric.getLogger().w("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
    }
    return null;
  }
  
  private Object getInfo()
  {
    try
    {
      Object localObject = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[] { Context.class }).invoke(null, new Object[] { context });
      return localObject;
    }
    catch (Exception localException)
    {
      Fabric.getLogger().w("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
    }
    return null;
  }
  
  private boolean isLimitAdTrackingEnabled()
  {
    try
    {
      boolean bool = ((Boolean)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(getInfo(), new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      Fabric.getLogger().w("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
    }
    return false;
  }
  
  public AdvertisingInfo getAdvertisingInfo()
  {
    if (isGooglePlayServiceAvailable(context)) {
      return new AdvertisingInfo(getAdvertisingId(), isLimitAdTrackingEnabled());
    }
    return null;
  }
  
  boolean isGooglePlayServiceAvailable(Context paramContext)
  {
    try
    {
      int i = ((Integer)Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", new Class[] { Context.class }).invoke(null, new Object[] { paramContext })).intValue();
      return i == 0;
    }
    catch (Exception paramContext) {}
    return false;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.AdvertisingInfoReflectionStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */