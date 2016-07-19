package me.lyft.android.ui.passenger.v2.inride;

import android.content.res.Resources;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.PassengerAnalytics;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.passenger.ride.Driver;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ride.RideFeature;
import me.lyft.android.infrastructure.share.IShareService;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.ui.dialogs.StandardDialogController;
import me.lyft.android.utils.Telephony;

public class ContactDriverDialogController
  extends StandardDialogController
{
  private final ImageLoader imageLoader;
  private final IPassengerRideProvider passengerRideProvider;
  private final IShareService smsService;
  private final Telephony telephony;
  
  @Inject
  public ContactDriverDialogController(DialogFlow paramDialogFlow, IShareService paramIShareService, IPassengerRideProvider paramIPassengerRideProvider, Telephony paramTelephony, ImageLoader paramImageLoader)
  {
    super(paramDialogFlow);
    smsService = paramIShareService;
    passengerRideProvider = paramIPassengerRideProvider;
    telephony = paramTelephony;
    imageLoader = paramImageLoader;
  }
  
  private void callDriver()
  {
    dismissDialog();
    String str = passengerRideProvider.getPassengerRide().getDriver().getPhoneNumber();
    telephony.callPhone(str);
  }
  
  private void sendMessageToDriver()
  {
    dismissDialog();
    PassengerAnalytics.trackTextDriverTap();
    smsService.openSmsComposer(passengerRideProvider.getPassengerRide().getDriver().getPhoneNumber());
  }
  
  public void onAttach()
  {
    super.onAttach();
    PassengerRide localPassengerRide = passengerRideProvider.getPassengerRide();
    Driver localDriver = localPassengerRide.getDriver();
    setContentTitle(getResources().getString(2131165949, new Object[] { localDriver.getName() }));
    RoundedImageView localRoundedImageView = (RoundedImageView)addHeaderLayout(2130903128);
    imageLoader.load(localDriver.getPhoto()).fit().centerCrop().into(localRoundedImageView);
    if (localPassengerRide.isFeatureEnabled(RideFeature.CALL_DRIVER)) {
      addPositiveButton(2130903157, getResources().getString(2131165948), new ContactDriverDialogController.1(this));
    }
    if (localPassengerRide.isFeatureEnabled(RideFeature.SMS_DRIVER)) {
      addNeutralButton(2130903157, getResources().getString(2131165950), new ContactDriverDialogController.2(this));
    }
    addNegativeButton(2130903152, getResources().getString(2131165358), getDismissListener());
  }
  
  public int viewId()
  {
    return 2131558419;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.inride.ContactDriverDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */