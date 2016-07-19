package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

public abstract class zzdu$zza
  extends Binder
  implements zzdu
{
  public zzdu$zza()
  {
    attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
  }
  
  public static zzdu zzy(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    if ((localIInterface != null) && ((localIInterface instanceof zzdu))) {
      return (zzdu)localIInterface;
    }
    return new zza(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
      paramParcel1 = zzkv();
      paramParcel2.writeNoException();
      if (paramParcel1 != null) {}
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
      paramParcel1 = getUri();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    double d = getScale();
    paramParcel2.writeNoException();
    paramParcel2.writeDouble(d);
    return true;
  }
  
  private static class zza
    implements zzdu
  {
    private IBinder zzahn;
    
    zza(IBinder paramIBinder)
    {
      zzahn = paramIBinder;
    }
    
    public IBinder asBinder()
    {
      return zzahn;
    }
    
    public double getScale()
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        zzahn.transact(3, localParcel1, localParcel2, 0);
        localParcel2.readException();
        double d = localParcel2.readDouble();
        return d;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
    
    /* Error */
    public Uri getUri()
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
      //   15: getfield 18	com/google/android/gms/internal/zzdu$zza$zza:zzahn	Landroid/os/IBinder;
      //   18: iconst_2
      //   19: aload_2
      //   20: aload_3
      //   21: iconst_0
      //   22: invokeinterface 43 5 0
      //   27: pop
      //   28: aload_3
      //   29: invokevirtual 46	android/os/Parcel:readException	()V
      //   32: aload_3
      //   33: invokevirtual 59	android/os/Parcel:readInt	()I
      //   36: ifeq +26 -> 62
      //   39: getstatic 65	android/net/Uri:CREATOR	Landroid/os/Parcelable$Creator;
      //   42: aload_3
      //   43: invokeinterface 71 2 0
      //   48: checkcast 61	android/net/Uri
      //   51: astore_1
      //   52: aload_3
      //   53: invokevirtual 52	android/os/Parcel:recycle	()V
      //   56: aload_2
      //   57: invokevirtual 52	android/os/Parcel:recycle	()V
      //   60: aload_1
      //   61: areturn
      //   62: aconst_null
      //   63: astore_1
      //   64: goto -12 -> 52
      //   67: astore_1
      //   68: aload_3
      //   69: invokevirtual 52	android/os/Parcel:recycle	()V
      //   72: aload_2
      //   73: invokevirtual 52	android/os/Parcel:recycle	()V
      //   76: aload_1
      //   77: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	78	0	this	zza
      //   51	13	1	localUri	Uri
      //   67	10	1	localObject	Object
      //   3	70	2	localParcel1	Parcel
      //   7	62	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   8	52	67	finally
    }
    
    public zzd zzkv()
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
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
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdu.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */