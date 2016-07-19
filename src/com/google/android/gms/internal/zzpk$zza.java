package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.clearcut.zzd;

public abstract class zzpk$zza
  extends Binder
  implements zzpk
{
  public static zzpk zzdm(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
    if ((localIInterface != null) && ((localIInterface instanceof zzpk))) {
      return (zzpk)localIInterface;
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
      paramParcel2.writeString("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
    paramParcel2 = zzpj.zza.zzdl(paramParcel1.readStrongBinder());
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (LogEventParcelable)LogEventParcelable.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      zza(paramParcel2, paramParcel1);
      return true;
    }
  }
  
  private static class zza
    implements zzpk
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
    public void zza(zzpj paramzzpj, LogEventParcelable paramLogEventParcelable)
      throws RemoteException
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   5: astore 4
      //   7: aload 4
      //   9: ldc 32
      //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   14: aload_1
      //   15: ifnull +10 -> 25
      //   18: aload_1
      //   19: invokeinterface 40 1 0
      //   24: astore_3
      //   25: aload 4
      //   27: aload_3
      //   28: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   31: aload_2
      //   32: ifnull +37 -> 69
      //   35: aload 4
      //   37: iconst_1
      //   38: invokevirtual 47	android/os/Parcel:writeInt	(I)V
      //   41: aload_2
      //   42: aload 4
      //   44: iconst_0
      //   45: invokevirtual 53	com/google/android/gms/clearcut/LogEventParcelable:writeToParcel	(Landroid/os/Parcel;I)V
      //   48: aload_0
      //   49: getfield 18	com/google/android/gms/internal/zzpk$zza$zza:zzahn	Landroid/os/IBinder;
      //   52: iconst_1
      //   53: aload 4
      //   55: aconst_null
      //   56: iconst_1
      //   57: invokeinterface 59 5 0
      //   62: pop
      //   63: aload 4
      //   65: invokevirtual 62	android/os/Parcel:recycle	()V
      //   68: return
      //   69: aload 4
      //   71: iconst_0
      //   72: invokevirtual 47	android/os/Parcel:writeInt	(I)V
      //   75: goto -27 -> 48
      //   78: astore_1
      //   79: aload 4
      //   81: invokevirtual 62	android/os/Parcel:recycle	()V
      //   84: aload_1
      //   85: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	86	0	this	zza
      //   0	86	1	paramzzpj	zzpj
      //   0	86	2	paramLogEventParcelable	LogEventParcelable
      //   1	27	3	localIBinder	IBinder
      //   5	75	4	localParcel	Parcel
      // Exception table:
      //   from	to	target	type
      //   7	14	78	finally
      //   18	25	78	finally
      //   25	31	78	finally
      //   35	48	78	finally
      //   48	63	78	finally
      //   69	75	78	finally
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpk.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */