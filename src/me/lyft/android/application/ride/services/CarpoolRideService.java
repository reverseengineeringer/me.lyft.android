package me.lyft.android.application.ride.services;

import com.lyft.android.api.dto.CarpoolRideDeclineRequestDTOBuilder;
import com.lyft.android.api.dto.CarpoolRidesResponseDTO;
import com.lyft.android.api.dto.RideUpdateRequestDTOBuilder;
import com.lyft.android.api.dto.UniversalDTO;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.studies.DriverAcceptAnalytics;
import me.lyft.android.common.DeviceClock;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.driver.carpool.CarpoolRidesMapper;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.domain.lyft.LyftValidationError;
import me.lyft.android.domain.ride.CancellationOption;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.lyft.LyftApiException;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class CarpoolRideService
  implements ICarpoolRideService
{
  private static final String ERROR_REASON_EXPIRED_REQUEST = "expiredRequest";
  private List<DriverRide> cachedRides;
  private final ILocationService locationService;
  private final ILyftApi lyftApi;
  
  public CarpoolRideService(ILyftApi paramILyftApi, ILocationService paramILocationService)
  {
    lyftApi = paramILyftApi;
    locationService = paramILocationService;
  }
  
  private Observable<Unit> changeRideStatus(final String paramString1, final String paramString2)
  {
    locationService.getLastLocation().flatMap(new Func1()
    {
      public Observable<UniversalDTO> call(Location paramAnonymousLocation)
      {
        return lyftApi.updateRide(paramString2, new RideUpdateRequestDTOBuilder().withStatus(paramString1).withActionTimestampMs(Long.valueOf(DeviceClock.getCurrentTimeMs())).withLocation(LocationMapper.toLocationDTO(paramAnonymousLocation)).build());
      }
    }).map(Unit.func1()).first();
  }
  
  private List<DriverRide> parseAndCacheResponse(CarpoolRidesResponseDTO paramCarpoolRidesResponseDTO, String paramString)
  {
    cachedRides = CarpoolRidesMapper.fromCarpoolRidesResponse(paramCarpoolRidesResponseDTO, paramString);
    return cachedRides;
  }
  
  private static Throwable parseThrowable(Throwable paramThrowable)
  {
    Object localObject = paramThrowable;
    if ((paramThrowable instanceof LyftApiException))
    {
      Iterator localIterator = ((LyftApiException)paramThrowable).getValidationErrors().iterator();
      do
      {
        localObject = paramThrowable;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (LyftValidationError)localIterator.next();
      } while (!Strings.equalsIgnoreCase("expiredRequest", ((LyftValidationError)localObject).getReason()));
      localObject = new ExpiredCarpoolRequestException(((LyftValidationError)localObject).getMessage());
    }
    return (Throwable)localObject;
  }
  
  public Observable<Unit> acceptRide(String paramString)
  {
    final ActionAnalytics localActionAnalytics = DriverAcceptAnalytics.initiateRideAcceptedAction();
    changeRideStatus("acknowledged", paramString).doOnNext(new Action1()
    {
      public void call(Unit paramAnonymousUnit)
      {
        localActionAnalytics.trackSuccess();
      }
    }).onErrorResumeNext(new Func1()
    {
      public Observable<? extends Unit> call(Throwable paramAnonymousThrowable)
      {
        localActionAnalytics.trackFailure(paramAnonymousThrowable);
        return Observable.error(CarpoolRideService.parseThrowable(paramAnonymousThrowable));
      }
    });
  }
  
  public void clearRides()
  {
    cachedRides = null;
  }
  
  public Observable<Unit> declineRides(final List<String> paramList, final CancellationOption paramCancellationOption)
  {
    locationService.getLastLocation().flatMap(new Func1()
    {
      public Observable<UniversalDTO> call(Location paramAnonymousLocation)
      {
        paramAnonymousLocation = new CarpoolRideDeclineRequestDTOBuilder().withIds(paramList).withReason(paramCancellationOption.getId()).withLat(Double.valueOf(paramAnonymousLocation.getLat())).withLng(Double.valueOf(paramAnonymousLocation.getLng())).build();
        return lyftApi.declineCarpoolRides(paramAnonymousLocation);
      }
    }).map(Unit.func1());
  }
  
  public Observable<List<DriverRide>> fetchCarpoolRides(final String paramString)
  {
    List localList = cachedRides;
    if (localList != null) {
      return Observable.just(localList);
    }
    lyftApi.getCarpoolRides().map(new Func1()
    {
      public List<DriverRide> call(CarpoolRidesResponseDTO paramAnonymousCarpoolRidesResponseDTO)
      {
        return CarpoolRideService.this.parseAndCacheResponse(paramAnonymousCarpoolRidesResponseDTO, paramString);
      }
    });
  }
  
  public void updateCarpoolRidesSync(String paramString)
    throws IOException
  {
    parseAndCacheResponse(lyftApi.getCarpoolRidesSync(), paramString);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.services.CarpoolRideService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */