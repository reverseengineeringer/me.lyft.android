package me.lyft.android.services;

import com.lyft.android.api.dto.HeatmapMetaDTO;
import javax.inject.Inject;
import me.lyft.android.errorhandling.IDefaultErrorHandler;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;
import rx.subscriptions.Subscriptions;

public class HeatMapService
{
  private static final long POLLING_FREQUENCY = 1L;
  private BehaviorSubject<HeatmapMetaDTO> behaviorSubject = BehaviorSubject.create();
  private IDefaultErrorHandler defaultErrorHandler;
  private final ILocationService locationService;
  private final ILyftApi lyftApi;
  private Subscription pollingSubscription = Subscriptions.empty();
  
  @Inject
  public HeatMapService(ILyftApi paramILyftApi, ILocationService paramILocationService, IDefaultErrorHandler paramIDefaultErrorHandler)
  {
    lyftApi = paramILyftApi;
    locationService = paramILocationService;
    defaultErrorHandler = paramIDefaultErrorHandler;
  }
  
  public HeatmapMetaDTO getHeatMapMetaData()
  {
    return (HeatmapMetaDTO)behaviorSubject.getValue();
  }
  
  public Observable<String> observeHeatMapMetaData()
  {
    return behaviorSubject.asObservable().filter(new HeatMapService.2(this)).map(new HeatMapService.1(this));
  }
  
  public void start()
  {
    pollingSubscription.unsubscribe();
    Scheduler.Worker localWorker = Schedulers.io().createWorker();
    pollingSubscription = localWorker;
    localWorker.schedule(new HeatMapService.3(this, localWorker));
  }
  
  public void stop()
  {
    pollingSubscription.unsubscribe();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.HeatMapService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */