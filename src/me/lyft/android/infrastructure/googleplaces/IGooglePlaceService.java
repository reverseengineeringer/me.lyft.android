package me.lyft.android.infrastructure.googleplaces;

import java.util.List;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.googleplaces.GooglePlace;
import me.lyft.android.domain.location.Location;
import rx.Observable;

public abstract interface IGooglePlaceService
{
  public abstract Observable<List<GooglePlace>> getCurrentPlaces();
  
  public abstract Observable<GooglePlace> getPlaceDetails(String paramString);
  
  public abstract Observable<List<GooglePlacePrediction>> queryPlaces(String paramString, Location paramLocation);
  
  public abstract Observable<List<GooglePlacePrediction>> queryPlaces(String paramString, Location paramLocation, Integer paramInteger);
  
  public abstract Observable<Unit> reportPlace(String paramString1, String paramString2);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googleplaces.IGooglePlaceService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */