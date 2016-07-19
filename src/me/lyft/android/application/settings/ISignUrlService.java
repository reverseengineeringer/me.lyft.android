package me.lyft.android.application.settings;

import rx.Observable;

public abstract interface ISignUrlService
{
  public abstract Observable<String> getSignedUrl(String paramString);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.settings.ISignUrlService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */