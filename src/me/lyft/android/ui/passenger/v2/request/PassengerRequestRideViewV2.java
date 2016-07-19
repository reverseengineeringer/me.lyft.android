package me.lyft.android.ui.passenger.v2.request;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.domain.passenger.ride.PassengerRideRequest.RequestRideStep;
import me.lyft.android.ui.MainScreens.PassengerRideScreen;
import me.lyft.android.ui.passenger.v2.request.confirm.ConfirmModule;
import me.lyft.android.ui.passenger.v2.request.destination.SetDestinationModule;
import me.lyft.android.ui.passenger.v2.request.pickup.SetPickupModule;
import me.lyft.android.ui.passenger.v2.request.time.SetTimeModule;
import me.lyft.android.ui.passenger.v2.request.venue.VenueModule;
import me.lyft.android.ui.passenger.v2.request.widgets.WidgetModule;

public class PassengerRequestRideViewV2
  extends FrameLayout
  implements HandleBack, PassengerRequestRidePresenterV2.RequestRideViewV2
{
  @Inject
  PassengerRequestRidePresenterV2 passengerRequestRidePresenter;
  final MainScreens.PassengerRideScreen passengerRideScreenParams;
  
  public PassengerRequestRideViewV2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    passengerRideScreenParams = ((MainScreens.PassengerRideScreen)Screen.fromView(this));
  }
  
  private Scoop createScoop(Object... paramVarArgs)
  {
    return DaggerInjector.extend(Scoop.fromView(this), paramVarArgs);
  }
  
  public String getWebDialogParams()
  {
    return passengerRideScreenParams.getWebDialogParams();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    passengerRequestRidePresenter.attachView(this);
  }
  
  public boolean onBack()
  {
    View localView = getChildAt(0);
    if ((localView != null) && ((localView instanceof HandleBack)) && (((HandleBack)localView).onBack())) {
      return true;
    }
    return passengerRequestRidePresenter.onBack();
  }
  
  protected void onDetachedFromWindow()
  {
    passengerRequestRidePresenter.detachView(this);
    super.onDetachedFromWindow();
  }
  
  public void resetWebDialogParams()
  {
    passengerRideScreenParams.resetWebDialogUrl();
  }
  
  public void showStep(PassengerRideRequest.RequestRideStep paramRequestRideStep)
  {
    int i;
    switch (PassengerRequestRideViewV2.1.$SwitchMap$me$lyft$android$domain$passenger$ride$PassengerRideRequest$RequestRideStep[paramRequestRideStep.ordinal()])
    {
    default: 
      throw new IllegalStateException("unsupported step");
    case 1: 
      paramRequestRideStep = createScoop(new Object[] { new SetPickupModule() });
      i = 2130903334;
    }
    for (;;)
    {
      removeAllViews();
      paramRequestRideStep.inflater(getContext()).inflate(i, this, true);
      return;
      paramRequestRideStep = createScoop(new Object[] { new SetDestinationModule(), new WidgetModule() });
      i = 2130903331;
      continue;
      paramRequestRideStep = createScoop(new Object[] { new ConfirmModule(), new WidgetModule() });
      i = 2130903326;
      continue;
      paramRequestRideStep = createScoop(new Object[] { new VenueModule() });
      i = 2130903335;
      continue;
      paramRequestRideStep = createScoop(new Object[] { new SetTimeModule() });
      i = 2130903332;
      continue;
      paramRequestRideStep = createScoop(new Object[] { new SetTimeModule() });
      i = 2130903333;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.PassengerRequestRideViewV2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */