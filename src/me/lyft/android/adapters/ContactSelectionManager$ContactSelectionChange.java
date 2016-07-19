package me.lyft.android.adapters;

import me.lyft.android.domain.contacts.UserContact;

public class ContactSelectionManager$ContactSelectionChange
{
  boolean selected;
  UserContact userContact;
  
  public ContactSelectionManager$ContactSelectionChange(ContactSelectionManager paramContactSelectionManager, boolean paramBoolean, UserContact paramUserContact)
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

/* Location:
 * Qualified Name:     me.lyft.android.adapters.ContactSelectionManager.ContactSelectionChange
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */