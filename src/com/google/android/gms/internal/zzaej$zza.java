package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.firstparty.GetBuyFlowInitializationTokenResponse;
import com.google.android.gms.wallet.firstparty.GetClientTokenResponse;
import com.google.android.gms.wallet.firstparty.GetInstrumentsResponse;

public abstract class zzaej$zza
  extends Binder
  implements zzaej
{
  public zzaej$zza()
  {
    attachInterface(this, "com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
  }
  
  public static zzaej zzlb(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof zzaej))) {
      return (zzaej)localIInterface;
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
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    label191:
    label261:
    Object localObject;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = (MaskedWallet)MaskedWallet.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label191;
        }
      }
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zza(paramInt1, paramParcel2, paramParcel1);
        return true;
        paramParcel2 = null;
        break;
      }
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = (FullWallet)FullWallet.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label261;
        }
      }
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zza(paramInt1, paramParcel2, paramParcel1);
        return true;
        paramParcel2 = null;
        break;
      }
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zza(paramInt1, bool1, paramParcel1);
        return true;
      }
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zzl(paramInt1, paramParcel1);
        return true;
      }
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label448;
        }
        localObject = (GetInstrumentsResponse)GetInstrumentsResponse.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label454;
        }
      }
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zza(paramParcel2, (GetInstrumentsResponse)localObject, paramParcel1);
        return true;
        paramParcel2 = null;
        break;
        localObject = null;
        break label413;
      }
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      paramInt1 = paramParcel1.readInt();
      bool1 = bool2;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zzb(paramInt1, bool1, paramParcel1);
        return true;
      }
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label601;
        }
        localObject = (GetBuyFlowInitializationTokenResponse)GetBuyFlowInitializationTokenResponse.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label607;
        }
      }
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zza(paramParcel2, (GetBuyFlowInitializationTokenResponse)localObject, paramParcel1);
        return true;
        paramParcel2 = null;
        break;
        localObject = null;
        break label566;
      }
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label671;
        }
      }
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zza(paramParcel2, paramParcel1);
        return true;
        paramParcel2 = null;
        break;
      }
    case 9: 
      label413:
      label448:
      label454:
      label566:
      label601:
      label607:
      label671:
      paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
        bool1 = bool3;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        if (paramParcel1.readInt() == 0) {
          break label751;
        }
      }
      label751:
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zza(paramParcel2, bool1, paramParcel1);
        return true;
        paramParcel2 = null;
        break;
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
    if (paramParcel1.readInt() != 0)
    {
      paramParcel2 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
      if (paramParcel1.readInt() == 0) {
        break label838;
      }
      localObject = (GetClientTokenResponse)GetClientTokenResponse.CREATOR.createFromParcel(paramParcel1);
      label803:
      if (paramParcel1.readInt() == 0) {
        break label844;
      }
    }
    label838:
    label844:
    for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      zza(paramParcel2, (GetClientTokenResponse)localObject, paramParcel1);
      return true;
      paramParcel2 = null;
      break;
      localObject = null;
      break label803;
    }
  }
  
  private static class zza
    implements zzaej
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
    
    public void zza(int paramInt, FullWallet paramFullWallet, Bundle paramBundle)
      throws RemoteException
    {
      Parcel localParcel = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
          localParcel.writeInt(paramInt);
          if (paramFullWallet != null)
          {
            localParcel.writeInt(1);
            paramFullWallet.writeToParcel(localParcel, 0);
            if (paramBundle != null)
            {
              localParcel.writeInt(1);
              paramBundle.writeToParcel(localParcel, 0);
              zzahn.transact(2, localParcel, null, 1);
            }
          }
          else
          {
            localParcel.writeInt(0);
            continue;
          }
          localParcel.writeInt(0);
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
    
    public void zza(int paramInt, MaskedWallet paramMaskedWallet, Bundle paramBundle)
      throws RemoteException
    {
      Parcel localParcel = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
          localParcel.writeInt(paramInt);
          if (paramMaskedWallet != null)
          {
            localParcel.writeInt(1);
            paramMaskedWallet.writeToParcel(localParcel, 0);
            if (paramBundle != null)
            {
              localParcel.writeInt(1);
              paramBundle.writeToParcel(localParcel, 0);
              zzahn.transact(1, localParcel, null, 1);
            }
          }
          else
          {
            localParcel.writeInt(0);
            continue;
          }
          localParcel.writeInt(0);
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
    
    /* Error */
    public void zza(int paramInt, boolean paramBoolean, Bundle paramBundle)
      throws RemoteException
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 4
      //   3: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   6: astore 5
      //   8: aload 5
      //   10: ldc 32
      //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   15: aload 5
      //   17: iload_1
      //   18: invokevirtual 40	android/os/Parcel:writeInt	(I)V
      //   21: iload_2
      //   22: ifeq +50 -> 72
      //   25: iload 4
      //   27: istore_1
      //   28: aload 5
      //   30: iload_1
      //   31: invokevirtual 40	android/os/Parcel:writeInt	(I)V
      //   34: aload_3
      //   35: ifnull +42 -> 77
      //   38: aload 5
      //   40: iconst_1
      //   41: invokevirtual 40	android/os/Parcel:writeInt	(I)V
      //   44: aload_3
      //   45: aload 5
      //   47: iconst_0
      //   48: invokevirtual 49	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
      //   51: aload_0
      //   52: getfield 18	com/google/android/gms/internal/zzaej$zza$zza:zzahn	Landroid/os/IBinder;
      //   55: iconst_3
      //   56: aload 5
      //   58: aconst_null
      //   59: iconst_1
      //   60: invokeinterface 55 5 0
      //   65: pop
      //   66: aload 5
      //   68: invokevirtual 58	android/os/Parcel:recycle	()V
      //   71: return
      //   72: iconst_0
      //   73: istore_1
      //   74: goto -46 -> 28
      //   77: aload 5
      //   79: iconst_0
      //   80: invokevirtual 40	android/os/Parcel:writeInt	(I)V
      //   83: goto -32 -> 51
      //   86: astore_3
      //   87: aload 5
      //   89: invokevirtual 58	android/os/Parcel:recycle	()V
      //   92: aload_3
      //   93: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	94	0	this	zza
      //   0	94	1	paramInt	int
      //   0	94	2	paramBoolean	boolean
      //   0	94	3	paramBundle	Bundle
      //   1	25	4	i	int
      //   6	82	5	localParcel	Parcel
      // Exception table:
      //   from	to	target	type
      //   8	21	86	finally
      //   28	34	86	finally
      //   38	51	86	finally
      //   51	66	86	finally
      //   77	83	86	finally
    }
    
    public void zza(Status paramStatus, Bundle paramBundle)
      throws RemoteException
    {
      Parcel localParcel = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
          if (paramStatus != null)
          {
            localParcel.writeInt(1);
            paramStatus.writeToParcel(localParcel, 0);
            if (paramBundle != null)
            {
              localParcel.writeInt(1);
              paramBundle.writeToParcel(localParcel, 0);
              zzahn.transact(8, localParcel, null, 1);
            }
          }
          else
          {
            localParcel.writeInt(0);
            continue;
          }
          localParcel.writeInt(0);
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
    
    public void zza(Status paramStatus, GetBuyFlowInitializationTokenResponse paramGetBuyFlowInitializationTokenResponse, Bundle paramBundle)
      throws RemoteException
    {
      Parcel localParcel = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
          if (paramStatus != null)
          {
            localParcel.writeInt(1);
            paramStatus.writeToParcel(localParcel, 0);
            if (paramGetBuyFlowInitializationTokenResponse != null)
            {
              localParcel.writeInt(1);
              paramGetBuyFlowInitializationTokenResponse.writeToParcel(localParcel, 0);
              if (paramBundle == null) {
                break label111;
              }
              localParcel.writeInt(1);
              paramBundle.writeToParcel(localParcel, 0);
              zzahn.transact(7, localParcel, null, 1);
            }
          }
          else
          {
            localParcel.writeInt(0);
            continue;
          }
          localParcel.writeInt(0);
        }
        finally
        {
          localParcel.recycle();
        }
        continue;
        label111:
        localParcel.writeInt(0);
      }
    }
    
    public void zza(Status paramStatus, GetClientTokenResponse paramGetClientTokenResponse, Bundle paramBundle)
      throws RemoteException
    {
      Parcel localParcel = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
          if (paramStatus != null)
          {
            localParcel.writeInt(1);
            paramStatus.writeToParcel(localParcel, 0);
            if (paramGetClientTokenResponse != null)
            {
              localParcel.writeInt(1);
              paramGetClientTokenResponse.writeToParcel(localParcel, 0);
              if (paramBundle == null) {
                break label111;
              }
              localParcel.writeInt(1);
              paramBundle.writeToParcel(localParcel, 0);
              zzahn.transact(10, localParcel, null, 1);
            }
          }
          else
          {
            localParcel.writeInt(0);
            continue;
          }
          localParcel.writeInt(0);
        }
        finally
        {
          localParcel.recycle();
        }
        continue;
        label111:
        localParcel.writeInt(0);
      }
    }
    
    public void zza(Status paramStatus, GetInstrumentsResponse paramGetInstrumentsResponse, Bundle paramBundle)
      throws RemoteException
    {
      Parcel localParcel = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
          if (paramStatus != null)
          {
            localParcel.writeInt(1);
            paramStatus.writeToParcel(localParcel, 0);
            if (paramGetInstrumentsResponse != null)
            {
              localParcel.writeInt(1);
              paramGetInstrumentsResponse.writeToParcel(localParcel, 0);
              if (paramBundle == null) {
                break label110;
              }
              localParcel.writeInt(1);
              paramBundle.writeToParcel(localParcel, 0);
              zzahn.transact(5, localParcel, null, 1);
            }
          }
          else
          {
            localParcel.writeInt(0);
            continue;
          }
          localParcel.writeInt(0);
        }
        finally
        {
          localParcel.recycle();
        }
        continue;
        label110:
        localParcel.writeInt(0);
      }
    }
    
    public void zza(Status paramStatus, boolean paramBoolean, Bundle paramBundle)
      throws RemoteException
    {
      int i = 1;
      Parcel localParcel = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
          if (paramStatus != null)
          {
            localParcel.writeInt(1);
            paramStatus.writeToParcel(localParcel, 0);
            break label113;
            localParcel.writeInt(i);
            if (paramBundle != null)
            {
              localParcel.writeInt(1);
              paramBundle.writeToParcel(localParcel, 0);
              label59:
              zzahn.transact(9, localParcel, null, 1);
            }
          }
          else
          {
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        label113:
        do
        {
          i = 0;
          break;
          localParcel.writeInt(0);
          break label59;
        } while (!paramBoolean);
      }
    }
    
    /* Error */
    public void zzb(int paramInt, boolean paramBoolean, Bundle paramBundle)
      throws RemoteException
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 4
      //   3: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   6: astore 5
      //   8: aload 5
      //   10: ldc 32
      //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   15: aload 5
      //   17: iload_1
      //   18: invokevirtual 40	android/os/Parcel:writeInt	(I)V
      //   21: iload_2
      //   22: ifeq +51 -> 73
      //   25: iload 4
      //   27: istore_1
      //   28: aload 5
      //   30: iload_1
      //   31: invokevirtual 40	android/os/Parcel:writeInt	(I)V
      //   34: aload_3
      //   35: ifnull +43 -> 78
      //   38: aload 5
      //   40: iconst_1
      //   41: invokevirtual 40	android/os/Parcel:writeInt	(I)V
      //   44: aload_3
      //   45: aload 5
      //   47: iconst_0
      //   48: invokevirtual 49	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
      //   51: aload_0
      //   52: getfield 18	com/google/android/gms/internal/zzaej$zza$zza:zzahn	Landroid/os/IBinder;
      //   55: bipush 6
      //   57: aload 5
      //   59: aconst_null
      //   60: iconst_1
      //   61: invokeinterface 55 5 0
      //   66: pop
      //   67: aload 5
      //   69: invokevirtual 58	android/os/Parcel:recycle	()V
      //   72: return
      //   73: iconst_0
      //   74: istore_1
      //   75: goto -47 -> 28
      //   78: aload 5
      //   80: iconst_0
      //   81: invokevirtual 40	android/os/Parcel:writeInt	(I)V
      //   84: goto -33 -> 51
      //   87: astore_3
      //   88: aload 5
      //   90: invokevirtual 58	android/os/Parcel:recycle	()V
      //   93: aload_3
      //   94: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	95	0	this	zza
      //   0	95	1	paramInt	int
      //   0	95	2	paramBoolean	boolean
      //   0	95	3	paramBundle	Bundle
      //   1	25	4	i	int
      //   6	83	5	localParcel	Parcel
      // Exception table:
      //   from	to	target	type
      //   8	21	87	finally
      //   28	34	87	finally
      //   38	51	87	finally
      //   51	67	87	finally
      //   78	84	87	finally
    }
    
    /* Error */
    public void zzl(int paramInt, Bundle paramBundle)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_3
      //   4: aload_3
      //   5: ldc 32
      //   7: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   10: aload_3
      //   11: iload_1
      //   12: invokevirtual 40	android/os/Parcel:writeInt	(I)V
      //   15: aload_2
      //   16: ifnull +33 -> 49
      //   19: aload_3
      //   20: iconst_1
      //   21: invokevirtual 40	android/os/Parcel:writeInt	(I)V
      //   24: aload_2
      //   25: aload_3
      //   26: iconst_0
      //   27: invokevirtual 49	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
      //   30: aload_0
      //   31: getfield 18	com/google/android/gms/internal/zzaej$zza$zza:zzahn	Landroid/os/IBinder;
      //   34: iconst_4
      //   35: aload_3
      //   36: aconst_null
      //   37: iconst_1
      //   38: invokeinterface 55 5 0
      //   43: pop
      //   44: aload_3
      //   45: invokevirtual 58	android/os/Parcel:recycle	()V
      //   48: return
      //   49: aload_3
      //   50: iconst_0
      //   51: invokevirtual 40	android/os/Parcel:writeInt	(I)V
      //   54: goto -24 -> 30
      //   57: astore_2
      //   58: aload_3
      //   59: invokevirtual 58	android/os/Parcel:recycle	()V
      //   62: aload_2
      //   63: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	64	0	this	zza
      //   0	64	1	paramInt	int
      //   0	64	2	paramBundle	Bundle
      //   3	56	3	localParcel	Parcel
      // Exception table:
      //   from	to	target	type
      //   4	15	57	finally
      //   19	30	57	finally
      //   30	44	57	finally
      //   49	54	57	finally
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaej.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */