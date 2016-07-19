package me.lyft.android.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class SeparatedListAdapter
  extends BaseAdapter
{
  private static final int TYPE_SECTION_HEADER = 0;
  private final ArrayAdapter<String> headers;
  private final Map<String, Adapter> sections = new LinkedHashMap();
  
  public SeparatedListAdapter(Context paramContext)
  {
    headers = new ArrayAdapter(paramContext, 2130903277);
  }
  
  public void addSection(String paramString, Adapter paramAdapter)
  {
    headers.add(paramString);
    sections.put(paramString, paramAdapter);
  }
  
  public int getCount()
  {
    int i = 0;
    Iterator localIterator = sections.values().iterator();
    while (localIterator.hasNext()) {
      i += ((Adapter)localIterator.next()).getCount() + 1;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    Iterator localIterator = sections.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      Adapter localAdapter = (Adapter)sections.get(localObject);
      int i = localAdapter.getCount() + 1;
      if (paramInt == 0) {
        return localObject;
      }
      if (paramInt < i) {
        return localAdapter.getItem(paramInt - 1);
      }
      paramInt -= i;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int j = 1;
    Iterator localIterator = sections.keySet().iterator();
    int i = paramInt;
    paramInt = j;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      localObject = (Adapter)sections.get(localObject);
      j = ((Adapter)localObject).getCount() + 1;
      if (i == 0) {
        return 0;
      }
      if (i < j) {
        return ((Adapter)localObject).getItemViewType(i - 1) + paramInt;
      }
      i -= j;
      paramInt += ((Adapter)localObject).getViewTypeCount();
    }
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    Iterator localIterator = sections.keySet().iterator();
    int i = paramInt;
    paramInt = j;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      localObject = (Adapter)sections.get(localObject);
      j = ((Adapter)localObject).getCount() + 1;
      if (i == 0) {
        return headers.getView(paramInt, paramView, paramViewGroup);
      }
      if (i < j) {
        return ((Adapter)localObject).getView(i - 1, paramView, paramViewGroup);
      }
      i -= j;
      paramInt += 1;
    }
    return null;
  }
  
  public int getViewTypeCount()
  {
    int i = 1;
    Iterator localIterator = sections.values().iterator();
    while (localIterator.hasNext()) {
      i += ((Adapter)localIterator.next()).getViewTypeCount();
    }
    return i;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return getItemViewType(paramInt) != 0;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.adapters.SeparatedListAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */