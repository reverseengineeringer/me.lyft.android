package me.lyft.android.ui.passenger.v2.inride;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import butterknife.ButterKnife;
import com.lyft.googlemaps.core.IMapTooltipView;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.analytics.EditPickupAnalytics;
import me.lyft.android.common.AppFlow;
import me.lyft.android.ui.passenger.PassengerScreens.PassengerEditPickup;

public class EditPickupMapTooltipView
  extends IMapTooltipView
{
  @Inject
  AppFlow appFlow;
  @Inject
  EditPickupAnalytics editPickupAnalytics;
  
  public EditPickupMapTooltipView(Context paramContext)
  {
    super(paramContext);
    DaggerInjector.fromView(this).inject(this);
    LayoutInflater.from(paramContext).inflate(2130903208, this, true);
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
  }
  
  public void onClick()
  {
    editPickupAnalytics.trackEditPickupStartedFromTooltip();
    appFlow.goTo(new PassengerScreens.PassengerEditPickup());
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
  
  public void setText(String paramString) {}
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.inride.EditPickupMapTooltipView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */