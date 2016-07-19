package me.lyft.android.infrastructure.assets;

import me.lyft.android.common.Unit;
import me.lyft.android.logging.L;
import me.lyft.android.rx.SimpleSubscriber;

class AssetPackagingService$1
  extends SimpleSubscriber<Unit>
{
  AssetPackagingService$1(AssetPackagingService paramAssetPackagingService) {}
  
  public void onError(Throwable paramThrowable)
  {
    super.onError(paramThrowable);
    L.w(paramThrowable, "updateAssets", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.assets.AssetPackagingService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */