package com.google.android.gms.maps.model.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class zzf$zza$zza
  implements zzf
{
  private IBinder zzahn;
  
  zzf$zza$zza(IBinder paramIBinder)
  {
    zzahn = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zzahn;
  }
  
  public float getAlpha()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      zzahn.transact(26, localParcel1, localParcel2, 0);
      localParcel2.readException();
      float f = localParcel2.readFloat();
      return f;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String getId()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      zzahn.transact(2, localParcel1, localParcel2, 0);
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
  public com.google.android.gms.maps.model.LatLng getPosition()
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
    //   14: aload_0
    //   15: getfield 18	com/google/android/gms/maps/model/internal/zzf$zza$zza:zzahn	Landroid/os/IBinder;
    //   18: iconst_4
    //   19: aload_2
    //   20: aload_3
    //   21: iconst_0
    //   22: invokeinterface 43 5 0
    //   27: pop
    //   28: aload_3
    //   29: invokevirtual 46	android/os/Parcel:readException	()V
    //   32: aload_3
    //   33: invokevirtual 64	android/os/Parcel:readInt	()I
    //   36: ifeq +24 -> 60
    //   39: getstatic 70	com/google/android/gms/maps/model/LatLng:CREATOR	Lcom/google/android/gms/maps/model/zze;
    //   42: aload_3
    //   43: invokevirtual 76	com/google/android/gms/maps/model/zze:createFromParcel	(Landroid/os/Parcel;)Ljava/lang/Object;
    //   46: checkcast 66	com/google/android/gms/maps/model/LatLng
    //   49: astore_1
    //   50: aload_3
    //   51: invokevirtual 52	android/os/Parcel:recycle	()V
    //   54: aload_2
    //   55: invokevirtual 52	android/os/Parcel:recycle	()V
    //   58: aload_1
    //   59: areturn
    //   60: aconst_null
    //   61: astore_1
    //   62: goto -12 -> 50
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 52	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: invokevirtual 52	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	zza
    //   49	13	1	localLatLng	com.google.android.gms.maps.model.LatLng
    //   65	10	1	localObject	Object
    //   3	68	2	localParcel1	Parcel
    //   7	60	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	50	65	finally
  }
  
  public float getRotation()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      zzahn.transact(23, localParcel1, localParcel2, 0);
      localParcel2.readException();
      float f = localParcel2.readFloat();
      return f;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String getSnippet()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      zzahn.transact(8, localParcel1, localParcel2, 0);
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
  
  public String getTitle()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      zzahn.transact(6, localParcel1, localParcel2, 0);
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
  
  public float getZIndex()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      zzahn.transact(28, localParcel1, localParcel2, 0);
      localParcel2.readException();
      float f = localParcel2.readFloat();
      return f;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int hashCodeRemote()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      zzahn.transact(17, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void hideInfoWindow()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      zzahn.transact(12, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean isDraggable()
    throws RemoteException
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      zzahn.transact(10, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean isFlat()
    throws RemoteException
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      zzahn.transact(21, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean isInfoWindowShown()
    throws RemoteException
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      zzahn.transact(13, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean isVisible()
    throws RemoteException
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      zzahn.transact(15, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void remove()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      zzahn.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void setAlpha(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      localParcel1.writeFloat(paramFloat);
      zzahn.transact(25, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      localParcel1.writeFloat(paramFloat1);
      localParcel1.writeFloat(paramFloat2);
      zzahn.transact(19, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void setDraggable(boolean paramBoolean)
    throws RemoteException
  {
    int i = 0;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      zzahn.transact(9, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void setFlat(boolean paramBoolean)
    throws RemoteException
  {
    int i = 0;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      zzahn.transact(20, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void setInfoWindowAnchor(float paramFloat1, float paramFloat2)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      localParcel1.writeFloat(paramFloat1);
      localParcel1.writeFloat(paramFloat2);
      zzahn.transact(24, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void setPosition(com.google.android.gms.maps.model.LatLng paramLatLng)
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
    //   15: ifnull +41 -> 56
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 101	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 109	com/google/android/gms/maps/model/LatLng:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 18	com/google/android/gms/maps/model/internal/zzf$zza$zza:zzahn	Landroid/os/IBinder;
    //   33: iconst_3
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 43 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 46	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 52	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 52	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 101	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 52	android/os/Parcel:recycle	()V
    //   69: aload_2
    //   70: invokevirtual 52	android/os/Parcel:recycle	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	zza
    //   0	75	1	paramLatLng	com.google.android.gms.maps.model.LatLng
    //   3	67	2	localParcel1	Parcel
    //   7	59	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	64	finally
    //   18	29	64	finally
    //   29	47	64	finally
    //   56	61	64	finally
  }
  
  public void setRotation(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      localParcel1.writeFloat(paramFloat);
      zzahn.transact(22, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void setSnippet(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      localParcel1.writeString(paramString);
      zzahn.transact(7, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void setTitle(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      localParcel1.writeString(paramString);
      zzahn.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void setVisible(boolean paramBoolean)
    throws RemoteException
  {
    int i = 0;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      zzahn.transact(14, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void setZIndex(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      localParcel1.writeFloat(paramFloat);
      zzahn.transact(27, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void showInfoWindow()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      zzahn.transact(11, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void zzak(com.google.android.gms.dynamic.zzd paramzzd)
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
    //   15: ifnull +43 -> 58
    //   18: aload_1
    //   19: invokeinterface 124 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 127	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 18	com/google/android/gms/maps/model/internal/zzf$zza$zza:zzahn	Landroid/os/IBinder;
    //   34: bipush 18
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 43 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 46	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 52	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 52	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 52	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 52	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	zza
    //   0	74	1	paramzzd	com.google.android.gms.dynamic.zzd
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
  
  /* Error */
  public boolean zzj(zzf paramzzf)
    throws RemoteException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 5
    //   12: aload 4
    //   14: ldc 33
    //   16: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: aload_1
    //   20: ifnull +62 -> 82
    //   23: aload_1
    //   24: invokeinterface 130 1 0
    //   29: astore_1
    //   30: aload 4
    //   32: aload_1
    //   33: invokevirtual 127	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   36: aload_0
    //   37: getfield 18	com/google/android/gms/maps/model/internal/zzf$zza$zza:zzahn	Landroid/os/IBinder;
    //   40: bipush 16
    //   42: aload 4
    //   44: aload 5
    //   46: iconst_0
    //   47: invokeinterface 43 5 0
    //   52: pop
    //   53: aload 5
    //   55: invokevirtual 46	android/os/Parcel:readException	()V
    //   58: aload 5
    //   60: invokevirtual 64	android/os/Parcel:readInt	()I
    //   63: istore_2
    //   64: iload_2
    //   65: ifeq +5 -> 70
    //   68: iconst_1
    //   69: istore_3
    //   70: aload 5
    //   72: invokevirtual 52	android/os/Parcel:recycle	()V
    //   75: aload 4
    //   77: invokevirtual 52	android/os/Parcel:recycle	()V
    //   80: iload_3
    //   81: ireturn
    //   82: aconst_null
    //   83: astore_1
    //   84: goto -54 -> 30
    //   87: astore_1
    //   88: aload 5
    //   90: invokevirtual 52	android/os/Parcel:recycle	()V
    //   93: aload 4
    //   95: invokevirtual 52	android/os/Parcel:recycle	()V
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	zza
    //   0	100	1	paramzzf	zzf
    //   63	2	2	i	int
    //   1	80	3	bool	boolean
    //   5	89	4	localParcel1	Parcel
    //   10	79	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   12	19	87	finally
    //   23	30	87	finally
    //   30	64	87	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.model.internal.zzf.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */