package me.lyft.android.infrastructure.photo;

import me.lyft.android.common.Unit;
import rx.Observable;

public abstract interface IPhotoPickerService
{
  public abstract Observable<Unit> observePhotoPickerResult();
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.photo.IPhotoPickerService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */