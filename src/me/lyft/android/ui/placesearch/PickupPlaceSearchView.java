package me.lyft.android.ui.placesearch;

import android.content.Context;
import android.util.AttributeSet;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.AppFlow;
import me.lyft.android.domain.location.Location;
import rx.Observable;

public class PickupPlaceSearchView
  extends PlaceSearchView
{
  @Inject
  AppFlow appFlow;
  @Inject
  IPlaceSearchPresenter placeSearchPresenter;
  @Inject
  IRideRequestSession rideRequestSession;
  final PlaceSearchScreens.PickupPlaceSearch screen;
  
  public PickupPlaceSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    screen = ((PlaceSearchScreens.PickupPlaceSearch)Screen.fromView(this));
  }
  
  protected int getHintId()
  {
    return 2131166140;
  }
  
  protected Observable<List<IPlaceItemViewModel>> getInitialPlaces()
  {
    return placeSearchPresenter.observePickupPlacesSuggestions();
  }
  
  protected String getInitialQuery()
  {
    return rideRequestSession.getPickupLocation().getDisplayName();
  }
  
  protected String getSourceForAnalytics()
  {
    return "pickup";
  }
  
  protected void onPlaceSelected(Location paramLocation)
  {
    if (rideRequestSession.hasVenuePickupLocation()) {
      rideRequestSession.resetVenuePickupLocation();
    }
    rideRequestSession.setPickupLocation(paramLocation);
    rideRequestSession.setRequestRideStep(screen.getNextRequestRideStep());
    appFlow.goBack();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.placesearch.PickupPlaceSearchView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */