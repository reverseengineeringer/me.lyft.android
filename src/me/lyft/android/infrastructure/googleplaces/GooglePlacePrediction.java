package me.lyft.android.infrastructure.googleplaces;

import me.lyft.android.common.Strings;
import me.lyft.android.domain.googleplaces.GooglePlaceType;

public class GooglePlacePrediction
{
  private final String description;
  private final String placeId;
  private final GooglePlaceType placeType;
  
  public GooglePlacePrediction(String paramString1, String paramString2, GooglePlaceType paramGooglePlaceType)
  {
    placeId = paramString1;
    description = paramString2;
    placeType = paramGooglePlaceType;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public String getName()
  {
    if (Strings.isNullOrEmpty(description)) {
      return "";
    }
    int i = description.indexOf(',');
    if (i != -1) {
      return description.substring(0, i);
    }
    return description;
  }
  
  public String getPlaceId()
  {
    return placeId;
  }
  
  public GooglePlaceType getPlaceType()
  {
    return placeType;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googleplaces.GooglePlacePrediction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */