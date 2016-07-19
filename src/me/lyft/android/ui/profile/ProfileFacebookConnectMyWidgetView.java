package me.lyft.android.ui.profile;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.profile.IProfileService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.profile.Profile;
import me.lyft.android.infrastructure.facebook.FacebookLoginResult;
import me.lyft.android.infrastructure.facebook.IFacebookLoginService;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IViewErrorHandler;

public class ProfileFacebookConnectMyWidgetView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  private RxUIBinder binder = new RxUIBinder();
  @Inject
  IFacebookLoginService facebookService;
  LinearLayout profileFbConnect;
  LinearLayout profileFbSettings;
  TextView profileFriendsTitleTextView;
  @Inject
  IProfileService profileService;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  public ProfileFacebookConnectMyWidgetView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    setOrientation(1);
    Scoop.fromView(this).inflater(paramContext).inflate(2130903407, this, true);
  }
  
  private void refreshFacebookToken(FacebookLoginResult paramFacebookLoginResult)
  {
    binder.bindAsyncCall(profileService.refreshFacebookToken(accessToken), new ProfileFacebookConnectMyWidgetView.4(this));
  }
  
  private void showFacebookConnect()
  {
    profileFbSettings.setVisibility(8);
    profileFriendsTitleTextView.setVisibility(0);
    profileFbConnect.setVisibility(0);
  }
  
  private void showFacebookSettings()
  {
    boolean bool = profileService.getMyProfile().isCanShowMutualFriends();
    profileFbConnect.setVisibility(8);
    Resources localResources = getResources();
    if (bool) {}
    for (int i = 2131165676;; i = 2131165561)
    {
      String str = localResources.getString(i).toUpperCase();
      profileFriendsTitleTextView.setText(Strings.joinWithDelimiter(" ", new String[] { localResources.getString(2131166178), str }));
      profileFriendsTitleTextView.setVisibility(0);
      profileFbSettings.setVisibility(0);
      return;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder.attach();
    profileFbConnect.setOnClickListener(new ProfileFacebookConnectMyWidgetView.1(this));
    profileFbSettings.setOnClickListener(new ProfileFacebookConnectMyWidgetView.2(this));
    if (profileService.shouldRequestProfileV1FacebookPermissions()) {
      showFacebookConnect();
    }
    for (;;)
    {
      facebookService.start();
      binder.bindAction(facebookService.observeLogin(), new ProfileFacebookConnectMyWidgetView.3(this));
      return;
      showFacebookSettings();
    }
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
 * Qualified Name:     me.lyft.android.ui.profile.ProfileFacebookConnectMyWidgetView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */