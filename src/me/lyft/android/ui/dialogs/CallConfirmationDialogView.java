package me.lyft.android.ui.dialogs;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.time.Time;
import me.lyft.android.ui.driver.DriverDialogs.CallConfirmationDialog;
import me.lyft.android.utils.Telephony;

public class CallConfirmationDialogView
  extends DialogContainerView
{
  Button confirmCallButton;
  DriverDialogs.CallConfirmationDialog params;
  TextView scheduledTimeConfirmationTextView;
  @Inject
  Telephony telephony;
  
  public CallConfirmationDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((DriverDialogs.CallConfirmationDialog)Screen.fromView(this));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    confirmCallButton.setText(getResources().getString(2131165574, new Object[] { params.getPassenger().getFirstName() }));
    confirmCallButton.setOnClickListener(new CallConfirmationDialogView.1(this));
    Time localTime = params.getScheduledTime();
    if (!localTime.isNull())
    {
      scheduledTimeConfirmationTextView.setText(getResources().getString(2131165627, new Object[] { localTime.formatTime() }));
      scheduledTimeConfirmationTextView.setVisibility(0);
      return;
    }
    scheduledTimeConfirmationTextView.setVisibility(8);
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
 * Qualified Name:     me.lyft.android.ui.dialogs.CallConfirmationDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */