package com.google.android.gms.internal;

import android.os.IBinder;

class zzsk$zza$zza
  implements zzsk
{
  private IBinder zzahn;
  
  zzsk$zza$zza(IBinder paramIBinder)
  {
    zzahn = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zzahn;
  }
  
  /* Error */
  public int zza(com.google.android.gms.dynamic.zzd paramzzd, String paramString, boolean paramBoolean)
    throws android.os.RemoteException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 5
    //   8: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 6
    //   13: aload 5
    //   15: ldc 32
    //   17: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: ifnull +77 -> 98
    //   24: aload_1
    //   25: invokeinterface 40 1 0
    //   30: astore_1
    //   31: aload 5
    //   33: aload_1
    //   34: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   37: aload 5
    //   39: aload_2
    //   40: invokevirtual 46	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   43: iload_3
    //   44: ifeq +6 -> 50
    //   47: iconst_1
    //   48: istore 4
    //   50: aload 5
    //   52: iload 4
    //   54: invokevirtual 50	android/os/Parcel:writeInt	(I)V
    //   57: aload_0
    //   58: getfield 18	com/google/android/gms/internal/zzsk$zza$zza:zzahn	Landroid/os/IBinder;
    //   61: iconst_3
    //   62: aload 5
    //   64: aload 6
    //   66: iconst_0
    //   67: invokeinterface 56 5 0
    //   72: pop
    //   73: aload 6
    //   75: invokevirtual 59	android/os/Parcel:readException	()V
    //   78: aload 6
    //   80: invokevirtual 63	android/os/Parcel:readInt	()I
    //   83: istore 4
    //   85: aload 6
    //   87: invokevirtual 66	android/os/Parcel:recycle	()V
    //   90: aload 5
    //   92: invokevirtual 66	android/os/Parcel:recycle	()V
    //   95: iload 4
    //   97: ireturn
    //   98: aconst_null
    //   99: astore_1
    //   100: goto -69 -> 31
    //   103: astore_1
    //   104: aload 6
    //   106: invokevirtual 66	android/os/Parcel:recycle	()V
    //   109: aload 5
    //   111: invokevirtual 66	android/os/Parcel:recycle	()V
    //   114: aload_1
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	zza
    //   0	116	1	paramzzd	com.google.android.gms.dynamic.zzd
    //   0	116	2	paramString	String
    //   0	116	3	paramBoolean	boolean
    //   1	95	4	i	int
    //   6	104	5	localParcel1	android.os.Parcel
    //   11	94	6	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   13	20	103	finally
    //   24	31	103	finally
    //   31	43	103	finally
    //   50	85	103	finally
  }
  
  /* Error */
  public com.google.android.gms.dynamic.zzd zza(com.google.android.gms.dynamic.zzd paramzzd, String paramString, int paramInt)
    throws android.os.RemoteException
  {
    // Byte code:
    //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 5
    //   10: aload 4
    //   12: ldc 32
    //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +70 -> 88
    //   21: aload_1
    //   22: invokeinterface 40 1 0
    //   27: astore_1
    //   28: aload 4
    //   30: aload_1
    //   31: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   34: aload 4
    //   36: aload_2
    //   37: invokevirtual 46	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   40: aload 4
    //   42: iload_3
    //   43: invokevirtual 50	android/os/Parcel:writeInt	(I)V
    //   46: aload_0
    //   47: getfield 18	com/google/android/gms/internal/zzsk$zza$zza:zzahn	Landroid/os/IBinder;
    //   50: iconst_2
    //   51: aload 4
    //   53: aload 5
    //   55: iconst_0
    //   56: invokeinterface 56 5 0
    //   61: pop
    //   62: aload 5
    //   64: invokevirtual 59	android/os/Parcel:readException	()V
    //   67: aload 5
    //   69: invokevirtual 71	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   72: invokestatic 77	com/google/android/gms/dynamic/zzd$zza:zzfc	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/zzd;
    //   75: astore_1
    //   76: aload 5
    //   78: invokevirtual 66	android/os/Parcel:recycle	()V
    //   81: aload 4
    //   83: invokevirtual 66	android/os/Parcel:recycle	()V
    //   86: aload_1
    //   87: areturn
    //   88: aconst_null
    //   89: astore_1
    //   90: goto -62 -> 28
    //   93: astore_1
    //   94: aload 5
    //   96: invokevirtual 66	android/os/Parcel:recycle	()V
    //   99: aload 4
    //   101: invokevirtual 66	android/os/Parcel:recycle	()V
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	zza
    //   0	106	1	paramzzd	com.google.android.gms.dynamic.zzd
    //   0	106	2	paramString	String
    //   0	106	3	paramInt	int
    //   3	97	4	localParcel1	android.os.Parcel
    //   8	87	5	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   10	17	93	finally
    //   21	28	93	finally
    //   28	76	93	finally
  }
  
  /* Error */
  public int zzd(com.google.android.gms.dynamic.zzd paramzzd, String paramString)
    throws android.os.RemoteException
  {
    // Byte code:
    //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 5
    //   10: aload 4
    //   12: ldc 32
    //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +61 -> 79
    //   21: aload_1
    //   22: invokeinterface 40 1 0
    //   27: astore_1
    //   28: aload 4
    //   30: aload_1
    //   31: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   34: aload 4
    //   36: aload_2
    //   37: invokevirtual 46	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   40: aload_0
    //   41: getfield 18	com/google/android/gms/internal/zzsk$zza$zza:zzahn	Landroid/os/IBinder;
    //   44: iconst_1
    //   45: aload 4
    //   47: aload 5
    //   49: iconst_0
    //   50: invokeinterface 56 5 0
    //   55: pop
    //   56: aload 5
    //   58: invokevirtual 59	android/os/Parcel:readException	()V
    //   61: aload 5
    //   63: invokevirtual 63	android/os/Parcel:readInt	()I
    //   66: istore_3
    //   67: aload 5
    //   69: invokevirtual 66	android/os/Parcel:recycle	()V
    //   72: aload 4
    //   74: invokevirtual 66	android/os/Parcel:recycle	()V
    //   77: iload_3
    //   78: ireturn
    //   79: aconst_null
    //   80: astore_1
    //   81: goto -53 -> 28
    //   84: astore_1
    //   85: aload 5
    //   87: invokevirtual 66	android/os/Parcel:recycle	()V
    //   90: aload 4
    //   92: invokevirtual 66	android/os/Parcel:recycle	()V
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	zza
    //   0	97	1	paramzzd	com.google.android.gms.dynamic.zzd
    //   0	97	2	paramString	String
    //   66	12	3	i	int
    //   3	88	4	localParcel1	android.os.Parcel
    //   8	78	5	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   10	17	84	finally
    //   21	28	84	finally
    //   28	67	84	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsk.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */