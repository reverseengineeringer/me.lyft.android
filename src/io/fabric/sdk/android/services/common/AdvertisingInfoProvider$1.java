package io.fabric.sdk.android.services.common;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;

class AdvertisingInfoProvider$1
  extends BackgroundPriorityRunnable
{
  AdvertisingInfoProvider$1(AdvertisingInfoProvider paramAdvertisingInfoProvider, AdvertisingInfo paramAdvertisingInfo) {}
  
  public void onRun()
  {
    AdvertisingInfo localAdvertisingInfo = AdvertisingInfoProvider.access$000(this$0);
    if (!val$advertisingInfo.equals(localAdvertisingInfo))
    {
      Fabric.getLogger().d("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
      AdvertisingInfoProvider.access$100(this$0, localAdvertisingInfo);
    }
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.AdvertisingInfoProvider.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */