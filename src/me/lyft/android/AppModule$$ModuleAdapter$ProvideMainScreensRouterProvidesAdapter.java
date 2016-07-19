package me.lyft.android;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.ui.MainScreensRouter;

public final class AppModule$$ModuleAdapter$ProvideMainScreensRouterProvidesAdapter
  extends ProvidesBinding<MainScreensRouter>
{
  private Binding<AppFlow> appFlow;
  private Binding<IDriverRideProvider> driverRideProvider;
  private final AppModule module;
  private Binding<IUserUiService> userService;
  
  public AppModule$$ModuleAdapter$ProvideMainScreensRouterProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.ui.MainScreensRouter", true, "me.lyft.android.AppModule", "provideMainScreensRouter");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    appFlow = paramLinker.requestBinding("me.lyft.android.common.AppFlow", AppModule.class, getClass().getClassLoader());
    userService = paramLinker.requestBinding("me.lyft.android.application.ride.IUserUiService", AppModule.class, getClass().getClassLoader());
    driverRideProvider = paramLinker.requestBinding("me.lyft.android.application.ride.IDriverRideProvider", AppModule.class, getClass().getClassLoader());
  }
  
  public MainScreensRouter get()
  {
    return module.provideMainScreensRouter((AppFlow)appFlow.get(), (IUserUiService)userService.get(), (IDriverRideProvider)driverRideProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(appFlow);
    paramSet1.add(userService);
    paramSet1.add(driverRideProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideMainScreensRouterProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */