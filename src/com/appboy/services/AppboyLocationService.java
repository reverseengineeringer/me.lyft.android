package com.appboy.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.IBinder;
import bo.app.em;
import com.appboy.Appboy;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;

public class AppboyLocationService
  extends Service
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyLocationService.class.getName() });
  private LocationListener b;
  private LocationManager c;
  
  private void b()
  {
    if (b != null) {}
    try
    {
      c.removeUpdates(b);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      AppboyLogger.w(a, "Could not remove background location updates. Security exception from insufficient permissions", localSecurityException);
    }
  }
  
  public static void requestInitialization(Context paramContext)
  {
    String str = a;
    paramContext.sendBroadcast(new Intent(paramContext.getPackageName() + ".REQUEST_INIT_APPBOY_LOCATION_SERVICE"));
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null)
    {
      AppboyLogger.i(a, "Null intent received. Initializing Appboy.");
      Appboy.getInstance(getApplicationContext());
      return 1;
    }
    String str = paramIntent.getAction();
    if (str == null)
    {
      AppboyLogger.w(a, "Null intent action received in Appboy location service: " + paramIntent.getDataString());
      return 1;
    }
    if (str.equals(getPackageName() + ".REQUEST_APPBOY_LOCATION_UPDATES"))
    {
      str = a;
      new StringBuilder("Requesting background location updates: ").append(paramIntent.getAction());
      if (c == null) {
        c = ((LocationManager)getApplicationContext().getSystemService("location"));
      }
      if (b == null) {
        b = new em(this);
      }
      float f = paramIntent.getFloatExtra("distance", 50.0F);
      long l = paramIntent.getLongExtra("time", 3600000L);
      if (b != null) {
        try
        {
          c.requestLocationUpdates("passive", l, f, b);
          AppboyLogger.i(a, String.format("Collecting locations using %s provider with time interval %ds and update distance %.1fm.", new Object[] { "passive", Long.valueOf(l / 1000L), Float.valueOf(f) }));
          return 1;
        }
        catch (SecurityException paramIntent)
        {
          AppboyLogger.w(a, "Could not request background location updates. Security exception from insufficient permissions", paramIntent);
          return 1;
        }
      }
      AppboyLogger.w(a, "Could not request background location updates. Appboy location listener was null.");
      return 1;
    }
    if (str.contains(getPackageName() + ".REQUEST_REMOVE_APPBOY_LOCATION_UPDATES"))
    {
      str = a;
      new StringBuilder("Removing current location updates: ").append(paramIntent.getAction());
      b();
      return 1;
    }
    AppboyLogger.w(a, "Unknown intent received: " + paramIntent.getAction());
    return 1;
  }
}

/* Location:
 * Qualified Name:     com.appboy.services.AppboyLocationService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */