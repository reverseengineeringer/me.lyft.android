package com.kochava.android.tracker;

import android.location.Location;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.kochava.android.util.Logging;

class LocationDirector$LocationGPlayCollector
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener
{
  /* Error */
  public void onConnected(android.os.Bundle paramBundle)
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
    //   0	372	1	paramBundle	android.os.Bundle
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
      LocationDirector.access$200(paramLocation.getLatitude(), paramLocation.getLongitude(), paramLocation.getAccuracy());
      LocationDirector.access$000();
    }
    while ((paramLocation.getAccuracy() >= LocationDirector.access$300()) && (LocationDirector.access$300() != 0.0F)) {
      return;
    }
    LocationDirector.access$200(paramLocation.getLatitude(), paramLocation.getLongitude(), paramLocation.getAccuracy());
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.LocationDirector.LocationGPlayCollector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */