package com.facebook.internal;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.facebook.FacebookException;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class AttributionIdentifiers
{
  private static final String ANDROID_ID_COLUMN_NAME = "androidid";
  private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
  private static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";
  private static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
  private static final int CONNECTION_RESULT_SUCCESS = 0;
  private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000L;
  private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
  private static final String TAG = AttributionIdentifiers.class.getCanonicalName();
  private static AttributionIdentifiers recentlyFetchedIdentifiers;
  private String androidAdvertiserId;
  private String androidInstallerPackage;
  private String attributionId;
  private long fetchTime;
  private boolean limitTracking;
  
  private static AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers paramAttributionIdentifiers)
  {
    fetchTime = System.currentTimeMillis();
    recentlyFetchedIdentifiers = paramAttributionIdentifiers;
    return paramAttributionIdentifiers;
  }
  
  private static AttributionIdentifiers getAndroidId(Context paramContext)
  {
    AttributionIdentifiers localAttributionIdentifiers = getAndroidIdViaReflection(paramContext);
    Object localObject = localAttributionIdentifiers;
    if (localAttributionIdentifiers == null)
    {
      paramContext = getAndroidIdViaService(paramContext);
      localObject = paramContext;
      if (paramContext == null) {
        localObject = new AttributionIdentifiers();
      }
    }
    return (AttributionIdentifiers)localObject;
  }
  
  private static AttributionIdentifiers getAndroidIdViaReflection(Context paramContext)
  {
    try
    {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        throw new FacebookException("getAndroidId cannot be called on the main thread.");
      }
    }
    catch (Exception paramContext)
    {
      Utility.logd("android_id", paramContext);
      return null;
    }
    Object localObject = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[] { Context.class });
    if (localObject == null) {
      return null;
    }
    localObject = Utility.invokeMethodQuietly(null, (Method)localObject, new Object[] { paramContext });
    if (((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 0))
    {
      localObject = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[] { Context.class });
      if (localObject == null) {
        return null;
      }
      paramContext = Utility.invokeMethodQuietly(null, (Method)localObject, new Object[] { paramContext });
      if (paramContext == null) {
        return null;
      }
      localObject = Utility.getMethodQuietly(paramContext.getClass(), "getId", new Class[0]);
      Method localMethod = Utility.getMethodQuietly(paramContext.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
      if ((localObject != null) && (localMethod != null))
      {
        AttributionIdentifiers localAttributionIdentifiers = new AttributionIdentifiers();
        androidAdvertiserId = ((String)Utility.invokeMethodQuietly(paramContext, (Method)localObject, new Object[0]));
        limitTracking = ((Boolean)Utility.invokeMethodQuietly(paramContext, localMethod, new Object[0])).booleanValue();
        return localAttributionIdentifiers;
      }
    }
    else
    {
      return null;
    }
    return null;
  }
  
  private static AttributionIdentifiers getAndroidIdViaService(Context paramContext)
  {
    GoogleAdServiceConnection localGoogleAdServiceConnection = new GoogleAdServiceConnection(null);
    Object localObject1 = new Intent("com.google.android.gms.ads.identifier.service.START");
    ((Intent)localObject1).setPackage("com.google.android.gms");
    if (paramContext.bindService((Intent)localObject1, localGoogleAdServiceConnection, 1)) {}
    try
    {
      localObject1 = new GoogleAdInfo(localGoogleAdServiceConnection.getBinder());
      AttributionIdentifiers localAttributionIdentifiers = new AttributionIdentifiers();
      androidAdvertiserId = ((GoogleAdInfo)localObject1).getAdvertiserId();
      limitTracking = ((GoogleAdInfo)localObject1).isTrackingLimited();
      return localAttributionIdentifiers;
    }
    catch (Exception localException)
    {
      Utility.logd("android_id", localException);
      return null;
    }
    finally
    {
      paramContext.unbindService(localGoogleAdServiceConnection);
    }
  }
  
  public static AttributionIdentifiers getAttributionIdentifiers(Context paramContext)
  {
    if ((recentlyFetchedIdentifiers != null) && (System.currentTimeMillis() - recentlyFetchedIdentifiersfetchTime < 3600000L)) {
      paramContext = recentlyFetchedIdentifiers;
    }
    for (;;)
    {
      return paramContext;
      AttributionIdentifiers localAttributionIdentifiers = getAndroidId(paramContext);
      Object localObject5 = null;
      Object localObject4 = null;
      Object localObject3 = null;
      Object localObject1 = localObject4;
      Object localObject2 = localObject5;
      try
      {
        if (paramContext.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", 0) != null)
        {
          localObject1 = localObject4;
          localObject2 = localObject5;
          localObject3 = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
        }
        for (;;)
        {
          localObject1 = localObject4;
          localObject2 = localObject5;
          String str = getInstallerPackageName(paramContext);
          if (str != null)
          {
            localObject1 = localObject4;
            localObject2 = localObject5;
            androidInstallerPackage = str;
          }
          if (localObject3 != null) {
            break label184;
          }
          localObject1 = localObject4;
          localObject2 = localObject5;
          paramContext = cacheAndReturnIdentifiers(localAttributionIdentifiers);
          if (0 == 0) {
            break;
          }
          throw new NullPointerException();
          localObject1 = localObject4;
          localObject2 = localObject5;
          if (paramContext.getPackageManager().resolveContentProvider("com.facebook.wakizashi.provider.AttributionIdProvider", 0) != null)
          {
            localObject1 = localObject4;
            localObject2 = localObject5;
            localObject3 = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
          }
        }
        label184:
        localObject1 = localObject4;
        localObject2 = localObject5;
        localObject3 = paramContext.getContentResolver().query((Uri)localObject3, new String[] { "aid", "androidid", "limit_tracking" }, null, null, null);
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (((Cursor)localObject3).moveToFirst()) {}
        }
        else
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          paramContext = cacheAndReturnIdentifiers(localAttributionIdentifiers);
          localObject1 = paramContext;
          paramContext = (Context)localObject1;
          return (AttributionIdentifiers)localObject1;
        }
        localObject1 = localObject3;
        localObject2 = localObject3;
        int i = ((Cursor)localObject3).getColumnIndex("aid");
        localObject1 = localObject3;
        localObject2 = localObject3;
        int k = ((Cursor)localObject3).getColumnIndex("androidid");
        localObject1 = localObject3;
        localObject2 = localObject3;
        int j = ((Cursor)localObject3).getColumnIndex("limit_tracking");
        localObject1 = localObject3;
        localObject2 = localObject3;
        attributionId = ((Cursor)localObject3).getString(i);
        if ((k > 0) && (j > 0))
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (localAttributionIdentifiers.getAndroidAdvertiserId() == null)
          {
            localObject1 = localObject3;
            localObject2 = localObject3;
            androidAdvertiserId = ((Cursor)localObject3).getString(k);
            localObject1 = localObject3;
            localObject2 = localObject3;
            limitTracking = Boolean.parseBoolean(((Cursor)localObject3).getString(j));
          }
        }
        return cacheAndReturnIdentifiers(localAttributionIdentifiers);
      }
      catch (Exception paramContext)
      {
        localObject2 = localObject1;
        Log.d(TAG, "Caught unexpected exception in getAttributionId(): " + paramContext.toString());
        paramContext = null;
        return null;
      }
      finally
      {
        if (localObject2 != null) {
          ((Cursor)localObject2).close();
        }
      }
    }
  }
  
  private static String getInstallerPackageName(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager != null) {
      return localPackageManager.getInstallerPackageName(paramContext.getPackageName());
    }
    return null;
  }
  
  public String getAndroidAdvertiserId()
  {
    return androidAdvertiserId;
  }
  
  public String getAndroidInstallerPackage()
  {
    return androidInstallerPackage;
  }
  
  public String getAttributionId()
  {
    return attributionId;
  }
  
  public boolean isTrackingLimited()
  {
    return limitTracking;
  }
  
  private static final class GoogleAdInfo
    implements IInterface
  {
    private static final int FIRST_TRANSACTION_CODE = 1;
    private static final int SECOND_TRANSACTION_CODE = 2;
    private IBinder binder;
    
    GoogleAdInfo(IBinder paramIBinder)
    {
      binder = paramIBinder;
    }
    
    public IBinder asBinder()
    {
      return binder;
    }
    
    public String getAdvertiserId()
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        binder.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        String str = localParcel2.readString();
        return str;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
    
    /* Error */
    public boolean isTrackingLimited()
      throws RemoteException
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   5: astore_3
      //   6: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   9: astore 4
      //   11: aload_3
      //   12: ldc 38
      //   14: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   17: aload_3
      //   18: iconst_1
      //   19: invokevirtual 64	android/os/Parcel:writeInt	(I)V
      //   22: aload_0
      //   23: getfield 23	com/facebook/internal/AttributionIdentifiers$GoogleAdInfo:binder	Landroid/os/IBinder;
      //   26: iconst_2
      //   27: aload_3
      //   28: aload 4
      //   30: iconst_0
      //   31: invokeinterface 48 5 0
      //   36: pop
      //   37: aload 4
      //   39: invokevirtual 51	android/os/Parcel:readException	()V
      //   42: aload 4
      //   44: invokevirtual 68	android/os/Parcel:readInt	()I
      //   47: istore_1
      //   48: iload_1
      //   49: ifeq +14 -> 63
      //   52: aload 4
      //   54: invokevirtual 57	android/os/Parcel:recycle	()V
      //   57: aload_3
      //   58: invokevirtual 57	android/os/Parcel:recycle	()V
      //   61: iload_2
      //   62: ireturn
      //   63: iconst_0
      //   64: istore_2
      //   65: goto -13 -> 52
      //   68: astore 5
      //   70: aload 4
      //   72: invokevirtual 57	android/os/Parcel:recycle	()V
      //   75: aload_3
      //   76: invokevirtual 57	android/os/Parcel:recycle	()V
      //   79: aload 5
      //   81: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	82	0	this	GoogleAdInfo
      //   47	2	1	i	int
      //   1	64	2	bool	boolean
      //   5	71	3	localParcel1	Parcel
      //   9	62	4	localParcel2	Parcel
      //   68	12	5	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   11	48	68	finally
    }
  }
  
  private static final class GoogleAdServiceConnection
    implements ServiceConnection
  {
    private AtomicBoolean consumed = new AtomicBoolean(false);
    private final BlockingQueue<IBinder> queue = new LinkedBlockingDeque();
    
    public IBinder getBinder()
      throws InterruptedException
    {
      if (consumed.compareAndSet(true, true)) {
        throw new IllegalStateException("Binder already consumed");
      }
      return (IBinder)queue.take();
    }
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      try
      {
        queue.put(paramIBinder);
        return;
      }
      catch (InterruptedException paramComponentName) {}
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName) {}
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.AttributionIdentifiers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */