package com.google.android.gms.ads.internal.reward.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzgn.zza;

public abstract interface zzc
  extends IInterface
{
  public abstract IBinder zza(zzd paramzzd, zzgn paramzzgn, int paramInt)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzc
  {
    public static zzc zzbg(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
      if ((localIInterface != null) && ((localIInterface instanceof zzc))) {
        return (zzc)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
      paramParcel1 = zza(zzd.zza.zzfc(paramParcel1.readStrongBinder()), zzgn.zza.zzaj(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    }
    
    private static class zza
      implements zzc
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
      public IBinder zza(zzd paramzzd, zzgn paramzzgn, int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 32
        //   17: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +81 -> 102
        //   24: aload_1
        //   25: invokeinterface 40 1 0
        //   30: astore_1
        //   31: aload 5
        //   33: aload_1
        //   34: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   37: aload 4
        //   39: astore_1
        //   40: aload_2
        //   41: ifnull +10 -> 51
        //   44: aload_2
        //   45: invokeinterface 46 1 0
        //   50: astore_1
        //   51: aload 5
        //   53: aload_1
        //   54: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   57: aload 5
        //   59: iload_3
        //   60: invokevirtual 50	android/os/Parcel:writeInt	(I)V
        //   63: aload_0
        //   64: getfield 18	com/google/android/gms/ads/internal/reward/client/zzc$zza$zza:zzahn	Landroid/os/IBinder;
        //   67: iconst_1
        //   68: aload 5
        //   70: aload 6
        //   72: iconst_0
        //   73: invokeinterface 56 5 0
        //   78: pop
        //   79: aload 6
        //   81: invokevirtual 59	android/os/Parcel:readException	()V
        //   84: aload 6
        //   86: invokevirtual 62	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   89: astore_1
        //   90: aload 6
        //   92: invokevirtual 65	android/os/Parcel:recycle	()V
        //   95: aload 5
        //   97: invokevirtual 65	android/os/Parcel:recycle	()V
        //   100: aload_1
        //   101: areturn
        //   102: aconst_null
        //   103: astore_1
        //   104: goto -73 -> 31
        //   107: astore_1
        //   108: aload 6
        //   110: invokevirtual 65	android/os/Parcel:recycle	()V
        //   113: aload 5
        //   115: invokevirtual 65	android/os/Parcel:recycle	()V
        //   118: aload_1
        //   119: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	120	0	this	zza
        //   0	120	1	paramzzd	zzd
        //   0	120	2	paramzzgn	zzgn
        //   0	120	3	paramInt	int
        //   1	37	4	localObject	Object
        //   6	108	5	localParcel1	Parcel
        //   11	98	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	20	107	finally
        //   24	31	107	finally
        //   31	37	107	finally
        //   44	51	107	finally
        //   51	90	107	finally
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.reward.client.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */