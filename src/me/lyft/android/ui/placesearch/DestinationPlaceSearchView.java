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
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType.Feature;
import rx.Observable;

public class DestinationPlaceSearchView
  extends PlaceSearchView
{
  @Inject
  AppFlow appFlow;
  @Inject
  IPlaceSearchPresenter placeSearchPresenter;
  @Inject
  IRideRequestSession rideRequestSession;
  final PlaceSearchScreens.DestinationPlaceSearch screen;
  
  public DestinationPlaceSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    screen = ((PlaceSearchScreens.DestinationPlaceSearch)Screen.fromView(this));
  }
  
  protected int getHintId()
  {
    return 2131166138;
  }
  
  protected Observable<List<IPlaceItemViewModel>> getInitialPlaces()
  {
    if ((rideRequestSession.getCurrentRideType().hasFeature(RequestRideType.Feature.DESTINATION_REQUIRED)) || (rideRequestSession.getDropoffLocation().isNull())) {
      return placeSearchPresenter.observeUserDropoffPlacesSuggestions();
    }
    return placeSearchPresenter.observeUserDropoffPlacesSuggestionsRemoveEnabled();
  }
  
  protected String getInitialQuery()
  {
    return rideRequestSession.getDropoffLocation().getDisplayName();
  }
  
  protected String getSourceForAnalytics()
  {
    return "destination";
  }
  
  protected void onPlaceSelected(Location paramLocation)
  {
    rideRequestSession.setForceDestination(false);
    rideRequestSession.setDropoffLocation(paramLocation);
    rideRequestSession.setRequestRideStep(screen.getNextRequestRideStep());
    appFlow.goBack();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.placesearch.DestinationPlaceSearchView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */