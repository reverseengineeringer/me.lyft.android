package me.lyft.android.ui.driver;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.dialogs.DialogContainerView;
import rx.functions.Action1;

public class PrimeTimeHeatmapDialogView
  extends DialogContainerView
{
  ImageView cancelButton;
  @Inject
  DialogFlow dialogFlow;
  TextView heatmapDialogBody;
  private Action1<DriverRide> onRouteChanged = new PrimeTimeHeatmapDialogView.2(this);
  private final DriverDialogs.PrimeTimeHeatmapDialog params;
  @Inject
  IDriverRideProvider routeProvider;
  
  public PrimeTimeHeatmapDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((DriverDialogs.PrimeTimeHeatmapDialog)Screen.fromView(this));
  }
  
  private void initializeDialog()
  {
    heatmapDialogBody.setText(getResources().getString(2131165755, new Object[] { params.getPercentage() }));
    cancelButton.setOnClickListener(new PrimeTimeHeatmapDialogView.1(this));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ButterKnife.bind(this);
    initializeDialog();
    Binder.attach(this).bind(routeProvider.observeRide(), onRouteChanged);
  }
  
  protected void onClickOutside()
  {
    onCancel();
    dialogFlow.dismiss();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.PrimeTimeHeatmapDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */