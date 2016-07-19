package com.waze;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class IServiceAIDL$Stub$Proxy
  implements IServiceAIDL
{
  private IBinder mRemote;
  
  IServiceAIDL$Stub$Proxy(IBinder paramIBinder)
  {
    mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return mRemote;
  }
  
  public void basicTypes(int paramInt, long paramLong, boolean paramBoolean, float paramFloat, double paramDouble, String paramString)
    throws RemoteException
  {
    int i = 0;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.waze.IServiceAIDL");
      localParcel1.writeInt(paramInt);
      localParcel1.writeLong(paramLong);
      paramInt = i;
      if (paramBoolean) {
        paramInt = 1;
      }
      localParcel1.writeInt(paramInt);
      localParcel1.writeFloat(paramFloat);
      localParcel1.writeDouble(paramDouble);
      localParcel1.writeString(paramString);
      mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int getPid()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.waze.IServiceAIDL");
      mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void sendKey(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.waze.IServiceAIDL");
      localParcel1.writeString(paramString);
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

/* Location:
 * Qualified Name:     com.waze.IServiceAIDL.Stub.Proxy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */