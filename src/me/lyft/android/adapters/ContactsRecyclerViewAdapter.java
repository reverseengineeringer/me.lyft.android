package me.lyft.android.adapters;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.contacts.UserContact;
import me.lyft.android.ui.splitfare.SearchHelper;

public class ContactsRecyclerViewAdapter
  extends RecyclerView.Adapter<ViewHolder>
  implements Filterable
{
  private static final int ENGLISH_ALPHABET_LENGTH = 26;
  private final ContactSelectionManager contactSelectionManager;
  private final List<UserContact> data = new ArrayList();
  private final Map<String, Integer> sectionIndexMap = new LinkedHashMap(26);
  private String[] sections;
  private int topMargin;
  private UserFilter userFilter;
  
  public ContactsRecyclerViewAdapter(ContactSelectionManager paramContactSelectionManager)
  {
    contactSelectionManager = paramContactSelectionManager;
    setHasStableIds(true);
  }
  
  private static String getCategory(UserContact paramUserContact)
  {
    return getDefaultCategory(paramUserContact.getName());
  }
  
  private String getCategoryForPosition(int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = getSectionForPosition(paramInt);
      return sections[paramInt];
    }
    int i = getSectionForPosition(paramInt - 1);
    paramInt = getSectionForPosition(paramInt);
    String str1 = sections[i];
    String str2 = sections[paramInt];
    if (!str2.equals(str1)) {
      return str2;
    }
    return null;
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
  
  public Filter getFilter()
  {
    return userFilter;
  }
  
  public UserContact getItem(int paramInt)
  {
    return (UserContact)data.get(paramInt);
  }
  
  public int getItemCount()
  {
    return data.size();
  }
  
  public long getItemId(int paramInt)
  {
    return ((UserContact)data.get(paramInt)).hashCode();
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
  
  public void onBindViewHolder(ViewHolder paramViewHolder, int paramInt)
  {
    UserContact localUserContact = (UserContact)data.get(paramInt);
    paramViewHolder.setItemLabels(localUserContact);
    if (contactSelectionManager.isSelected(localUserContact)) {
      checkBox.setChecked(true);
    }
    for (;;)
    {
      paramViewHolder.setCategory(getCategoryForPosition(paramInt));
      if (paramInt != 0) {
        break;
      }
      ((ViewGroup.MarginLayoutParams)itemView.getLayoutParams()).setMargins(0, topMargin, 0, 0);
      return;
      checkBox.setChecked(false);
    }
    ((ViewGroup.MarginLayoutParams)itemView.getLayoutParams()).setMargins(0, 0, 0, 0);
  }
  
  public ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new ViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903129, paramViewGroup, false));
  }
  
  public void onViewRecycled(ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
  }
  
  public void setTopMargin(int paramInt)
  {
    topMargin = paramInt;
  }
  
  public void swapData(List<UserContact> paramList)
  {
    data.clear();
    if (paramList != null)
    {
      data.addAll(paramList);
      initAlphabetIndexer();
      userFilter = new UserFilter(this, paramList, null);
    }
    notifyDataSetChanged();
  }
  
  private static class UserFilter
    extends Filter
  {
    private final ContactsRecyclerViewAdapter adapter;
    private final List<UserContact> filteredList;
    private final List<UserContact> originalList;
    
    private UserFilter(ContactsRecyclerViewAdapter paramContactsRecyclerViewAdapter, List<UserContact> paramList)
    {
      adapter = paramContactsRecyclerViewAdapter;
      originalList = new LinkedList(paramList);
      filteredList = new ArrayList(paramList.size());
    }
    
    protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      filteredList.clear();
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      if (paramCharSequence.length() == 0) {
        filteredList.addAll(originalList);
      }
      for (;;)
      {
        values = filteredList;
        count = filteredList.size();
        return localFilterResults;
        paramCharSequence = paramCharSequence.toString().toLowerCase().trim();
        Iterator localIterator = originalList.iterator();
        while (localIterator.hasNext())
        {
          UserContact localUserContact = (UserContact)localIterator.next();
          if (localUserContact.getName().contains(paramCharSequence)) {
            filteredList.add(localUserContact);
          }
        }
      }
    }
    
    protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      adapter.data.clear();
      adapter.data.addAll((ArrayList)values);
      adapter.notifyDataSetChanged();
    }
  }
  
  public static class ViewHolder
    extends RecyclerView.ViewHolder
  {
    TextView categoryTextView;
    CheckBox checkBox;
    View dividerView;
    TextView inviteNameTextView;
    TextView inviteTextView;
    
    public ViewHolder(View paramView)
    {
      super();
      ButterKnife.bind(this, paramView);
    }
    
    private void setItemLabels(UserContact paramUserContact)
    {
      String str = paramUserContact.getName();
      if (paramUserContact.getPhoneNumber() != null) {}
      for (paramUserContact = paramUserContact.getPhoneNumber(); !Strings.isNullOrEmpty(str); paramUserContact = paramUserContact.getEmail())
      {
        inviteTextView.setVisibility(0);
        inviteTextView.setText(paramUserContact);
        inviteNameTextView.setText(str);
        return;
      }
      inviteTextView.setVisibility(8);
      inviteNameTextView.setText(paramUserContact);
    }
    
    public void setCategory(String paramString)
    {
      if (!Strings.isNullOrEmpty(paramString))
      {
        categoryTextView.setText(paramString);
        categoryTextView.setVisibility(0);
        dividerView.setVisibility(8);
        return;
      }
      categoryTextView.setVisibility(8);
      dividerView.setVisibility(0);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.adapters.ContactsRecyclerViewAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */