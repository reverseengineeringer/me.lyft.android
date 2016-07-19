package me.lyft.android.infrastructure.contacts;

import java.util.HashSet;
import java.util.Set;
import me.lyft.android.domain.contacts.UserContact;
import me.lyft.android.ui.splitfare.SearchHelper;
import rx.functions.Func1;

public class AndroidContactsProvider$PhoneNumberFilter
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

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.contacts.AndroidContactsProvider.PhoneNumberFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */