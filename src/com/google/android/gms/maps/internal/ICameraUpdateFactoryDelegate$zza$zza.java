package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

class ICameraUpdateFactoryDelegate$zza$zza
  implements ICameraUpdateFactoryDelegate
{
  private IBinder zzahn;
  
  ICameraUpdateFactoryDelegate$zza$zza(IBinder paramIBinder)
  {
    zzahn = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zzahn;
  }
  
  /* Error */
  public zzd newCameraPosition(com.google.android.gms.maps.model.CameraPosition paramCameraPosition)
    throws RemoteException
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
    //   15: ifnull +51 -> 66
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 47	com/google/android/gms/maps/model/CameraPosition:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 18	com/google/android/gms/maps/internal/ICameraUpdateFactoryDelegate$zza$zza:zzahn	Landroid/os/IBinder;
    //   33: bipush 7
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 53 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 56	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 59	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   52: invokestatic 65	com/google/android/gms/dynamic/zzd$zza:zzfc	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/zzd;
    //   55: astore_1
    //   56: aload_3
    //   57: invokevirtual 68	android/os/Parcel:recycle	()V
    //   60: aload_2
    //   61: invokevirtual 68	android/os/Parcel:recycle	()V
    //   64: aload_1
    //   65: areturn
    //   66: aload_2
    //   67: iconst_0
    //   68: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   71: goto -42 -> 29
    //   74: astore_1
    //   75: aload_3
    //   76: invokevirtual 68	android/os/Parcel:recycle	()V
    //   79: aload_2
    //   80: invokevirtual 68	android/os/Parcel:recycle	()V
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	zza
    //   0	85	1	paramCameraPosition	com.google.android.gms.maps.model.CameraPosition
    //   3	77	2	localParcel1	Parcel
    //   7	69	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	74	finally
    //   18	29	74	finally
    //   29	56	74	finally
    //   66	71	74	finally
  }
  
  /* Error */
  public zzd newLatLng(com.google.android.gms.maps.model.LatLng paramLatLng)
    throws RemoteException
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
    //   15: ifnull +51 -> 66
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 74	com/google/android/gms/maps/model/LatLng:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 18	com/google/android/gms/maps/internal/ICameraUpdateFactoryDelegate$zza$zza:zzahn	Landroid/os/IBinder;
    //   33: bipush 8
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 53 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 56	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 59	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   52: invokestatic 65	com/google/android/gms/dynamic/zzd$zza:zzfc	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/zzd;
    //   55: astore_1
    //   56: aload_3
    //   57: invokevirtual 68	android/os/Parcel:recycle	()V
    //   60: aload_2
    //   61: invokevirtual 68	android/os/Parcel:recycle	()V
    //   64: aload_1
    //   65: areturn
    //   66: aload_2
    //   67: iconst_0
    //   68: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   71: goto -42 -> 29
    //   74: astore_1
    //   75: aload_3
    //   76: invokevirtual 68	android/os/Parcel:recycle	()V
    //   79: aload_2
    //   80: invokevirtual 68	android/os/Parcel:recycle	()V
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	zza
    //   0	85	1	paramLatLng	com.google.android.gms.maps.model.LatLng
    //   3	77	2	localParcel1	Parcel
    //   7	69	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	74	finally
    //   18	29	74	finally
    //   29	56	74	finally
    //   66	71	74	finally
  }
  
  /* Error */
  public zzd newLatLngBounds(com.google.android.gms.maps.model.LatLngBounds paramLatLngBounds, int paramInt)
    throws RemoteException
  {
    // Byte code:
    //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 33
    //   12: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +60 -> 76
    //   19: aload_3
    //   20: iconst_1
    //   21: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   24: aload_1
    //   25: aload_3
    //   26: iconst_0
    //   27: invokevirtual 79	com/google/android/gms/maps/model/LatLngBounds:writeToParcel	(Landroid/os/Parcel;I)V
    //   30: aload_3
    //   31: iload_2
    //   32: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   35: aload_0
    //   36: getfield 18	com/google/android/gms/maps/internal/ICameraUpdateFactoryDelegate$zza$zza:zzahn	Landroid/os/IBinder;
    //   39: bipush 10
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 53 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 56	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 59	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   61: invokestatic 65	com/google/android/gms/dynamic/zzd$zza:zzfc	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/zzd;
    //   64: astore_1
    //   65: aload 4
    //   67: invokevirtual 68	android/os/Parcel:recycle	()V
    //   70: aload_3
    //   71: invokevirtual 68	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: areturn
    //   76: aload_3
    //   77: iconst_0
    //   78: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   81: goto -51 -> 30
    //   84: astore_1
    //   85: aload 4
    //   87: invokevirtual 68	android/os/Parcel:recycle	()V
    //   90: aload_3
    //   91: invokevirtual 68	android/os/Parcel:recycle	()V
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	zza
    //   0	96	1	paramLatLngBounds	com.google.android.gms.maps.model.LatLngBounds
    //   0	96	2	paramInt	int
    //   3	88	3	localParcel1	Parcel
    //   7	79	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	84	finally
    //   19	30	84	finally
    //   30	65	84	finally
    //   76	81	84	finally
  }
  
  /* Error */
  public zzd newLatLngBoundsWithSize(com.google.android.gms.maps.model.LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException
  {
    // Byte code:
    //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 6
    //   10: aload 5
    //   12: ldc 33
    //   14: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +78 -> 96
    //   21: aload 5
    //   23: iconst_1
    //   24: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   27: aload_1
    //   28: aload 5
    //   30: iconst_0
    //   31: invokevirtual 79	com/google/android/gms/maps/model/LatLngBounds:writeToParcel	(Landroid/os/Parcel;I)V
    //   34: aload 5
    //   36: iload_2
    //   37: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   40: aload 5
    //   42: iload_3
    //   43: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   46: aload 5
    //   48: iload 4
    //   50: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   53: aload_0
    //   54: getfield 18	com/google/android/gms/maps/internal/ICameraUpdateFactoryDelegate$zza$zza:zzahn	Landroid/os/IBinder;
    //   57: bipush 11
    //   59: aload 5
    //   61: aload 6
    //   63: iconst_0
    //   64: invokeinterface 53 5 0
    //   69: pop
    //   70: aload 6
    //   72: invokevirtual 56	android/os/Parcel:readException	()V
    //   75: aload 6
    //   77: invokevirtual 59	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   80: invokestatic 65	com/google/android/gms/dynamic/zzd$zza:zzfc	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/zzd;
    //   83: astore_1
    //   84: aload 6
    //   86: invokevirtual 68	android/os/Parcel:recycle	()V
    //   89: aload 5
    //   91: invokevirtual 68	android/os/Parcel:recycle	()V
    //   94: aload_1
    //   95: areturn
    //   96: aload 5
    //   98: iconst_0
    //   99: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   102: goto -68 -> 34
    //   105: astore_1
    //   106: aload 6
    //   108: invokevirtual 68	android/os/Parcel:recycle	()V
    //   111: aload 5
    //   113: invokevirtual 68	android/os/Parcel:recycle	()V
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	zza
    //   0	118	1	paramLatLngBounds	com.google.android.gms.maps.model.LatLngBounds
    //   0	118	2	paramInt1	int
    //   0	118	3	paramInt2	int
    //   0	118	4	paramInt3	int
    //   3	109	5	localParcel1	Parcel
    //   8	99	6	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	17	105	finally
    //   21	34	105	finally
    //   34	84	105	finally
    //   96	102	105	finally
  }
  
  /* Error */
  public zzd newLatLngZoom(com.google.android.gms.maps.model.LatLng paramLatLng, float paramFloat)
    throws RemoteException
  {
    // Byte code:
    //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 33
    //   12: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +60 -> 76
    //   19: aload_3
    //   20: iconst_1
    //   21: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   24: aload_1
    //   25: aload_3
    //   26: iconst_0
    //   27: invokevirtual 74	com/google/android/gms/maps/model/LatLng:writeToParcel	(Landroid/os/Parcel;I)V
    //   30: aload_3
    //   31: fload_2
    //   32: invokevirtual 87	android/os/Parcel:writeFloat	(F)V
    //   35: aload_0
    //   36: getfield 18	com/google/android/gms/maps/internal/ICameraUpdateFactoryDelegate$zza$zza:zzahn	Landroid/os/IBinder;
    //   39: bipush 9
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 53 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 56	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 59	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   61: invokestatic 65	com/google/android/gms/dynamic/zzd$zza:zzfc	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/zzd;
    //   64: astore_1
    //   65: aload 4
    //   67: invokevirtual 68	android/os/Parcel:recycle	()V
    //   70: aload_3
    //   71: invokevirtual 68	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: areturn
    //   76: aload_3
    //   77: iconst_0
    //   78: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   81: goto -51 -> 30
    //   84: astore_1
    //   85: aload 4
    //   87: invokevirtual 68	android/os/Parcel:recycle	()V
    //   90: aload_3
    //   91: invokevirtual 68	android/os/Parcel:recycle	()V
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	zza
    //   0	96	1	paramLatLng	com.google.android.gms.maps.model.LatLng
    //   0	96	2	paramFloat	float
    //   3	88	3	localParcel1	Parcel
    //   7	79	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	84	finally
    //   19	30	84	finally
    //   30	65	84	finally
    //   76	81	84	finally
  }
  
  public zzd scrollBy(float paramFloat1, float paramFloat2)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      localParcel1.writeFloat(paramFloat1);
      localParcel1.writeFloat(paramFloat2);
      zzahn.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      zzd localzzd = zzd.zza.zzfc(localParcel2.readStrongBinder());
      return localzzd;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public zzd zoomBy(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      localParcel1.writeFloat(paramFloat);
      zzahn.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      zzd localzzd = zzd.zza.zzfc(localParcel2.readStrongBinder());
      return localzzd;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public zzd zoomByWithFocus(float paramFloat, int paramInt1, int paramInt2)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      localParcel1.writeFloat(paramFloat);
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      zzahn.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      zzd localzzd = zzd.zza.zzfc(localParcel2.readStrongBinder());
      return localzzd;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public zzd zoomIn()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      zzahn.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      zzd localzzd = zzd.zza.zzfc(localParcel2.readStrongBinder());
      return localzzd;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public zzd zoomOut()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      zzahn.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      zzd localzzd = zzd.zza.zzfc(localParcel2.readStrongBinder());
      return localzzd;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public zzd zoomTo(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      localParcel1.writeFloat(paramFloat);
      zzahn.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      zzd localzzd = zzd.zza.zzfc(localParcel2.readStrongBinder());
      return localzzd;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */