package me.lyft.android.domain.geo;

import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.Strings;
import me.lyft.android.infrastructure.googlegeo.model.GoogleAddressComponentDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleGeocodeResponseDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleGeocodeResultDTO;

public class AddressMapper
{
  public static final String BICYCLE_ROUTE = "Bicycle Route";
  public static final String ROUTE_TYPE = "route";
  public static final String STREET_NUMBER_TYPE = "street_number";
  
  public static Address fromGoogleGeocodeResult(GoogleGeocodeResponseDTO paramGoogleGeocodeResponseDTO)
  {
    GoogleGeocodeResultDTO localGoogleGeocodeResultDTO = getBestAddress(paramGoogleGeocodeResponseDTO);
    Object localObject1 = null;
    Object localObject2 = null;
    paramGoogleGeocodeResponseDTO = (GoogleGeocodeResponseDTO)localObject2;
    if (localGoogleGeocodeResultDTO != null)
    {
      String str = getShortAddress(addressComponents);
      paramGoogleGeocodeResponseDTO = (GoogleGeocodeResponseDTO)localObject2;
      localObject1 = str;
      if (hasStreetNumber(addressComponents))
      {
        paramGoogleGeocodeResponseDTO = formattedAddress;
        localObject1 = str;
      }
    }
    return new Address((String)localObject1, paramGoogleGeocodeResponseDTO);
  }
  
  private static GoogleGeocodeResultDTO getBestAddress(GoogleGeocodeResponseDTO paramGoogleGeocodeResponseDTO)
  {
    paramGoogleGeocodeResponseDTO = paramGoogleGeocodeResponseDTO.getResults();
    if (paramGoogleGeocodeResponseDTO.isEmpty()) {
      paramGoogleGeocodeResponseDTO = null;
    }
    GoogleGeocodeResultDTO localGoogleGeocodeResultDTO2;
    GoogleGeocodeResultDTO localGoogleGeocodeResultDTO1;
    do
    {
      return paramGoogleGeocodeResponseDTO;
      localGoogleGeocodeResultDTO2 = (GoogleGeocodeResultDTO)paramGoogleGeocodeResponseDTO.get(0);
      if ((!formattedAddress.contains("Bicycle Route")) || (paramGoogleGeocodeResponseDTO.size() <= 1)) {
        break;
      }
      localGoogleGeocodeResultDTO1 = (GoogleGeocodeResultDTO)paramGoogleGeocodeResponseDTO.get(1);
      paramGoogleGeocodeResponseDTO = localGoogleGeocodeResultDTO1;
    } while (hasStreetNumber(addressComponents));
    return localGoogleGeocodeResultDTO2;
  }
  
  private static String getShortAddress(List<GoogleAddressComponentDTO> paramList)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    Iterator localIterator = paramList.iterator();
    paramList = (List<GoogleAddressComponentDTO>)localObject3;
    if (localIterator.hasNext())
    {
      GoogleAddressComponentDTO localGoogleAddressComponentDTO = (GoogleAddressComponentDTO)localIterator.next();
      localObject3 = localObject2;
      Object localObject4 = localObject1;
      if (types != null)
      {
        if (!types.contains("street_number")) {
          break label101;
        }
        localObject4 = shortName;
        localObject3 = localObject2;
      }
      for (;;)
      {
        localObject2 = localObject3;
        localObject1 = localObject4;
        if (!Strings.isNullOrEmpty(paramList)) {
          break;
        }
        paramList = shortName;
        localObject2 = localObject3;
        localObject1 = localObject4;
        break;
        label101:
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (types.contains("route"))
        {
          localObject3 = shortName;
          localObject4 = localObject1;
        }
      }
    }
    localObject3 = paramList;
    if (localObject2 != null)
    {
      localObject3 = paramList;
      if (localObject1 != null) {
        localObject3 = (String)localObject1 + " " + (String)localObject2;
      }
    }
    return (String)localObject3;
  }
  
  private static boolean hasStreetNumber(List<GoogleAddressComponentDTO> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      GoogleAddressComponentDTO localGoogleAddressComponentDTO = (GoogleAddressComponentDTO)paramList.next();
      if ((types != null) && (types.contains("street_number"))) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.geo.AddressMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */