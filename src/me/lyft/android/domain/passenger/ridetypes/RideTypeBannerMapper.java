package me.lyft.android.domain.passenger.ridetypes;

import com.lyft.android.api.dto.BannerDTO;
import com.lyft.android.api.dto.BannerItemDTO;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RideTypeBannerMapper
{
  public static Map<String, RideTypeBanner> fromBannerDTOs(List<BannerDTO> paramList)
  {
    HashMap localHashMap = new HashMap();
    if (paramList == null) {}
    for (;;)
    {
      return localHashMap;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BannerDTO localBannerDTO = (BannerDTO)paramList.next();
        RideTypeBanner localRideTypeBanner = fromBannerItemDTO(bannerItem);
        localHashMap.put(rideType, localRideTypeBanner);
      }
    }
  }
  
  public static RideTypeBanner fromBannerItemDTO(BannerItemDTO paramBannerItemDTO)
  {
    if (paramBannerItemDTO == null) {
      return RideTypeBanner.empty();
    }
    return new RideTypeBanner(text, url, deeplink, textColor, bannerColor);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ridetypes.RideTypeBannerMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */