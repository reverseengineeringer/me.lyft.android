package me.lyft.android.domain.passenger.ride;

import com.lyft.android.api.dto.RideTypeMetaDTO;
import com.lyft.android.api.dto.TypeInformationDTO;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MatchingStringsMapper
{
  public static Map<String, List<String>> fromRideTypeMetaDTOs(List<RideTypeMetaDTO> paramList)
  {
    HashMap localHashMap = new HashMap();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RideTypeMetaDTO localRideTypeMetaDTO = (RideTypeMetaDTO)paramList.next();
        if ((localRideTypeMetaDTO != null) && (typeInformation != null)) {
          localHashMap.put(publicId, typeInformation.matchingStrings);
        }
      }
    }
    return localHashMap;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.MatchingStringsMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */