package com.waze.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;

class WazeSDKManager$2
  implements ServiceConnection
{
  WazeSDKManager$2(WazeSDKManager paramWazeSDKManager) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    WazeSDKManager.access$1(this$0, new Messenger(paramIBinder));
    WazeSDKManager.access$3(this$0, true);
    if (WazeSDKManager.access$4(this$0)) {
      WazeSDKManager.access$5(WazeSDKManager.mInstance);
    }
    WazeSDKManager.access$2(WazeSDKManager.Waze_Message.Waze_Message_CONNECTION_STATUS.ordinal(), "STATUS", "true");
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    WazeSDKManager.access$1(this$0, null);
    WazeSDKManager.access$2(WazeSDKManager.Waze_Message.Waze_Message_CONNECTION_STATUS.ordinal(), "STATUS", "false");
  }
}

/* Location:
 * Qualified Name:     com.waze.sdk.WazeSDKManager.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */