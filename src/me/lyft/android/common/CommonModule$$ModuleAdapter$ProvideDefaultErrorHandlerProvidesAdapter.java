package me.lyft.android.common;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.ILogoutService;
import me.lyft.android.errorhandling.IDefaultErrorHandler;

public final class CommonModule$$ModuleAdapter$ProvideDefaultErrorHandlerProvidesAdapter
  extends ProvidesBinding<IDefaultErrorHandler>
{
  private Binding<AppFlow> appFlow;
  private Binding<DialogFlow> dialogFlow;
  private Binding<ILogoutService> logoutService;
  private final CommonModule module;
  
  public CommonModule$$ModuleAdapter$ProvideDefaultErrorHandlerProvidesAdapter(CommonModule paramCommonModule)
  {
    super("me.lyft.android.errorhandling.IDefaultErrorHandler", false, "me.lyft.android.common.CommonModule", "provideDefaultErrorHandler");
    module = paramCommonModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    appFlow = paramLinker.requestBinding("me.lyft.android.common.AppFlow", CommonModule.class, getClass().getClassLoader());
    dialogFlow = paramLinker.requestBinding("me.lyft.android.common.DialogFlow", CommonModule.class, getClass().getClassLoader());
    logoutService = paramLinker.requestBinding("me.lyft.android.application.ILogoutService", CommonModule.class, getClass().getClassLoader());
  }
  
  public IDefaultErrorHandler get()
  {
    return module.provideDefaultErrorHandler((AppFlow)appFlow.get(), (DialogFlow)dialogFlow.get(), (ILogoutService)logoutService.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(appFlow);
    paramSet1.add(dialogFlow);
    paramSet1.add(logoutService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.CommonModule..ModuleAdapter.ProvideDefaultErrorHandlerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */