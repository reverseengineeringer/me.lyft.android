package me.lyft.android.domain.passenger.ridetypes;

import com.lyft.android.api.dto.ActionsDTO;
import com.lyft.android.api.dto.PopupDTO;
import com.lyft.android.api.dto.RideTypeMetaDTO;
import com.lyft.android.api.dto.StyleDTO;
import com.lyft.android.api.dto.TypeInformationDTO;
import me.lyft.android.common.Objects;

public class RideTypeMetaMapper
{
  public static Actions actionsFromDTO(RideTypeMetaDTO paramRideTypeMetaDTO)
  {
    if ((paramRideTypeMetaDTO == null) || (actions == null)) {
      return Actions.empty();
    }
    paramRideTypeMetaDTO = actions;
    return new Actions(pickupLabel, pickupColor, pickupActiveColor, destinationLabel, destinationColor, destinationActiveColor, requestLabel, requestColor, requestActiveColor);
  }
  
  public static Popup popupFromDTO(RideTypeMetaDTO paramRideTypeMetaDTO)
  {
    if ((paramRideTypeMetaDTO == null) || (popup == null)) {
      return Popup.empty();
    }
    paramRideTypeMetaDTO = popup;
    return new Popup(backgroundColor, iconFile, title, seats, description, ((Boolean)Objects.firstNonNull(showOnFirstSelection, Boolean.FALSE)).booleanValue());
  }
  
  public static Style styleFromDTO(RideTypeMetaDTO paramRideTypeMetaDTO)
  {
    if ((paramRideTypeMetaDTO == null) || (style == null)) {
      return Style.empty();
    }
    return new Style(style.primaryColor);
  }
  
  public static TypeInformation typeInformationFromDTO(RideTypeMetaDTO paramRideTypeMetaDTO)
  {
    if ((paramRideTypeMetaDTO == null) || (typeInformation == null)) {
      return TypeInformation.empty();
    }
    paramRideTypeMetaDTO = typeInformation;
    return new TypeInformation(title, subtitle, description, pickupSubtitle, glyph, image, mapMarker);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ridetypes.RideTypeMetaMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */