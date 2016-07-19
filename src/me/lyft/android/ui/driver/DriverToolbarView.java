package me.lyft.android.ui.driver;

import android.content.Context;
import android.util.AttributeSet;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.driver.DriverOverflowMenuDisplayManager;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.rx.Binder;
import rx.functions.Action1;

public class DriverToolbarView
  extends Toolbar
{
  private Binder binder;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  DriverOverflowMenuDisplayManager driverOverflowMenuDisplayManager;
  private DriverRide driverRide;
  @Inject
  IDriverRideProvider driverRideProvider;
  private Action1<Integer> onMenuItemClicked = new DriverToolbarView.2(this);
  private Action1<DriverRide> onRouterUpdated = new DriverToolbarView.1(this);
  
  public DriverToolbarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void initToolbar()
  {
    hideHomeIcon();
    addItem(2131558450, 2130838283);
    if (driverOverflowMenuDisplayManager.enableShowOverflowMenu()) {
      showItem(2131558450);
    }
  }
  
  private void updateToolbar()
  {
    if (driverRide.isTrainingRide()) {
      hideDriverModeToggle();
    }
    for (;;)
    {
      updateToolbarLogo();
      return;
      showDriverModeToggle();
    }
  }
  
  private void updateToolbarLogo()
  {
    if (driverRide.isCourier())
    {
      setLogo(2130838110);
      return;
    }
    if (driverRide.isPlus())
    {
      setLogo(2130838118);
      return;
    }
    setLogo(2130838116);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    binder.bind(driverRideProvider.observeRide(), onRouterUpdated);
    binder.bind(observeItemClick(), onMenuItemClicked);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    driverRide = driverRideProvider.getDriverRide();
    initToolbar();
    updateToolbar();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.DriverToolbarView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */