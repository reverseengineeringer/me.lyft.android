package me.lyft.android.application.requestridetypes;

import com.lyft.android.api.dto.RideTypesResponseDTO;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import me.lyft.android.application.IAppInfoService;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType.Feature;
import me.lyft.android.domain.passenger.ridetypes.RideTypeMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.lyft.LyftApiException;
import me.lyft.android.persistence.ISimpleRepository;
import rx.Observable;
import rx.functions.Func1;

public class RequestRideTypeService
  implements IRequestRideTypeService
{
  private final IAppInfoService appInfoService;
  private final ILyftApi lyftApi;
  private final AtomicBoolean regionUnavailable = new AtomicBoolean(false);
  private final ISimpleRepository<List<RequestRideType>> rideTypesRepository;
  
  public RequestRideTypeService(ILyftApi paramILyftApi, IAppInfoService paramIAppInfoService, ISimpleRepository<List<RequestRideType>> paramISimpleRepository)
  {
    lyftApi = paramILyftApi;
    appInfoService = paramIAppInfoService;
    rideTypesRepository = paramISimpleRepository;
  }
  
  public RequestRideType findRideTypeById(final String paramString)
  {
    (RequestRideType)Iterables.firstOrDefault((Iterable)rideTypesRepository.get(), new Func1()
    {
      public Boolean call(RequestRideType paramAnonymousRequestRideType)
      {
        return Boolean.valueOf(Strings.equalsIgnoreCase(paramAnonymousRequestRideType.getPublicId(), paramString));
      }
    }, getDefaultRideType());
  }
  
  public RequestRideType getDefaultRideType()
  {
    Iterator localIterator = ((List)rideTypesRepository.get()).iterator();
    while (localIterator.hasNext())
    {
      RequestRideType localRequestRideType = (RequestRideType)localIterator.next();
      if (localRequestRideType.hasFeature(RequestRideType.Feature.IS_DISPLAY_DEFAULT)) {
        return localRequestRideType;
      }
    }
    return (RequestRideType)Iterables.firstOrDefault((Iterable)rideTypesRepository.get(), RequestRideType.empty());
  }
  
  public List<RequestRideType> getRideTypes()
  {
    return (List)rideTypesRepository.get();
  }
  
  public boolean hasRideTypes()
  {
    return !((List)rideTypesRepository.get()).isEmpty();
  }
  
  public boolean isRegionUnavailable()
  {
    return regionUnavailable.get();
  }
  
  public Observable<List<RequestRideType>> observeRideTypes()
  {
    return rideTypesRepository.observe();
  }
  
  public void updateRideTypes(Location paramLocation)
    throws IOException
  {
    if (paramLocation.isNull()) {
      return;
    }
    List localList = Collections.emptyList();
    try
    {
      paramLocation = lyftApi.getRideTypes(paramLocation.getLat(), paramLocation.getLng());
      regionUnavailable.set(false);
      paramLocation = RideTypeMapper.fromRideTypeV2DTOs(ride_types, appInfoService.getRideTypeMetas());
      rideTypesRepository.update(paramLocation);
      return;
    }
    catch (LyftApiException paramLocation)
    {
      while (paramLocation.getStatusCode() == 400)
      {
        regionUnavailable.set(true);
        paramLocation = localList;
      }
      throw paramLocation;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.requestridetypes.RequestRideTypeService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */