package me.lyft.android.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.lyft.android.common.Strings;
import me.lyft.android.providers.ContactPhone;
import me.lyft.android.providers.UserContact;
import me.lyft.android.ui.invites.InviteItemView;
import me.lyft.android.ui.splitfare.SearchHelper;

public class ContactsAdapter
  extends BaseAdapter
  implements SectionIndexer
{
  private static final int ENGLISH_ALPHABET_LENGTH = 26;
  private final Set<UserContact> checkedContacts = new HashSet();
  private final List<UserContact> data = new ArrayList();
  private final Set<UserContact> disabledContacts = new HashSet();
  private boolean hasMaxInvitesBeenHit = false;
  private final LayoutInflater inflater;
  private boolean isCategoriesEnabled = true;
  private final Map<String, Integer> sectionIndexMap = new LinkedHashMap(26);
  private String[] sections;
  
  public ContactsAdapter(LayoutInflater paramLayoutInflater)
  {
    inflater = paramLayoutInflater;
  }
  
  private static String getCategory(UserContact paramUserContact)
  {
    if (!Strings.isNullOrEmpty(paramUserContact.getCategory())) {
      return paramUserContact.getCategory();
    }
    return getDefaultCategory(paramUserContact.getName());
  }
  
  private static String getDefaultCategory(String paramString)
  {
    if ((SearchHelper.isPhoneNumber(paramString)) || (SearchHelper.startsWithDigit(paramString))) {
      return "#";
    }
    return String.valueOf(paramString.charAt(0)).toUpperCase();
  }
  
  private void initAlphabetIndexer()
  {
    int i = 0;
    while (i < data.size())
    {
      localObject = getCategory((UserContact)data.get(i));
      if (!sectionIndexMap.containsKey(localObject)) {
        sectionIndexMap.put(localObject, Integer.valueOf(i));
      }
      i += 1;
    }
    Object localObject = new ArrayList(sectionIndexMap.keySet());
    sections = new String[((List)localObject).size()];
    ((List)localObject).toArray(sections);
  }
  
  private boolean isItemChecked(UserContact paramUserContact)
  {
    return checkedContacts.contains(paramUserContact);
  }
  
  private static List<UserContact> toList(Set<UserContact> paramSet)
  {
    ArrayList localArrayList = new ArrayList(paramSet.size());
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      localArrayList.add((UserContact)paramSet.next());
    }
    return localArrayList;
  }
  
  public void addCheckedContact(UserContact paramUserContact)
  {
    checkedContacts.add(paramUserContact);
  }
  
  public void addDisabledContact(UserContact paramUserContact)
  {
    disabledContacts.add(paramUserContact);
  }
  
  public ContactsAdapter disableCategories()
  {
    isCategoriesEnabled = false;
    return this;
  }
  
  public List<UserContact> getCheckedData()
  {
    return toList(checkedContacts);
  }
  
  public int getCheckedItemCount()
  {
    return checkedContacts.size();
  }
  
  public int getCount()
  {
    return data.size();
  }
  
  public List<UserContact> getData()
  {
    return data;
  }
  
  public List<UserContact> getDisabledData()
  {
    return toList(disabledContacts);
  }
  
  public UserContact getItem(int paramInt)
  {
    return (UserContact)data.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getPositionForSection(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < sections.length)) {
      return ((Integer)sectionIndexMap.get(sections[paramInt])).intValue();
    }
    return 0;
  }
  
  public int getSectionForPosition(int paramInt)
  {
    int i;
    if (data.size() <= paramInt)
    {
      i = 0;
      return i;
    }
    String str = getCategory((UserContact)data.get(paramInt));
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= sections.length) {
        break label67;
      }
      i = paramInt;
      if (sections[paramInt].equals(str)) {
        break;
      }
      paramInt += 1;
    }
    label67:
    return 0;
  }
  
  public String[] getSections()
  {
    return sections;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool2 = false;
    UserContact localUserContact;
    boolean bool3;
    boolean bool1;
    if (paramView == null)
    {
      paramViewGroup = (InviteItemView)inflater.inflate(2130903129, paramViewGroup, false);
      localUserContact = (UserContact)data.get(paramInt);
      bool3 = isItemChecked(paramInt);
      if (!isItemDisabled(paramInt))
      {
        bool1 = bool2;
        if (!bool3)
        {
          bool1 = bool2;
          if (!hasMaxInvitesBeenHit) {}
        }
      }
      else
      {
        bool1 = true;
      }
      if (!isCategoriesEnabled) {
        break label168;
      }
      if (paramInt != 0) {
        break label120;
      }
      paramInt = getSectionForPosition(paramInt);
      paramView = getSections()[paramInt];
    }
    label120:
    String str;
    do
    {
      paramViewGroup.showWithCategories(localUserContact, bool3, bool1, paramView);
      return paramViewGroup;
      paramViewGroup = (InviteItemView)paramView;
      break;
      int i = getSectionForPosition(paramInt - 1);
      paramInt = getSectionForPosition(paramInt);
      str = getSections()[i];
      paramView = getSections()[paramInt];
    } while (!paramView.equals(str));
    for (;;)
    {
      paramView = null;
    }
    label168:
    paramViewGroup.showWithoutCategories(localUserContact, bool3, bool1);
    return paramViewGroup;
  }
  
  public boolean isItemChecked(int paramInt)
  {
    return isItemChecked(getItem(paramInt));
  }
  
  public boolean isItemDisabled(int paramInt)
  {
    return isItemDisabled(getItem(paramInt));
  }
  
  public boolean isItemDisabled(UserContact paramUserContact)
  {
    boolean bool = false;
    ContactPhone localContactPhone = paramUserContact.getPhoneNumber();
    if ((!Strings.isNullOrEmpty(paramUserContact.getEmail())) || ((localContactPhone != null) && (SearchHelper.isNumberValid(localContactPhone.getPhoneNumber())))) {}
    for (int i = 1;; i = 0)
    {
      if ((disabledContacts.contains(paramUserContact)) || (i == 0)) {
        bool = true;
      }
      return bool;
    }
  }
  
  public void setHasMaxInvitesBeenHit(boolean paramBoolean)
  {
    hasMaxInvitesBeenHit = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void setItemDisabled(int paramInt)
  {
    UserContact localUserContact = getItem(paramInt);
    if (disabledContacts.add(localUserContact)) {
      notifyDataSetChanged();
    }
  }
  
  public void swapData(List<UserContact> paramList)
  {
    data.clear();
    sectionIndexMap.clear();
    if (paramList != null)
    {
      data.addAll(paramList);
      initAlphabetIndexer();
    }
    notifyDataSetChanged();
  }
  
  public void toggleChecked(int paramInt)
  {
    UserContact localUserContact = getItem(paramInt);
    if (checkedContacts.contains(localUserContact)) {
      checkedContacts.remove(localUserContact);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      checkedContacts.add(localUserContact);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.adapters.ContactsAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */