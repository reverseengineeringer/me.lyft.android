package me.lyft.android.ui.passenger.v2.request;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.cost.ICostService;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType.Feature;
import me.lyft.android.domain.ride.ScheduledInterval;
import me.lyft.android.rx.IRxBinder;
import me.lyft.android.rx.RxUIBinder;
import rx.Observable;
import rx.functions.Action1;

public class ScheduleRideButton
  extends LinearLayout
{
  @Inject
  ICostService costService;
  private final Action1<Unit> onUpdateButtonState = new ScheduleRideButton.2(this);
  ImageView pickupTimerIcon;
  @Inject
  IRideRequestSession rideRequestSession;
  final IRxBinder rxBinder = new RxUIBinder();
  
  public ScheduleRideButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Scoop.fromView(this).inflater(paramContext).inflate(2130903330, this, true);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private boolean isScheduledTimeOptional()
  {
    return !rideRequestSession.getCurrentRideType().hasFeature(RequestRideType.Feature.SCHEDULE_REQUIRED);
  }
  
  private boolean isScheduledTimeSet()
  {
    return !rideRequestSession.getScheduledInterval().isNull();
  }
  
  public void hideAvailablePickupTimer()
  {
    setVisibility(8);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    rxBinder.attach();
    rxBinder.bindAction(rideRequestSession.observeCurrentRideType().map(Unit.func1()), onUpdateButtonState);
    rxBinder.bindAction(rideRequestSession.observeScheduledInterval().map(Unit.func1()), onUpdateButtonState);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    rxBinder.detach();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    setOnClickListener(new ScheduleRideButton.1(this));
  }
  
  public void showAvailablePickupTimer()
  {
    pickupTimerIcon.setImageResource(2130838389);
    setVisibility(0);
  }
  
  public void showSelectedPickupTimer()
  {
    pickupTimerIcon.setImageResource(2130838388);
    setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.ScheduleRideButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */