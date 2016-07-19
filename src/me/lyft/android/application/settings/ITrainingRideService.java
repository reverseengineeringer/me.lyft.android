package me.lyft.android.application.settings;

import me.lyft.android.common.Unit;
import me.lyft.android.domain.location.Location;
import rx.Observable;

public abstract interface ITrainingRideService
{
  public abstract Observable<Unit> startTrainingRide(Location paramLocation);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.settings.ITrainingRideService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */