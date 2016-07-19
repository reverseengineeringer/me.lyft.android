package me.lyft.android.providers;

import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import javax.inject.Inject;
import javax.inject.Singleton;
import me.lyft.android.LyftApplication;
import rx.Observable;

@Singleton
public class AdvertisingIdProvider
{
  @Inject
  LyftApplication app;
  
  public Observable<AdvertisingIdClient.Info> getAdvertisingInfo()
  {
    return Observable.create(new AdvertisingIdProvider.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.providers.AdvertisingIdProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */