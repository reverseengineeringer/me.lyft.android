package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.notifications.InAppNotificationService;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideInAppNotificationServiceProvidesAdapter
  extends ProvidesBinding<InAppNotificationService>
{
  private Binding<DialogFlow> dialogFlow;
  private Binding<ILyftApi> lyftApi;
  private Binding<ILyftPreferences> lyftPreferences;
  private final InfrastructureServicesModule module;
  private Binding<IUserProvider> userProvider;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideInAppNotificationServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.notifications.InAppNotificationService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideInAppNotificationService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", InfrastructureServicesModule.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
    lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
    dialogFlow = paramLinker.requestBinding("me.lyft.android.common.DialogFlow", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public InAppNotificationService get()
  {
    return module.provideInAppNotificationService((ILyftApi)lyftApi.get(), (IUserProvider)userProvider.get(), (ILyftPreferences)lyftPreferences.get(), (DialogFlow)dialogFlow.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApi);
    paramSet1.add(userProvider);
    paramSet1.add(lyftPreferences);
    paramSet1.add(dialogFlow);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideInAppNotificationServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */