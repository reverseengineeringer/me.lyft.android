package me.lyft.android.application.eta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import me.lyft.android.application.drivers.INearbyDriversService;
import me.lyft.android.application.geo.GoogleGeoAnalytics;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.drivers.NearbyDriver;
import me.lyft.android.domain.eta.EtaEstimate;
import me.lyft.android.domain.location.Location;
import me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi;
import me.lyft.android.infrastructure.googlegeo.model.DistanceMatrixElementDTO;
import me.lyft.android.infrastructure.googlegeo.model.DistanceMatrixResponseDTO;
import me.lyft.android.infrastructure.googlegeo.model.DistanceMatrixRowDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleDurationDTO;
import me.lyft.android.logging.L;
import rx.functions.Func1;

public class PickupEtaFallbackService
  implements IPickupEtaFallbackService
{
  private GoogleGeoAnalytics googleGeoAnalytics;
  private IGoogleGeoApi googleGeoApi;
  private INearbyDriversService nearbyDriversService;
  private IRideRequestSession rideRequestSession;
  
  public PickupEtaFallbackService(INearbyDriversService paramINearbyDriversService, IRideRequestSession paramIRideRequestSession, IGoogleGeoApi paramIGoogleGeoApi, GoogleGeoAnalytics paramGoogleGeoAnalytics)
  {
    nearbyDriversService = paramINearbyDriversService;
    rideRequestSession = paramIRideRequestSession;
    googleGeoApi = paramIGoogleGeoApi;
    googleGeoAnalytics = paramGoogleGeoAnalytics;
  }
  
  private List<DriverEtaEstimate> createDriverEstimates()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = nearbyDriversService.getDriverRideTypes().iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      Iterator localIterator2 = nearbyDriversService.getDriversForRideType(str).iterator();
      while (localIterator2.hasNext())
      {
        NearbyDriver localNearbyDriver = (NearbyDriver)localIterator2.next();
        DriverEtaEstimate localDriverEtaEstimate2 = findDriverEstimateById(localArrayList, localNearbyDriver.getId());
        DriverEtaEstimate localDriverEtaEstimate1 = localDriverEtaEstimate2;
        if (localDriverEtaEstimate2 == null)
        {
          localDriverEtaEstimate1 = new DriverEtaEstimate(localNearbyDriver.getId(), localNearbyDriver.getLocation().toQueryString());
          localArrayList.add(localDriverEtaEstimate1);
        }
        localDriverEtaEstimate1.addRideType(str);
      }
    }
    return localArrayList;
  }
  
  private DriverEtaEstimate findDriverEstimateById(List<DriverEtaEstimate> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DriverEtaEstimate localDriverEtaEstimate = (DriverEtaEstimate)paramList.next();
      if (localDriverEtaEstimate.getId().equalsIgnoreCase(paramString)) {
        return localDriverEtaEstimate;
      }
    }
    return null;
  }
  
  private void mapDistanceMatrixToDriverEtas(List<DriverEtaEstimate> paramList, DistanceMatrixResponseDTO paramDistanceMatrixResponseDTO)
  {
    if (paramDistanceMatrixResponseDTO != null)
    {
      int i = 0;
      paramDistanceMatrixResponseDTO = rows.iterator();
      while (paramDistanceMatrixResponseDTO.hasNext())
      {
        Object localObject = (DistanceMatrixRowDTO)paramDistanceMatrixResponseDTO.next();
        if (elements.size() > 0)
        {
          localObject = (DistanceMatrixElementDTO)elements.get(0);
          if (((DistanceMatrixElementDTO)localObject).isOk())
          {
            localObject = duration;
            ((DriverEtaEstimate)paramList.get(i)).setEta(value);
          }
        }
        i += 1;
      }
    }
  }
  
  private List<EtaEstimate> mapDriverEtasToEtaEstimates(List<DriverEtaEstimate> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = nearbyDriversService.getDriverRideTypes().iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      Object localObject1 = null;
      Iterator localIterator2 = paramList.iterator();
      while (localIterator2.hasNext())
      {
        Object localObject2 = (DriverEtaEstimate)localIterator2.next();
        if (((DriverEtaEstimate)localObject2).getRideTypes().contains(str))
        {
          localObject2 = ((DriverEtaEstimate)localObject2).getEta();
          if ((localObject2 != null) && ((localObject1 == null) || (((Long)localObject1).longValue() > ((Long)localObject2).longValue()))) {
            localObject1 = localObject2;
          }
        }
      }
      if (localObject1 != null) {
        localArrayList.add(EtaEstimate.create(((Long)localObject1).longValue(), str, false));
      }
    }
    return localArrayList;
  }
  
  public List<EtaEstimate> useGoogleFallback()
  {
    Object localObject1 = Collections.emptyList();
    List localList = createDriverEstimates();
    if (localList.size() < 1) {
      return (List<EtaEstimate>)localObject1;
    }
    Object localObject2 = Strings.joinWithDelimiter("|", Iterables.map(localList, new Func1()
    {
      public String call(DriverEtaEstimate paramAnonymousDriverEtaEstimate)
      {
        return paramAnonymousDriverEtaEstimate.getLocationQuery();
      }
    }));
    Location localLocation = rideRequestSession.getPickupLocation();
    try
    {
      googleGeoAnalytics.etaInitiation();
      localObject2 = googleGeoApi.distancematrixSync((String)localObject2, localLocation.toQueryString());
      if (((DistanceMatrixResponseDTO)localObject2).isOK())
      {
        googleGeoAnalytics.trackEtaSuccess();
        mapDistanceMatrixToDriverEtas(localList, (DistanceMatrixResponseDTO)localObject2);
        localList = mapDriverEtasToEtaEstimates(localList);
        localObject1 = localList;
      }
      else
      {
        googleGeoAnalytics.trackEtaFailure(new RuntimeException("Failed with status: " + ((DistanceMatrixResponseDTO)localObject2).getStatus()));
      }
    }
    catch (Throwable localThrowable)
    {
      googleGeoAnalytics.trackEtaFailure(localThrowable);
      L.w(localThrowable, "google eta fallback request failed", new Object[0]);
    }
    return (List<EtaEstimate>)localObject1;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.eta.PickupEtaFallbackService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */