package com.google.android.gms.gcm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class INetworkTaskCallback$Stub
  extends Binder
  implements INetworkTaskCallback
{
  public static INetworkTaskCallback asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.gcm.INetworkTaskCallback");
    if ((localIInterface != null) && ((localIInterface instanceof INetworkTaskCallback))) {
      return (INetworkTaskCallback)localIInterface;
    }
    return new Proxy(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.gcm.INetworkTaskCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.gcm.INetworkTaskCallback");
    taskFinished(paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
  }
  
  private static class Proxy
    implements INetworkTaskCallback
  {
    private IBinder mRemote;
    
    Proxy(IBinder paramIBinder)
    {
      mRemote = paramIBinder;
    }
    
    public IBinder asBinder()
    {
      return mRemote;
    }
    
    public void taskFinished(int paramInt)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.gcm.INetworkTaskCallback");
        localParcel1.writeInt(paramInt);
        mRemote.transact(2, localParcel1, localParcel2, 0);
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
 * Qualified Name:     com.google.android.gms.gcm.INetworkTaskCallback.Stub
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */