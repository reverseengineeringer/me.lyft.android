package io.fabric.sdk.android.services.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

final class AdvertisingInfoServiceStrategy$AdvertisingConnection
  implements ServiceConnection
{
  private final LinkedBlockingQueue<IBinder> queue = new LinkedBlockingQueue(1);
  private boolean retrieved = false;
  
  public IBinder getBinder()
  {
    if (retrieved) {
      Fabric.getLogger().e("Fabric", "getBinder already called");
    }
    retrieved = true;
    try
    {
      IBinder localIBinder = (IBinder)queue.poll(200L, TimeUnit.MILLISECONDS);
      return localIBinder;
    }
    catch (InterruptedException localInterruptedException) {}
    return null;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      queue.put(paramIBinder);
      return;
    }
    catch (InterruptedException paramComponentName) {}
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    queue.clear();
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.AdvertisingInfoServiceStrategy.AdvertisingConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */