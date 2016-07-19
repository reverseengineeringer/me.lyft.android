package me.lyft.android.application.ride;

import com.lyft.android.api.dto.ScheduledRideAvailableTimesResponseDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import me.lyft.android.common.DeviceClock;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.NullLocation;
import me.lyft.android.domain.lyft.LyftError;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.domain.ride.ScheduledInterval;
import me.lyft.android.domain.ride.ScheduledIntervalMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.lyft.LyftApiException;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class ScheduledRideTimesService
  implements IScheduledRideTimesService
{
  static final long CACHE_TIMEOUT = TimeUnit.MINUTES.toMillis(2L);
  static final String INACTIVE_CARPOOL_ROUTE_ERROR_CODE = "inactive_chauffeur_route";
  static final String INACTIVE_CARPOOL_ROUTE_LINE_ERROR_CODE = "inactive_chauffeur_route_line";
  private static final Func1<Throwable, Observable<? extends List<ScheduledInterval>>> MAP_TO_ERROR = new Func1()
  {
    public Observable<? extends List<ScheduledInterval>> call(Throwable paramAnonymousThrowable)
    {
      if (!(paramAnonymousThrowable instanceof LyftApiException)) {
        return Observable.error(paramAnonymousThrowable);
      }
      Object localObject = ((LyftApiException)paramAnonymousThrowable).getLyftError();
      String str = ((LyftError)localObject).getErrorCode();
      localObject = ((LyftError)localObject).getErrorDescription();
      if (Objects.equals(str, "inactive_chauffeur_route")) {
        return Observable.error(new InactiveCarpoolRouteException(str, (String)localObject));
      }
      if (Objects.equals(str, "inactive_chauffeur_route_line")) {
        return Observable.error(new InactiveCarpoolRouteLineFallbackException(str, (String)localObject));
      }
      return Observable.error(paramAnonymousThrowable);
    }
  };
  private static final Func1<ScheduledRideAvailableTimesResponseDTO, List<ScheduledInterval>> MAP_TO_SCHEDULED_INTERVAL = new Func1()
  {
    public List<ScheduledInterval> call(ScheduledRideAvailableTimesResponseDTO paramAnonymousScheduledRideAvailableTimesResponseDTO)
    {
      return ScheduledIntervalMapper.fromScheduledRideAvailableTimesResponseDTO(paramAnonymousScheduledRideAvailableTimesResponseDTO);
    }
  };
  private final ILyftApi api;
  private Location destinationLocation = Location.empty();
  private final List<ScheduledInterval> intervals = new ArrayList();
  private Location pickupLocation = Location.empty();
  private RequestRideType requestRideType = RequestRideType.empty();
  private long timestamp = Long.MAX_VALUE;
  
  public ScheduledRideTimesService(ILyftApi paramILyftApi)
  {
    api = paramILyftApi;
  }
  
  /* Error */
  private boolean isCacheValid(RequestRideType paramRequestRideType, Location paramLocation1, Location paramLocation2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 106	me/lyft/android/common/DeviceClock:getCurrentTimeMs	()J
    //   5: aload_0
    //   6: getfield 85	me/lyft/android/application/ride/ScheduledRideTimesService:timestamp	J
    //   9: lsub
    //   10: getstatic 53	me/lyft/android/application/ride/ScheduledRideTimesService:CACHE_TIMEOUT	J
    //   13: lcmp
    //   14: ifgt +54 -> 68
    //   17: aload_1
    //   18: invokevirtual 110	me/lyft/android/domain/passenger/ridetypes/RequestRideType:getPublicId	()Ljava/lang/String;
    //   21: aload_0
    //   22: getfield 81	me/lyft/android/application/ride/ScheduledRideTimesService:requestRideType	Lme/lyft/android/domain/passenger/ridetypes/RequestRideType;
    //   25: invokevirtual 110	me/lyft/android/domain/passenger/ridetypes/RequestRideType:getPublicId	()Ljava/lang/String;
    //   28: invokestatic 116	me/lyft/android/common/Strings:equalsIgnoreCase	(Ljava/lang/String;Ljava/lang/String;)Z
    //   31: ifeq +37 -> 68
    //   34: aload_2
    //   35: aload_0
    //   36: getfield 72	me/lyft/android/application/ride/ScheduledRideTimesService:pickupLocation	Lme/lyft/android/domain/location/Location;
    //   39: invokevirtual 120	me/lyft/android/domain/location/Location:hasSameCoordinates	(Lme/lyft/android/domain/location/LatLng;)Z
    //   42: ifeq +26 -> 68
    //   45: aload_3
    //   46: aload_0
    //   47: getfield 74	me/lyft/android/application/ride/ScheduledRideTimesService:destinationLocation	Lme/lyft/android/domain/location/Location;
    //   50: invokevirtual 120	me/lyft/android/domain/location/Location:hasSameCoordinates	(Lme/lyft/android/domain/location/LatLng;)Z
    //   53: istore 4
    //   55: iload 4
    //   57: ifeq +11 -> 68
    //   60: iconst_1
    //   61: istore 4
    //   63: aload_0
    //   64: monitorexit
    //   65: iload 4
    //   67: ireturn
    //   68: iconst_0
    //   69: istore 4
    //   71: goto -8 -> 63
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	ScheduledRideTimesService
    //   0	79	1	paramRequestRideType	RequestRideType
    //   0	79	2	paramLocation1	Location
    //   0	79	3	paramLocation2	Location
    //   53	17	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	55	74	finally
  }
  
  private void updateAvailableTimes(RequestRideType paramRequestRideType, Location paramLocation1, Location paramLocation2, List<ScheduledInterval> paramList)
  {
    try
    {
      pickupLocation = ((Location)Objects.firstNonNull(paramLocation1, NullLocation.getInstance()));
      destinationLocation = ((Location)Objects.firstNonNull(paramLocation2, NullLocation.getInstance()));
      requestRideType = ((RequestRideType)Objects.firstNonNull(paramRequestRideType, RequestRideType.empty()));
      timestamp = DeviceClock.getCurrentTimeMs();
      intervals.clear();
      intervals.addAll(paramList);
      return;
    }
    finally
    {
      paramRequestRideType = finally;
      throw paramRequestRideType;
    }
  }
  
  public Observable<List<ScheduledInterval>> fetchForLocations(final RequestRideType paramRequestRideType, final Location paramLocation1, final Location paramLocation2)
  {
    String str = paramRequestRideType.getPublicId();
    double d1 = paramLocation1.getLat();
    double d2 = paramLocation1.getLng();
    Double localDouble1;
    if (paramLocation2.isNull())
    {
      localDouble1 = null;
      if (!paramLocation2.isNull()) {
        break label80;
      }
    }
    label80:
    for (Double localDouble2 = null;; localDouble2 = Double.valueOf(paramLocation2.getLng()))
    {
      if ((intervals.isEmpty()) || (!isCacheValid(paramRequestRideType, paramLocation1, paramLocation2))) {
        break label92;
      }
      return Observable.just(intervals);
      localDouble1 = Double.valueOf(paramLocation2.getLat());
      break;
    }
    label92:
    api.getScheduledRidesAvailability(str, d1, d2, localDouble1, localDouble2).map(MAP_TO_SCHEDULED_INTERVAL).doOnNext(new Action1()
    {
      public void call(List<ScheduledInterval> paramAnonymousList)
      {
        ScheduledRideTimesService.this.updateAvailableTimes(paramRequestRideType, paramLocation1, paramLocation2, paramAnonymousList);
      }
    }).onErrorResumeNext(MAP_TO_ERROR);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.ScheduledRideTimesService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */