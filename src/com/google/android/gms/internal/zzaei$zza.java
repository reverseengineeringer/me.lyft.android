package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract class zzaei$zza
  extends Binder
  implements zzaei
{
  public static zzaei zzla(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletInternalServiceCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof zzaei))) {
      return (zzaei)localIInterface;
    }
    return new zza(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.wallet.internal.IWalletInternalServiceCallbacks");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletInternalServiceCallbacks");
    paramInt1 = paramParcel1.readInt();
    paramInt2 = paramParcel1.readInt();
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      zzb(paramInt1, paramInt2, paramParcel1);
      return true;
    }
  }
  
  private static class zza
    implements zzaei
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
    
    /* Error */
    public void zzb(int paramInt1, int paramInt2, Bundle paramBundle)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore 4
      //   5: aload 4
      //   7: ldc 33
      //   9: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   12: aload 4
      //   14: iload_1
      //   15: invokevirtual 41	android/os/Parcel:writeInt	(I)V
      //   18: aload 4
      //   20: iload_2
      //   21: invokevirtual 41	android/os/Parcel:writeInt	(I)V
      //   24: aload_3
      //   25: ifnull +37 -> 62
      //   28: aload 4
      //   30: iconst_1
      //   31: invokevirtual 41	android/os/Parcel:writeInt	(I)V
      //   34: aload_3
      //   35: aload 4
      //   37: iconst_0
      //   38: invokevirtual 47	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
      //   41: aload_0
      //   42: getfield 18	com/google/android/gms/internal/zzaei$zza$zza:zzahn	Landroid/os/IBinder;
      //   45: iconst_1
      //   46: aload 4
      //   48: aconst_null
      //   49: iconst_1
      //   50: invokeinterface 53 5 0
      //   55: pop
      //   56: aload 4
      //   58: invokevirtual 56	android/os/Parcel:recycle	()V
      //   61: return
      //   62: aload 4
      //   64: iconst_0
      //   65: invokevirtual 41	android/os/Parcel:writeInt	(I)V
      //   68: goto -27 -> 41
      //   71: astore_3
      //   72: aload 4
      //   74: invokevirtual 56	android/os/Parcel:recycle	()V
      //   77: aload_3
      //   78: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	79	0	this	zza
      //   0	79	1	paramInt1	int
      //   0	79	2	paramInt2	int
      //   0	79	3	paramBundle	Bundle
      //   3	70	4	localParcel	Parcel
      // Exception table:
      //   from	to	target	type
      //   5	24	71	finally
      //   28	41	71	finally
      //   41	56	71	finally
      //   62	68	71	finally
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaei.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */