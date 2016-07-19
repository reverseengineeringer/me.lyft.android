package bo.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Criteria;
import android.location.LocationManager;
import com.appboy.Constants;
import com.appboy.configuration.XmlAppConfigurationProvider;
import com.appboy.services.AppboyLocationService;
import com.appboy.support.AppboyLogger;
import com.appboy.support.PermissionUtils;
import com.appboy.support.StringUtils;

public final class bw
  implements cl
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, bw.class.getName() });
  private final Context b;
  private final String c;
  private final LocationManager d;
  private final ch e;
  private final boolean f;
  private final boolean g;
  private boolean h = false;
  private long i = 3600000L;
  private float j = 50.0F;
  private String k;
  
  public bw(Context paramContext, ch paramch, XmlAppConfigurationProvider paramXmlAppConfigurationProvider, fb paramfb)
  {
    b = paramContext;
    c = paramContext.getPackageName();
    e = paramch;
    d = ((LocationManager)paramContext.getSystemService("location"));
    boolean bool1;
    if (paramXmlAppConfigurationProvider.isLocationCollectionEnabled())
    {
      AppboyLogger.i(a, "Location collection enabled via appboy.xml configuration.");
      bool1 = true;
      f = bool1;
      if (!paramfb.b()) {
        break label363;
      }
      if (!paramfb.c()) {
        break label348;
      }
      AppboyLogger.i(a, "Background location collection enabled via server configuration.");
      bool1 = true;
      label109:
      h = bool1;
      if (!fn.a(b, AppboyLocationService.class)) {
        break label400;
      }
      bool1 = bool2;
      label131:
      g = bool1;
      if (paramfb.d() < 0L) {
        break label422;
      }
      i = paramfb.d();
      AppboyLogger.i(a, "Time interval override set via server configuration for background location collection: " + i / 1000L + "s.");
      label191:
      if (paramfb.e() < 0.0F) {
        break label524;
      }
      j = paramfb.e();
      AppboyLogger.i(a, "Distance threshold override set via server configuration for background location collection: " + j + "m.");
    }
    for (;;)
    {
      paramContext = new bx(this);
      paramch = new IntentFilter(c + ".SINGLE_APPBOY_LOCATION_UPDATE");
      paramch.addAction(c + ".REQUEST_INIT_APPBOY_LOCATION_SERVICE");
      b.registerReceiver(paramContext, paramch);
      if (!PermissionUtils.hasPermission(b, "android.permission.ACCESS_FINE_LOCATION")) {
        d();
      }
      return;
      AppboyLogger.i(a, "Location collection disabled via appboy.xml configuration.");
      bool1 = false;
      break;
      label348:
      AppboyLogger.i(a, "Background location collection disabled via server configuration.");
      bool1 = false;
      break label109;
      label363:
      if (paramXmlAppConfigurationProvider.isBackgroundLocationCollectionEnabled())
      {
        AppboyLogger.i(a, "Background location collection enabled via appboy.xml configuration.");
        bool1 = true;
        break label109;
      }
      AppboyLogger.i(a, "Background location collection disabled via appboy.xml configuration.");
      bool1 = false;
      break label109;
      label400:
      AppboyLogger.i(a, String.format("Appboy location service is not available. Declare <service android:name=\"com.appboy.services.AppboyLocationService\"/> in your AndroidManifest.xml to enable Appboy location service.", new Object[0]));
      bool1 = false;
      break label131;
      label422:
      if (paramXmlAppConfigurationProvider.getLocationUpdateTimeIntervalInMillis() > 300000L)
      {
        i = paramXmlAppConfigurationProvider.getLocationUpdateTimeIntervalInMillis();
        AppboyLogger.i(a, "Time interval override set via appboy.xml configuration for background location collection: " + i / 1000L + "s.");
        break label191;
      }
      i = 3600000L;
      AppboyLogger.i(a, "Time interval override set to default for background location collection: " + i / 1000L + "s.");
      break label191;
      label524:
      if (paramXmlAppConfigurationProvider.getLocationUpdateDistanceInMeters() > 50.0F)
      {
        j = paramXmlAppConfigurationProvider.getLocationUpdateDistanceInMeters();
        AppboyLogger.i(a, "Distance threshold override set via appboy.xml configuration for background location collection: " + j + "m.");
      }
      else
      {
        j = 50.0F;
        AppboyLogger.i(a, "Distance threshold override set to default for background location collection: " + j + "m.");
      }
    }
  }
  
  private boolean a(String paramString)
  {
    if (!g)
    {
      AppboyLogger.i(a, String.format("Appboy Location service is not available. Did not send intent to service: %s", new Object[] { paramString }));
      return false;
    }
    Intent localIntent = new Intent(paramString).setClass(b, AppboyLocationService.class);
    if (paramString.equals(c + ".REQUEST_APPBOY_LOCATION_UPDATES"))
    {
      localIntent.putExtra("distance", j);
      localIntent.putExtra("time", i);
    }
    b.startService(localIntent);
    return true;
  }
  
  private void d()
  {
    if (!g)
    {
      AppboyLogger.i(a, "Did not attempt to stop service. Appboy Location service is not available.");
      return;
    }
    AppboyLogger.i(a, "Stopping Appboy location service if currently running.");
    Intent localIntent = new Intent().setClass(b, AppboyLocationService.class);
    b.stopService(localIntent);
  }
  
  public final void a(da paramda)
  {
    if (paramda == null) {
      AppboyLogger.w(a, "Could not reset background location collection interval. Server config was null.");
    }
    do
    {
      return;
      if (g >= 0L)
      {
        i = g;
        AppboyLogger.i(a, "Time interval override reset via server configuration for background location collection: " + i / 1000L + "s.");
      }
      if (h >= 0.0F)
      {
        j = h;
        AppboyLogger.i(a, "Distance threshold override reset via server configuration for background location collection: " + j + "m.");
      }
    } while (!e);
    if (f)
    {
      h = true;
      AppboyLogger.i(a, "Background location collection enabled via server configuration. Requesting location updates.");
      b();
      return;
    }
    h = false;
    AppboyLogger.i(a, "Background location collection disabled via server configuration. Stopping any active Appboy location service.");
    d();
  }
  
  public final boolean a()
  {
    if (!f)
    {
      AppboyLogger.i(a, "Did not request single location update. Location collection is disabled.");
      return false;
    }
    if ((!PermissionUtils.hasPermission(b, "android.permission.ACCESS_FINE_LOCATION")) && (!PermissionUtils.hasPermission(b, "android.permission.ACCESS_COARSE_LOCATION")))
    {
      AppboyLogger.i(a, "Did not request single location update. Fine grained location permissions not found.");
      return false;
    }
    Object localObject1;
    if (PermissionUtils.hasPermission(b, "android.permission.ACCESS_FINE_LOCATION")) {
      localObject1 = "passive";
    }
    while (StringUtils.isNullOrBlank((String)localObject1))
    {
      localObject1 = a;
      return false;
      if (k != null)
      {
        localObject1 = k;
      }
      else
      {
        localObject1 = new Criteria();
        ((Criteria)localObject1).setAccuracy(2);
        ((Criteria)localObject1).setPowerRequirement(1);
        k = d.getBestProvider((Criteria)localObject1, true);
        localObject1 = k;
      }
    }
    try
    {
      Object localObject2 = a;
      localObject2 = new Intent(c + ".SINGLE_APPBOY_LOCATION_UPDATE");
      ((Intent)localObject2).putExtra("origin", "Appboy location manager");
      localObject2 = PendingIntent.getBroadcast(b, 0, (Intent)localObject2, 134217728);
      d.requestSingleUpdate((String)localObject1, (PendingIntent)localObject2);
      return true;
    }
    catch (SecurityException localSecurityException)
    {
      AppboyLogger.w(a, "Failed to request single location update due to security exception from insufficient permissions.", localSecurityException);
      return false;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(a, "Failed to request single location update due to exception.", localException);
    }
    return false;
  }
  
  public final boolean a(dj paramdj)
  {
    try
    {
      paramdj = dd.a(paramdj);
      e.a(paramdj);
      return true;
    }
    catch (Exception paramdj)
    {
      AppboyLogger.w(a, "Failed to log location recorded event.", paramdj);
    }
    return false;
  }
  
  public final boolean b()
  {
    if (!f)
    {
      AppboyLogger.i(a, "Did not request background location updates. Location collection is disabled.");
      return false;
    }
    if (!h)
    {
      AppboyLogger.i(a, "Did not request background location updates. Background location collection is disabled.");
      return false;
    }
    if (!PermissionUtils.hasPermission(b, "android.permission.ACCESS_FINE_LOCATION"))
    {
      AppboyLogger.i(a, "Did not request background location updates. Fine grained location permissions not found.");
      return false;
    }
    try
    {
      a(c + ".REQUEST_REMOVE_APPBOY_LOCATION_UPDATES");
      boolean bool = a(c + ".REQUEST_APPBOY_LOCATION_UPDATES");
      return bool;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(a, "Could not request location updates due to exception.", localException);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     bo.app.bw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */