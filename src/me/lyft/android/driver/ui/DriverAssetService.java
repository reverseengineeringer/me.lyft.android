package me.lyft.android.driver.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.HashMap;
import java.util.Map;
import me.lyft.android.common.Objects;
import me.lyft.android.infrastructure.assets.IAssetLoadingService;
import rx.Observable;
import rx.functions.Func1;

public class DriverAssetService
  implements IDriverAssetService
{
  private static final Map<String, Integer> DEFAULT_MARKER_MAP = new HashMap() {};
  private final IAssetLoadingService assetLoadingService;
  private final Resources resources;
  
  public DriverAssetService(Resources paramResources, IAssetLoadingService paramIAssetLoadingService)
  {
    resources = paramResources;
    assetLoadingService = paramIAssetLoadingService;
  }
  
  private Bitmap getBitmapFromResourceId(int paramInt)
  {
    return BitmapFactory.decodeResource(resources, paramInt);
  }
  
  private Bitmap getByRideType(String paramString)
  {
    return getBitmapFromResourceId(resolveNearbyDriverMarker(paramString));
  }
  
  private int resolveNearbyDriverMarker(String paramString)
  {
    return ((Integer)Objects.firstNonNull(DEFAULT_MARKER_MAP.get(paramString), Integer.valueOf(2130838425))).intValue();
  }
  
  public Observable<Bitmap> getDriverBitmap(String paramString1, final String paramString2)
  {
    assetLoadingService.loadMarkerBitmap(paramString1).onErrorReturn(new Func1()
    {
      public Bitmap call(Throwable paramAnonymousThrowable)
      {
        return DriverAssetService.this.getByRideType(paramString2);
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.driver.ui.DriverAssetService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */