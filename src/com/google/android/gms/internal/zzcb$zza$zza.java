package com.google.android.gms.internal;

import android.os.IBinder;

class zzcb$zza$zza
  implements zzcb
{
  private IBinder zzahn;
  
  zzcb$zza$zza(IBinder paramIBinder)
  {
    zzahn = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zzahn;
  }
  
  /* Error */
  public IBinder zza(String paramString, com.google.android.gms.dynamic.zzd paramzzd)
    throws android.os.RemoteException
  {
    // Byte code:
    //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 32
    //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 39	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_2
    //   21: ifnull +52 -> 73
    //   24: aload_2
    //   25: invokeinterface 43 1 0
    //   30: astore_1
    //   31: aload_3
    //   32: aload_1
    //   33: invokevirtual 46	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   36: aload_0
    //   37: getfield 18	com/google/android/gms/internal/zzcb$zza$zza:zzahn	Landroid/os/IBinder;
    //   40: iconst_1
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 52 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 55	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 58	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   61: astore_1
    //   62: aload 4
    //   64: invokevirtual 61	android/os/Parcel:recycle	()V
    //   67: aload_3
    //   68: invokevirtual 61	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: areturn
    //   73: aconst_null
    //   74: astore_1
    //   75: goto -44 -> 31
    //   78: astore_1
    //   79: aload 4
    //   81: invokevirtual 61	android/os/Parcel:recycle	()V
    //   84: aload_3
    //   85: invokevirtual 61	android/os/Parcel:recycle	()V
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	zza
    //   0	90	1	paramString	String
    //   0	90	2	paramzzd	com.google.android.gms.dynamic.zzd
    //   3	82	3	localParcel1	android.os.Parcel
    //   7	73	4	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   9	20	78	finally
    //   24	31	78	finally
    //   31	62	78	finally
  }
  
  /* Error */
  public IBinder zzb(String paramString, com.google.android.gms.dynamic.zzd paramzzd)
    throws android.os.RemoteException
  {
    // Byte code:
    //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 32
    //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 39	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_2
    //   21: ifnull +52 -> 73
    //   24: aload_2
    //   25: invokeinterface 43 1 0
    //   30: astore_1
    //   31: aload_3
    //   32: aload_1
    //   33: invokevirtual 46	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   36: aload_0
    //   37: getfield 18	com/google/android/gms/internal/zzcb$zza$zza:zzahn	Landroid/os/IBinder;
    //   40: iconst_2
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 52 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 55	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 58	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   61: astore_1
    //   62: aload 4
    //   64: invokevirtual 61	android/os/Parcel:recycle	()V
    //   67: aload_3
    //   68: invokevirtual 61	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: areturn
    //   73: aconst_null
    //   74: astore_1
    //   75: goto -44 -> 31
    //   78: astore_1
    //   79: aload 4
    //   81: invokevirtual 61	android/os/Parcel:recycle	()V
    //   84: aload_3
    //   85: invokevirtual 61	android/os/Parcel:recycle	()V
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	zza
    //   0	90	1	paramString	String
    //   0	90	2	paramzzd	com.google.android.gms.dynamic.zzd
    //   3	82	3	localParcel1	android.os.Parcel
    //   7	73	4	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   9	20	78	finally
    //   24	31	78	finally
    //   31	62	78	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcb.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */