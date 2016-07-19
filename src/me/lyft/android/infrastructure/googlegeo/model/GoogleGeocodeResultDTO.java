package me.lyft.android.infrastructure.googlegeo.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class GoogleGeocodeResultDTO
{
  public static final String ADMINISTRATIVE_AREA_LEVEL_1_TYPE = "administrative_area_level_1";
  public static final String LOCALITY_TYPE = "locality";
  @SerializedName("address_components")
  public final List<GoogleAddressComponentDTO> addressComponents;
  @SerializedName("formatted_address")
  public final String formattedAddress;
  @SerializedName("geometry")
  public final GoogleGeometryDTO geometry;
  @SerializedName("types")
  public final List<String> types;
  
  public GoogleGeocodeResultDTO()
  {
    addressComponents = new ArrayList();
    formattedAddress = "";
    geometry = new GoogleGeometryDTO();
    types = new ArrayList();
  }
  
  public GoogleGeocodeResultDTO(List<GoogleAddressComponentDTO> paramList, String paramString, GoogleGeometryDTO paramGoogleGeometryDTO, List<String> paramList1)
  {
    addressComponents = paramList;
    formattedAddress = paramString;
    geometry = paramGoogleGeometryDTO;
    types = paramList1;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googlegeo.model.GoogleGeocodeResultDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */