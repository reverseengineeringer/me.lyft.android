package me.lyft.android.ui.driver;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.ride.IDriverRouteService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.dialogs.DialogContainerView;

public class LastRideExitDialogView
  extends DialogContainerView
{
  private Binder binder;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  IDriverRouteService driverRouteService;
  Button exitLastRideButton;
  @Inject
  IProgressController progressController;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  public LastRideExitDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder = Binder.attach(this);
    exitLastRideButton.setOnClickListener(new LastRideExitDialogView.1(this));
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
 * Qualified Name:     me.lyft.android.ui.driver.LastRideExitDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */