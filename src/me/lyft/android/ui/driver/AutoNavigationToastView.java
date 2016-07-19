package me.lyft.android.ui.driver;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.rx.CountdownTimer;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.navigation.Navigator;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.dialogs.DialogContainerView;
import me.lyft.android.utils.TextToSpeech;
import rx.functions.Action1;

public class AutoNavigationToastView
  extends DialogContainerView
{
  private static final int AUTO_NAV_TIMEOUT = 3;
  @Inject
  AppFlow appFlow;
  TextView autoNavigateCountdownTextView;
  LinearLayout autoNavigateToast;
  @Inject
  DialogFlow dialogFlow;
  private DriverStop displayedStop;
  @Inject
  Navigator navigator;
  private Action1<DriverRide> onRouteUpdated = new AutoNavigationToastView.3(this);
  @Inject
  IDriverRideProvider routeProvider;
  @Inject
  TextToSpeech textToSpeech;
  
  public AutoNavigationToastView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Binder localBinder = Binder.attach(this);
    ButterKnife.bind(this);
    displayedStop = routeProvider.getDriverRide().getCurrentStop();
    autoNavigateToast.setOnClickListener(new AutoNavigationToastView.1(this));
    localBinder.bind(routeProvider.observeRide(), onRouteUpdated);
    String str = routeProvider.getDriverRide().getCurrentPassenger().getFirstName();
    DriverStop localDriverStop = routeProvider.getDriverRide().getCurrentStop();
    int i;
    if (localDriverStop.isPickup())
    {
      i = 2131166133;
      if (Strings.isNullOrEmpty(str)) {
        break label167;
      }
    }
    label167:
    for (str = getResources().getString(i, new Object[] { str });; str = getResources().getString(2131165920))
    {
      textToSpeech.speak(str);
      localBinder.bind(CountdownTimer.create(1000L, TimeUnit.MILLISECONDS, 3), new AutoNavigationToastView.2(this, localDriverStop));
      return;
      i = 2131165667;
      break;
    }
  }
  
  protected void onClickOutside()
  {
    super.onClickOutside();
    dialogFlow.dismiss();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.AutoNavigationToastView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */