package me.lyft.android.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import me.lyft.android.domain.system.Country;

public class CountryAdapter
  extends BaseAdapter
  implements SectionIndexer
{
  private static final int ENGLISH_ALPHABET_LENGTH = 26;
  List<Country> countries = new ArrayList();
  private boolean isSpinner;
  LayoutInflater layoutInflater;
  String packageName;
  Resources resources;
  private final Map<String, Integer> sectionIndexMap = new LinkedHashMap(27);
  String[] sections;
  
  public CountryAdapter(Context paramContext, List<Country> paramList, boolean paramBoolean)
  {
    countries = paramList;
    isSpinner = paramBoolean;
    layoutInflater = LayoutInflater.from(paramContext);
    packageName = paramContext.getPackageName();
    resources = paramContext.getResources();
    initAlphabetIndexer();
  }
  
  private String getCategory(Country paramCountry)
  {
    if (paramCountry.isTopCountry()) {
      return "Top Countries";
    }
    return Normalizer.normalize(paramCountry.getCountryName().substring(0, 1), Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
  }
  
  private void initAlphabetIndexer()
  {
    int i = 0;
    while (i < countries.size())
    {
      localObject = getCategory((Country)countries.get(i));
      if (!sectionIndexMap.containsKey(localObject)) {
        sectionIndexMap.put(localObject, Integer.valueOf(i));
      }
      i += 1;
    }
    Object localObject = new ArrayList(sectionIndexMap.keySet());
    sections = new String[((List)localObject).size()];
    ((List)localObject).toArray(sections);
  }
  
  public int getCount()
  {
    return countries.size();
  }
  
  public Object getItem(int paramInt)
  {
    return countries.get(paramInt);
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
    if (countries.size() <= paramInt)
    {
      i = 0;
      return i;
    }
    String str = getCategory((Country)countries.get(paramInt));
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= sections.length) {
        break label68;
      }
      i = paramInt;
      if (sections[paramInt].equals(str)) {
        break;
      }
      paramInt += 1;
    }
    label68:
    return 0;
  }
  
  public Object[] getSections()
  {
    return sections;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i;
    if (paramView == null)
    {
      paramView = layoutInflater;
      if (isSpinner)
      {
        i = 2130903131;
        paramView = paramView.inflate(i, null);
        paramViewGroup = new ViewHolder(paramView);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      localObject = (Country)countries.get(paramInt);
      countryNameView.setText(((Country)localObject).getCountryName());
      i = resources.getIdentifier("country_" + ((Country)localObject).getCountryCode().toLowerCase(), "drawable", packageName);
      flagImageView.setImageResource(i);
      if (!isSpinner)
      {
        if (paramInt != 0) {
          break label175;
        }
        localObject = getCategory((Country)localObject);
        categoryView.setVisibility(0);
        categoryView.setText((CharSequence)localObject);
      }
      return paramView;
      i = 2130903132;
      break;
      paramViewGroup = (ViewHolder)paramView.getTag();
    }
    label175:
    Object localObject = getCategory((Country)localObject);
    if (!((String)localObject).equals(getCategory((Country)countries.get(paramInt - 1))))
    {
      categoryView.setVisibility(0);
      categoryView.setText((CharSequence)localObject);
      return paramView;
    }
    categoryView.setVisibility(8);
    return paramView;
  }
  
  static class ViewHolder
  {
    TextView categoryView;
    TextView countryNameView;
    ImageView flagImageView;
    
    public ViewHolder(View paramView)
    {
      categoryView = ((TextView)paramView.findViewById(2131558862));
      countryNameView = ((TextView)paramView.findViewById(2131558861));
      flagImageView = ((ImageView)paramView.findViewById(2131558860));
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.adapters.CountryAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */