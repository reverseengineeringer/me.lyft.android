package me.lyft.android.ui.dialogs;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import java.text.DateFormat;
import javax.inject.Inject;
import me.lyft.android.application.ride.IUserDispatchService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DateUtils;
import me.lyft.android.domain.driver.Vehicle;
import me.lyft.android.domain.driverdocuments.Insurance;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.Dialogs.InsuranceExpiringDialog;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;

public class InsuranceExpiringDialogView
  extends DialogContainerView
{
  @Inject
  AppFlow appFlow;
  private Binder binder;
  TextView messageTextView;
  Button notNowButton;
  private final Dialogs.InsuranceExpiringDialog params;
  @Inject
  IProgressController progressController;
  TextView titleTextView;
  Button updateInsuranceButton;
  @Inject
  IUserDispatchService userModeService;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  public InsuranceExpiringDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((Dialogs.InsuranceExpiringDialog)Screen.fromView(this));
  }
  
  private void initTitleAndMessage()
  {
    Insurance localInsurance = params.getVehicle().getInsurance();
    if (localInsurance.getExpirationDate() == null) {
      throw new IllegalArgumentException("Date should be provided for expiration dialog");
    }
    if (!localInsurance.isApprovedButExpiringSoon())
    {
      DateFormat localDateFormat = DateUtils.createDateFormat("MM/dd/yy");
      titleTextView.setText(getResources().getString(2131166110));
      messageTextView.setText(getResources().getString(2131166109, new Object[] { localDateFormat.format(localInsurance.getExpirationDate()) }));
    }
  }
  
  private void switchToDriverModeIfPossible()
  {
    if (!params.getAttemptEnterDriverMode()) {}
    Insurance localInsurance;
    do
    {
      return;
      localInsurance = params.getVehicle().getInsurance();
    } while ((localInsurance.getExpirationDate() == null) || (!localInsurance.isApprovedButExpiringSoon()));
    binder.bind(userModeService.switchToDispatchable(true), new InsuranceExpiringDialogView.3(this));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    updateInsuranceButton.setOnClickListener(new InsuranceExpiringDialogView.1(this));
    notNowButton.setOnClickListener(new InsuranceExpiringDialogView.2(this));
    initTitleAndMessage();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.dialogs.InsuranceExpiringDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */