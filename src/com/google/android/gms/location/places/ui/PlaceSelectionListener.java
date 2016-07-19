package com.google.android.gms.location.places.ui;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;

public abstract interface PlaceSelectionListener
{
  public abstract void onError(Status paramStatus);
  
  public abstract void onPlaceSelected(Place paramPlace);
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.ui.PlaceSelectionListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */