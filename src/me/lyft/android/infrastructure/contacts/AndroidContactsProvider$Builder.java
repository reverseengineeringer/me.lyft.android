package me.lyft.android.infrastructure.contacts;

import java.util.ArrayList;
import java.util.List;
import me.lyft.android.domain.contacts.UserContact;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

class AndroidContactsProvider$Builder
{
  final List<Observable<UserContact>> observables = new ArrayList(4);
  
  private AndroidContactsProvider$Builder(AndroidContactsProvider paramAndroidContactsProvider) {}
  
  public Builder emails()
  {
    observables.add(this$0.emailsObservable);
    return this;
  }
  
  public Observable<List<UserContact>> observe()
  {
    return Observable.merge(observables).toSortedList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
  }
  
  public Builder phones()
  {
    observables.add(this$0.phonesObservable);
    return this;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.contacts.AndroidContactsProvider.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */