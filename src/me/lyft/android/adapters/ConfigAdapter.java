package me.lyft.android.adapters;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.infrastructure.environment.ConfigDTO;

public class ConfigAdapter
  extends ArrayAdapter<ConfigDTO>
{
  private List<ConfigDTO> configs;
  private List<ConfigDTO> filteredConfigs;
  
  public ConfigAdapter(Context paramContext, int paramInt, List<ConfigDTO> paramList)
  {
    super(paramContext, paramInt, paramList);
    configs = paramList;
    filteredConfigs = paramList;
  }
  
  public int getCount()
  {
    return filteredConfigs.size();
  }
  
  public Filter getFilter()
  {
    new Filter()
    {
      protected Filter.FilterResults performFiltering(CharSequence paramAnonymousCharSequence)
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = configs.iterator();
        while (localIterator.hasNext())
        {
          ConfigDTO localConfigDTO = (ConfigDTO)localIterator.next();
          if (localConfigDTO.getDisplayName().toLowerCase().contains(paramAnonymousCharSequence.toString().toLowerCase())) {
            localArrayList.add(localConfigDTO);
          }
        }
        paramAnonymousCharSequence = new Filter.FilterResults();
        count = localArrayList.size();
        values = localArrayList;
        return paramAnonymousCharSequence;
      }
      
      protected void publishResults(CharSequence paramAnonymousCharSequence, Filter.FilterResults paramAnonymousFilterResults)
      {
        ConfigAdapter.access$102(ConfigAdapter.this, (List)values);
        notifyDataSetChanged();
      }
    };
  }
  
  public ConfigDTO getItem(int paramInt)
  {
    return (ConfigDTO)filteredConfigs.get(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (TextView)super.getView(paramInt, paramView, paramViewGroup);
    paramViewGroup = (ConfigDTO)filteredConfigs.get(paramInt);
    paramView.setText(Html.fromHtml(getContext().getString(2131165557, new Object[] { paramViewGroup.getDisplayName(), paramViewGroup.getUrl() })));
    return paramView;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.adapters.ConfigAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */