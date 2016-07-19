package me.lyft.android.adapters;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import me.lyft.android.domain.contacts.UserContact;

class ContactsRecyclerViewAdapter$UserFilter
  extends Filter
{
  private final ContactsRecyclerViewAdapter adapter;
  private final List<UserContact> filteredList;
  private final List<UserContact> originalList;
  
  private ContactsRecyclerViewAdapter$UserFilter(ContactsRecyclerViewAdapter paramContactsRecyclerViewAdapter, List<UserContact> paramList)
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
    ContactsRecyclerViewAdapter.access$200(adapter).clear();
    ContactsRecyclerViewAdapter.access$200(adapter).addAll((ArrayList)values);
    adapter.notifyDataSetChanged();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.adapters.ContactsRecyclerViewAdapter.UserFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */