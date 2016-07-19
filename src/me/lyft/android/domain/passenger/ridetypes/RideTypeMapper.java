package me.lyft.android.domain.passenger.ridetypes;

import com.lyft.android.api.dto.ActionsDTO;
import com.lyft.android.api.dto.PopupDTO;
import com.lyft.android.api.dto.PricingDetailsDTO;
import com.lyft.android.api.dto.RideTypeDTO;
import com.lyft.android.api.dto.RideTypeMetaDTO;
import com.lyft.android.api.dto.TypeInformationDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.logging.L;

public class RideTypeMapper
{
  private static int extractNumSeats(RideTypeDTO paramRideTypeDTO)
  {
    return ((Integer)Objects.firstNonNull(seats, Integer.valueOf(-1))).intValue();
  }
  
  private static RideTypeMetaDTO findRideTypeMetaByPublicId(List<RideTypeMetaDTO> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RideTypeMetaDTO localRideTypeMetaDTO = (RideTypeMetaDTO)paramList.next();
      if (Objects.equals(publicId, paramString)) {
        return localRideTypeMetaDTO;
      }
    }
    return null;
  }
  
  private static String formattedMoney(Integer paramInteger, String paramString)
  {
    return Money.create(((Integer)Objects.firstNonNull(paramInteger, Integer.valueOf(0))).intValue(), (String)Objects.firstNonNull(paramString, "USD")).format();
  }
  
  private static Pricing fromPricingDetailsDTO(PricingDetailsDTO paramPricingDetailsDTO)
  {
    if (paramPricingDetailsDTO == null) {
      return Pricing.empty();
    }
    String str = currency;
    return new Pricing(Integer.valueOf(0), String.valueOf(Objects.firstNonNull(formattedMoney(cost_minimum, str), "")), String.valueOf(Objects.firstNonNull(formattedMoney(base_charge, str), "")), String.valueOf(Objects.firstNonNull(formattedMoney(cost_per_mile, str), "")), String.valueOf(Objects.firstNonNull(formattedMoney(cost_per_minute, str), "")));
  }
  
  public static RequestRideType fromRideTypeDTO(RideTypeDTO paramRideTypeDTO, RideTypeMetaDTO paramRideTypeMetaDTO)
  {
    return new RequestRideType(ride_type, typeInformation.title, typeInformation.shortTitle, fromPricingDetailsDTO(pricing_details), typeInformation.subtitle, popup.description, typeInformation.glyph, actions.requestColor, actions.requestColor, popup.backgroundColor, typeInformation.image, (String)Objects.firstNonNull(typeInformation.description, typeInformation.subtitle), typeInformation.longDescription, ((Boolean)Objects.firstNonNull(displayNewBadge, Boolean.valueOf(false))).booleanValue(), getShowOnFirstSelection(paramRideTypeMetaDTO), extractNumSeats(paramRideTypeDTO), mapFeatures(features));
  }
  
  public static List<RequestRideType> fromRideTypeV2DTOs(List<RideTypeDTO> paramList, List<RideTypeMetaDTO> paramList1)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RideTypeDTO localRideTypeDTO = (RideTypeDTO)paramList.next();
      RideTypeMetaDTO localRideTypeMetaDTO = findRideTypeMetaByPublicId(paramList1, ride_type);
      if ((localRideTypeMetaDTO == null) || (Strings.isNullOrEmpty(publicId))) {
        L.e("nullPublicIdFound " + localRideTypeMetaDTO, new Object[0]);
      } else {
        localArrayList.add(fromRideTypeDTO(localRideTypeDTO, localRideTypeMetaDTO));
      }
    }
    return localArrayList;
  }
  
  private static boolean getShowOnFirstSelection(RideTypeMetaDTO paramRideTypeMetaDTO)
  {
    if ((popup == null) || (popup.showOnFirstSelection == null)) {
      return false;
    }
    return popup.showOnFirstSelection.booleanValue();
  }
  
  private static List<RequestRideType.Feature> mapFeatures(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramList = Collections.emptyList();
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      paramList = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (String)localIterator.next();
      try
      {
        localArrayList.add(RequestRideType.Feature.valueOf(Strings.toUpperCaseEnglish(paramList)));
      }
      catch (Throwable paramList) {}
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ridetypes.RideTypeMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */