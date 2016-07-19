package me.lyft.android.ui.splitfare;

import com.lyft.scoop.Layout;
import java.util.List;
import me.lyft.android.providers.UserContact;

@Layout(2130903130)
public class SplitFareDialogs$ContactsSearchDialog
  extends SplitFareDialogs
{
  private final List<UserContact> checkedContacts;
  private final List<UserContact> contacts;
  private final List<UserContact> disabledContacts;
  
  public SplitFareDialogs$ContactsSearchDialog(List<UserContact> paramList1, List<UserContact> paramList2, List<UserContact> paramList3)
  {
    contacts = paramList1;
    checkedContacts = paramList2;
    disabledContacts = paramList3;
  }
  
  public List<UserContact> getCheckedContacts()
  {
    return checkedContacts;
  }
  
  public List<UserContact> getContacts()
  {
    return contacts;
  }
  
  public List<UserContact> getDisabledContacts()
  {
    return disabledContacts;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.splitfare.SplitFareDialogs.ContactsSearchDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */