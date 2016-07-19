package com.waze.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.waze.IServiceAIDL;
import com.waze.IServiceAIDL.Stub;

class WazeSDKManager$1
  implements ServiceConnection
{
  WazeSDKManager$1(WazeSDKManager paramWazeSDKManager) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    WazeSDKManager.mAIDLService = IServiceAIDL.Stub.asInterface(paramIBinder);
    WazeSDKManager.access$0(this$0, true);
    try
    {
      WazeSDKManager.mAIDLService.sendKey(WazeSDKManager.mDecryptKey);
      return;
    }
    catch (RemoteException paramComponentName)
    {
      paramComponentName.printStackTrace();
      return;
    }
    catch (Exception paramComponentName)
    {
      paramComponentName.printStackTrace();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    WazeSDKManager.mAIDLService = null;
  }
}

/* Location:
 * Qualified Name:     com.waze.sdk.WazeSDKManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */