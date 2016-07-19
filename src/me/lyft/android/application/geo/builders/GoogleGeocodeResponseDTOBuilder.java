package me.lyft.android.application.geo.builders;

import java.util.ArrayList;
import java.util.List;
import me.lyft.android.infrastructure.googlegeo.model.GoogleGeocodeResponseDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleGeocodeResultDTO;

public class GoogleGeocodeResponseDTOBuilder
{
  private final List<GoogleGeocodeResultDTO> geocodeResultList;
  
  public GoogleGeocodeResponseDTOBuilder()
  {
    geocodeResultList = new ArrayList();
  }
  
  private GoogleGeocodeResponseDTOBuilder(List<GoogleGeocodeResultDTO> paramList)
  {
    geocodeResultList = paramList;
  }
  
  public GoogleGeocodeResponseDTO build()
  {
    return new GoogleGeocodeResponseDTO("OK", geocodeResultList);
  }
  
  public GoogleGeocodeResponseDTOBuilder withResult(GoogleGeocodeResultDTOBuilder paramGoogleGeocodeResultDTOBuilder)
  {
    ArrayList localArrayList = new ArrayList(geocodeResultList);
    localArrayList.add(paramGoogleGeocodeResultDTOBuilder.build());
    return new GoogleGeocodeResponseDTOBuilder(localArrayList);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.builders.GoogleGeocodeResponseDTOBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */