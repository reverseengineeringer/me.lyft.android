package com.google.android.gms.maps.internal;

import android.os.IBinder;

class zzq$zza$zza
  implements zzq
{
  private IBinder zzahn;
  
  zzq$zza$zza(IBinder paramIBinder)
  {
    zzahn = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zzahn;
  }
  
  /* Error */
  public boolean zzd(com.google.android.gms.maps.model.internal.zzf paramzzf)
    throws android.os.RemoteException
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 5
    //   12: aload 4
    //   14: ldc 33
    //   16: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: aload_1
    //   20: ifnull +59 -> 79
    //   23: aload_1
    //   24: invokeinterface 41 1 0
    //   29: astore_1
    //   30: aload 4
    //   32: aload_1
    //   33: invokevirtual 44	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   36: aload_0
    //   37: getfield 18	com/google/android/gms/maps/internal/zzq$zza$zza:zzahn	Landroid/os/IBinder;
    //   40: iconst_1
    //   41: aload 4
    //   43: aload 5
    //   45: iconst_0
    //   46: invokeinterface 50 5 0
    //   51: pop
    //   52: aload 5
    //   54: invokevirtual 53	android/os/Parcel:readException	()V
    //   57: aload 5
    //   59: invokevirtual 57	android/os/Parcel:readInt	()I
    //   62: istore_2
    //   63: iload_2
    //   64: ifeq +20 -> 84
    //   67: aload 5
    //   69: invokevirtual 60	android/os/Parcel:recycle	()V
    //   72: aload 4
    //   74: invokevirtual 60	android/os/Parcel:recycle	()V
    //   77: iload_3
    //   78: ireturn
    //   79: aconst_null
    //   80: astore_1
    //   81: goto -51 -> 30
    //   84: iconst_0
    //   85: istore_3
    //   86: goto -19 -> 67
    //   89: astore_1
    //   90: aload 5
    //   92: invokevirtual 60	android/os/Parcel:recycle	()V
    //   95: aload 4
    //   97: invokevirtual 60	android/os/Parcel:recycle	()V
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	zza
    //   0	102	1	paramzzf	com.google.android.gms.maps.model.internal.zzf
    //   62	2	2	i	int
    //   1	85	3	bool	boolean
    //   5	91	4	localParcel1	android.os.Parcel
    //   10	81	5	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   12	19	89	finally
    //   23	30	89	finally
    //   30	63	89	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.internal.zzq.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */