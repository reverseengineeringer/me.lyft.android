package me.lyft.android.infrastructure.assets;

import java.io.File;
import me.lyft.android.common.Unit;
import rx.functions.Action1;

class AssetPackagingService$2
  implements Action1<Unit>
{
  AssetPackagingService$2(AssetPackagingService paramAssetPackagingService, File paramFile) {}
  
  public void call(Unit paramUnit)
  {
    val$packageFile.delete();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.assets.AssetPackagingService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */