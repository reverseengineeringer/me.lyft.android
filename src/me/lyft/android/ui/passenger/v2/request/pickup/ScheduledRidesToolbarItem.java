package me.lyft.android.ui.passenger.v2.request.pickup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.ride.services.IScheduledRideService;
import me.lyft.android.domain.ride.ScheduledRide;
import me.lyft.android.domain.time.Time;
import me.lyft.android.rx.IRxBinder;
import me.lyft.android.rx.RxUIBinder;
import rx.functions.Action1;

public class ScheduledRidesToolbarItem
  extends FrameLayout
{
  final IRxBinder binder = new RxUIBinder();
  LinearLayout container;
  TextView countLabel;
  TextView dateLabel;
  final Action1<List<ScheduledRide>> onScheduledRidesUpdate = new ScheduledRidesToolbarItem.1(this);
  @Inject
  IScheduledRideService scheduledRideService;
  final Scoop scoop = Scoop.fromView(this);
  TextView timeLabel;
  
  public ScheduledRidesToolbarItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    scoop.inflater(paramContext).inflate(2130903446, this, true);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void setFirstScheduledRide(ScheduledRide paramScheduledRide)
  {
    paramScheduledRide = paramScheduledRide.getPickupTime();
    dateLabel.setText(paramScheduledRide.formatDateWithToday());
    timeLabel.setText(paramScheduledRide.formatTime());
  }
  
  private void setScheduledRideCount(int paramInt)
  {
    if (paramInt <= 1)
    {
      countLabel.setVisibility(8);
      return;
    }
    countLabel.setText(String.valueOf(paramInt));
    countLabel.setVisibility(0);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder.attach();
    binder.bindAction(scheduledRideService.observeScheduledRides(), onScheduledRidesUpdate);
  }
  
  protected void onDetachedFromWindow()
  {
    binder.detach();
    super.onDetachedFromWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
  
  public void setPressed(boolean paramBoolean)
  {
    container.setPressed(paramBoolean);
    super.setPressed(paramBoolean);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.pickup.ScheduledRidesToolbarItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */