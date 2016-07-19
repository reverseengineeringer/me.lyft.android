package com.google.android.gms.location.places;

import android.text.style.CharacterStyle;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

public abstract interface AutocompletePrediction
  extends Freezable<AutocompletePrediction>
{
  public abstract CharSequence getFullText(CharacterStyle paramCharacterStyle);
  
  public abstract String getPlaceId();
  
  public abstract List<Integer> getPlaceTypes();
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.AutocompletePrediction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */