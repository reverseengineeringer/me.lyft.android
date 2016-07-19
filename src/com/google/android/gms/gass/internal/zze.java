package com.google.android.gms.gass.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface zze
  extends IInterface
{
  public abstract GassResponseParcel zza(GassRequestParcel paramGassRequestParcel)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zze
  {
    public static zze zzgl(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.gass.internal.IGassService");
      if ((localIInterface != null) && ((localIInterface instanceof zze))) {
        return (zze)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.gass.internal.IGassService");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.gass.internal.IGassService");
      if (paramParcel1.readInt() != 0)
      {
        paramParcel1 = (GassRequestParcel)GassRequestParcel.CREATOR.createFromParcel(paramParcel1);
        paramParcel1 = zza(paramParcel1);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label104;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel1 = null;
        break;
        label104:
        paramParcel2.writeInt(0);
      }
    }
    
    private static class zza
      implements zze
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
      
      public GassResponseParcel zza(GassRequestParcel paramGassRequestParcel)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.gass.internal.IGassService");
            if (paramGassRequestParcel != null)
            {
              localParcel1.writeInt(1);
              paramGassRequestParcel.writeToParcel(localParcel1, 0);
              zzahn.transact(1, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramGassRequestParcel = (GassResponseParcel)GassResponseParcel.CREATOR.createFromParcel(localParcel2);
                return paramGassRequestParcel;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramGassRequestParcel = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.gass.internal.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */