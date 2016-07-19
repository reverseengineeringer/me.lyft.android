package me.lyft.android.infrastructure.assets;

import me.lyft.android.common.Unit;
import rx.Observable;

public abstract interface IAssetPackagingService
{
  public abstract void downloadAssetsIfChanged(String paramString);
  
  public abstract Observable<Unit> unpackEmbededZipResources();
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.assets.IAssetPackagingService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */