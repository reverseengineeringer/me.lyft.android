package me.lyft.android.ui.profile;

import dagger.Module;
import dagger.Provides;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.driver.IVehicleService;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.profile.IProfileService;
import me.lyft.android.application.profile.IRideProfileService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.infrastructure.photo.IPhotoPickerService;
import me.lyft.android.infrastructure.profile.IProfilePhotoLoader;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.SlideMenuController;

@Module(complete=false, injects={EditProfileController.class, UpdatePassengerProfilePhotoController.class, UpdatePassengerPhotoFromEditProfileController.class, DriverRideProfileController.class, DriverMyProfileController.class, ProfileScrollview.class, DriverProfilePhotoCarWidgetView.class, PassengerRideProfileController.class, PassengerMyProfileController.class, ProfileToolBarView.class, ProfileFacebookConnectRideWidgetView.class, ProfileFacebookConnectMyWidgetView.class, PassengerProfilePhotoWidgetView.class, ProfileFriendsWidgetView.class, ProfileBioWidgetView.class, ProfileFriendsItemWidgetView.class, ProfileAdditionalFriendWidgetView.class})
public class ProfileModule
{
  @Provides
  public DriverMyProfileController provideDriverMyProfileController(IProfileService paramIProfileService, IVehicleService paramIVehicleService, IViewErrorHandler paramIViewErrorHandler, SlideMenuController paramSlideMenuController)
  {
    return new DriverMyProfileController(paramIProfileService, paramIVehicleService, paramIViewErrorHandler, paramSlideMenuController);
  }
  
  @Provides
  public DriverRideProfileController provideDriverRideProfileController(AppFlow paramAppFlow, IRideProfileService paramIRideProfileService, IPassengerRideProvider paramIPassengerRideProvider)
  {
    return new DriverRideProfileController(paramAppFlow, paramIRideProfileService, paramIPassengerRideProvider);
  }
  
  @Provides
  public EditProfileController provideEditProfileController(AppFlow paramAppFlow, DialogFlow paramDialogFlow, IProgressController paramIProgressController, IPhotoPickerService paramIPhotoPickerService, IProfileService paramIProfileService, IUserProvider paramIUserProvider, IViewErrorHandler paramIViewErrorHandler, IProfilePhotoLoader paramIProfilePhotoLoader)
  {
    return new EditProfileController(paramAppFlow, paramDialogFlow, paramIProgressController, paramIPhotoPickerService, paramIProfileService, paramIUserProvider, paramIViewErrorHandler, paramIProfilePhotoLoader);
  }
  
  @Provides
  public PassengerMyProfileController providePassengerMyProfileController(IProfileService paramIProfileService, SlideMenuController paramSlideMenuController)
  {
    return new PassengerMyProfileController(paramIProfileService, paramSlideMenuController);
  }
  
  @Provides
  public PassengerRideProfileController providePassengerRideProfileController(AppFlow paramAppFlow, IRideProfileService paramIRideProfileService, IPassengerRideProvider paramIPassengerRideProvider)
  {
    return new PassengerRideProfileController(paramAppFlow, paramIRideProfileService, paramIPassengerRideProvider);
  }
  
  @Provides
  public UpdatePassengerPhotoFromEditProfileController provideUpdatePassengerPhotoFromEditProfileController(AppFlow paramAppFlow, DialogFlow paramDialogFlow, IProfilePhotoLoader paramIProfilePhotoLoader)
  {
    return new UpdatePassengerPhotoFromEditProfileController(paramAppFlow, paramDialogFlow, paramIProfilePhotoLoader);
  }
  
  @Provides
  public UpdatePassengerProfilePhotoController provideUpdatePassengerProfilePhotoController(AppFlow paramAppFlow, DialogFlow paramDialogFlow, IProfilePhotoLoader paramIProfilePhotoLoader, IProgressController paramIProgressController, IProfileService paramIProfileService, IPhotoPickerService paramIPhotoPickerService, IViewErrorHandler paramIViewErrorHandler)
  {
    return new UpdatePassengerProfilePhotoController(paramAppFlow, paramDialogFlow, paramIProfilePhotoLoader, paramIProgressController, paramIProfileService, paramIPhotoPickerService, paramIViewErrorHandler);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.profile.ProfileModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */