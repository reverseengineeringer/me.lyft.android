package me.lyft.android.application.topdestinations;

import java.util.List;
import me.lyft.android.domain.location.Location;
import rx.Observable;

public abstract interface ITopDestinationsService
{
  public abstract Observable<List<Location>> observeTopDestinations(Location paramLocation);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.topdestinations.ITopDestinationsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */