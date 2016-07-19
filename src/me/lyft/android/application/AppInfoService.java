package me.lyft.android.application;

import com.lyft.android.api.dto.AppInfoDTO;
import com.lyft.android.api.dto.RideTypeMetaDTO;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.core.CallAnalytics;
import me.lyft.android.analytics.core.SpanningAnalytics;
import me.lyft.android.analytics.core.events.CallEvent.Call;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.constants.Priority;
import me.lyft.android.application.tooltip.ITooltipService;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.location.Location;
import me.lyft.android.infrastructure.assets.IAssetPackagingService;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class AppInfoService
  implements IAppInfoService
{
  private static final long LOAD_APP_INFO_TIMEOUT_MILLISECONDS = 4000L;
  private AppInfoDTO appInfo;
  private final IAssetPackagingService assetPackagingService;
  private final IConstantsProvider constantsProvider;
  private final ILocationService locationService;
  private final ILyftApi lyftApi;
  private final ILyftPreferences preferences;
  private final ITooltipService tooltipService;
  
  public AppInfoService(ILocationService paramILocationService, ILyftApi paramILyftApi, IConstantsProvider paramIConstantsProvider, ITooltipService paramITooltipService, IAssetPackagingService paramIAssetPackagingService, ILyftPreferences paramILyftPreferences)
  {
    locationService = paramILocationService;
    lyftApi = paramILyftApi;
    constantsProvider = paramIConstantsProvider;
    tooltipService = paramITooltipService;
    assetPackagingService = paramIAssetPackagingService;
    preferences = paramILyftPreferences;
    appInfo = paramILyftPreferences.getAppInfo();
    if (appInfo != null) {
      paramIConstantsProvider.update(appInfo.constants, Priority.PRIMARY);
    }
  }
  
  private void updateApiBaseUrlIfChanged()
  {
    String str = (String)constantsProvider.get(Constants.API_BASE_URL, preferences.getApiRoot());
    if (!str.equals(lyftApi.getApiRoot()))
    {
      lyftApi.setApiRoot(str);
      ((CallAnalytics)new CallAnalytics(CallEvent.Call.API_SWITCH_BASE_URL).setParameter(str).trackInitiation()).trackSuccess();
    }
  }
  
  public String getAppInfoRevision()
  {
    if ((appInfo != null) && (appInfo.revision != null)) {
      return appInfo.revision;
    }
    return "";
  }
  
  public RideTypeMetaDTO getRideTypeMetaById(String paramString)
  {
    Iterator localIterator = getRideTypeMetas().iterator();
    while (localIterator.hasNext())
    {
      RideTypeMetaDTO localRideTypeMetaDTO = (RideTypeMetaDTO)localIterator.next();
      if (Objects.equals(paramString, publicId)) {
        return localRideTypeMetaDTO;
      }
    }
    return null;
  }
  
  public List<RideTypeMetaDTO> getRideTypeMetas()
  {
    if ((appInfo != null) && (appInfo.rideTypes != null)) {
      return appInfo.rideTypes;
    }
    return Collections.emptyList();
  }
  
  public Observable<Unit> loadAppInfo(final String paramString)
  {
    locationService.getLastLocation().flatMap(new Func1()
    {
      public Observable<AppInfoDTO> call(Location paramAnonymousLocation)
      {
        return lyftApi.getAppInfo(paramAnonymousLocation.getLat(), paramAnonymousLocation.getLng(), paramString);
      }
    }).timeout(4000L, TimeUnit.MILLISECONDS).doOnNext(new Action1()
    {
      public void call(AppInfoDTO paramAnonymousAppInfoDTO)
      {
        updateAppInfo(paramAnonymousAppInfoDTO);
        preferences.setInstallReferrer(null);
      }
    }).map(Unit.func1());
  }
  
  public void updateAppInfo(AppInfoDTO paramAppInfoDTO)
  {
    appInfo = paramAppInfoDTO;
    preferences.setAppInfo(paramAppInfoDTO);
    constantsProvider.update(constants, Priority.PRIMARY);
    tooltipService.updateTooltips(hints);
    updateApiBaseUrlIfChanged();
    paramAppInfoDTO = (String)Objects.firstNonNull(assetsUrl, "");
    assetPackagingService.downloadAssetsIfChanged(paramAppInfoDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.AppInfoService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */