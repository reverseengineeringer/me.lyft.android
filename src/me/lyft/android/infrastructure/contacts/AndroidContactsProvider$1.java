package me.lyft.android.infrastructure.contacts;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.provider.ContactsContract.CommonDataKinds.Email;
import java.io.Closeable;
import me.lyft.android.common.Closeables;
import me.lyft.android.domain.contacts.UserContact;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class AndroidContactsProvider$1
  implements Observable.OnSubscribe<UserContact>
{
  AndroidContactsProvider$1(AndroidContactsProvider paramAndroidContactsProvider) {}
  
  public void call(Subscriber<? super UserContact> paramSubscriber)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      Cursor localCursor = this$0.resolver.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, new String[] { "display_name", "data1" }, null, null, "display_name COLLATE NOCASE ASC");
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
        paramSubscriber.onNext(new UserContact(localCursor.getString(i), localCursor.getString(j), null, null));
      }
      Closeables.closeQuietly((Closeable)localObject2);
    }
    catch (Exception localException)
    {
      localObject2 = localObject1;
      paramSubscriber.onError(localException);
      if (Build.VERSION.SDK_INT >= 16)
      {
        Closeables.closeQuietly((Closeable)localObject1);
        return;
        localObject1 = localException;
        localObject2 = localException;
        paramSubscriber.onCompleted();
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
      throw paramSubscriber;
      ((Cursor)localObject2).close();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.contacts.AndroidContactsProvider.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */