package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class zzug$zza$zza
  implements zzug
{
  private IBinder zzahn;
  
  zzug$zza$zza(IBinder paramIBinder)
  {
    zzahn = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zzahn;
  }
  
  /* Error */
  public boolean getBooleanFlagValue(String paramString, boolean paramBoolean, int paramInt)
    throws RemoteException
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 6
    //   8: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 7
    //   13: aload 6
    //   15: ldc 33
    //   17: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload 6
    //   22: aload_1
    //   23: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   26: iload_2
    //   27: ifeq +65 -> 92
    //   30: iconst_1
    //   31: istore 4
    //   33: aload 6
    //   35: iload 4
    //   37: invokevirtual 44	android/os/Parcel:writeInt	(I)V
    //   40: aload 6
    //   42: iload_3
    //   43: invokevirtual 44	android/os/Parcel:writeInt	(I)V
    //   46: aload_0
    //   47: getfield 18	com/google/android/gms/internal/zzug$zza$zza:zzahn	Landroid/os/IBinder;
    //   50: iconst_2
    //   51: aload 6
    //   53: aload 7
    //   55: iconst_0
    //   56: invokeinterface 50 5 0
    //   61: pop
    //   62: aload 7
    //   64: invokevirtual 53	android/os/Parcel:readException	()V
    //   67: aload 7
    //   69: invokevirtual 57	android/os/Parcel:readInt	()I
    //   72: istore_3
    //   73: iload_3
    //   74: ifeq +24 -> 98
    //   77: iload 5
    //   79: istore_2
    //   80: aload 7
    //   82: invokevirtual 60	android/os/Parcel:recycle	()V
    //   85: aload 6
    //   87: invokevirtual 60	android/os/Parcel:recycle	()V
    //   90: iload_2
    //   91: ireturn
    //   92: iconst_0
    //   93: istore 4
    //   95: goto -62 -> 33
    //   98: iconst_0
    //   99: istore_2
    //   100: goto -20 -> 80
    //   103: astore_1
    //   104: aload 7
    //   106: invokevirtual 60	android/os/Parcel:recycle	()V
    //   109: aload 6
    //   111: invokevirtual 60	android/os/Parcel:recycle	()V
    //   114: aload_1
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	zza
    //   0	116	1	paramString	String
    //   0	116	2	paramBoolean	boolean
    //   0	116	3	paramInt	int
    //   31	63	4	i	int
    //   1	77	5	bool	boolean
    //   6	104	6	localParcel1	Parcel
    //   11	94	7	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   13	26	103	finally
    //   33	73	103	finally
  }
  
  public int getIntFlagValue(String paramString, int paramInt1, int paramInt2)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      zzahn.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt1 = localParcel2.readInt();
      return paramInt1;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public long getLongFlagValue(String paramString, long paramLong, int paramInt)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
      localParcel1.writeString(paramString);
      localParcel1.writeLong(paramLong);
      localParcel1.writeInt(paramInt);
      zzahn.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramLong = localParcel2.readLong();
      return paramLong;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String getStringFlagValue(String paramString1, String paramString2, int paramInt)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      localParcel1.writeInt(paramInt);
      zzahn.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString1 = localParcel2.readString();
      return paramString1;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void init(com.google.android.gms.dynamic.zzd paramzzd)
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
    //   15: ifnull +42 -> 57
    //   18: aload_1
    //   19: invokeinterface 85 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 88	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 18	com/google/android/gms/internal/zzug$zza$zza:zzahn	Landroid/os/IBinder;
    //   34: iconst_1
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 50 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 53	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 60	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 60	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aconst_null
    //   58: astore_1
    //   59: goto -34 -> 25
    //   62: astore_1
    //   63: aload_3
    //   64: invokevirtual 60	android/os/Parcel:recycle	()V
    //   67: aload_2
    //   68: invokevirtual 60	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	zza
    //   0	73	1	paramzzd	com.google.android.gms.dynamic.zzd
    //   3	65	2	localParcel1	Parcel
    //   7	57	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	62	finally
    //   18	25	62	finally
    //   25	48	62	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzug.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */