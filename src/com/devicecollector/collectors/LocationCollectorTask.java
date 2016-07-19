package com.devicecollector.collectors;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.devicecollector.DataCollection;
import com.devicecollector.DataCollection.PostElement;
import java.util.Date;

public class LocationCollectorTask
  extends AbstractAsyncCollectorTask
  implements LocationListener
{
  private Location currentLocation;
  boolean foundLocation;
  private LocationManager locationManager;
  private Date started = new Date();
  
  public LocationCollectorTask(Activity paramActivity, CollectorStatusListener paramCollectorStatusListener, DataCollection paramDataCollection, long paramLong)
  {
    super(paramActivity, paramCollectorStatusListener, paramDataCollection, CollectorEnum.GEO_LOCATION, paramLong);
    locationManager = ((LocationManager)paramActivity.getApplicationContext().getSystemService("location"));
  }
  
  private void getOlderUpdate(String paramString)
  {
    locationManager.requestLocationUpdates(paramString, 1000L, 1.0F, this);
  }
  
  @TargetApi(9)
  private void getSingleUpdate(String paramString)
  {
    locationManager.requestSingleUpdate(paramString, this, null);
  }
  
  private boolean isBetterLocation(Location paramLocation1, Location paramLocation2)
  {
    if (paramLocation2 == null) {
      return true;
    }
    long l = paramLocation1.getTime() - paramLocation2.getTime();
    int j;
    int k;
    if (l > 3600000L)
    {
      j = 1;
      if (l >= 3600000L) {
        break label63;
      }
      k = 1;
      label41:
      if (l <= 0L) {
        break label69;
      }
    }
    label63:
    label69:
    for (int i = 1;; i = 0)
    {
      if (j == 0) {
        break label74;
      }
      return true;
      j = 0;
      break;
      k = 0;
      break label41;
    }
    label74:
    if (k != 0) {
      return false;
    }
    int m = (int)(paramLocation1.getAccuracy() - paramLocation2.getAccuracy());
    if (m > 0)
    {
      j = 1;
      if (m >= 0) {
        break label147;
      }
      k = 1;
      label109:
      if (m <= 200) {
        break label153;
      }
    }
    boolean bool;
    label147:
    label153:
    for (m = 1;; m = 0)
    {
      bool = isSameProvider(paramLocation1.getProvider(), paramLocation2.getProvider());
      if (k == 0) {
        break label159;
      }
      return true;
      j = 0;
      break;
      k = 0;
      break label109;
    }
    label159:
    if ((i != 0) && (j == 0)) {
      return true;
    }
    return (i != 0) && (m == 0) && (bool);
  }
  
  private boolean isSameProvider(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    return paramString1.equals(paramString2);
  }
  
  private void stopListening()
  {
    if (locationManager != null) {
      locationManager.removeUpdates(this);
    }
  }
  
  private void submitLocation()
  {
    if (currentLocation != null)
    {
      long l = (currentLocation.getTime() - started.getTime()) / 1000L;
      debug("Time it took:" + l, new Object[0]);
      dc.addMobileData(DataCollection.PostElement.LATITUDE, "" + currentLocation.getLatitude());
      dc.addMobileData(DataCollection.PostElement.LONGITUDE, "" + currentLocation.getLongitude());
      dc.addMobileData(DataCollection.PostElement.GEO_DATE, "" + currentLocation.getTime() / 1000L);
      dc.addMobileData(DataCollection.PostElement.GEO_PROVIDER, "" + currentLocation.getProvider());
      foundLocation = true;
    }
    for (;;)
    {
      finished = true;
      stopListening();
      endProcess(errorCode, errorCause);
      return;
      debug("No Location found.", new Object[0]);
      if (errorCode == null)
      {
        errorCode = SoftErrorCode.SERVICE_UNAVAILABLE;
        errorCause = new RuntimeException("No location found");
      }
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    stopListening();
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    if (isBetterLocation(paramLocation, currentLocation)) {
      currentLocation = paramLocation;
    }
    submitLocation();
  }
  
  public void onProviderDisabled(String paramString)
  {
    submitLocation();
  }
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
    if ((paramInt == 0) || (paramInt == 1)) {
      submitLocation();
    }
  }
  
  /* Error */
  protected void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 165	com/devicecollector/collectors/LocationCollectorTask:foundLocation	Z
    //   5: aconst_null
    //   6: astore_1
    //   7: aload_0
    //   8: ldc -38
    //   10: iconst_0
    //   11: anewarray 122	java/lang/Object
    //   14: invokevirtual 126	com/devicecollector/collectors/LocationCollectorTask:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: aload_0
    //   18: getfield 50	com/devicecollector/collectors/LocationCollectorTask:locationManager	Landroid/location/LocationManager;
    //   21: iconst_1
    //   22: invokevirtual 222	android/location/LocationManager:getProviders	(Z)Ljava/util/List;
    //   25: astore_2
    //   26: aload_2
    //   27: invokeinterface 228 1 0
    //   32: ifne +24 -> 56
    //   35: aload_0
    //   36: getstatic 189	com/devicecollector/collectors/SoftErrorCode:SERVICE_UNAVAILABLE	Lcom/devicecollector/collectors/SoftErrorCode;
    //   39: new 191	java/lang/RuntimeException
    //   42: dup
    //   43: getstatic 189	com/devicecollector/collectors/SoftErrorCode:SERVICE_UNAVAILABLE	Lcom/devicecollector/collectors/SoftErrorCode;
    //   46: invokevirtual 231	com/devicecollector/collectors/SoftErrorCode:name	()Ljava/lang/String;
    //   49: invokespecial 195	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   52: invokevirtual 182	com/devicecollector/collectors/LocationCollectorTask:endProcess	(Lcom/devicecollector/collectors/SoftErrorCode;Ljava/lang/Exception;)V
    //   55: return
    //   56: aload_2
    //   57: invokeinterface 235 1 0
    //   62: astore 4
    //   64: aload_1
    //   65: astore_2
    //   66: aload 4
    //   68: invokeinterface 241 1 0
    //   73: ifeq +191 -> 264
    //   76: aload 4
    //   78: invokeinterface 245 1 0
    //   83: checkcast 92	java/lang/String
    //   86: astore_3
    //   87: aload_0
    //   88: invokevirtual 248	com/devicecollector/collectors/LocationCollectorTask:isCancelled	()Z
    //   91: ifne -27 -> 64
    //   94: aload_0
    //   95: new 107	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   102: ldc -6
    //   104: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_3
    //   108: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc -4
    //   113: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: iconst_0
    //   120: anewarray 122	java/lang/Object
    //   123: invokevirtual 126	com/devicecollector/collectors/LocationCollectorTask:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: aload_1
    //   127: astore_2
    //   128: aload_1
    //   129: ifnonnull +5 -> 134
    //   132: aload_3
    //   133: astore_2
    //   134: aload_0
    //   135: getfield 50	com/devicecollector/collectors/LocationCollectorTask:locationManager	Landroid/location/LocationManager;
    //   138: ldc -2
    //   140: invokevirtual 258	android/location/LocationManager:getLastKnownLocation	(Ljava/lang/String;)Landroid/location/Location;
    //   143: astore 5
    //   145: aload_2
    //   146: astore_1
    //   147: aload 5
    //   149: ifnull -85 -> 64
    //   152: aload_2
    //   153: astore_1
    //   154: aload_0
    //   155: getfield 32	com/devicecollector/collectors/LocationCollectorTask:started	Ljava/util/Date;
    //   158: invokevirtual 105	java/util/Date:getTime	()J
    //   161: aload 5
    //   163: invokevirtual 76	android/location/Location:getTime	()J
    //   166: lsub
    //   167: ldc2_w 77
    //   170: lcmp
    //   171: ifge -107 -> 64
    //   174: aload_0
    //   175: new 107	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 260
    //   185: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload 5
    //   190: invokevirtual 86	android/location/Location:getProvider	()Ljava/lang/String;
    //   193: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: iconst_0
    //   200: anewarray 122	java/lang/Object
    //   203: invokevirtual 126	com/devicecollector/collectors/LocationCollectorTask:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: aload_0
    //   207: aload 5
    //   209: aload_0
    //   210: getfield 104	com/devicecollector/collectors/LocationCollectorTask:currentLocation	Landroid/location/Location;
    //   213: invokespecial 205	com/devicecollector/collectors/LocationCollectorTask:isBetterLocation	(Landroid/location/Location;Landroid/location/Location;)Z
    //   216: ifeq +48 -> 264
    //   219: aload_0
    //   220: new 107	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   227: aload 5
    //   229: invokevirtual 86	android/location/Location:getProvider	()Ljava/lang/String;
    //   232: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc_w 262
    //   238: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: iconst_0
    //   245: anewarray 122	java/lang/Object
    //   248: invokevirtual 126	com/devicecollector/collectors/LocationCollectorTask:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   251: aload_0
    //   252: aload 5
    //   254: putfield 104	com/devicecollector/collectors/LocationCollectorTask:currentLocation	Landroid/location/Location;
    //   257: aload_3
    //   258: astore_2
    //   259: aload_0
    //   260: iconst_1
    //   261: putfield 165	com/devicecollector/collectors/LocationCollectorTask:foundLocation	Z
    //   264: aload_0
    //   265: invokevirtual 248	com/devicecollector/collectors/LocationCollectorTask:isCancelled	()Z
    //   268: ifne +215 -> 483
    //   271: aload_0
    //   272: getfield 174	com/devicecollector/collectors/LocationCollectorTask:errorCode	Lcom/devicecollector/collectors/SoftErrorCode;
    //   275: ifnonnull +208 -> 483
    //   278: aload_0
    //   279: getfield 165	com/devicecollector/collectors/LocationCollectorTask:foundLocation	Z
    //   282: ifeq +7 -> 289
    //   285: aload_2
    //   286: ifnonnull +193 -> 479
    //   289: aload_0
    //   290: ldc_w 264
    //   293: iconst_0
    //   294: anewarray 122	java/lang/Object
    //   297: invokevirtual 126	com/devicecollector/collectors/LocationCollectorTask:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: aload_0
    //   301: monitorenter
    //   302: invokestatic 269	android/os/Looper:prepare	()V
    //   305: getstatic 275	android/os/Build$VERSION:SDK_INT	I
    //   308: bipush 8
    //   310: if_icmple +126 -> 436
    //   313: aload_0
    //   314: aload_2
    //   315: invokespecial 277	com/devicecollector/collectors/LocationCollectorTask:getSingleUpdate	(Ljava/lang/String;)V
    //   318: aload_0
    //   319: getfield 168	com/devicecollector/collectors/LocationCollectorTask:finished	Z
    //   322: ifne +80 -> 402
    //   325: aload_0
    //   326: invokevirtual 248	com/devicecollector/collectors/LocationCollectorTask:isCancelled	()Z
    //   329: ifne +73 -> 402
    //   332: aload_0
    //   333: ldc_w 279
    //   336: iconst_1
    //   337: anewarray 122	java/lang/Object
    //   340: dup
    //   341: iconst_0
    //   342: new 107	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   349: ldc -118
    //   351: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload_0
    //   355: invokevirtual 282	com/devicecollector/collectors/LocationCollectorTask:getTimeoutMs	()J
    //   358: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   361: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: aastore
    //   365: invokevirtual 126	com/devicecollector/collectors/LocationCollectorTask:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   368: aload_0
    //   369: aload_0
    //   370: invokevirtual 282	com/devicecollector/collectors/LocationCollectorTask:getTimeoutMs	()J
    //   373: invokevirtual 286	java/lang/Object:wait	(J)V
    //   376: aload_0
    //   377: ldc_w 288
    //   380: iconst_0
    //   381: anewarray 122	java/lang/Object
    //   384: invokevirtual 126	com/devicecollector/collectors/LocationCollectorTask:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   387: aload_0
    //   388: getfield 165	com/devicecollector/collectors/LocationCollectorTask:foundLocation	Z
    //   391: ifne +11 -> 402
    //   394: aload_0
    //   395: invokespecial 170	com/devicecollector/collectors/LocationCollectorTask:stopListening	()V
    //   398: aload_0
    //   399: invokevirtual 291	com/devicecollector/collectors/LocationCollectorTask:timeout	()V
    //   402: aload_0
    //   403: monitorexit
    //   404: return
    //   405: astore_1
    //   406: aload_0
    //   407: monitorexit
    //   408: aload_1
    //   409: athrow
    //   410: astore_1
    //   411: aload_0
    //   412: aload_1
    //   413: invokevirtual 294	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   416: iconst_0
    //   417: anewarray 122	java/lang/Object
    //   420: invokevirtual 126	com/devicecollector/collectors/LocationCollectorTask:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   423: aload_0
    //   424: getstatic 297	com/devicecollector/collectors/SoftErrorCode:PERMISSION_DENIED	Lcom/devicecollector/collectors/SoftErrorCode;
    //   427: putfield 174	com/devicecollector/collectors/LocationCollectorTask:errorCode	Lcom/devicecollector/collectors/SoftErrorCode;
    //   430: aload_0
    //   431: aload_1
    //   432: putfield 178	com/devicecollector/collectors/LocationCollectorTask:errorCause	Ljava/lang/Exception;
    //   435: return
    //   436: aload_0
    //   437: aload_2
    //   438: invokespecial 299	com/devicecollector/collectors/LocationCollectorTask:getOlderUpdate	(Ljava/lang/String;)V
    //   441: goto -123 -> 318
    //   444: astore_1
    //   445: aload_0
    //   446: new 107	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   453: ldc_w 301
    //   456: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload_1
    //   460: invokevirtual 302	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   463: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: iconst_0
    //   470: anewarray 122	java/lang/Object
    //   473: invokevirtual 126	com/devicecollector/collectors/LocationCollectorTask:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   476: goto -74 -> 402
    //   479: aload_0
    //   480: invokespecial 207	com/devicecollector/collectors/LocationCollectorTask:submitLocation	()V
    //   483: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	this	LocationCollectorTask
    //   6	148	1	localObject1	Object
    //   405	4	1	localObject2	Object
    //   410	22	1	localSecurityException	SecurityException
    //   444	16	1	localException	Exception
    //   25	413	2	localObject3	Object
    //   86	172	3	str	String
    //   62	15	4	localIterator	java.util.Iterator
    //   143	110	5	localLocation	Location
    // Exception table:
    //   from	to	target	type
    //   302	318	405	finally
    //   318	402	405	finally
    //   402	404	405	finally
    //   406	408	405	finally
    //   436	441	405	finally
    //   445	476	405	finally
    //   7	55	410	java/lang/SecurityException
    //   56	64	410	java/lang/SecurityException
    //   66	126	410	java/lang/SecurityException
    //   134	145	410	java/lang/SecurityException
    //   154	206	410	java/lang/SecurityException
    //   206	257	410	java/lang/SecurityException
    //   259	264	410	java/lang/SecurityException
    //   302	318	444	java/lang/Exception
    //   318	402	444	java/lang/Exception
    //   436	441	444	java/lang/Exception
  }
}

/* Location:
 * Qualified Name:     com.devicecollector.collectors.LocationCollectorTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */