package me.lyft.android.ui.placesearch;

import android.content.Context;
import android.util.AttributeSet;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.passenger.IPassengerRideService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import rx.Observable;

public class PassengerSetDropoffSearchView
  extends PlaceSearchView
{
  @Inject
  AppFlow appFlow;
  private Binder binder;
  @Inject
  IPassengerRideProvider passengerRideProvider;
  @Inject
  IPassengerRideService passengerRideService;
  @Inject
  IPlaceSearchPresenter placeSearchPresenter;
  @Inject
  IProgressController progressController;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  public PassengerSetDropoffSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  protected int getHintId()
  {
    return 2131166138;
  }
  
  protected Observable<List<IPlaceItemViewModel>> getInitialPlaces()
  {
    return placeSearchPresenter.observeUserDropoffPlacesSuggestions();
  }
  
  protected String getInitialQuery()
  {
    return passengerRideProvider.getPassengerRide().getDropoff().getDisplayName();
  }
  
  protected String getSourceForAnalytics()
  {
    return "destiny";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
  }
  
  protected void onPlaceSelected(Location paramLocation)
  {
    progressController.showProgress();
    binder.bind(passengerRideService.setDropoff(paramLocation), new PassengerSetDropoffSearchView.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.placesearch.PassengerSetDropoffSearchView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */