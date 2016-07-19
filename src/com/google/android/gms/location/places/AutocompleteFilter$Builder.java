package com.google.android.gms.location.places;

import java.util.Arrays;

public final class AutocompleteFilter$Builder
{
  private boolean aek = false;
  private int aem = 0;
  
  public AutocompleteFilter build()
  {
    return new AutocompleteFilter(1, false, Arrays.asList(new Integer[] { Integer.valueOf(aem) }));
  }
  
  public Builder setTypeFilter(int paramInt)
  {
    aem = paramInt;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.AutocompleteFilter.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */