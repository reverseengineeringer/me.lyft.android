package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.IUserSession;
import me.lyft.android.application.IAppInfoService;
import me.lyft.android.application.autofill.AutoFillAnalytics;
import me.lyft.android.application.autofill.AutoFillService;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.landing.ILandingService;
import me.lyft.android.infrastructure.assets.IAssetPackagingService;
import me.lyft.android.infrastructure.bootstrap.IBootstrapService;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideBootstrapServiceProvidesAdapter
  extends ProvidesBinding<IBootstrapService>
{
  private Binding<IAppInfoService> appInfoService;
  private Binding<IAssetPackagingService> assetPackagingService;
  private Binding<AutoFillAnalytics> autoFillAnalytics;
  private Binding<AutoFillService> autoFillService;
  private Binding<IFeaturesProvider> featuresProvider;
  private Binding<ILandingService> landingService;
  private Binding<ILyftPreferences> lyftPreferences;
  private final InfrastructureServicesModule module;
  private Binding<IUserSession> userSession;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideBootstrapServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.bootstrap.IBootstrapService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideBootstrapService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    userSession = paramLinker.requestBinding("me.lyft.android.IUserSession", InfrastructureServicesModule.class, getClass().getClassLoader());
    lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
    appInfoService = paramLinker.requestBinding("me.lyft.android.application.IAppInfoService", InfrastructureServicesModule.class, getClass().getClassLoader());
    assetPackagingService = paramLinker.requestBinding("me.lyft.android.infrastructure.assets.IAssetPackagingService", InfrastructureServicesModule.class, getClass().getClassLoader());
    landingService = paramLinker.requestBinding("me.lyft.android.application.landing.ILandingService", InfrastructureServicesModule.class, getClass().getClassLoader());
    autoFillService = paramLinker.requestBinding("me.lyft.android.application.autofill.AutoFillService", InfrastructureServicesModule.class, getClass().getClassLoader());
    autoFillAnalytics = paramLinker.requestBinding("me.lyft.android.application.autofill.AutoFillAnalytics", InfrastructureServicesModule.class, getClass().getClassLoader());
    featuresProvider = paramLinker.requestBinding("me.lyft.android.application.features.IFeaturesProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public IBootstrapService get()
  {
    return module.provideBootstrapService((IUserSession)userSession.get(), (ILyftPreferences)lyftPreferences.get(), (IAppInfoService)appInfoService.get(), (IAssetPackagingService)assetPackagingService.get(), (ILandingService)landingService.get(), (AutoFillService)autoFillService.get(), (AutoFillAnalytics)autoFillAnalytics.get(), (IFeaturesProvider)featuresProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(userSession);
    paramSet1.add(lyftPreferences);
    paramSet1.add(appInfoService);
    paramSet1.add(assetPackagingService);
    paramSet1.add(landingService);
    paramSet1.add(autoFillService);
    paramSet1.add(autoFillAnalytics);
    paramSet1.add(featuresProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideBootstrapServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */