package me.lyft.android.ui.profile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.profile.IProfileService;
import me.lyft.android.application.profile.IRideProfileService;
import me.lyft.android.domain.profile.Profile;
import me.lyft.android.infrastructure.facebook.FacebookLoginResult;
import me.lyft.android.infrastructure.facebook.IFacebookLoginService;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IViewErrorHandler;

public class ProfileFacebookConnectRideWidgetView
  extends LinearLayout
{
  private RxUIBinder binder = new RxUIBinder();
  @Inject
  IFacebookLoginService facebookService;
  LinearLayout fbConnectContainer;
  private Profile profile;
  LinearLayout profileFbConnect;
  ProfileFriendsWidgetView profileFriendsWidgetView;
  @Inject
  IProfileService profileService;
  @Inject
  IRideProfileService rideProfileService;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  public ProfileFacebookConnectRideWidgetView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    setOrientation(1);
    Scoop.fromView(this).inflater(paramContext).inflate(2130903408, this, true);
  }
  
  private void loadMutualFriends(Profile paramProfile)
  {
    profileFriendsWidgetView.setVisibility(0);
    profileFriendsWidgetView.loadUserFriends(paramProfile.getMutualFriends(), paramProfile.getAdditionalMutualFriendsCount());
  }
  
  private void refreshFacebookToken(FacebookLoginResult paramFacebookLoginResult)
  {
    binder.bindAsyncCall(profileService.refreshFacebookToken(accessToken), new ProfileFacebookConnectRideWidgetView.2(this));
  }
  
  private void showFacebookConnectOrFriends(Profile paramProfile)
  {
    if (profileService.shouldRequestProfileV1FacebookPermissions()) {
      fbConnectContainer.setVisibility(0);
    }
    do
    {
      return;
      fbConnectContainer.setVisibility(8);
    } while (!paramProfile.hasMutualFriends());
    loadMutualFriends(paramProfile);
  }
  
  public void displayProfile(Profile paramProfile)
  {
    profile = paramProfile;
    binder.bindAction(facebookService.observeLogin(), new ProfileFacebookConnectRideWidgetView.3(this));
    if (paramProfile.hasProfileOverride())
    {
      setVisibility(8);
      return;
    }
    showFacebookConnectOrFriends(paramProfile);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder.attach();
    facebookService.start();
    profileFbConnect.setOnClickListener(new ProfileFacebookConnectRideWidgetView.1(this));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    facebookService.stop();
    binder.detach();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.profile.ProfileFacebookConnectRideWidgetView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */