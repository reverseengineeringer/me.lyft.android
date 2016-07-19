package com.google.android.gms.maps.internal;

import android.os.IBinder;

class zzs$zza$zza
  implements zzs
{
  private IBinder zzahn;
  
  zzs$zza$zza(IBinder paramIBinder)
  {
    zzahn = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zzahn;
  }
  
  /* Error */
  public boolean onMyLocationButtonClick()
    throws android.os.RemoteException
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore_3
    //   6: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore 4
    //   11: aload_3
    //   12: ldc 33
    //   14: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 18	com/google/android/gms/maps/internal/zzs$zza$zza:zzahn	Landroid/os/IBinder;
    //   21: iconst_1
    //   22: aload_3
    //   23: aload 4
    //   25: iconst_0
    //   26: invokeinterface 43 5 0
    //   31: pop
    //   32: aload 4
    //   34: invokevirtual 46	android/os/Parcel:readException	()V
    //   37: aload 4
    //   39: invokevirtual 50	android/os/Parcel:readInt	()I
    //   42: istore_1
    //   43: iload_1
    //   44: ifeq +14 -> 58
    //   47: aload 4
    //   49: invokevirtual 53	android/os/Parcel:recycle	()V
    //   52: aload_3
    //   53: invokevirtual 53	android/os/Parcel:recycle	()V
    //   56: iload_2
    //   57: ireturn
    //   58: iconst_0
    //   59: istore_2
    //   60: goto -13 -> 47
    //   63: astore 5
    //   65: aload 4
    //   67: invokevirtual 53	android/os/Parcel:recycle	()V
    //   70: aload_3
    //   71: invokevirtual 53	android/os/Parcel:recycle	()V
    //   74: aload 5
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	zza
    //   42	2	1	i	int
    //   1	59	2	bool	boolean
    //   5	66	3	localParcel1	android.os.Parcel
    //   9	57	4	localParcel2	android.os.Parcel
    //   63	12	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	43	63	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.internal.zzs.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */