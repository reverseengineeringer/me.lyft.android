package com.waze.sdk;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class WazeSDKManager$ActivityHandler
  extends Handler
{
  private final WeakReference<WazeSDKManager> mActivity;
  
  public WazeSDKManager$ActivityHandler(WazeSDKManager paramWazeSDKManager)
  {
    mActivity = new WeakReference(paramWazeSDKManager);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (WazeSDKManager.access$6(WazeSDKManager.mInstance)) {
      switch (what)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                } while (Utils.DecryptData(paramMessage.getData().getByteArray("NEXT_TURN"), WazeSDKManager.mDecryptKey) != null);
                return;
                paramMessage = Utils.DecryptData(paramMessage.getData().getByteArray("ETA_MINUTES"), WazeSDKManager.mDecryptKey);
              } while (paramMessage == null);
              WazeSDKManager.access$2(2, "ETA_MINUTES", paramMessage);
              return;
              paramMessage = Utils.DecryptData(paramMessage.getData().getByteArray("INSTRUCTION"), WazeSDKManager.mDecryptKey);
            } while (paramMessage == null);
            WazeSDKManager.access$2(3, "INSTRUCTION", paramMessage);
            return;
            paramMessage = Utils.DecryptData(paramMessage.getData().getByteArray("INSTRUCTION_EXIT"), WazeSDKManager.mDecryptKey);
          } while (paramMessage == null);
          WazeSDKManager.access$2(6, "INSTRUCTION_EXIT", paramMessage);
          return;
          paramMessage = Utils.DecryptData(paramMessage.getData().getByteArray("AGREEMENT"), WazeSDKManager.mDecryptKey);
        } while ((paramMessage == null) || (!Boolean.valueOf(paramMessage).booleanValue()));
        if ((WazeSDKManager.msearchQuery != null) && (!WazeSDKManager.msearchQuery.isEmpty()))
        {
          ((WazeSDKManager)mActivity.get()).searchRequest(WazeSDKManager.msearchQuery);
          return;
        }
        ((WazeSDKManager)mActivity.get()).driveRequest(WazeSDKManager.mNavigateLon, WazeSDKManager.mNavigateLat);
        return;
        paramMessage = Utils.DecryptData(paramMessage.getData().getByteArray("DISTANCE_METERS"), WazeSDKManager.mDecryptKey);
      } while (paramMessage == null);
      WazeSDKManager.access$2(1, "DISTANCE_METERS", paramMessage);
      return;
      paramMessage = Utils.DecryptData(paramMessage.getData().getByteArray("GeoJson"), WazeSDKManager.mDecryptKey);
    } while (paramMessage == null);
    WazeSDKManager.access$2(0, "GeoJson", paramMessage);
  }
}

/* Location:
 * Qualified Name:     com.waze.sdk.WazeSDKManager.ActivityHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */