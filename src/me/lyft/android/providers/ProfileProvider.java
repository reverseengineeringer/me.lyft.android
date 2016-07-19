package me.lyft.android.providers;

import android.content.ContentResolver;
import javax.inject.Inject;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.schedulers.Schedulers;

public class ProfileProvider
{
  private static final String NAME_PATTERN = "^[\\p{L}\\s'.-]+$";
  private static final String[] PHONE_PROFILE_PROJECTION = { "is_primary", "data3", "data2", "photo_uri" };
  private final ContentResolver contentResolver;
  final Observable.OnSubscribe<ProfileProvider.PhoneProfile> phoneProfileSubscriber = new ProfileProvider.1(this);
  
  @Inject
  public ProfileProvider(ContentResolver paramContentResolver)
  {
    contentResolver = paramContentResolver;
  }
  
  public Observable<ProfileProvider.PhoneProfile> observePhoneProfile()
  {
    return Observable.create(phoneProfileSubscriber).subscribeOn(Schedulers.io());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.providers.ProfileProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */