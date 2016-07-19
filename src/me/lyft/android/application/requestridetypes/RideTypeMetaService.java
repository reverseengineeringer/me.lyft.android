package me.lyft.android.application.requestridetypes;

import com.jakewharton.rxrelay.BehaviorRelay;
import com.lyft.android.api.dto.BannerDTO;
import com.lyft.android.api.dto.RideTypeMetaDTO;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import me.lyft.android.application.IAppInfoService;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.passenger.ride.MatchingStringsMapper;
import me.lyft.android.domain.passenger.ridetypes.Actions;
import me.lyft.android.domain.passenger.ridetypes.Popup;
import me.lyft.android.domain.passenger.ridetypes.RideTypeBanner;
import me.lyft.android.domain.passenger.ridetypes.RideTypeBannerMapper;
import me.lyft.android.domain.passenger.ridetypes.RideTypeMetaMapper;
import me.lyft.android.domain.passenger.ridetypes.Style;
import me.lyft.android.domain.passenger.ridetypes.TypeInformation;
import me.lyft.android.domain.ride.RideType;
import rx.Observable;

public class RideTypeMetaService
  implements IRideTypeMetaService
{
  public static final String DEFAULT_BANNER_LABEL = "default";
  private final IAppInfoService appInfoService;
  private BehaviorRelay<Map<String, RideTypeBanner>> bannersRelay = BehaviorRelay.create(Collections.emptyMap());
  private Map<String, List<String>> matchingStringsByType = Collections.emptyMap();
  
  public RideTypeMetaService(IAppInfoService paramIAppInfoService)
  {
    appInfoService = paramIAppInfoService;
  }
  
  public RideTypeBanner findBannerByRideType(String paramString)
  {
    Map localMap = (Map)bannersRelay.getValue();
    return (RideTypeBanner)Objects.firstNonNull(new RideTypeBanner[] { (RideTypeBanner)localMap.get(paramString), (RideTypeBanner)localMap.get("default"), RideTypeBanner.empty() });
  }
  
  public List<String> findMatchingStringsByRideType(RideType paramRideType)
  {
    return (List)Objects.firstNonNull(matchingStringsByType.get(paramRideType.getType()), Collections.emptyList());
  }
  
  public Actions getActionsForRideType(String paramString)
  {
    return RideTypeMetaMapper.actionsFromDTO(appInfoService.getRideTypeMetaById(paramString));
  }
  
  public int getMaximumContributorsForRideType(String paramString)
  {
    paramString = appInfoService.getRideTypeMetaById(paramString);
    if ((paramString != null) && (maximumContributors != null)) {
      return maximumContributors.intValue();
    }
    return 0;
  }
  
  public Popup getPopupForRideType(String paramString)
  {
    return RideTypeMetaMapper.popupFromDTO(appInfoService.getRideTypeMetaById(paramString));
  }
  
  public Style getStyleForRideType(String paramString)
  {
    return RideTypeMetaMapper.styleFromDTO(appInfoService.getRideTypeMetaById(paramString));
  }
  
  public TypeInformation getTypeInformationForRideType(String paramString)
  {
    return RideTypeMetaMapper.typeInformationFromDTO(appInfoService.getRideTypeMetaById(paramString));
  }
  
  public Observable<Unit> observeBannersChanged()
  {
    return bannersRelay.asObservable().map(Unit.func1());
  }
  
  public void updateBanners(List<BannerDTO> paramList)
  {
    paramList = RideTypeBannerMapper.fromBannerDTOs(paramList);
    bannersRelay.call(paramList);
  }
  
  public void updateMatchingStrings(List<RideTypeMetaDTO> paramList)
  {
    matchingStringsByType = MatchingStringsMapper.fromRideTypeMetaDTOs(paramList);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.requestridetypes.RideTypeMetaService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */