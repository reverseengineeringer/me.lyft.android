package me.lyft.android.ui.dialogs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.rx.IRxBinder;
import me.lyft.android.rx.RxUIBinder;

public class EditPickupOnboardingDialogView
  extends DialogContainerView
{
  private IRxBinder binder = new RxUIBinder();
  @Inject
  DialogFlow dialogFlow;
  View okButton;
  @Inject
  IPassengerRideProvider passengerRideProvider;
  
  public EditPickupOnboardingDialogView(Context paramContext, AttributeSet paramAttributeSet)
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
    binder.attach();
    okButton.setOnClickListener(new EditPickupOnboardingDialogView.1(this));
    binder.bindAction(passengerRideProvider.observeRideUpdateEvent(), new EditPickupOnboardingDialogView.2(this));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    binder.detach();
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
 * Qualified Name:     me.lyft.android.ui.dialogs.EditPickupOnboardingDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */