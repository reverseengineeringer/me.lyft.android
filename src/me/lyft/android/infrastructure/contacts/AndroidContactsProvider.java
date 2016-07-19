package me.lyft.android.infrastructure.contacts;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import me.lyft.android.common.Closeables;
import me.lyft.android.domain.contacts.UserContact;
import me.lyft.android.ui.splitfare.SearchHelper;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class AndroidContactsProvider
  implements IAndroidContactsProvider
{
  final Func1<UserContact, Boolean> emailLengthFilter = new Func1()
  {
    public Boolean call(UserContact paramAnonymousUserContact)
    {
      if (paramAnonymousUserContact.getEmail().length() < 40) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
    }
  };
  final Observable.OnSubscribe<UserContact> emailSubscriber = new Observable.OnSubscribe()
  {
    public void call(Subscriber<? super UserContact> paramAnonymousSubscriber)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      try
      {
        Cursor localCursor = resolver.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, new String[] { "display_name", "data1" }, null, null, "display_name COLLATE NOCASE ASC");
        localObject1 = localCursor;
        localObject2 = localCursor;
        int i = localCursor.getColumnIndex("display_name");
        localObject1 = localCursor;
        localObject2 = localCursor;
        int j = localCursor.getColumnIndex("data1");
        for (;;)
        {
          localObject1 = localCursor;
          localObject2 = localCursor;
          if (!localCursor.moveToNext()) {
            break;
          }
          localObject1 = localCursor;
          localObject2 = localCursor;
          paramAnonymousSubscriber.onNext(new UserContact(localCursor.getString(i), localCursor.getString(j), null, null));
        }
        Closeables.closeQuietly((Closeable)localObject2);
      }
      catch (Exception localException)
      {
        localObject2 = localObject1;
        paramAnonymousSubscriber.onError(localException);
        if (Build.VERSION.SDK_INT >= 16)
        {
          Closeables.closeQuietly((Closeable)localObject1);
          return;
          localObject1 = localException;
          localObject2 = localException;
          paramAnonymousSubscriber.onCompleted();
          if (Build.VERSION.SDK_INT >= 16)
          {
            Closeables.closeQuietly(localException);
            return;
          }
          localException.close();
          return;
        }
        ((Cursor)localObject1).close();
        return;
      }
      finally
      {
        if (Build.VERSION.SDK_INT < 16) {}
      }
      for (;;)
      {
        throw paramAnonymousSubscriber;
        ((Cursor)localObject2).close();
      }
    }
  };
  final Observable<UserContact> emailsObservable;
  final Observable.OnSubscribe<UserContact> phoneSubscriber = new Observable.OnSubscribe()
  {
    public void call(Subscriber<? super UserContact> paramAnonymousSubscriber)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      try
      {
        Cursor localCursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[] { "display_name", "data1", "data2" }, null, null, "display_name COLLATE NOCASE ASC");
        localObject1 = localCursor;
        localObject2 = localCursor;
        int i = localCursor.getColumnIndex("display_name");
        localObject1 = localCursor;
        localObject2 = localCursor;
        localCursor.getColumnIndex("photo_uri");
        localObject1 = localCursor;
        localObject2 = localCursor;
        int j = localCursor.getColumnIndex("data1");
        for (;;)
        {
          localObject1 = localCursor;
          localObject2 = localCursor;
          if (!localCursor.moveToNext()) {
            break;
          }
          localObject1 = localCursor;
          localObject2 = localCursor;
          paramAnonymousSubscriber.onNext(new UserContact(localCursor.getString(i), null, localCursor.getString(j), localCursor.getString(j)));
        }
        Closeables.closeQuietly((Closeable)localObject2);
      }
      catch (Exception localException)
      {
        localObject2 = localObject1;
        paramAnonymousSubscriber.onError(localException);
        if (Build.VERSION.SDK_INT >= 16)
        {
          Closeables.closeQuietly((Closeable)localObject1);
          return;
          localObject1 = localException;
          localObject2 = localException;
          paramAnonymousSubscriber.onCompleted();
          if (Build.VERSION.SDK_INT >= 16)
          {
            Closeables.closeQuietly(localException);
            return;
          }
          localException.close();
          return;
        }
        ((Cursor)localObject1).close();
        return;
      }
      finally
      {
        if (Build.VERSION.SDK_INT < 16) {}
      }
      for (;;)
      {
        throw paramAnonymousSubscriber;
        ((Cursor)localObject2).close();
      }
    }
  };
  final Observable<UserContact> phonesObservable;
  final ContentResolver resolver;
  
  public AndroidContactsProvider(ContentResolver paramContentResolver)
  {
    resolver = paramContentResolver;
    phonesObservable = Observable.create(phoneSubscriber).filter(new PhoneNumberFilter()).cache();
    emailsObservable = Observable.create(emailSubscriber).filter(emailLengthFilter).cache();
  }
  
  public Observable<List<UserContact>> getEmailsObservable()
  {
    return new Builder(null).emails().observe();
  }
  
  public Observable<List<UserContact>> getPhonesAndEmailsObservable()
  {
    return new Builder(null).phones().emails().observe();
  }
  
  public Observable<List<UserContact>> getPhonesObservable()
  {
    return new Builder(null).phones().observe();
  }
  
  private class Builder
  {
    final List<Observable<UserContact>> observables = new ArrayList(4);
    
    private Builder() {}
    
    public Builder emails()
    {
      observables.add(emailsObservable);
      return this;
    }
    
    public Observable<List<UserContact>> observe()
    {
      return Observable.merge(observables).toSortedList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
    
    public Builder phones()
    {
      observables.add(phonesObservable);
      return this;
    }
  }
  
  public static class PhoneNumberFilter
    implements Func1<UserContact, Boolean>
  {
    private final Set<String> addedPhoneNumbers = new HashSet();
    
    public Boolean call(UserContact paramUserContact)
    {
      paramUserContact = SearchHelper.normalizeNumber(paramUserContact.getPhoneNumber());
      if ((!addedPhoneNumbers.contains(paramUserContact)) && (SearchHelper.isNormalizedNumberValid(paramUserContact)))
      {
        addedPhoneNumbers.add(paramUserContact);
        return Boolean.valueOf(true);
      }
      return Boolean.valueOf(false);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.contacts.AndroidContactsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */