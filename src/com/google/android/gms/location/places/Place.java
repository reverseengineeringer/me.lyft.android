package com.google.android.gms.location.places;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public abstract interface Place
  extends Freezable<Place>
{
  public abstract CharSequence getAddress();
  
  public abstract String getId();
  
  public abstract LatLng getLatLng();
  
  public abstract CharSequence getName();
  
  public abstract CharSequence getPhoneNumber();
  
  public abstract List<Integer> getPlaceTypes();
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.Place
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */