package io.fabric.sdk.android.services.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class AdvertisingInfoServiceStrategy
  implements AdvertisingInfoStrategy
{
  private final Context context;
  
  public AdvertisingInfoServiceStrategy(Context paramContext)
  {
    context = paramContext.getApplicationContext();
  }
  
  /* Error */
  public AdvertisingInfo getAdvertisingInfo()
  {
    // Byte code:
    //   0: invokestatic 44	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   3: invokestatic 47	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   6: if_acmpne +17 -> 23
    //   9: invokestatic 53	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   12: ldc 55
    //   14: ldc 57
    //   16: invokeinterface 63 3 0
    //   21: aconst_null
    //   22: areturn
    //   23: aload_0
    //   24: getfield 29	io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy:context	Landroid/content/Context;
    //   27: invokevirtual 67	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   30: ldc 69
    //   32: iconst_0
    //   33: invokevirtual 75	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   36: pop
    //   37: new 10	io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy$AdvertisingConnection
    //   40: dup
    //   41: aconst_null
    //   42: invokespecial 78	io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy$AdvertisingConnection:<init>	(Lio/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy$1;)V
    //   45: astore_2
    //   46: new 80	android/content/Intent
    //   49: dup
    //   50: ldc 82
    //   52: invokespecial 85	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   55: astore_3
    //   56: aload_3
    //   57: ldc 87
    //   59: invokevirtual 91	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   62: pop
    //   63: aload_0
    //   64: getfield 29	io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy:context	Landroid/content/Context;
    //   67: aload_3
    //   68: aload_2
    //   69: iconst_1
    //   70: invokevirtual 95	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   73: istore_1
    //   74: iload_1
    //   75: ifeq +123 -> 198
    //   78: new 13	io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy$AdvertisingInterface
    //   81: dup
    //   82: aload_2
    //   83: invokevirtual 99	io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy$AdvertisingConnection:getBinder	()Landroid/os/IBinder;
    //   86: invokespecial 102	io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy$AdvertisingInterface:<init>	(Landroid/os/IBinder;)V
    //   89: astore_3
    //   90: new 104	io/fabric/sdk/android/services/common/AdvertisingInfo
    //   93: dup
    //   94: aload_3
    //   95: invokevirtual 108	io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy$AdvertisingInterface:getId	()Ljava/lang/String;
    //   98: aload_3
    //   99: invokevirtual 112	io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy$AdvertisingInterface:isLimitAdTrackingEnabled	()Z
    //   102: invokespecial 115	io/fabric/sdk/android/services/common/AdvertisingInfo:<init>	(Ljava/lang/String;Z)V
    //   105: astore_3
    //   106: aload_0
    //   107: getfield 29	io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy:context	Landroid/content/Context;
    //   110: aload_2
    //   111: invokevirtual 119	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   114: aload_3
    //   115: areturn
    //   116: astore_2
    //   117: invokestatic 53	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   120: ldc 55
    //   122: ldc 121
    //   124: invokeinterface 63 3 0
    //   129: aconst_null
    //   130: areturn
    //   131: astore_2
    //   132: invokestatic 53	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   135: ldc 55
    //   137: ldc 123
    //   139: aload_2
    //   140: invokeinterface 126 4 0
    //   145: aconst_null
    //   146: areturn
    //   147: astore_3
    //   148: invokestatic 53	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   151: ldc 55
    //   153: ldc -128
    //   155: aload_3
    //   156: invokeinterface 131 4 0
    //   161: aload_0
    //   162: getfield 29	io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy:context	Landroid/content/Context;
    //   165: aload_2
    //   166: invokevirtual 119	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_2
    //   172: invokestatic 53	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   175: ldc 55
    //   177: ldc -123
    //   179: aload_2
    //   180: invokeinterface 126 4 0
    //   185: aconst_null
    //   186: areturn
    //   187: astore_3
    //   188: aload_0
    //   189: getfield 29	io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy:context	Landroid/content/Context;
    //   192: aload_2
    //   193: invokevirtual 119	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   196: aload_3
    //   197: athrow
    //   198: invokestatic 53	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   201: ldc 55
    //   203: ldc -123
    //   205: invokeinterface 63 3 0
    //   210: aconst_null
    //   211: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	AdvertisingInfoServiceStrategy
    //   73	2	1	bool	boolean
    //   45	66	2	localAdvertisingConnection	AdvertisingConnection
    //   116	1	2	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   131	35	2	localException1	Exception
    //   171	22	2	localThrowable	Throwable
    //   55	60	3	localObject1	Object
    //   147	9	3	localException2	Exception
    //   187	10	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	37	116	android/content/pm/PackageManager$NameNotFoundException
    //   23	37	131	java/lang/Exception
    //   78	106	147	java/lang/Exception
    //   63	74	171	java/lang/Throwable
    //   106	114	171	java/lang/Throwable
    //   161	169	171	java/lang/Throwable
    //   188	198	171	java/lang/Throwable
    //   198	210	171	java/lang/Throwable
    //   78	106	187	finally
    //   148	161	187	finally
  }
  
  private static final class AdvertisingConnection
    implements ServiceConnection
  {
    private final LinkedBlockingQueue<IBinder> queue = new LinkedBlockingQueue(1);
    private boolean retrieved = false;
    
    public IBinder getBinder()
    {
      if (retrieved) {
        Fabric.getLogger().e("Fabric", "getBinder already called");
      }
      retrieved = true;
      try
      {
        IBinder localIBinder = (IBinder)queue.poll(200L, TimeUnit.MILLISECONDS);
        return localIBinder;
      }
      catch (InterruptedException localInterruptedException) {}
      return null;
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
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      queue.clear();
    }
  }
  
  private static final class AdvertisingInterface
    implements IInterface
  {
    private final IBinder binder;
    
    public AdvertisingInterface(IBinder paramIBinder)
    {
      binder = paramIBinder;
    }
    
    public IBinder asBinder()
    {
      return binder;
    }
    
    public String getId()
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
      catch (Exception localException)
      {
        Fabric.getLogger().d("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
        return null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
    
    /* Error */
    public boolean isLimitAdTrackingEnabled()
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_3
      //   4: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   7: astore 4
      //   9: aload_3
      //   10: ldc 35
      //   12: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   15: aload_3
      //   16: iconst_1
      //   17: invokevirtual 77	android/os/Parcel:writeInt	(I)V
      //   20: aload_0
      //   21: getfield 18	io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy$AdvertisingInterface:binder	Landroid/os/IBinder;
      //   24: iconst_2
      //   25: aload_3
      //   26: aload 4
      //   28: iconst_0
      //   29: invokeinterface 45 5 0
      //   34: pop
      //   35: aload 4
      //   37: invokevirtual 48	android/os/Parcel:readException	()V
      //   40: aload 4
      //   42: invokevirtual 81	android/os/Parcel:readInt	()I
      //   45: istore_1
      //   46: iload_1
      //   47: ifeq +16 -> 63
      //   50: iconst_1
      //   51: istore_2
      //   52: aload 4
      //   54: invokevirtual 54	android/os/Parcel:recycle	()V
      //   57: aload_3
      //   58: invokevirtual 54	android/os/Parcel:recycle	()V
      //   61: iload_2
      //   62: ireturn
      //   63: iconst_0
      //   64: istore_2
      //   65: goto -13 -> 52
      //   68: astore 5
      //   70: invokestatic 60	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
      //   73: ldc 62
      //   75: ldc 83
      //   77: invokeinterface 70 3 0
      //   82: aload 4
      //   84: invokevirtual 54	android/os/Parcel:recycle	()V
      //   87: aload_3
      //   88: invokevirtual 54	android/os/Parcel:recycle	()V
      //   91: iconst_0
      //   92: ireturn
      //   93: astore 5
      //   95: aload 4
      //   97: invokevirtual 54	android/os/Parcel:recycle	()V
      //   100: aload_3
      //   101: invokevirtual 54	android/os/Parcel:recycle	()V
      //   104: aload 5
      //   106: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	107	0	this	AdvertisingInterface
      //   45	2	1	i	int
      //   51	14	2	bool	boolean
      //   3	98	3	localParcel1	Parcel
      //   7	89	4	localParcel2	Parcel
      //   68	1	5	localException	Exception
      //   93	12	5	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   9	46	68	java/lang/Exception
      //   9	46	93	finally
      //   70	82	93	finally
    }
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.AdvertisingInfoServiceStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */