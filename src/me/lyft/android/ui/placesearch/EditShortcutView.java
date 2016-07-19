package me.lyft.android.ui.placesearch;

import android.content.Context;
import android.util.AttributeSet;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.shortcuts.IShortcutService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.shortcuts.Shortcut;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import rx.Observable;

public class EditShortcutView
  extends PlaceSearchView
{
  @Inject
  AppFlow appFlow;
  private Binder binder;
  private final PlaceSearchScreens.EditShortcut params;
  @Inject
  IPlaceSearchPresenter placeSearchPresenter;
  @Inject
  IProgressController progressController;
  @Inject
  IShortcutService shortcutService;
  
  public EditShortcutView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((PlaceSearchScreens.EditShortcut)Screen.fromView(this));
  }
  
  protected int getHintId()
  {
    if (params.getShortcut().isHome()) {
      return 2131166139;
    }
    return 2131166141;
  }
  
  protected Observable<List<IPlaceItemViewModel>> getInitialPlaces()
  {
    return placeSearchPresenter.observeShortcutSuggestions();
  }
  
  protected String getInitialQuery()
  {
    return params.getShortcut().getLocation().getDisplayName();
  }
  
  protected String getSourceForAnalytics()
  {
    return "shortcut";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
  }
  
  protected void onPlaceSelected(Location paramLocation)
  {
    progressController.showProgress();
    binder.bind(shortcutService.saveShortcut(params.getShortcut().getType(), paramLocation), new EditShortcutView.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.placesearch.EditShortcutView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */