package me.lyft.android;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.infrastructure.lyft.IAppStateHandler;

public final class AppModule$$ModuleAdapter$ProvideAppStateHandlerProvidesAdapter
  extends ProvidesBinding<IAppStateHandler>
{
  private final AppModule module;
  private Binding<IUserSession> userSession;
  
  public AppModule$$ModuleAdapter$ProvideAppStateHandlerProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.infrastructure.lyft.IAppStateHandler", true, "me.lyft.android.AppModule", "provideAppStateHandler");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    userSession = paramLinker.requestBinding("me.lyft.android.IUserSession", AppModule.class, getClass().getClassLoader());
  }
  
  public IAppStateHandler get()
  {
    return module.provideAppStateHandler((IUserSession)userSession.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(userSession);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideAppStateHandlerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */