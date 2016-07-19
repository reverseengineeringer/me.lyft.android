package me.lyft.android.application.eta;

import com.jakewharton.rxrelay.BehaviorRelay;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.application.geo.IEtaAnalyticService;
import me.lyft.android.common.Preconditions;
import me.lyft.android.domain.eta.EtaEstimate;
import me.lyft.android.domain.eta.EtaEstimateMapper;
import me.lyft.android.domain.eta.NullEtaEstimate;
import me.lyft.android.domain.location.Location;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.lyft.LyftApiException;
import rx.Observable;

public class PickupEtaService
  implements IPickupEtaService
{
  private BehaviorRelay<List<EtaEstimate>> estimatesSubject = BehaviorRelay.create();
  private IEtaAnalyticService etaAnalyticService;
  private IPickupEtaFallbackService googleEtaFallbackService;
  private ILyftApi lyftApi;
  
  public PickupEtaService(ILyftApi paramILyftApi, IEtaAnalyticService paramIEtaAnalyticService, IPickupEtaFallbackService paramIPickupEtaFallbackService)
  {
    lyftApi = paramILyftApi;
    etaAnalyticService = paramIEtaAnalyticService;
    googleEtaFallbackService = paramIPickupEtaFallbackService;
  }
  
  private EtaEstimate getEtaEstimate(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    if (estimatesSubject.hasValue()) {
      return getEtaEstimateByRideTypeId((List)estimatesSubject.getValue(), paramString);
    }
    return NullEtaEstimate.create();
  }
  
  private EtaEstimate getEtaEstimateByRideTypeId(List<EtaEstimate> paramList, String paramString)
  {
    Preconditions.checkNotNull(paramString);
    NullEtaEstimate localNullEtaEstimate = NullEtaEstimate.create();
    Iterator localIterator = paramList.iterator();
    do
    {
      paramList = localNullEtaEstimate;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (EtaEstimate)localIterator.next();
    } while (!paramString.equalsIgnoreCase(rideTypeId));
    return paramList;
  }
  
  private void reportEta(List<EtaEstimate> paramList)
  {
    etaAnalyticService.record(paramList);
  }
  
  private void updateAndReportEtas(List<EtaEstimate> paramList, boolean paramBoolean)
  {
    if ((paramList.isEmpty()) && (paramBoolean)) {
      paramList.addAll(googleEtaFallbackService.useGoogleFallback());
    }
    estimatesSubject.call(paramList);
    reportEta(paramList);
  }
  
  public Long getEta(String paramString)
  {
    return getEtaEstimate(paramString).etaInMinutes();
  }
  
  public Observable<List<EtaEstimate>> observeEta()
  {
    return estimatesSubject.asObservable();
  }
  
  public void updateEtas(Location paramLocation)
    throws IOException
  {
    boolean bool = true;
    List localList = Collections.emptyList();
    try
    {
      paramLocation = EtaEstimateMapper.fromEtaResponse(lyftApi.getEtaEstimate(paramLocation.getLat(), paramLocation.getLng()));
      updateAndReportEtas(paramLocation, bool);
      return;
    }
    catch (LyftApiException paramLocation)
    {
      while (paramLocation.getStatusCode() == 400)
      {
        bool = false;
        paramLocation = localList;
      }
      throw paramLocation;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.eta.PickupEtaService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */