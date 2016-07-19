package com.google.android.gms.gass.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

class zze$zza$zza
  implements zze
{
  private IBinder zzahn;
  
  zze$zza$zza(IBinder paramIBinder)
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

/* Location:
 * Qualified Name:     com.google.android.gms.gass.internal.zze.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */