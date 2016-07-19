package me.lyft.android.driver.ui;

import android.graphics.Bitmap;
import rx.functions.Func1;

class DriverAssetService$2
  implements Func1<Throwable, Bitmap>
{
  DriverAssetService$2(DriverAssetService paramDriverAssetService, String paramString) {}
  
  public Bitmap call(Throwable paramThrowable)
  {
    return DriverAssetService.access$000(this$0, val$rideType);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.driver.ui.DriverAssetService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */