package me.lyft.android.ui.help;

import dagger.Module;
import dagger.Provides;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.application.ridehistory.IPassengerRideHistoryService;
import me.lyft.android.application.settings.ISignUrlService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.development.IDeveloperTools;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.SlideMenuController;
import me.lyft.android.ui.ridehistory.PassengerRideHistoryItemView;
import me.lyft.android.utils.WebBrowser;

@Module(complete=false, injects={HelpController.class, HelpTermsController.class, HelpLegalController.class, PassengerRideHistoryItemView.class})
public class HelpModule
{
  @Provides
  public HelpController provideHelpController(ISignUrlService paramISignUrlService, IPassengerRideHistoryService paramIPassengerRideHistoryService, IViewErrorHandler paramIViewErrorHandler, IProgressController paramIProgressController, ILyftPreferences paramILyftPreferences, IUserProvider paramIUserProvider, IUserUiService paramIUserUiService, IDevice paramIDevice, IPassengerRideProvider paramIPassengerRideProvider, AppFlow paramAppFlow, IDeveloperTools paramIDeveloperTools, WebBrowser paramWebBrowser, SlideMenuController paramSlideMenuController, IFeaturesProvider paramIFeaturesProvider)
  {
    return new HelpController(paramISignUrlService, paramIPassengerRideHistoryService, paramIViewErrorHandler, paramIProgressController, paramILyftPreferences, paramIUserProvider, paramIUserUiService, paramIDevice, paramIPassengerRideProvider, paramAppFlow, paramIDeveloperTools, paramWebBrowser, paramSlideMenuController, paramIFeaturesProvider);
  }
  
  @Provides
  public HelpLegalController provideHelpLegalController(AppFlow paramAppFlow, WebBrowser paramWebBrowser, ILyftPreferences paramILyftPreferences)
  {
    return new HelpLegalController(paramAppFlow, paramWebBrowser, paramILyftPreferences);
  }
  
  @Provides
  public HelpTermsController provideHelpTermsController(IUserProvider paramIUserProvider, IConstantsProvider paramIConstantsProvider)
  {
    return new HelpTermsController(paramIUserProvider, paramIConstantsProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.help.HelpModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */