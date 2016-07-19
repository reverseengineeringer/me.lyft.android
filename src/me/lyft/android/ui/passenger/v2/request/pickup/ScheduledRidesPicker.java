package me.lyft.android.ui.passenger.v2.request.pickup;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.recyclerview.RecyclerItemClickListener;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.ride.services.IScheduledRideService;
import me.lyft.android.controls.recycleview.WrapContentLayoutManager;
import me.lyft.android.domain.ride.ScheduledRide;
import me.lyft.android.rx.IRxBinder;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.passenger.v2.PassengerRideRouter;
import rx.Observable;
import rx.functions.Action1;

public class ScheduledRidesPicker
  extends LinearLayout
{
  final ScheduledRidesPickerAdapter adapter;
  final IRxBinder binder = new RxUIBinder();
  final RecyclerItemClickListener clickListener;
  private final Action1<ScheduledRide> onItemClick = new ScheduledRidesPicker.2(this);
  private final Action1<List<ScheduledRide>> onScheduledRidesUpdate = new ScheduledRidesPicker.3(this);
  RecyclerView recyclerView;
  @Inject
  PassengerRideRouter router;
  @Inject
  IScheduledRideService scheduledRideService;
  final Scoop scoop = Scoop.fromView(this);
  
  public ScheduledRidesPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = scoop.inflater(paramContext);
    paramAttributeSet.inflate(2130903445, this, true);
    DaggerInjector.fromView(this).inject(this);
    adapter = new ScheduledRidesPickerAdapter(paramAttributeSet);
    clickListener = new RecyclerItemClickListener(paramContext);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder.attach();
    binder.bindAction(scheduledRideService.observeScheduledRides(), onScheduledRidesUpdate);
    binder.bindAction(clickListener.observeClickEvents().map(new ScheduledRidesPicker.1(this)), onItemClick);
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
    recyclerView.setLayoutManager(new WrapContentLayoutManager(recyclerView, 1, false));
    recyclerView.setAdapter(adapter);
    recyclerView.addOnItemTouchListener(clickListener);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.pickup.ScheduledRidesPicker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */