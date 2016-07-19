package com.waze;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class IServiceAIDL$Stub
  extends Binder
  implements IServiceAIDL
{
  public static IServiceAIDL asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.waze.IServiceAIDL");
    if ((localIInterface != null) && ((localIInterface instanceof IServiceAIDL))) {
      return (IServiceAIDL)localIInterface;
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
      paramParcel2.writeString("com.waze.IServiceAIDL");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.waze.IServiceAIDL");
      paramInt1 = getPid();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.waze.IServiceAIDL");
      sendKey(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.waze.IServiceAIDL");
    paramInt1 = paramParcel1.readInt();
    long l = paramParcel1.readLong();
    if (paramParcel1.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      basicTypes(paramInt1, l, bool, paramParcel1.readFloat(), paramParcel1.readDouble(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
  }
  
  private static class Proxy
    implements IServiceAIDL
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
}

/* Location:
 * Qualified Name:     com.waze.IServiceAIDL.Stub
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */