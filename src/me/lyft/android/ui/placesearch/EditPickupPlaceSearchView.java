package me.lyft.android.ui.placesearch;

import android.content.Context;
import android.util.AttributeSet;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.ride.IRideSession;
import me.lyft.android.common.AppFlow;
import me.lyft.android.domain.location.Location;
import rx.Observable;

public class EditPickupPlaceSearchView
  extends PlaceSearchView
{
  @Inject
  AppFlow appFlow;
  @Inject
  IPlaceSearchPresenter placeSearchPresenter;
  @Inject
  IRideSession rideSession;
  
  public EditPickupPlaceSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
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
    return rideSession.getPickupLocation().getDisplayName();
  }
  
  protected String getSourceForAnalytics()
  {
    return "editPickup";
  }
  
  protected void onPlaceSelected(Location paramLocation)
  {
    rideSession.setPickupLocation(paramLocation);
    appFlow.goBack();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.placesearch.EditPickupPlaceSearchView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */