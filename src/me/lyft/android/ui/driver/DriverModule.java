package me.lyft.android.ui.driver;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.domain.driver.DriverOverflowMenuDisplayManager;
import me.lyft.android.ui.CallPassengerMenuItem;
import me.lyft.android.ui.driver.achievements.DriverEarningsRecentActivitiesWidget;
import me.lyft.android.ui.driver.achievements.DriverSettingsEarningsController;
import me.lyft.android.ui.driver.carpool.DriverDeclineRideDialogController;
import me.lyft.android.ui.driver.carpool.NavigationSelectorDialogView;
import me.lyft.android.ui.driver.expresspay.AddDebitCardDialogView;
import me.lyft.android.ui.driver.expresspay.DriverEarningsExpressPayWidget;
import me.lyft.android.ui.driver.expresspay.EditDebitCardView;
import me.lyft.android.ui.driver.expresspay.ExpressPayDialogView;
import me.lyft.android.ui.driver.expresspay.ExpressPayPayoutSucceededDialogView;
import me.lyft.android.ui.driver.expresspay.ExpressPayView;
import me.lyft.android.ui.driver.ridescreens.DriverLapseDialogController;
import me.lyft.android.ui.tooltips.TooltipContainerView;

@Module(complete=false, injects={RideOverviewView.class, RideOverviewRouteItem.class, ExpressPayView.class, DriverToolbarView.class, DriverAddressInfoView.class, DriverSettingsEarningsController.class, DriverEarningsExpressPayWidget.class, DriverEarningsRecentActivitiesWidget.class, AutoNavigationToastView.class, CourierDriverInfoDialogView.class, DestinyInfoDialogView.class, DriverOverflowMenuView.class, CallPassengerMenuItem.class, NavigationDialogView.class, NoShowConfirmationDialogView.class, PrimeTimeHeatmapDialogView.class, QueuedRideDialogView.class, QueuedRidePassengerItemView.class, RideArrivalConfirmationDialogView.class, RideDropoffConfirmationDialogView.class, RidePickupConfirmationDialogView.class, SkipPassengerDialogView.class, DriverCancellationConfirmationDialogViewController.class, DriverApplicationDialogController.class, DriverDeclineRideDialogController.class, LastRideConfirmationDialogView.class, LastRideExitDialogView.class, GoOnlineDescriptionDialogView.class, TooltipContainerView.class, TrainingRideCompletedDialogView.class, DriverEndRideConfirmationDialogView.class, AddDebitCardDialogView.class, EditDebitCardView.class, ExpressPayDialogView.class, ExpressPayPayoutSucceededDialogView.class, NavigationSelectorDialogView.class, CarpoolDriverCancellationDialogController.class, DriverLapseDialogController.class})
public class DriverModule
{
  @Provides
  @Singleton
  public DriverOverflowMenuDisplayManager provideDriverOverflowMenuDisplayManager(IDriverRideProvider paramIDriverRideProvider, IFeaturesProvider paramIFeaturesProvider, IUserUiService paramIUserUiService, IUserProvider paramIUserProvider)
  {
    return new DriverOverflowMenuDisplayManager(paramIDriverRideProvider, paramIFeaturesProvider, paramIUserUiService, paramIUserProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.DriverModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */