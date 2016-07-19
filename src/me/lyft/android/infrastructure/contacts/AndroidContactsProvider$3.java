package me.lyft.android.infrastructure.contacts;

import me.lyft.android.domain.contacts.UserContact;
import rx.functions.Func1;

class AndroidContactsProvider$3
  implements Func1<UserContact, Boolean>
{
  AndroidContactsProvider$3(AndroidContactsProvider paramAndroidContactsProvider) {}
  
  public Boolean call(UserContact paramUserContact)
  {
    if (paramUserContact.getEmail().length() < 40) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.contacts.AndroidContactsProvider.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */