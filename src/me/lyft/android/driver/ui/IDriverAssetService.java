package me.lyft.android.driver.ui;

import android.graphics.Bitmap;
import rx.Observable;

public abstract interface IDriverAssetService
{
  public abstract Observable<Bitmap> getDriverBitmap(String paramString1, String paramString2);
}

/* Location:
 * Qualified Name:     me.lyft.android.driver.ui.IDriverAssetService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */