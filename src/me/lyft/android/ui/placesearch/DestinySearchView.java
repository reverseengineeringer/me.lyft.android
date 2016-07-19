package me.lyft.android.ui.placesearch;

import android.content.Context;
import android.util.AttributeSet;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.ride.IDestinyService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.domain.location.Location;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import rx.Observable;

public class DestinySearchView
  extends PlaceSearchView
{
  @Inject
  AppFlow appFlow;
  private Binder binder;
  private PlaceSearchScreens.DestinySearch destinySearch;
  @Inject
  IDestinyService destinyService;
  private Location driverDestination;
  @Inject
  IPlaceSearchPresenter placeSearchPresenter;
  @Inject
  IProgressController progressController;
  @Inject
  IUserProvider userProvider;
  
  public DestinySearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    destinySearch = ((PlaceSearchScreens.DestinySearch)Screen.fromView(this));
    driverDestination = destinySearch.getDriverDestination();
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
    return driverDestination.getAddress();
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
    binder.bind(destinyService.setDestiny(paramLocation), new DestinySearchView.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.placesearch.DestinySearchView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */