package com.google.android.gms.maps.internal;

import android.os.IBinder;

class IProjectionDelegate$zza$zza
  implements IProjectionDelegate
{
  private IBinder zzahn;
  
  IProjectionDelegate$zza$zza(IBinder paramIBinder)
  {
    zzahn = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zzahn;
  }
  
  /* Error */
  public com.google.android.gms.maps.model.LatLng fromScreenLocation(com.google.android.gms.dynamic.zzd paramzzd)
    throws android.os.RemoteException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore_3
    //   6: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore 4
    //   11: aload_3
    //   12: ldc 33
    //   14: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +68 -> 86
    //   21: aload_1
    //   22: invokeinterface 41 1 0
    //   27: astore_1
    //   28: aload_3
    //   29: aload_1
    //   30: invokevirtual 44	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   33: aload_0
    //   34: getfield 18	com/google/android/gms/maps/internal/IProjectionDelegate$zza$zza:zzahn	Landroid/os/IBinder;
    //   37: iconst_1
    //   38: aload_3
    //   39: aload 4
    //   41: iconst_0
    //   42: invokeinterface 50 5 0
    //   47: pop
    //   48: aload 4
    //   50: invokevirtual 53	android/os/Parcel:readException	()V
    //   53: aload_2
    //   54: astore_1
    //   55: aload 4
    //   57: invokevirtual 57	android/os/Parcel:readInt	()I
    //   60: ifeq +15 -> 75
    //   63: getstatic 63	com/google/android/gms/maps/model/LatLng:CREATOR	Lcom/google/android/gms/maps/model/zze;
    //   66: aload 4
    //   68: invokevirtual 69	com/google/android/gms/maps/model/zze:createFromParcel	(Landroid/os/Parcel;)Ljava/lang/Object;
    //   71: checkcast 59	com/google/android/gms/maps/model/LatLng
    //   74: astore_1
    //   75: aload 4
    //   77: invokevirtual 72	android/os/Parcel:recycle	()V
    //   80: aload_3
    //   81: invokevirtual 72	android/os/Parcel:recycle	()V
    //   84: aload_1
    //   85: areturn
    //   86: aconst_null
    //   87: astore_1
    //   88: goto -60 -> 28
    //   91: astore_1
    //   92: aload 4
    //   94: invokevirtual 72	android/os/Parcel:recycle	()V
    //   97: aload_3
    //   98: invokevirtual 72	android/os/Parcel:recycle	()V
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	zza
    //   0	103	1	paramzzd	com.google.android.gms.dynamic.zzd
    //   1	53	2	localObject	Object
    //   5	93	3	localParcel1	android.os.Parcel
    //   9	84	4	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   11	17	91	finally
    //   21	28	91	finally
    //   28	53	91	finally
    //   55	75	91	finally
  }
  
  /* Error */
  public com.google.android.gms.maps.model.VisibleRegion getVisibleRegion()
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
    //   14: aload_0
    //   15: getfield 18	com/google/android/gms/maps/internal/IProjectionDelegate$zza$zza:zzahn	Landroid/os/IBinder;
    //   18: iconst_3
    //   19: aload_2
    //   20: aload_3
    //   21: iconst_0
    //   22: invokeinterface 50 5 0
    //   27: pop
    //   28: aload_3
    //   29: invokevirtual 53	android/os/Parcel:readException	()V
    //   32: aload_3
    //   33: invokevirtual 57	android/os/Parcel:readInt	()I
    //   36: ifeq +24 -> 60
    //   39: getstatic 80	com/google/android/gms/maps/model/VisibleRegion:CREATOR	Lcom/google/android/gms/maps/model/zzp;
    //   42: aload_3
    //   43: invokevirtual 83	com/google/android/gms/maps/model/zzp:createFromParcel	(Landroid/os/Parcel;)Ljava/lang/Object;
    //   46: checkcast 77	com/google/android/gms/maps/model/VisibleRegion
    //   49: astore_1
    //   50: aload_3
    //   51: invokevirtual 72	android/os/Parcel:recycle	()V
    //   54: aload_2
    //   55: invokevirtual 72	android/os/Parcel:recycle	()V
    //   58: aload_1
    //   59: areturn
    //   60: aconst_null
    //   61: astore_1
    //   62: goto -12 -> 50
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 72	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: invokevirtual 72	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	zza
    //   49	13	1	localVisibleRegion	com.google.android.gms.maps.model.VisibleRegion
    //   65	10	1	localObject	Object
    //   3	68	2	localParcel1	android.os.Parcel
    //   7	60	3	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   8	50	65	finally
  }
  
  /* Error */
  public com.google.android.gms.dynamic.zzd toScreenLocation(com.google.android.gms.maps.model.LatLng paramLatLng)
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
    //   15: ifnull +50 -> 65
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 89	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 93	com/google/android/gms/maps/model/LatLng:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 18	com/google/android/gms/maps/internal/IProjectionDelegate$zza$zza:zzahn	Landroid/os/IBinder;
    //   33: iconst_2
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 50 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 53	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 96	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   51: invokestatic 102	com/google/android/gms/dynamic/zzd$zza:zzfc	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/zzd;
    //   54: astore_1
    //   55: aload_3
    //   56: invokevirtual 72	android/os/Parcel:recycle	()V
    //   59: aload_2
    //   60: invokevirtual 72	android/os/Parcel:recycle	()V
    //   63: aload_1
    //   64: areturn
    //   65: aload_2
    //   66: iconst_0
    //   67: invokevirtual 89	android/os/Parcel:writeInt	(I)V
    //   70: goto -41 -> 29
    //   73: astore_1
    //   74: aload_3
    //   75: invokevirtual 72	android/os/Parcel:recycle	()V
    //   78: aload_2
    //   79: invokevirtual 72	android/os/Parcel:recycle	()V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	zza
    //   0	84	1	paramLatLng	com.google.android.gms.maps.model.LatLng
    //   3	76	2	localParcel1	android.os.Parcel
    //   7	68	3	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	73	finally
    //   18	29	73	finally
    //   29	55	73	finally
    //   65	70	73	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.internal.IProjectionDelegate.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */