package me.lyft.android.ui.placesearch;

import android.content.Context;
import android.util.AttributeSet;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.ride.IDriverRouteService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.domain.location.Location;
import me.lyft.android.navigation.Navigator;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import rx.Observable;

public class DriverSetDropoffSearchView
  extends PlaceSearchView
{
  @Inject
  AppFlow appFlow;
  private Binder binder;
  @Inject
  IDriverRouteService driverRouteService;
  @Inject
  Navigator navigator;
  private final PlaceSearchScreens.DriverSetDropoffSearch params;
  @Inject
  IPlaceSearchPresenter placeSearchPresenter;
  @Inject
  IProgressController progressController;
  
  public DriverSetDropoffSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((PlaceSearchScreens.DriverSetDropoffSearch)Screen.fromView(this));
  }
  
  protected int getHintId()
  {
    return 2131166138;
  }
  
  protected Observable<List<IPlaceItemViewModel>> getInitialPlaces()
  {
    return placeSearchPresenter.observeDriverDropoffPlacesSuggestions();
  }
  
  protected String getInitialQuery()
  {
    return "";
  }
  
  protected String getSourceForAnalytics()
  {
    return "destination";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
  }
  
  protected void onPlaceSelected(Location paramLocation)
  {
    progressController.showProgress();
    binder.bind(driverRouteService.setDropoff(paramLocation), new DriverSetDropoffSearchView.1(this, paramLocation));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.placesearch.DriverSetDropoffSearchView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */