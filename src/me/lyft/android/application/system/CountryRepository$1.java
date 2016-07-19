package me.lyft.android.application.system;

import java.text.Collator;
import java.util.Comparator;
import me.lyft.android.domain.system.Country;

class CountryRepository$1
  implements Comparator<Country>
{
  CountryRepository$1(CountryRepository paramCountryRepository, Collator paramCollator) {}
  
  public int compare(Country paramCountry1, Country paramCountry2)
  {
    return val$collator.compare(paramCountry1.getCountryName(), paramCountry2.getCountryName());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.system.CountryRepository.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */