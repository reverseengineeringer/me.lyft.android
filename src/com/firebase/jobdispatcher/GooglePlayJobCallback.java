package com.firebase.jobdispatcher;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.gcm.INetworkTaskCallback;
import com.google.android.gms.gcm.INetworkTaskCallback.Stub;

final class GooglePlayJobCallback
  implements JobCallback
{
  private final INetworkTaskCallback mCallback;
  
  public GooglePlayJobCallback(IBinder paramIBinder)
  {
    mCallback = INetworkTaskCallback.Stub.asInterface(paramIBinder);
  }
  
  public void jobFinished(int paramInt)
  {
    try
    {
      mCallback.taskFinished(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeException(localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.GooglePlayJobCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */