package com.google.android.gms.wearable;

import com.google.android.gms.common.data.DataHolder;

class WearableListenerService$zzc$1
  implements Runnable
{
  WearableListenerService$zzc$1(WearableListenerService.zzc paramzzc, DataHolder paramDataHolder) {}
  
  public void run()
  {
    DataEventBuffer localDataEventBuffer = new DataEventBuffer(aJu);
    try
    {
      aJv.aJr.onDataChanged(localDataEventBuffer);
      return;
    }
    finally
    {
      localDataEventBuffer.release();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.WearableListenerService.zzc.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */