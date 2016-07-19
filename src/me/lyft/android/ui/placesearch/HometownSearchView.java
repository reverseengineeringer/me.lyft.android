package me.lyft.android.ui.placesearch;

import android.content.Context;
import android.util.AttributeSet;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.common.AddressUtils;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.location.Location;
import me.lyft.android.ui.profile.EditProfileSession;
import me.lyft.android.ui.profile.ProfileScreens.EditProfileScreen;
import rx.Observable;

public class HometownSearchView
  extends PlaceSearchView
{
  @Inject
  AppFlow appFlow;
  private EditProfileSession editProfileSession;
  private final ProfileScreens.EditProfileScreen screenParams;
  
  public HometownSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    screenParams = ((ProfileScreens.EditProfileScreen)Screen.fromView(this));
    editProfileSession = screenParams.getEditProfileSession();
  }
  
  protected Observable<List<IPlaceItemViewModel>> getAutocompletePlaces(String paramString)
  {
    return placeSearchPresenter.loadCityAutocompleteSuggestions(paramString);
  }
  
  protected int getHintId()
  {
    return 2131166160;
  }
  
  protected Observable<List<IPlaceItemViewModel>> getInitialPlaces()
  {
    return Observable.empty();
  }
  
  protected String getInitialQuery()
  {
    return editProfileSession.getHometown();
  }
  
  protected String getSourceForAnalytics()
  {
    return "city";
  }
  
  public String joinTitleSubtitle(String paramString1, String paramString2)
  {
    if (paramString1.equalsIgnoreCase(paramString2)) {
      return paramString1;
    }
    return Strings.joinWithDelimiter(", ", new String[] { paramString1, paramString2 });
  }
  
  protected void onPlaceSelected(Location paramLocation)
  {
    String str = paramLocation.getDisplayName();
    paramLocation = AddressUtils.getStateOrCountry(paramLocation.getRoutableAddress());
    editProfileSession.setHometown(joinTitleSubtitle(str, paramLocation));
    appFlow.goBack();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.placesearch.HometownSearchView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */