package com.google.android.gms.internal;

import android.os.IBinder;

class zzhu$zza$zza
  implements zzhu
{
  private IBinder zzahn;
  
  zzhu$zza$zza(IBinder paramIBinder)
  {
    zzahn = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zzahn;
  }
  
  /* Error */
  public IBinder zzo(com.google.android.gms.dynamic.zzd paramzzd)
    throws android.os.RemoteException
  {
    // Byte code:
    //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 33
    //   11: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +48 -> 63
    //   18: aload_1
    //   19: invokeinterface 41 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 44	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 18	com/google/android/gms/internal/zzhu$zza$zza:zzahn	Landroid/os/IBinder;
    //   34: iconst_1
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 50 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 53	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 56	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   52: astore_1
    //   53: aload_3
    //   54: invokevirtual 59	android/os/Parcel:recycle	()V
    //   57: aload_2
    //   58: invokevirtual 59	android/os/Parcel:recycle	()V
    //   61: aload_1
    //   62: areturn
    //   63: aconst_null
    //   64: astore_1
    //   65: goto -40 -> 25
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 59	android/os/Parcel:recycle	()V
    //   73: aload_2
    //   74: invokevirtual 59	android/os/Parcel:recycle	()V
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	zza
    //   0	79	1	paramzzd	com.google.android.gms.dynamic.zzd
    //   3	71	2	localParcel1	android.os.Parcel
    //   7	63	3	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	68	finally
    //   18	25	68	finally
    //   25	53	68	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhu.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */