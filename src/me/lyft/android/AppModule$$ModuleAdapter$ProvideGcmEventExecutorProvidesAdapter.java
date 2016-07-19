package me.lyft.android;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.payment.IPricingService;
import me.lyft.android.gcm.IGcmEventExecutor;
import me.lyft.android.gcm.IGcmSerializer;
import me.lyft.android.infrastructure.lyft.IAppStateHandler;
import me.lyft.android.notifications.IStatusBarNotificationsService;

public final class AppModule$$ModuleAdapter$ProvideGcmEventExecutorProvidesAdapter
  extends ProvidesBinding<IGcmEventExecutor>
{
  private Binding<IAppStateHandler> appStateHandler;
  private Binding<IFeaturesProvider> featuresProvider;
  private Binding<IGcmSerializer> gcmSerializer;
  private final AppModule module;
  private Binding<IPricingService> pricingService;
  private Binding<IStatusBarNotificationsService> statusBarNotificationsService;
  
  public AppModule$$ModuleAdapter$ProvideGcmEventExecutorProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.gcm.IGcmEventExecutor", true, "me.lyft.android.AppModule", "provideGcmEventExecutor");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    statusBarNotificationsService = paramLinker.requestBinding("me.lyft.android.notifications.IStatusBarNotificationsService", AppModule.class, getClass().getClassLoader());
    gcmSerializer = paramLinker.requestBinding("me.lyft.android.gcm.IGcmSerializer", AppModule.class, getClass().getClassLoader());
    appStateHandler = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.IAppStateHandler", AppModule.class, getClass().getClassLoader());
    pricingService = paramLinker.requestBinding("me.lyft.android.application.payment.IPricingService", AppModule.class, getClass().getClassLoader());
    featuresProvider = paramLinker.requestBinding("me.lyft.android.application.features.IFeaturesProvider", AppModule.class, getClass().getClassLoader());
  }
  
  public IGcmEventExecutor get()
  {
    return module.provideGcmEventExecutor((IStatusBarNotificationsService)statusBarNotificationsService.get(), (IGcmSerializer)gcmSerializer.get(), (IAppStateHandler)appStateHandler.get(), (IPricingService)pricingService.get(), (IFeaturesProvider)featuresProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(statusBarNotificationsService);
    paramSet1.add(gcmSerializer);
    paramSet1.add(appStateHandler);
    paramSet1.add(pricingService);
    paramSet1.add(featuresProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideGcmEventExecutorProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */