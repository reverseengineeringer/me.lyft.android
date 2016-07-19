package me.lyft.android.application.requestridetypes;

import com.lyft.android.api.dto.BannerDTO;
import com.lyft.android.api.dto.RideTypeMetaDTO;
import java.util.List;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.passenger.ridetypes.Actions;
import me.lyft.android.domain.passenger.ridetypes.Popup;
import me.lyft.android.domain.passenger.ridetypes.RideTypeBanner;
import me.lyft.android.domain.passenger.ridetypes.Style;
import me.lyft.android.domain.passenger.ridetypes.TypeInformation;
import me.lyft.android.domain.ride.RideType;
import rx.Observable;

public abstract interface IRideTypeMetaService
{
  public abstract RideTypeBanner findBannerByRideType(String paramString);
  
  public abstract List<String> findMatchingStringsByRideType(RideType paramRideType);
  
  public abstract Actions getActionsForRideType(String paramString);
  
  public abstract int getMaximumContributorsForRideType(String paramString);
  
  public abstract Popup getPopupForRideType(String paramString);
  
  public abstract Style getStyleForRideType(String paramString);
  
  public abstract TypeInformation getTypeInformationForRideType(String paramString);
  
  public abstract Observable<Unit> observeBannersChanged();
  
  public abstract void updateBanners(List<BannerDTO> paramList);
  
  public abstract void updateMatchingStrings(List<RideTypeMetaDTO> paramList);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.requestridetypes.IRideTypeMetaService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */