package me.lyft.android;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.enterprise.IEnterpriseService;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.deeplinks.DeepLinkManager;
import me.lyft.android.flows.ProfileFlow;
import me.lyft.android.jobs.JobManager;
import me.lyft.android.ui.MainScreensRouter;
import me.lyft.android.ui.onboarding.CarpoolDriverOnboardingRouter;

public final class AppModule$$ModuleAdapter$ProvideDeepLinkManagerProvidesAdapter
  extends ProvidesBinding<DeepLinkManager>
{
  private Binding<AppFlow> appFlow;
  private Binding<CarpoolDriverOnboardingRouter> carpoolDriverOnboardingRouter;
  private Binding<IEnterpriseService> enterpriseService;
  private Binding<IFeaturesProvider> featuresProvider;
  private Binding<JobManager> jobManager;
  private Binding<MainScreensRouter> mainScreensRouter;
  private final AppModule module;
  private Binding<ProfileFlow> profileFlow;
  private Binding<IUserProvider> userProvider;
  private Binding<IUserUiService> userUIService;
  
  public AppModule$$ModuleAdapter$ProvideDeepLinkManagerProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.deeplinks.DeepLinkManager", true, "me.lyft.android.AppModule", "provideDeepLinkManager");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    appFlow = paramLinker.requestBinding("me.lyft.android.common.AppFlow", AppModule.class, getClass().getClassLoader());
    jobManager = paramLinker.requestBinding("me.lyft.android.jobs.JobManager", AppModule.class, getClass().getClassLoader());
    profileFlow = paramLinker.requestBinding("me.lyft.android.flows.ProfileFlow", AppModule.class, getClass().getClassLoader());
    mainScreensRouter = paramLinker.requestBinding("me.lyft.android.ui.MainScreensRouter", AppModule.class, getClass().getClassLoader());
    featuresProvider = paramLinker.requestBinding("me.lyft.android.application.features.IFeaturesProvider", AppModule.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", AppModule.class, getClass().getClassLoader());
    carpoolDriverOnboardingRouter = paramLinker.requestBinding("me.lyft.android.ui.onboarding.CarpoolDriverOnboardingRouter", AppModule.class, getClass().getClassLoader());
    enterpriseService = paramLinker.requestBinding("me.lyft.android.application.enterprise.IEnterpriseService", AppModule.class, getClass().getClassLoader());
    userUIService = paramLinker.requestBinding("me.lyft.android.application.ride.IUserUiService", AppModule.class, getClass().getClassLoader());
  }
  
  public DeepLinkManager get()
  {
    return module.provideDeepLinkManager((AppFlow)appFlow.get(), (JobManager)jobManager.get(), (ProfileFlow)profileFlow.get(), (MainScreensRouter)mainScreensRouter.get(), (IFeaturesProvider)featuresProvider.get(), (IUserProvider)userProvider.get(), (CarpoolDriverOnboardingRouter)carpoolDriverOnboardingRouter.get(), (IEnterpriseService)enterpriseService.get(), (IUserUiService)userUIService.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(appFlow);
    paramSet1.add(jobManager);
    paramSet1.add(profileFlow);
    paramSet1.add(mainScreensRouter);
    paramSet1.add(featuresProvider);
    paramSet1.add(userProvider);
    paramSet1.add(carpoolDriverOnboardingRouter);
    paramSet1.add(enterpriseService);
    paramSet1.add(userUIService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideDeepLinkManagerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */