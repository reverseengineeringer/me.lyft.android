package me.lyft.android.providers;

import android.content.ContentResolver;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.functions.Func1;

@Deprecated
public class ContactsProvider
{
  final Observable<UserContact> companyObservable;
  final Observable.OnSubscribe<UserContact> companySubscriber = new ContactsProvider.2(this);
  private final Func1<UserContact, Boolean> emailLengthFilter = new ContactsProvider.5(this);
  final Observable.OnSubscribe<UserContact> emailSubscriber = new ContactsProvider.1(this);
  final Observable<UserContact> emailsObservable;
  private final Func1<UserContact, Boolean> hasNameFilter = new ContactsProvider.4(this);
  final Observable.OnSubscribe<UserContact> phoneSubscriber = new ContactsProvider.3(this);
  final Observable<UserContact> phonesObservable;
  final ContentResolver resolver;
  
  public ContactsProvider(ContentResolver paramContentResolver)
  {
    resolver = paramContentResolver;
    phonesObservable = Observable.create(phoneSubscriber).filter(new ContactsProvider.PhoneNumberFilter()).cache();
    emailsObservable = Observable.create(emailSubscriber).filter(emailLengthFilter).cache();
    companyObservable = Observable.create(companySubscriber).cache();
  }
  
  public ContactsProvider.Builder create()
  {
    return new ContactsProvider.Builder(this, null);
  }
  
  public Observable<UserContact> getPhonesObservable()
  {
    return phonesObservable;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.providers.ContactsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */