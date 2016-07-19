package me.lyft.android.ui.driver.carpool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.domain.time.Time;
import me.lyft.android.flows.ProfileFlow;
import me.lyft.android.infrastructure.share.IShareService;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.ui.driver.DriverDialogs.CallConfirmationDialog;

public class CarpoolPassengerView
  extends LinearLayout
{
  View contactButtonsLayout;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  IDriverRideProvider driverRideProvider;
  @Inject
  ImageLoader imageLoader;
  TextView messageTextView;
  @Inject
  ProfileFlow profileFlow;
  ImageView profileImageView;
  @Inject
  IShareService smsService;
  
  public CarpoolPassengerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  public void hideContactButtons()
  {
    contactButtonsLayout.setVisibility(8);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    showProfilePhoto(driverRideProvider.getDriverRide().getCurrentPassenger().getPhotoUrl());
  }
  
  public void onCallClicked()
  {
    dialogFlow.show(new DriverDialogs.CallConfirmationDialog(driverRideProvider.getDriverRide().getCurrentPassenger()));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
  
  public void onImageClicked()
  {
    profileFlow.openPassengerRideProfile(driverRideProvider.getDriverRide().getCurrentPassenger().getId());
  }
  
  public void onTextClicked()
  {
    smsService.openSmsComposer(driverRideProvider.getDriverRide().getCurrentPassenger().getPhoneNumber());
  }
  
  public void showAcknowledgeMessage()
  {
    String str = driverRideProvider.getDriverRide().getCurrentPassenger().getFirstName();
    messageTextView.setText(getContext().getString(2131165376, new Object[] { str }));
  }
  
  public void showContactButtons()
  {
    contactButtonsLayout.setVisibility(0);
  }
  
  public void showDropoffMessage()
  {
    String str = driverRideProvider.getDriverRide().getCurrentPassenger().getFirstName();
    messageTextView.setText(getContext().getString(2131165386, new Object[] { str }));
  }
  
  public void showPickupMessage()
  {
    String str1 = driverRideProvider.getDriverRide().getCurrentPassenger().getFirstName();
    String str2 = driverRideProvider.getDriverRide().getCurrentStop().getScheduledTime().formatTime();
    messageTextView.setText(getContext().getString(2131165405, new Object[] { str1, str2 }));
  }
  
  public void showProfilePhoto(String paramString)
  {
    imageLoader.load(paramString).fit().centerCrop().placeholder(2130838447).into(profileImageView);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.carpool.CarpoolPassengerView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */