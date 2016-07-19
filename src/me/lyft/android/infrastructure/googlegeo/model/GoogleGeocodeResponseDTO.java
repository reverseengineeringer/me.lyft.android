package me.lyft.android.infrastructure.googlegeo.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class GoogleGeocodeResponseDTO
  extends GoogleGeoResponseDTO
{
  @SerializedName("results")
  List<GoogleGeocodeResultDTO> results = new ArrayList();
  @SerializedName("status")
  private String status;
  
  public GoogleGeocodeResponseDTO(String paramString, List<GoogleGeocodeResultDTO> paramList)
  {
    status = paramString;
    results = paramList;
  }
  
  public List<GoogleGeocodeResultDTO> getResults()
  {
    return results;
  }
  
  public String getStatus()
  {
    return status;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googlegeo.model.GoogleGeocodeResponseDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */