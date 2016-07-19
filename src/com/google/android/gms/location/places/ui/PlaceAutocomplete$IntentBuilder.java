package com.google.android.gms.location.places.ui;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;

public class PlaceAutocomplete$IntentBuilder
  extends zza.zza
{
  public PlaceAutocomplete$IntentBuilder(int paramInt)
  {
    super("com.google.android.gms.location.places.ui.AUTOCOMPLETE");
    mIntent.putExtra("gmscore_client_jar_version", GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    mIntent.putExtra("mode", paramInt);
    mIntent.putExtra("origin", 2);
  }
  
  public Intent build(Activity paramActivity)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    return super.build(paramActivity);
  }
  
  public IntentBuilder setBoundsBias(LatLngBounds paramLatLngBounds)
  {
    if (paramLatLngBounds != null)
    {
      mIntent.putExtra("bounds", paramLatLngBounds);
      return this;
    }
    mIntent.removeExtra("bounds");
    return this;
  }
  
  public IntentBuilder setFilter(AutocompleteFilter paramAutocompleteFilter)
  {
    if (paramAutocompleteFilter != null)
    {
      mIntent.putExtra("filter", paramAutocompleteFilter);
      return this;
    }
    mIntent.removeExtra("filter");
    return this;
  }
  
  public IntentBuilder zzkv(String paramString)
  {
    if (paramString != null)
    {
      mIntent.putExtra("initial_query", paramString);
      return this;
    }
    mIntent.removeExtra("initial_query");
    return this;
  }
  
  public IntentBuilder zzuk(int paramInt)
  {
    mIntent.putExtra("origin", paramInt);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.ui.PlaceAutocomplete.IntentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */