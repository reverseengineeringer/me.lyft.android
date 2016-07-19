package me.lyft.android.domain.geo;

import java.util.Iterator;
import java.util.List;
import me.lyft.android.infrastructure.googlegeo.model.GoogleAddressComponentDTO;

public class CityMapper
{
  public static City fromGoogleAddressComponentsDTO(List<GoogleAddressComponentDTO> paramList)
  {
    Object localObject2 = "";
    Object localObject1 = "";
    Iterator localIterator = paramList.iterator();
    paramList = (List<GoogleAddressComponentDTO>)localObject2;
    while (localIterator.hasNext())
    {
      GoogleAddressComponentDTO localGoogleAddressComponentDTO = (GoogleAddressComponentDTO)localIterator.next();
      if (types != null)
      {
        localObject2 = localObject1;
        if (types.contains("administrative_area_level_1")) {
          localObject2 = shortName;
        }
        localObject1 = localObject2;
        if (types.contains("locality"))
        {
          paramList = shortName;
          localObject1 = localObject2;
        }
      }
    }
    return new City(paramList, (String)localObject1);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.geo.CityMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */