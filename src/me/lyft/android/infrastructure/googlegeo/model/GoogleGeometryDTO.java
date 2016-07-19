package me.lyft.android.infrastructure.googlegeo.model;

import com.google.gson.annotations.SerializedName;

public class GoogleGeometryDTO
{
  @SerializedName("location")
  GoogleLatLngDTO location;
  
  public GoogleLatLngDTO getLocation()
  {
    return location;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googlegeo.model.GoogleGeometryDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */