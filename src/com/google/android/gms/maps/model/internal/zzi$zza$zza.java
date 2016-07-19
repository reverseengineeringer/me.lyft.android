package com.google.android.gms.maps.model.internal;

import android.os.IBinder;

class zzi$zza$zza
  implements zzi
{
  private IBinder zzahn;
  
  zzi$zza$zza(IBinder paramIBinder)
  {
    zzahn = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zzahn;
  }
  
  /* Error */
  public com.google.android.gms.maps.model.Tile getTile(int paramInt1, int paramInt2, int paramInt3)
    throws android.os.RemoteException
  {
    // Byte code:
    //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 6
    //   10: aload 5
    //   12: ldc 33
    //   14: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 5
    //   19: iload_1
    //   20: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   23: aload 5
    //   25: iload_2
    //   26: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   29: aload 5
    //   31: iload_3
    //   32: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   35: aload_0
    //   36: getfield 18	com/google/android/gms/maps/model/internal/zzi$zza$zza:zzahn	Landroid/os/IBinder;
    //   39: iconst_1
    //   40: aload 5
    //   42: aload 6
    //   44: iconst_0
    //   45: invokeinterface 47 5 0
    //   50: pop
    //   51: aload 6
    //   53: invokevirtual 50	android/os/Parcel:readException	()V
    //   56: aload 6
    //   58: invokevirtual 54	android/os/Parcel:readInt	()I
    //   61: ifeq +29 -> 90
    //   64: getstatic 60	com/google/android/gms/maps/model/Tile:CREATOR	Lcom/google/android/gms/maps/model/zzn;
    //   67: aload 6
    //   69: invokevirtual 66	com/google/android/gms/maps/model/zzn:createFromParcel	(Landroid/os/Parcel;)Ljava/lang/Object;
    //   72: checkcast 56	com/google/android/gms/maps/model/Tile
    //   75: astore 4
    //   77: aload 6
    //   79: invokevirtual 69	android/os/Parcel:recycle	()V
    //   82: aload 5
    //   84: invokevirtual 69	android/os/Parcel:recycle	()V
    //   87: aload 4
    //   89: areturn
    //   90: aconst_null
    //   91: astore 4
    //   93: goto -16 -> 77
    //   96: astore 4
    //   98: aload 6
    //   100: invokevirtual 69	android/os/Parcel:recycle	()V
    //   103: aload 5
    //   105: invokevirtual 69	android/os/Parcel:recycle	()V
    //   108: aload 4
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	zza
    //   0	111	1	paramInt1	int
    //   0	111	2	paramInt2	int
    //   0	111	3	paramInt3	int
    //   75	17	4	localTile	com.google.android.gms.maps.model.Tile
    //   96	13	4	localObject	Object
    //   3	101	5	localParcel1	android.os.Parcel
    //   8	91	6	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   10	77	96	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.model.internal.zzi.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */