package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zzc.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public abstract interface zzaeh
  extends IInterface
{
  public abstract zzaee zza(zzd paramzzd, zzc paramzzc, WalletFragmentOptions paramWalletFragmentOptions, zzaef paramzzaef)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzaeh
  {
    public static zzaeh zzkz(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
      if ((localIInterface != null) && ((localIInterface instanceof zzaeh))) {
        return (zzaeh)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject2 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
      zzd localzzd = zzd.zza.zzfc(paramParcel1.readStrongBinder());
      zzc localzzc = zzc.zza.zzfb(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0) {}
      for (Object localObject1 = (WalletFragmentOptions)WalletFragmentOptions.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        localObject1 = zza(localzzd, localzzc, (WalletFragmentOptions)localObject1, zzaef.zza.zzkx(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel1 = (Parcel)localObject2;
        if (localObject1 != null) {
          paramParcel1 = ((zzaee)localObject1).asBinder();
        }
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
    }
    
    private static class zza
      implements zzaeh
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
      public zzaee zza(zzd paramzzd, zzc paramzzc, WalletFragmentOptions paramWalletFragmentOptions, zzaef paramzzaef)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 6
        //   8: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 7
        //   13: aload 6
        //   15: ldc 32
        //   17: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +114 -> 135
        //   24: aload_1
        //   25: invokeinterface 40 1 0
        //   30: astore_1
        //   31: aload 6
        //   33: aload_1
        //   34: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   37: aload_2
        //   38: ifnull +102 -> 140
        //   41: aload_2
        //   42: invokeinterface 46 1 0
        //   47: astore_1
        //   48: aload 6
        //   50: aload_1
        //   51: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   54: aload_3
        //   55: ifnull +90 -> 145
        //   58: aload 6
        //   60: iconst_1
        //   61: invokevirtual 50	android/os/Parcel:writeInt	(I)V
        //   64: aload_3
        //   65: aload 6
        //   67: iconst_0
        //   68: invokevirtual 56	com/google/android/gms/wallet/fragment/WalletFragmentOptions:writeToParcel	(Landroid/os/Parcel;I)V
        //   71: aload 5
        //   73: astore_1
        //   74: aload 4
        //   76: ifnull +11 -> 87
        //   79: aload 4
        //   81: invokeinterface 59 1 0
        //   86: astore_1
        //   87: aload 6
        //   89: aload_1
        //   90: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   93: aload_0
        //   94: getfield 18	com/google/android/gms/internal/zzaeh$zza$zza:zzahn	Landroid/os/IBinder;
        //   97: iconst_1
        //   98: aload 6
        //   100: aload 7
        //   102: iconst_0
        //   103: invokeinterface 65 5 0
        //   108: pop
        //   109: aload 7
        //   111: invokevirtual 68	android/os/Parcel:readException	()V
        //   114: aload 7
        //   116: invokevirtual 71	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   119: invokestatic 77	com/google/android/gms/internal/zzaee$zza:zzkw	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/zzaee;
        //   122: astore_1
        //   123: aload 7
        //   125: invokevirtual 80	android/os/Parcel:recycle	()V
        //   128: aload 6
        //   130: invokevirtual 80	android/os/Parcel:recycle	()V
        //   133: aload_1
        //   134: areturn
        //   135: aconst_null
        //   136: astore_1
        //   137: goto -106 -> 31
        //   140: aconst_null
        //   141: astore_1
        //   142: goto -94 -> 48
        //   145: aload 6
        //   147: iconst_0
        //   148: invokevirtual 50	android/os/Parcel:writeInt	(I)V
        //   151: goto -80 -> 71
        //   154: astore_1
        //   155: aload 7
        //   157: invokevirtual 80	android/os/Parcel:recycle	()V
        //   160: aload 6
        //   162: invokevirtual 80	android/os/Parcel:recycle	()V
        //   165: aload_1
        //   166: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	167	0	this	zza
        //   0	167	1	paramzzd	zzd
        //   0	167	2	paramzzc	zzc
        //   0	167	3	paramWalletFragmentOptions	WalletFragmentOptions
        //   0	167	4	paramzzaef	zzaef
        //   1	71	5	localObject	Object
        //   6	155	6	localParcel1	Parcel
        //   11	145	7	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	20	154	finally
        //   24	31	154	finally
        //   31	37	154	finally
        //   41	48	154	finally
        //   48	54	154	finally
        //   58	71	154	finally
        //   79	87	154	finally
        //   87	123	154	finally
        //   145	151	154	finally
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaeh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */