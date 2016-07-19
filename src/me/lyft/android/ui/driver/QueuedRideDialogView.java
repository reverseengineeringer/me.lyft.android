package me.lyft.android.ui.driver;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.dialogs.DialogContainerView;
import rx.Observable;

public class QueuedRideDialogView
  extends DialogContainerView
{
  private static final int DIALOG_AUTO_DISMISS_SEC = 3;
  @Inject
  IAppForegroundDetector appForegroundDetector;
  private Binder binder;
  ViewGroup containerView;
  @Inject
  DialogFlow dialogFlow;
  private List<DriverRidePassenger> passengers;
  
  public QueuedRideDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    passengers = ((DriverDialogs.QueuedRideDialog)Screen.fromView(this)).getPassengers();
  }
  
  private void doDismiss()
  {
    binder.bind(Observable.timer(3L, TimeUnit.SECONDS), new QueuedRideDialogView.3(this));
  }
  
  public void dismiss()
  {
    dialogFlow.dismiss();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    Iterator localIterator = passengers.iterator();
    while (localIterator.hasNext())
    {
      DriverRidePassenger localDriverRidePassenger = (DriverRidePassenger)localIterator.next();
      containerView.addView(new QueuedRidePassengerItemView(getContext(), localDriverRidePassenger));
    }
    binder = Binder.attach(this);
    binder.bind(appForegroundDetector.observeAppForegrounded().filter(new QueuedRideDialogView.1(this)), new QueuedRideDialogView.2(this));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
  
  public boolean performClick()
  {
    dialogFlow.dismiss();
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.QueuedRideDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */