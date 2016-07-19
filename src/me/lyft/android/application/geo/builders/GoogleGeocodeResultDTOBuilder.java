package me.lyft.android.application.geo.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.lyft.android.infrastructure.googlegeo.model.GoogleAddressComponentDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleGeocodeResultDTO;

public class GoogleGeocodeResultDTOBuilder
{
  private final List<GoogleAddressComponentDTO> addressComponentList;
  private String formattedAddress;
  private List<String> types;
  
  public GoogleGeocodeResultDTOBuilder()
  {
    addressComponentList = new ArrayList();
    types = Collections.emptyList();
  }
  
  private GoogleGeocodeResultDTOBuilder(List<GoogleAddressComponentDTO> paramList, String paramString, List<String> paramList1)
  {
    addressComponentList = paramList;
    formattedAddress = paramString;
    types = paramList1;
  }
  
  public GoogleGeocodeResultDTO build()
  {
    return new GoogleGeocodeResultDTO(addressComponentList, formattedAddress, null, types);
  }
  
  public GoogleGeocodeResultDTOBuilder withComponent(GoogleAddressComponentDTOBuilder paramGoogleAddressComponentDTOBuilder)
  {
    ArrayList localArrayList = new ArrayList(addressComponentList);
    localArrayList.add(paramGoogleAddressComponentDTOBuilder.build());
    return new GoogleGeocodeResultDTOBuilder(localArrayList, formattedAddress, types);
  }
  
  public GoogleGeocodeResultDTOBuilder withFormattedAddress(String paramString)
  {
    return new GoogleGeocodeResultDTOBuilder(addressComponentList, paramString, types);
  }
  
  public GoogleGeocodeResultDTOBuilder withTypes(List<String> paramList)
  {
    return new GoogleGeocodeResultDTOBuilder(addressComponentList, formattedAddress, paramList);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.builders.GoogleGeocodeResultDTOBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */