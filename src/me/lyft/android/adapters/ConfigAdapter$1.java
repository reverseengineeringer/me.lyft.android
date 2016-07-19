package me.lyft.android.adapters;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.infrastructure.environment.ConfigDTO;

class ConfigAdapter$1
  extends Filter
{
  ConfigAdapter$1(ConfigAdapter paramConfigAdapter) {}
  
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ConfigAdapter.access$000(this$0).iterator();
    while (localIterator.hasNext())
    {
      ConfigDTO localConfigDTO = (ConfigDTO)localIterator.next();
      if (localConfigDTO.getDisplayName().toLowerCase().contains(paramCharSequence.toString().toLowerCase())) {
        localArrayList.add(localConfigDTO);
      }
    }
    paramCharSequence = new Filter.FilterResults();
    count = localArrayList.size();
    values = localArrayList;
    return paramCharSequence;
  }
  
  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    ConfigAdapter.access$102(this$0, (List)values);
    this$0.notifyDataSetChanged();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.adapters.ConfigAdapter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */