package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

public abstract class zzca$zza
  extends Binder
  implements zzca
{
  public zzca$zza()
  {
    attachInterface(this, "com.google.android.gms.ads.adshield.internal.IAdShieldClient");
  }
  
  public static zzca zzd(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
    if ((localIInterface != null) && ((localIInterface instanceof zzca))) {
      return (zzca)localIInterface;
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
    String str = null;
    int j = 0;
    int k = 0;
    int i = 0;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
      paramParcel1 = zzdg();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
      zzb(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
      bool = zza(zzd.zza.zzfc(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
      bool = zzb(zzd.zza.zzfc(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
      zzk(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
      paramParcel1 = zza(zzd.zza.zzfc(paramParcel1.readStrongBinder()), zzd.zza.zzfc(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      if (paramParcel1 != null) {}
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
      paramParcel1 = zzc(zzd.zza.zzfc(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
      paramParcel1 = zza(zzd.zza.zzfc(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
      zzd(zzd.zza.zzfc(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
      zzd localzzd = zzb(zzd.zza.zzfc(paramParcel1.readStrongBinder()), zzd.zza.zzfc(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel1 = str;
      if (localzzd != null) {
        paramParcel1 = localzzd.asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
    str = paramParcel1.readString();
    if (paramParcel1.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      bool = zzb(str, bool);
      paramParcel2.writeNoException();
      paramInt1 = k;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    }
  }
  
  private static class zza
    implements zzca
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
    public zzd zza(zzd paramzzd1, zzd paramzzd2)
      throws RemoteException
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   5: astore 4
      //   7: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   10: astore 5
      //   12: aload 4
      //   14: ldc 32
      //   16: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   19: aload_1
      //   20: ifnull +78 -> 98
      //   23: aload_1
      //   24: invokeinterface 40 1 0
      //   29: astore_1
      //   30: aload 4
      //   32: aload_1
      //   33: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   36: aload_3
      //   37: astore_1
      //   38: aload_2
      //   39: ifnull +10 -> 49
      //   42: aload_2
      //   43: invokeinterface 40 1 0
      //   48: astore_1
      //   49: aload 4
      //   51: aload_1
      //   52: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   55: aload_0
      //   56: getfield 18	com/google/android/gms/internal/zzca$zza$zza:zzahn	Landroid/os/IBinder;
      //   59: bipush 6
      //   61: aload 4
      //   63: aload 5
      //   65: iconst_0
      //   66: invokeinterface 49 5 0
      //   71: pop
      //   72: aload 5
      //   74: invokevirtual 52	android/os/Parcel:readException	()V
      //   77: aload 5
      //   79: invokevirtual 55	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
      //   82: invokestatic 61	com/google/android/gms/dynamic/zzd$zza:zzfc	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/zzd;
      //   85: astore_1
      //   86: aload 5
      //   88: invokevirtual 64	android/os/Parcel:recycle	()V
      //   91: aload 4
      //   93: invokevirtual 64	android/os/Parcel:recycle	()V
      //   96: aload_1
      //   97: areturn
      //   98: aconst_null
      //   99: astore_1
      //   100: goto -70 -> 30
      //   103: astore_1
      //   104: aload 5
      //   106: invokevirtual 64	android/os/Parcel:recycle	()V
      //   109: aload 4
      //   111: invokevirtual 64	android/os/Parcel:recycle	()V
      //   114: aload_1
      //   115: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	116	0	this	zza
      //   0	116	1	paramzzd1	zzd
      //   0	116	2	paramzzd2	zzd
      //   1	36	3	localObject	Object
      //   5	105	4	localParcel1	Parcel
      //   10	95	5	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   12	19	103	finally
      //   23	30	103	finally
      //   30	36	103	finally
      //   42	49	103	finally
      //   49	86	103	finally
    }
    
    /* Error */
    public String zza(zzd paramzzd, String paramString)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_3
      //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   7: astore 4
      //   9: aload_3
      //   10: ldc 32
      //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   15: aload_1
      //   16: ifnull +58 -> 74
      //   19: aload_1
      //   20: invokeinterface 40 1 0
      //   25: astore_1
      //   26: aload_3
      //   27: aload_1
      //   28: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   31: aload_3
      //   32: aload_2
      //   33: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   36: aload_0
      //   37: getfield 18	com/google/android/gms/internal/zzca$zza$zza:zzahn	Landroid/os/IBinder;
      //   40: bipush 8
      //   42: aload_3
      //   43: aload 4
      //   45: iconst_0
      //   46: invokeinterface 49 5 0
      //   51: pop
      //   52: aload 4
      //   54: invokevirtual 52	android/os/Parcel:readException	()V
      //   57: aload 4
      //   59: invokevirtual 73	android/os/Parcel:readString	()Ljava/lang/String;
      //   62: astore_1
      //   63: aload 4
      //   65: invokevirtual 64	android/os/Parcel:recycle	()V
      //   68: aload_3
      //   69: invokevirtual 64	android/os/Parcel:recycle	()V
      //   72: aload_1
      //   73: areturn
      //   74: aconst_null
      //   75: astore_1
      //   76: goto -50 -> 26
      //   79: astore_1
      //   80: aload 4
      //   82: invokevirtual 64	android/os/Parcel:recycle	()V
      //   85: aload_3
      //   86: invokevirtual 64	android/os/Parcel:recycle	()V
      //   89: aload_1
      //   90: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	91	0	this	zza
      //   0	91	1	paramzzd	zzd
      //   0	91	2	paramString	String
      //   3	83	3	localParcel1	Parcel
      //   7	74	4	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   9	15	79	finally
      //   19	26	79	finally
      //   26	63	79	finally
    }
    
    /* Error */
    public boolean zza(zzd paramzzd)
      throws RemoteException
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   5: astore 4
      //   7: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   10: astore 5
      //   12: aload 4
      //   14: ldc 32
      //   16: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   19: aload_1
      //   20: ifnull +61 -> 81
      //   23: aload_1
      //   24: invokeinterface 40 1 0
      //   29: astore_1
      //   30: aload 4
      //   32: aload_1
      //   33: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   36: aload_0
      //   37: getfield 18	com/google/android/gms/internal/zzca$zza$zza:zzahn	Landroid/os/IBinder;
      //   40: iconst_3
      //   41: aload 4
      //   43: aload 5
      //   45: iconst_0
      //   46: invokeinterface 49 5 0
      //   51: pop
      //   52: aload 5
      //   54: invokevirtual 52	android/os/Parcel:readException	()V
      //   57: aload 5
      //   59: invokevirtual 78	android/os/Parcel:readInt	()I
      //   62: istore_2
      //   63: iload_2
      //   64: ifeq +5 -> 69
      //   67: iconst_1
      //   68: istore_3
      //   69: aload 5
      //   71: invokevirtual 64	android/os/Parcel:recycle	()V
      //   74: aload 4
      //   76: invokevirtual 64	android/os/Parcel:recycle	()V
      //   79: iload_3
      //   80: ireturn
      //   81: aconst_null
      //   82: astore_1
      //   83: goto -53 -> 30
      //   86: astore_1
      //   87: aload 5
      //   89: invokevirtual 64	android/os/Parcel:recycle	()V
      //   92: aload 4
      //   94: invokevirtual 64	android/os/Parcel:recycle	()V
      //   97: aload_1
      //   98: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	99	0	this	zza
      //   0	99	1	paramzzd	zzd
      //   62	2	2	i	int
      //   1	79	3	bool	boolean
      //   5	88	4	localParcel1	Parcel
      //   10	78	5	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   12	19	86	finally
      //   23	30	86	finally
      //   30	63	86	finally
    }
    
    /* Error */
    public zzd zzb(zzd paramzzd1, zzd paramzzd2)
      throws RemoteException
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   5: astore 4
      //   7: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   10: astore 5
      //   12: aload 4
      //   14: ldc 32
      //   16: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   19: aload_1
      //   20: ifnull +78 -> 98
      //   23: aload_1
      //   24: invokeinterface 40 1 0
      //   29: astore_1
      //   30: aload 4
      //   32: aload_1
      //   33: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   36: aload_3
      //   37: astore_1
      //   38: aload_2
      //   39: ifnull +10 -> 49
      //   42: aload_2
      //   43: invokeinterface 40 1 0
      //   48: astore_1
      //   49: aload 4
      //   51: aload_1
      //   52: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   55: aload_0
      //   56: getfield 18	com/google/android/gms/internal/zzca$zza$zza:zzahn	Landroid/os/IBinder;
      //   59: bipush 10
      //   61: aload 4
      //   63: aload 5
      //   65: iconst_0
      //   66: invokeinterface 49 5 0
      //   71: pop
      //   72: aload 5
      //   74: invokevirtual 52	android/os/Parcel:readException	()V
      //   77: aload 5
      //   79: invokevirtual 55	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
      //   82: invokestatic 61	com/google/android/gms/dynamic/zzd$zza:zzfc	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/zzd;
      //   85: astore_1
      //   86: aload 5
      //   88: invokevirtual 64	android/os/Parcel:recycle	()V
      //   91: aload 4
      //   93: invokevirtual 64	android/os/Parcel:recycle	()V
      //   96: aload_1
      //   97: areturn
      //   98: aconst_null
      //   99: astore_1
      //   100: goto -70 -> 30
      //   103: astore_1
      //   104: aload 5
      //   106: invokevirtual 64	android/os/Parcel:recycle	()V
      //   109: aload 4
      //   111: invokevirtual 64	android/os/Parcel:recycle	()V
      //   114: aload_1
      //   115: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	116	0	this	zza
      //   0	116	1	paramzzd1	zzd
      //   0	116	2	paramzzd2	zzd
      //   1	36	3	localObject	Object
      //   5	105	4	localParcel1	Parcel
      //   10	95	5	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   12	19	103	finally
      //   23	30	103	finally
      //   30	36	103	finally
      //   42	49	103	finally
      //   49	86	103	finally
    }
    
    public void zzb(String paramString1, String paramString2)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        zzahn.transact(2, localParcel1, localParcel2, 0);
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
    public boolean zzb(zzd paramzzd)
      throws RemoteException
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   5: astore 4
      //   7: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   10: astore 5
      //   12: aload 4
      //   14: ldc 32
      //   16: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   19: aload_1
      //   20: ifnull +61 -> 81
      //   23: aload_1
      //   24: invokeinterface 40 1 0
      //   29: astore_1
      //   30: aload 4
      //   32: aload_1
      //   33: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   36: aload_0
      //   37: getfield 18	com/google/android/gms/internal/zzca$zza$zza:zzahn	Landroid/os/IBinder;
      //   40: iconst_4
      //   41: aload 4
      //   43: aload 5
      //   45: iconst_0
      //   46: invokeinterface 49 5 0
      //   51: pop
      //   52: aload 5
      //   54: invokevirtual 52	android/os/Parcel:readException	()V
      //   57: aload 5
      //   59: invokevirtual 78	android/os/Parcel:readInt	()I
      //   62: istore_2
      //   63: iload_2
      //   64: ifeq +5 -> 69
      //   67: iconst_1
      //   68: istore_3
      //   69: aload 5
      //   71: invokevirtual 64	android/os/Parcel:recycle	()V
      //   74: aload 4
      //   76: invokevirtual 64	android/os/Parcel:recycle	()V
      //   79: iload_3
      //   80: ireturn
      //   81: aconst_null
      //   82: astore_1
      //   83: goto -53 -> 30
      //   86: astore_1
      //   87: aload 5
      //   89: invokevirtual 64	android/os/Parcel:recycle	()V
      //   92: aload 4
      //   94: invokevirtual 64	android/os/Parcel:recycle	()V
      //   97: aload_1
      //   98: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	99	0	this	zza
      //   0	99	1	paramzzd	zzd
      //   62	2	2	i	int
      //   1	79	3	bool	boolean
      //   5	88	4	localParcel1	Parcel
      //   10	78	5	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   12	19	86	finally
      //   23	30	86	finally
      //   30	63	86	finally
    }
    
    /* Error */
    public boolean zzb(String paramString, boolean paramBoolean)
      throws RemoteException
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 4
      //   3: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   6: astore 5
      //   8: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   11: astore 6
      //   13: aload 5
      //   15: ldc 32
      //   17: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   20: aload 5
      //   22: aload_1
      //   23: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   26: iload_2
      //   27: ifeq +58 -> 85
      //   30: iconst_1
      //   31: istore_3
      //   32: aload 5
      //   34: iload_3
      //   35: invokevirtual 85	android/os/Parcel:writeInt	(I)V
      //   38: aload_0
      //   39: getfield 18	com/google/android/gms/internal/zzca$zza$zza:zzahn	Landroid/os/IBinder;
      //   42: bipush 11
      //   44: aload 5
      //   46: aload 6
      //   48: iconst_0
      //   49: invokeinterface 49 5 0
      //   54: pop
      //   55: aload 6
      //   57: invokevirtual 52	android/os/Parcel:readException	()V
      //   60: aload 6
      //   62: invokevirtual 78	android/os/Parcel:readInt	()I
      //   65: istore_3
      //   66: iload_3
      //   67: ifeq +23 -> 90
      //   70: iload 4
      //   72: istore_2
      //   73: aload 6
      //   75: invokevirtual 64	android/os/Parcel:recycle	()V
      //   78: aload 5
      //   80: invokevirtual 64	android/os/Parcel:recycle	()V
      //   83: iload_2
      //   84: ireturn
      //   85: iconst_0
      //   86: istore_3
      //   87: goto -55 -> 32
      //   90: iconst_0
      //   91: istore_2
      //   92: goto -19 -> 73
      //   95: astore_1
      //   96: aload 6
      //   98: invokevirtual 64	android/os/Parcel:recycle	()V
      //   101: aload 5
      //   103: invokevirtual 64	android/os/Parcel:recycle	()V
      //   106: aload_1
      //   107: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	108	0	this	zza
      //   0	108	1	paramString	String
      //   0	108	2	paramBoolean	boolean
      //   31	56	3	i	int
      //   1	70	4	bool	boolean
      //   6	96	5	localParcel1	Parcel
      //   11	86	6	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   13	26	95	finally
      //   32	66	95	finally
    }
    
    /* Error */
    public String zzc(zzd paramzzd)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   7: astore_3
      //   8: aload_2
      //   9: ldc 32
      //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   14: aload_1
      //   15: ifnull +49 -> 64
      //   18: aload_1
      //   19: invokeinterface 40 1 0
      //   24: astore_1
      //   25: aload_2
      //   26: aload_1
      //   27: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   30: aload_0
      //   31: getfield 18	com/google/android/gms/internal/zzca$zza$zza:zzahn	Landroid/os/IBinder;
      //   34: bipush 7
      //   36: aload_2
      //   37: aload_3
      //   38: iconst_0
      //   39: invokeinterface 49 5 0
      //   44: pop
      //   45: aload_3
      //   46: invokevirtual 52	android/os/Parcel:readException	()V
      //   49: aload_3
      //   50: invokevirtual 73	android/os/Parcel:readString	()Ljava/lang/String;
      //   53: astore_1
      //   54: aload_3
      //   55: invokevirtual 64	android/os/Parcel:recycle	()V
      //   58: aload_2
      //   59: invokevirtual 64	android/os/Parcel:recycle	()V
      //   62: aload_1
      //   63: areturn
      //   64: aconst_null
      //   65: astore_1
      //   66: goto -41 -> 25
      //   69: astore_1
      //   70: aload_3
      //   71: invokevirtual 64	android/os/Parcel:recycle	()V
      //   74: aload_2
      //   75: invokevirtual 64	android/os/Parcel:recycle	()V
      //   78: aload_1
      //   79: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	80	0	this	zza
      //   0	80	1	paramzzd	zzd
      //   3	72	2	localParcel1	Parcel
      //   7	64	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   8	14	69	finally
      //   18	25	69	finally
      //   25	54	69	finally
    }
    
    /* Error */
    public void zzd(zzd paramzzd)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   7: astore_3
      //   8: aload_2
      //   9: ldc 32
      //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   14: aload_1
      //   15: ifnull +43 -> 58
      //   18: aload_1
      //   19: invokeinterface 40 1 0
      //   24: astore_1
      //   25: aload_2
      //   26: aload_1
      //   27: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   30: aload_0
      //   31: getfield 18	com/google/android/gms/internal/zzca$zza$zza:zzahn	Landroid/os/IBinder;
      //   34: bipush 9
      //   36: aload_2
      //   37: aload_3
      //   38: iconst_0
      //   39: invokeinterface 49 5 0
      //   44: pop
      //   45: aload_3
      //   46: invokevirtual 52	android/os/Parcel:readException	()V
      //   49: aload_3
      //   50: invokevirtual 64	android/os/Parcel:recycle	()V
      //   53: aload_2
      //   54: invokevirtual 64	android/os/Parcel:recycle	()V
      //   57: return
      //   58: aconst_null
      //   59: astore_1
      //   60: goto -35 -> 25
      //   63: astore_1
      //   64: aload_3
      //   65: invokevirtual 64	android/os/Parcel:recycle	()V
      //   68: aload_2
      //   69: invokevirtual 64	android/os/Parcel:recycle	()V
      //   72: aload_1
      //   73: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	74	0	this	zza
      //   0	74	1	paramzzd	zzd
      //   3	66	2	localParcel1	Parcel
      //   7	58	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   8	14	63	finally
      //   18	25	63	finally
      //   25	49	63	finally
    }
    
    public String zzdg()
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
        zzahn.transact(1, localParcel1, localParcel2, 0);
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
    
    public void zzk(String paramString)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
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
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzca.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */