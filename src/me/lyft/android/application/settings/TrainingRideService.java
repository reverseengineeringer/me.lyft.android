package me.lyft.android.application.settings;

import com.lyft.android.api.dto.GhostrideRequestDTO;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.location.Location;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;

public class TrainingRideService
  implements ITrainingRideService
{
  private ILyftApi lyftApi;
  
  public TrainingRideService(ILyftApi paramILyftApi)
  {
    lyftApi = paramILyftApi;
  }
  
  public Observable<Unit> startTrainingRide(Location paramLocation)
  {
    return lyftApi.startCouchRide(new GhostrideRequestDTO(Double.valueOf(paramLocation.getLat()), Double.valueOf(paramLocation.getLng()))).map(Unit.func1());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.settings.TrainingRideService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */