package com.kochava.android.tracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationServices;
import com.kochava.android.util.Logging;

class LocationDirector
{
  protected static int desiredAccuracy = 50;
  private static boolean gatheringLocation = false;
  private static boolean haveCoarseLocation;
  private static boolean haveFineLocation;
  private static LocationDirector instance = null;
  private static float latestAccuracy;
  private static double latestLat;
  private static double latestLon;
  private static long latestTimestamp;
  private static LocationGPlayCollector lgc;
  protected static android.location.LocationListener locationListenerOldStrategy = new android.location.LocationListener()
  {
    public void onLocationChanged(Location paramAnonymousLocation)
    {
      Logging.Log("onLocationChanged");
      Logging.Log("lat " + paramAnonymousLocation.getLatitude());
      Logging.Log("long " + paramAnonymousLocation.getLongitude());
      Logging.Log("accuracy " + paramAnonymousLocation.getAccuracy());
      if (paramAnonymousLocation.getAccuracy() <= LocationDirector.desiredAccuracy)
      {
        LocationDirector.saveLocation(paramAnonymousLocation.getLatitude(), paramAnonymousLocation.getLongitude(), paramAnonymousLocation.getAccuracy());
        LocationDirector.access$000();
      }
      while ((paramAnonymousLocation.getAccuracy() >= LocationDirector.latestAccuracy) && (LocationDirector.latestAccuracy != 0.0F)) {
        return;
      }
      LocationDirector.saveLocation(paramAnonymousLocation.getLatitude(), paramAnonymousLocation.getLongitude(), paramAnonymousLocation.getAccuracy());
    }
    
    public void onProviderDisabled(String paramAnonymousString) {}
    
    public void onProviderEnabled(String paramAnonymousString) {}
    
    public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle) {}
  };
  private static Context mContext;
  private static GoogleApiClient mGoogleApiClient;
  static LocationManager oldStratLM;
  private static SharedPreferences prefs;
  protected static int staleness = 15;
  protected static int timeout = 15;
  
  private static LocationGPlayCollector getGPlayCollector()
  {
    if (lgc == null) {
      lgc = new LocationGPlayCollector();
    }
    return lgc;
  }
  
  protected static LocationDirector getInstance(Context paramContext)
  {
    if (instance == null) {
      instance = new LocationDirector();
    }
    if (mContext == null) {
      mContext = paramContext;
    }
    return instance;
  }
  
  protected static long getLocationAge(Location paramLocation)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return getLocationAgeMillisPostOS17(paramLocation);
    }
    return getLocationAgeMillisPreOS17(paramLocation);
  }
  
  @SuppressLint({"NewApi"})
  private static long getLocationAgeMillisPostOS17(Location paramLocation)
  {
    return (SystemClock.elapsedRealtimeNanos() - paramLocation.getElapsedRealtimeNanos()) / 1000000L;
  }
  
  private static long getLocationAgeMillisPreOS17(Location paramLocation)
  {
    return System.currentTimeMillis() - paramLocation.getTime();
  }
  
  private static void getLocationOldStrategy()
  {
    oldStratLM = (LocationManager)mContext.getSystemService("location");
    if (oldStratLM == null)
    {
      reset();
      return;
    }
    int i;
    Location localLocation;
    Object localObject1;
    if (haveFineLocation)
    {
      i = 1;
      localLocation = null;
      localObject1 = null;
      Object localObject2 = null;
      switch (i)
      {
      default: 
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        Logging.Log("GPS - Last known location: ");
        Logging.Log("lat " + ((Location)localObject1).getLatitude());
        Logging.Log("long " + ((Location)localObject1).getLongitude());
        Logging.Log("accuracy: " + ((Location)localObject1).getAccuracy());
        if ((getLocationAge((Location)localObject1) <= staleness * 1000) && (((Location)localObject1).getAccuracy() <= desiredAccuracy))
        {
          saveLocation(((Location)localObject1).getLatitude(), ((Location)localObject1).getLongitude(), ((Location)localObject1).getAccuracy());
          reset();
          return;
          if (haveCoarseLocation)
          {
            i = 2;
            break;
          }
          reset();
          return;
          localObject1 = oldStratLM.getLastKnownLocation("gps");
          localLocation = oldStratLM.getLastKnownLocation("network");
          continue;
        }
        if ((((Location)localObject1).getAccuracy() < latestAccuracy) || (latestAccuracy == 0.0F)) {
          saveLocation(((Location)localObject1).getLatitude(), ((Location)localObject1).getLongitude(), ((Location)localObject1).getAccuracy());
        }
      }
    }
    if (localLocation != null)
    {
      Logging.Log("NETWORK - Last known location: ");
      Logging.Log("lat " + localLocation.getLatitude());
      Logging.Log("long " + localLocation.getLongitude());
      Logging.Log("accuracy: " + localLocation.getAccuracy());
      if ((getLocationAge(localLocation) <= staleness * 1000) && (localLocation.getAccuracy() <= desiredAccuracy))
      {
        saveLocation(localLocation.getLatitude(), localLocation.getLongitude(), localLocation.getAccuracy());
        reset();
        return;
      }
      if ((localLocation.getAccuracy() < latestAccuracy) || (latestAccuracy == 0.0F)) {
        saveLocation(localLocation.getLatitude(), localLocation.getLongitude(), localLocation.getAccuracy());
      }
    }
    switch (i)
    {
    default: 
      return;
    case 1: 
      oldStratLM.requestLocationUpdates("gps", 0L, 0.0F, locationListenerOldStrategy);
    }
    oldStratLM.requestLocationUpdates("network", 0L, 0.0F, locationListenerOldStrategy);
  }
  
  @SuppressLint({"NewApi"})
  private static boolean isLocationEnabled()
  {
    int j = 0;
    if (Build.VERSION.SDK_INT >= 19) {}
    while (!TextUtils.isEmpty(Settings.Secure.getString(mContext.getContentResolver(), "location_providers_allowed")))
    {
      try
      {
        i = Settings.Secure.getInt(mContext.getContentResolver(), "location_mode");
        if (i != 0) {
          return true;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i = j;
          if (Global.DEBUGERROR)
          {
            localException.printStackTrace();
            i = j;
          }
        }
      }
      return false;
    }
    return false;
  }
  
  private static void reset()
  {
    Logging.Log("LocationDirector reset called.");
    try
    {
      LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, getGPlayCollector());
      mGoogleApiClient.disconnect();
      mGoogleApiClient = null;
      try
      {
        oldStratLM.removeUpdates(locationListenerOldStrategy);
        oldStratLM = null;
        if (prefs == null) {
          prefs = mContext.getSharedPreferences("initPrefs", 0);
        }
        if (latestAccuracy != 0.0F)
        {
          prefs.edit().putString("kochava_lat", latestLat + "").apply();
          prefs.edit().putString("kochava_lon", latestLon + "").apply();
          prefs.edit().putString("kochava_accuracy", latestAccuracy + "").apply();
          prefs.edit().putLong("kochava_loc_timestamp", latestTimestamp).apply();
          Feature.locationHandler.sendEmptyMessage(0);
        }
        latestLat = 0.0D;
        latestLon = 0.0D;
        latestTimestamp = 0L;
        latestAccuracy = 0.0F;
        gatheringLocation = false;
        return;
      }
      catch (Error localError1)
      {
        for (;;) {}
      }
      catch (Exception localException1)
      {
        for (;;) {}
      }
    }
    catch (Error localError2)
    {
      for (;;) {}
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  private static void saveLocation(double paramDouble1, double paramDouble2, float paramFloat)
  {
    latestLat = paramDouble1;
    latestLon = paramDouble2;
    latestAccuracy = paramFloat;
    latestTimestamp = System.currentTimeMillis();
  }
  
  protected void buildAndConnectGoogleApiClient(Context paramContext)
    throws Error, Exception
  {
    try
    {
      mGoogleApiClient = new GoogleApiClient.Builder(paramContext).addConnectionCallbacks(getGPlayCollector()).addOnConnectionFailedListener(getGPlayCollector()).addApi(LocationServices.API).build();
      mGoogleApiClient.connect();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  protected void getLocation()
  {
    boolean bool2 = false;
    if (!isLocationEnabled()) {
      return;
    }
    if (gatheringLocation)
    {
      Logging.Log("Gather location called, but already gathering location.");
      return;
    }
    if (mContext.getPackageManager().checkPermission("android.permission.ACCESS_FINE_LOCATION", mContext.getPackageName()) < 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      haveFineLocation = bool1;
      bool1 = bool2;
      if (mContext.getPackageManager().checkPermission("android.permission.ACCESS_COARSE_LOCATION", mContext.getPackageName()) < 0) {
        bool1 = true;
      }
      haveCoarseLocation = bool1;
      if ((haveFineLocation) || (haveCoarseLocation)) {
        break;
      }
      Logging.Log("No location permissions, can't gather location.");
      return;
    }
    Logging.Log("Gathering location...");
    gatheringLocation = true;
    new Thread()
    {
      public void run()
      {
        try
        {
          Thread.sleep(LocationDirector.timeout * 1000);
          Logging.Log("timeout reached, calling reset");
          LocationDirector.access$000();
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
        }
      }
    }.start();
    int i = 0;
    try
    {
      buildAndConnectGoogleApiClient(mContext);
      if (i != 0)
      {
        Logging.Log("Error starting GPlay location services, starting up old Location gathering strategy.");
        getLocationOldStrategy();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = 1;
      }
    }
    catch (Error localError)
    {
      for (;;)
      {
        i = 1;
      }
      Logging.Log("No error starting GPlay location services.");
    }
  }
  
  static class LocationGPlayCollector
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, com.google.android.gms.location.LocationListener
  {
    /* Error */
    public void onConnected(Bundle paramBundle)
    {
      // Byte code:
      //   0: getstatic 30	com/google/android/gms/location/LocationServices:FusedLocationApi	Lcom/google/android/gms/location/FusedLocationProviderApi;
      //   3: invokestatic 34	com/kochava/android/tracker/LocationDirector:access$100	()Lcom/google/android/gms/common/api/GoogleApiClient;
      //   6: invokeinterface 40 2 0
      //   11: astore_1
      //   12: aload_1
      //   13: ifnull +312 -> 325
      //   16: ldc 42
      //   18: invokestatic 48	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   21: new 50	java/lang/StringBuilder
      //   24: dup
      //   25: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   28: ldc 53
      //   30: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   33: aload_1
      //   34: invokevirtual 63	android/location/Location:getLatitude	()D
      //   37: invokevirtual 66	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   40: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   43: invokestatic 48	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   46: new 50	java/lang/StringBuilder
      //   49: dup
      //   50: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   53: ldc 72
      //   55: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   58: aload_1
      //   59: invokevirtual 75	android/location/Location:getLongitude	()D
      //   62: invokevirtual 66	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   65: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   68: invokestatic 48	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   71: new 50	java/lang/StringBuilder
      //   74: dup
      //   75: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   78: ldc 77
      //   80: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   83: aload_1
      //   84: invokevirtual 81	android/location/Location:getAccuracy	()F
      //   87: invokevirtual 84	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
      //   90: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   93: invokestatic 48	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   96: aload_1
      //   97: invokestatic 88	com/kochava/android/tracker/LocationDirector:getLocationAge	(Landroid/location/Location;)J
      //   100: getstatic 92	com/kochava/android/tracker/LocationDirector:staleness	I
      //   103: sipush 1000
      //   106: imul
      //   107: i2l
      //   108: lcmp
      //   109: ifgt +39 -> 148
      //   112: aload_1
      //   113: invokevirtual 81	android/location/Location:getAccuracy	()F
      //   116: getstatic 95	com/kochava/android/tracker/LocationDirector:desiredAccuracy	I
      //   119: i2f
      //   120: fcmpg
      //   121: ifgt +27 -> 148
      //   124: ldc 97
      //   126: invokestatic 48	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   129: aload_1
      //   130: invokevirtual 63	android/location/Location:getLatitude	()D
      //   133: aload_1
      //   134: invokevirtual 75	android/location/Location:getLongitude	()D
      //   137: aload_1
      //   138: invokevirtual 81	android/location/Location:getAccuracy	()F
      //   141: invokestatic 101	com/kochava/android/tracker/LocationDirector:access$200	(DDF)V
      //   144: invokestatic 104	com/kochava/android/tracker/LocationDirector:access$000	()V
      //   147: return
      //   148: aload_1
      //   149: invokevirtual 81	android/location/Location:getAccuracy	()F
      //   152: invokestatic 107	com/kochava/android/tracker/LocationDirector:access$300	()F
      //   155: fcmpl
      //   156: iflt +11 -> 167
      //   159: invokestatic 107	com/kochava/android/tracker/LocationDirector:access$300	()F
      //   162: fconst_0
      //   163: fcmpl
      //   164: ifne +23 -> 187
      //   167: ldc 109
      //   169: invokestatic 48	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   172: aload_1
      //   173: invokevirtual 63	android/location/Location:getLatitude	()D
      //   176: aload_1
      //   177: invokevirtual 75	android/location/Location:getLongitude	()D
      //   180: aload_1
      //   181: invokevirtual 81	android/location/Location:getAccuracy	()F
      //   184: invokestatic 101	com/kochava/android/tracker/LocationDirector:access$200	(DDF)V
      //   187: iconst_0
      //   188: istore_3
      //   189: iload_3
      //   190: istore_2
      //   191: invokestatic 113	com/kochava/android/tracker/LocationDirector:access$400	()Z
      //   194: ifeq +49 -> 243
      //   197: ldc 115
      //   199: invokestatic 48	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   202: new 117	com/google/android/gms/location/LocationRequest
      //   205: dup
      //   206: invokespecial 118	com/google/android/gms/location/LocationRequest:<init>	()V
      //   209: astore_1
      //   210: aload_1
      //   211: ldc2_w 119
      //   214: invokevirtual 124	com/google/android/gms/location/LocationRequest:setInterval	(J)Lcom/google/android/gms/location/LocationRequest;
      //   217: pop
      //   218: aload_1
      //   219: bipush 100
      //   221: invokevirtual 128	com/google/android/gms/location/LocationRequest:setPriority	(I)Lcom/google/android/gms/location/LocationRequest;
      //   224: pop
      //   225: getstatic 30	com/google/android/gms/location/LocationServices:FusedLocationApi	Lcom/google/android/gms/location/FusedLocationProviderApi;
      //   228: invokestatic 34	com/kochava/android/tracker/LocationDirector:access$100	()Lcom/google/android/gms/common/api/GoogleApiClient;
      //   231: aload_1
      //   232: invokestatic 132	com/kochava/android/tracker/LocationDirector:access$500	()Lcom/kochava/android/tracker/LocationDirector$LocationGPlayCollector;
      //   235: invokeinterface 136 4 0
      //   240: pop
      //   241: iload_3
      //   242: istore_2
      //   243: invokestatic 113	com/kochava/android/tracker/LocationDirector:access$400	()Z
      //   246: ifeq +7 -> 253
      //   249: iload_2
      //   250: ifeq -103 -> 147
      //   253: ldc -118
      //   255: invokestatic 48	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   258: new 117	com/google/android/gms/location/LocationRequest
      //   261: dup
      //   262: invokespecial 118	com/google/android/gms/location/LocationRequest:<init>	()V
      //   265: astore_1
      //   266: aload_1
      //   267: ldc2_w 119
      //   270: invokevirtual 124	com/google/android/gms/location/LocationRequest:setInterval	(J)Lcom/google/android/gms/location/LocationRequest;
      //   273: pop
      //   274: aload_1
      //   275: bipush 102
      //   277: invokevirtual 128	com/google/android/gms/location/LocationRequest:setPriority	(I)Lcom/google/android/gms/location/LocationRequest;
      //   280: pop
      //   281: getstatic 30	com/google/android/gms/location/LocationServices:FusedLocationApi	Lcom/google/android/gms/location/FusedLocationProviderApi;
      //   284: invokestatic 34	com/kochava/android/tracker/LocationDirector:access$100	()Lcom/google/android/gms/common/api/GoogleApiClient;
      //   287: aload_1
      //   288: invokestatic 132	com/kochava/android/tracker/LocationDirector:access$500	()Lcom/kochava/android/tracker/LocationDirector$LocationGPlayCollector;
      //   291: invokeinterface 136 4 0
      //   296: pop
      //   297: return
      //   298: astore_1
      //   299: new 50	java/lang/StringBuilder
      //   302: dup
      //   303: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   306: ldc -116
      //   308: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   311: aload_1
      //   312: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
      //   315: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   318: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   321: invokestatic 48	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   324: return
      //   325: ldc -113
      //   327: invokestatic 48	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   330: goto -143 -> 187
      //   333: astore_1
      //   334: iconst_1
      //   335: istore_2
      //   336: new 50	java/lang/StringBuilder
      //   339: dup
      //   340: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   343: ldc -111
      //   345: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   348: aload_1
      //   349: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
      //   352: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   355: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   358: invokestatic 48	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   361: goto -118 -> 243
      //   364: astore_1
      //   365: iconst_1
      //   366: istore_2
      //   367: goto -124 -> 243
      //   370: astore_1
      //   371: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	372	0	this	LocationGPlayCollector
      //   0	372	1	paramBundle	Bundle
      //   190	177	2	i	int
      //   188	54	3	j	int
      // Exception table:
      //   from	to	target	type
      //   253	297	298	java/lang/Exception
      //   197	241	333	java/lang/Exception
      //   197	241	364	java/lang/Error
      //   253	297	370	java/lang/Error
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult) {}
    
    public void onConnectionSuspended(int paramInt) {}
    
    public void onLocationChanged(Location paramLocation)
    {
      Logging.Log("onLocationChanged GPlay");
      Logging.Log("lat " + paramLocation.getLatitude());
      Logging.Log("long " + paramLocation.getLongitude());
      Logging.Log("accuracy " + paramLocation.getAccuracy());
      if (paramLocation.getAccuracy() <= LocationDirector.desiredAccuracy)
      {
        LocationDirector.saveLocation(paramLocation.getLatitude(), paramLocation.getLongitude(), paramLocation.getAccuracy());
        LocationDirector.access$000();
      }
      while ((paramLocation.getAccuracy() >= LocationDirector.latestAccuracy) && (LocationDirector.latestAccuracy != 0.0F)) {
        return;
      }
      LocationDirector.saveLocation(paramLocation.getLatitude(), paramLocation.getLongitude(), paramLocation.getAccuracy());
    }
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.LocationDirector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */