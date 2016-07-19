package me.lyft.android.application.system;

import java.util.List;
import me.lyft.android.domain.system.Country;

public abstract interface ICountryRepository
{
  public abstract int getPositionForCountry(String paramString);
  
  public abstract List<Country> getSupportedCountries();
  
  public abstract int getUsPosition();
}

/* Location:
 * Qualified Name:     me.lyft.android.application.system.ICountryRepository
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */