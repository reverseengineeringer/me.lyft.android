package me.lyft.android.adapters;

import com.jakewharton.rxrelay.BehaviorRelay;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import me.lyft.android.domain.contacts.UserContact;
import rx.Observable;

public class ContactSelectionManager
{
  private final LinkedHashMap<Integer, UserContact> selectedContact = new LinkedHashMap();
  private final BehaviorRelay<ContactSelectionChange> selectionSubject = BehaviorRelay.create();
  
  public List<UserContact> getSelectedContacts()
  {
    return new ArrayList(selectedContact.values());
  }
  
  public int getSelectedCount()
  {
    return selectedContact.size();
  }
  
  public boolean isSelected(UserContact paramUserContact)
  {
    return selectedContact.containsKey(Integer.valueOf(paramUserContact.hashCode()));
  }
  
  public Observable<ContactSelectionChange> observeSelection()
  {
    return selectionSubject.asObservable();
  }
  
  public boolean toggleContact(UserContact paramUserContact)
  {
    if (selectedContact.containsKey(Integer.valueOf(paramUserContact.hashCode())))
    {
      selectedContact.remove(Integer.valueOf(paramUserContact.hashCode()));
      selectionSubject.call(new ContactSelectionChange(false, paramUserContact));
      return false;
    }
    selectedContact.put(Integer.valueOf(paramUserContact.hashCode()), paramUserContact);
    selectionSubject.call(new ContactSelectionChange(true, paramUserContact));
    return true;
  }
  
  public class ContactSelectionChange
  {
    boolean selected;
    UserContact userContact;
    
    public ContactSelectionChange(boolean paramBoolean, UserContact paramUserContact)
    {
      selected = paramBoolean;
      userContact = paramUserContact;
    }
    
    public UserContact getUserContact()
    {
      return userContact;
    }
    
    public boolean isSelected()
    {
      return selected;
    }
    
    public void setSelected(boolean paramBoolean)
    {
      selected = paramBoolean;
    }
    
    public void setUserContact(UserContact paramUserContact)
    {
      userContact = paramUserContact;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.adapters.ContactSelectionManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */