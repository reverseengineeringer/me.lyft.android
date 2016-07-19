package me.lyft.android.infrastructure.placesearch;

import java.util.List;
import me.lyft.android.domain.location.Location;
import rx.Observable;

public abstract interface IPlaceSearchService
{
  public abstract Observable<List<Location>> placeSearchFallback(String paramString);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.placesearch.IPlaceSearchService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */