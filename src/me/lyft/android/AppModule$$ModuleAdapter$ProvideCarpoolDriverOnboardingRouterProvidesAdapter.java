package me.lyft.android;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.ui.MainScreensRouter;
import me.lyft.android.ui.onboarding.CarpoolDriverOnboardingRouter;

public final class AppModule$$ModuleAdapter$ProvideCarpoolDriverOnboardingRouterProvidesAdapter
  extends ProvidesBinding<CarpoolDriverOnboardingRouter>
{
  private Binding<AppFlow> appFlow;
  private Binding<DialogFlow> dialogFlow;
  private Binding<ILyftPreferences> lyftPreferences;
  private Binding<MainScreensRouter> mainScreensRouter;
  private final AppModule module;
  private Binding<IUserProvider> userProvider;
  
  public AppModule$$ModuleAdapter$ProvideCarpoolDriverOnboardingRouterProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.ui.onboarding.CarpoolDriverOnboardingRouter", true, "me.lyft.android.AppModule", "provideCarpoolDriverOnboardingRouter");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    appFlow = paramLinker.requestBinding("me.lyft.android.common.AppFlow", AppModule.class, getClass().getClassLoader());
    lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", AppModule.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", AppModule.class, getClass().getClassLoader());
    dialogFlow = paramLinker.requestBinding("me.lyft.android.common.DialogFlow", AppModule.class, getClass().getClassLoader());
    mainScreensRouter = paramLinker.requestBinding("me.lyft.android.ui.MainScreensRouter", AppModule.class, getClass().getClassLoader());
  }
  
  public CarpoolDriverOnboardingRouter get()
  {
    return module.provideCarpoolDriverOnboardingRouter((AppFlow)appFlow.get(), (ILyftPreferences)lyftPreferences.get(), (IUserProvider)userProvider.get(), (DialogFlow)dialogFlow.get(), (MainScreensRouter)mainScreensRouter.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(appFlow);
    paramSet1.add(lyftPreferences);
    paramSet1.add(userProvider);
    paramSet1.add(dialogFlow);
    paramSet1.add(mainScreensRouter);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideCarpoolDriverOnboardingRouterProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */