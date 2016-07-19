package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.shortcuts.IShortcutService;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideShortcutServiceProvidesAdapter
  extends ProvidesBinding<IShortcutService>
{
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  private Binding<IUserProvider> userProvider;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideShortcutServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.shortcuts.IShortcutService", true, "me.lyft.android.application.ApplicationServicesModule", "provideShortcutService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IShortcutService get()
  {
    return module.provideShortcutService((IUserProvider)userProvider.get(), (ILyftApi)lyftApi.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(userProvider);
    paramSet1.add(lyftApi);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideShortcutServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */