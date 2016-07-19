package me.lyft.android.infrastructure.contacts;

import java.util.List;
import me.lyft.android.domain.contacts.UserContact;
import rx.Observable;

public abstract interface IAndroidContactsProvider
{
  public abstract Observable<List<UserContact>> getEmailsObservable();
  
  public abstract Observable<List<UserContact>> getPhonesAndEmailsObservable();
  
  public abstract Observable<List<UserContact>> getPhonesObservable();
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.contacts.IAndroidContactsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */