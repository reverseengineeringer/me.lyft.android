package me.lyft.android.ui.development;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.Toggle;
import javax.inject.Inject;
import me.lyft.android.application.constants.ILeanplumOverrideService;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.ActivityController;
import me.lyft.android.common.AppFlow;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.development.IDeveloperTools;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.MainActivity;

public class DevelopmentView
  extends LinearLayout
{
  @Inject
  ActivityController activityController;
  @Inject
  AppFlow appFlow;
  @Inject
  IDeveloperTools developerTools;
  Spinner httpLoggingLevelSpinner;
  @Inject
  ILeanplumOverrideService leanplumOverrideService;
  Toggle leanplumOverrideToggle;
  @Inject
  IRideRequestSession rideRequestSession;
  Toolbar toolbar;
  
  public DevelopmentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Binder.attach(this).bind(leanplumOverrideToggle.observeChange(), new DevelopmentView.1(this));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    leanplumOverrideToggle.setChecked(leanplumOverrideService.isLeanplumEnabled());
    toolbar.setTitle(getContext().getString(2131165555));
    httpLoggingLevelSpinner.setSelection(developerTools.getHttpLoggingLevelOrdinal(), false);
  }
  
  public void onLevelSelected(int paramInt)
  {
    developerTools.setHttpLoggingLevel(paramInt);
  }
  
  public void onMenuClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131558923: 
    case 2131558927: 
    default: 
      return;
    case 2131558924: 
      appFlow.goTo(new DevelopmentScreens.DevelopmentInappNotificationScreen());
      return;
    case 2131558925: 
      appFlow.goTo(new DevelopmentScreens.ProxySettingsScreen());
      return;
    case 2131558921: 
      appFlow.goTo(new DevelopmentScreens.FeaturesScreen());
      return;
    case 2131558928: 
      appFlow.goTo(new DevelopmentScreens.TestViewsScreen());
      return;
    case 2131558929: 
      appFlow.goTo(new DevelopmentScreens.DeepLinksScreen());
      return;
    case 2131558930: 
      activityController.finish();
      MainActivity.restartActivity(getContext());
      return;
    case 2131558931: 
      rideRequestSession.clearRideRequest();
      return;
    case 2131558926: 
      httpLoggingLevelSpinner.performClick();
      return;
    }
    paramView = leanplumOverrideToggle;
    if (!leanplumOverrideToggle.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.development.DevelopmentView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */