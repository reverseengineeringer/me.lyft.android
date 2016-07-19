package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.analytics.trackers.IAnalyticsService;
import me.lyft.android.infrastructure.activity.ActivityServiceRegistry;
import me.lyft.android.infrastructure.androidpay.IAndroidPayService;
import me.lyft.android.infrastructure.appboy.IAppboyService;
import me.lyft.android.infrastructure.competition.InstallTrackerService;
import me.lyft.android.infrastructure.deferred.IDeferredSyncService;
import me.lyft.android.infrastructure.driverdefense.DriverShortcutStarterService;
import me.lyft.android.infrastructure.gallery.IGalleryService;
import me.lyft.android.infrastructure.googleplay.IGoogleApiProvider;
import me.lyft.android.infrastructure.instabug.IInstabugService;
import me.lyft.android.infrastructure.leanplum.ILeanplumService;
import me.lyft.android.infrastructure.locationsettings.ILocationSettingsService;
import me.lyft.android.infrastructure.paypal.IPayPalService;
import me.lyft.android.infrastructure.viewserver.IViewServerService;
import me.lyft.android.notifications.IStatusBarNotificationsService;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideActivityServiceRegistryProvidesAdapter
  extends ProvidesBinding<ActivityServiceRegistry>
{
  private Binding<IAnalyticsService> analyticsService;
  private Binding<IAppboyService> appboyService;
  private Binding<IDeferredSyncService> deferredSyncService;
  private Binding<DriverShortcutStarterService> driverShortcutStarterService;
  private Binding<IGalleryService> galleryService;
  private Binding<IGoogleApiProvider> googleApiProvider;
  private Binding<IInstabugService> instabugService;
  private Binding<InstallTrackerService> installTrackerService;
  private Binding<ILeanplumService> leanplumService;
  private Binding<ILocationSettingsService> locationSettingsService;
  private final InfrastructureServicesModule module;
  private Binding<IPayPalService> payPalService;
  private Binding<IStatusBarNotificationsService> statusBarNotificationsService;
  private Binding<IViewServerService> viewServerService;
  private Binding<IAndroidPayService> walletService;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideActivityServiceRegistryProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.activity.ActivityServiceRegistry", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideActivityServiceRegistry");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    googleApiProvider = paramLinker.requestBinding("me.lyft.android.infrastructure.googleplay.IGoogleApiProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
    walletService = paramLinker.requestBinding("me.lyft.android.infrastructure.androidpay.IAndroidPayService", InfrastructureServicesModule.class, getClass().getClassLoader());
    galleryService = paramLinker.requestBinding("me.lyft.android.infrastructure.gallery.IGalleryService", InfrastructureServicesModule.class, getClass().getClassLoader());
    analyticsService = paramLinker.requestBinding("me.lyft.android.analytics.trackers.IAnalyticsService", InfrastructureServicesModule.class, getClass().getClassLoader());
    payPalService = paramLinker.requestBinding("me.lyft.android.infrastructure.paypal.IPayPalService", InfrastructureServicesModule.class, getClass().getClassLoader());
    locationSettingsService = paramLinker.requestBinding("me.lyft.android.infrastructure.locationsettings.ILocationSettingsService", InfrastructureServicesModule.class, getClass().getClassLoader());
    viewServerService = paramLinker.requestBinding("me.lyft.android.infrastructure.viewserver.IViewServerService", InfrastructureServicesModule.class, getClass().getClassLoader());
    driverShortcutStarterService = paramLinker.requestBinding("me.lyft.android.infrastructure.driverdefense.DriverShortcutStarterService", InfrastructureServicesModule.class, getClass().getClassLoader());
    installTrackerService = paramLinker.requestBinding("me.lyft.android.infrastructure.competition.InstallTrackerService", InfrastructureServicesModule.class, getClass().getClassLoader());
    appboyService = paramLinker.requestBinding("me.lyft.android.infrastructure.appboy.IAppboyService", InfrastructureServicesModule.class, getClass().getClassLoader());
    statusBarNotificationsService = paramLinker.requestBinding("me.lyft.android.notifications.IStatusBarNotificationsService", InfrastructureServicesModule.class, getClass().getClassLoader());
    leanplumService = paramLinker.requestBinding("me.lyft.android.infrastructure.leanplum.ILeanplumService", InfrastructureServicesModule.class, getClass().getClassLoader());
    instabugService = paramLinker.requestBinding("me.lyft.android.infrastructure.instabug.IInstabugService", InfrastructureServicesModule.class, getClass().getClassLoader());
    deferredSyncService = paramLinker.requestBinding("me.lyft.android.infrastructure.deferred.IDeferredSyncService", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public ActivityServiceRegistry get()
  {
    return module.provideActivityServiceRegistry((IGoogleApiProvider)googleApiProvider.get(), (IAndroidPayService)walletService.get(), (IGalleryService)galleryService.get(), (IAnalyticsService)analyticsService.get(), (IPayPalService)payPalService.get(), (ILocationSettingsService)locationSettingsService.get(), (IViewServerService)viewServerService.get(), (DriverShortcutStarterService)driverShortcutStarterService.get(), (InstallTrackerService)installTrackerService.get(), (IAppboyService)appboyService.get(), (IStatusBarNotificationsService)statusBarNotificationsService.get(), (ILeanplumService)leanplumService.get(), (IInstabugService)instabugService.get(), (IDeferredSyncService)deferredSyncService.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(googleApiProvider);
    paramSet1.add(walletService);
    paramSet1.add(galleryService);
    paramSet1.add(analyticsService);
    paramSet1.add(payPalService);
    paramSet1.add(locationSettingsService);
    paramSet1.add(viewServerService);
    paramSet1.add(driverShortcutStarterService);
    paramSet1.add(installTrackerService);
    paramSet1.add(appboyService);
    paramSet1.add(statusBarNotificationsService);
    paramSet1.add(leanplumService);
    paramSet1.add(instabugService);
    paramSet1.add(deferredSyncService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideActivityServiceRegistryProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */