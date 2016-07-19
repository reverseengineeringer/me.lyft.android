package me.lyft.android.infrastructure.assets;

import java.io.File;
import java.io.FileInputStream;
import me.lyft.android.common.Unit;
import rx.Observable;
import rx.functions.Func1;

class AssetPackagingService$3
  implements Func1<File, Observable<? extends Unit>>
{
  AssetPackagingService$3(AssetPackagingService paramAssetPackagingService, String paramString) {}
  
  public Observable<? extends Unit> call(File paramFile)
  {
    try
    {
      paramFile = new FileInputStream(paramFile);
      paramFile = AssetPackagingService.access$000(this$0, val$fileName, paramFile);
      return paramFile;
    }
    catch (Throwable paramFile) {}
    return Observable.error(paramFile);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.assets.AssetPackagingService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */