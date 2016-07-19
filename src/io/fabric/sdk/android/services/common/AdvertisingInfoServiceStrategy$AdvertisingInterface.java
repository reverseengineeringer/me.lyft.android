package io.fabric.sdk.android.services.common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;

final class AdvertisingInfoServiceStrategy$AdvertisingInterface
  implements IInterface
{
  private final IBinder binder;
  
  public AdvertisingInfoServiceStrategy$AdvertisingInterface(IBinder paramIBinder)
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

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.AdvertisingInfoServiceStrategy.AdvertisingInterface
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */