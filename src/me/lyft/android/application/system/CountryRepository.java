package me.lyft.android.application.system;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import me.lyft.android.domain.system.Country;

public class CountryRepository
  implements ICountryRepository
{
  private static final String US_COUNTRY_CODE = "US";
  private ArrayList<Country> countries = new ArrayList();
  private Country usCountry;
  
  public CountryRepository()
  {
    final Collator localCollator = Collator.getInstance();
    localCollator.setStrength(2);
    String[] arrayOfString = Locale.getISOCountries();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      localObject = new Country((String)localObject, new Locale("", (String)localObject).getDisplayCountry(), false);
      countries.add(localObject);
      if ("US".equalsIgnoreCase(((Country)localObject).getCountryCode())) {
        usCountry = ((Country)localObject);
      }
      i += 1;
    }
    Collections.sort(countries, new Comparator()
    {
      public int compare(Country paramAnonymousCountry1, Country paramAnonymousCountry2)
      {
        return localCollator.compare(paramAnonymousCountry1.getCountryName(), paramAnonymousCountry2.getCountryName());
      }
    });
  }
  
  public int getPositionForCountry(String paramString)
  {
    int i = 0;
    while (i < countries.size())
    {
      if (((Country)countries.get(i)).getCountryCode().equals(paramString)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public List<Country> getSupportedCountries()
  {
    return countries;
  }
  
  public int getUsPosition()
  {
    return countries.indexOf(usCountry);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.system.CountryRepository
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */