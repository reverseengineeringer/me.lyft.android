package me.lyft.android.ui.placesearch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.Scoop;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.PlaceSearchAnalytics;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.location.Location;
import me.lyft.android.rx.Binder;
import rx.Observable;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public abstract class PlaceSearchView
  extends LinearLayout
  implements HandleBack
{
  @Inject
  AppFlow appFlow;
  private Binder binder;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  IPlaceSearchPresenter placeSearchPresenter;
  PlaceSearchResultsView resultsView;
  private Subscription suggestionsSubscription = Subscriptions.empty();
  PlaceSearchToolbar toolbar;
  
  public PlaceSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {
      return;
    }
    setOrientation(1);
    Scoop.fromView(this).inflater(paramContext).inflate(2130903386, this, true);
    ButterKnife.bind(this);
  }
  
  private void loadInitialPlaces()
  {
    resultsView.clearPlaces();
    suggestionsSubscription.unsubscribe();
    suggestionsSubscription = binder.bind(getInitialPlaces(), new PlaceSearchView.5(this));
  }
  
  private void onQueryChanged(String paramString)
  {
    if (paramString.length() > 0)
    {
      suggestionsSubscription.unsubscribe();
      suggestionsSubscription = binder.bind(getAutocompletePlaces(paramString), new PlaceSearchView.4(this));
      return;
    }
    loadInitialPlaces();
  }
  
  protected Observable<List<IPlaceItemViewModel>> getAutocompletePlaces(String paramString)
  {
    return placeSearchPresenter.loadAutocompleteSuggestions(paramString);
  }
  
  protected abstract int getHintId();
  
  protected abstract Observable<List<IPlaceItemViewModel>> getInitialPlaces();
  
  protected abstract String getInitialQuery();
  
  protected abstract String getSourceForAnalytics();
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder = Binder.attach(this);
    toolbar.setHintId(getHintId());
    toolbar.setQuery(getInitialQuery());
    if (Strings.isNullOrEmpty(getInitialQuery())) {
      toolbar.showKeyboard();
    }
    loadInitialPlaces();
    binder.bind(toolbar.observeQueryChange(), new PlaceSearchView.1(this));
    binder.bind(toolbar.observeBackButtonTap(), new PlaceSearchView.2(this));
    binder.bind(resultsView.observeSelectedItem(), new PlaceSearchView.3(this));
    PlaceSearchAnalytics.trackSearchPlaces(getSourceForAnalytics());
  }
  
  public boolean onBack()
  {
    PlaceSearchAnalytics.trackCancel();
    return appFlow.goBack();
  }
  
  protected abstract void onPlaceSelected(Location paramLocation);
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.placesearch.PlaceSearchView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */