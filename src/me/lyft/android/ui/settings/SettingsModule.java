package me.lyft.android.ui.settings;

import android.content.res.Resources;
import dagger.Module;
import dagger.Provides;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.driver.achievements.DriverStatsController;
import me.lyft.android.ui.driver.achievements.card.DarkAchievementCardView;
import me.lyft.android.ui.driver.achievements.card.ExpressPayAchievementCard;
import me.lyft.android.ui.driver.achievements.card.GlowstacheAchievementCard;
import me.lyft.android.ui.driver.achievements.card.LightAchievementCardView;
import me.lyft.android.ui.driver.achievements.card.RefereeAchievementCardView;
import me.lyft.android.ui.driver.achievements.card.ReferralAchievementCardView;
import me.lyft.android.ui.driver.achievements.card.SignonAchievementCardView;
import me.lyft.android.ui.driver.expresspay.ExpressPayErrorHandler;
import me.lyft.android.ui.driver.expresspay.IExpressPayErrorHandler;
import me.lyft.android.ui.driver.vehicles.CarController;
import me.lyft.android.ui.driver.vehicles.DriverVehicleListItemView;
import me.lyft.android.ui.driver.vehicles.DriverVehiclesController;

@Module(complete=false, injects={SettingsController.class, EditEmailController.class, EditPhoneController.class, EditPhoneVerifyNumberController.class, AccessibilitySettingsController.class, NavigationSettingsController.class, CarController.class, DriverStatsController.class, GlowstacheAchievementCard.class, ReferralAchievementCardView.class, LightAchievementCardView.class, DarkAchievementCardView.class, ExpressPayAchievementCard.class, SignonAchievementCardView.class, RefereeAchievementCardView.class, PersonalInsuranceController.class, CapturedPersonalInsuranceController.class, VehicleInspectionController.class, VehicleRegistrationController.class, CapturedCarDocumentPreviewController.class, PhoneVerifyView.class, TrainingRideStartController.class, DriverVehiclesController.class, DriverVehicleListItemView.class})
public class SettingsModule
{
  @Provides
  public IExpressPayErrorHandler provideExpressPayErrorHandler(IViewErrorHandler paramIViewErrorHandler, Resources paramResources, DialogFlow paramDialogFlow, IConstantsProvider paramIConstantsProvider)
  {
    return new ExpressPayErrorHandler(paramIViewErrorHandler, paramResources, paramDialogFlow, paramIConstantsProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.settings.SettingsModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */