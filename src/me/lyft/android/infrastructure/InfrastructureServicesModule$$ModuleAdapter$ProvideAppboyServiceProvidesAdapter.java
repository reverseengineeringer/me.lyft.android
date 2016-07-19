package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.infrastructure.appboy.IAppboyService;
import me.lyft.android.infrastructure.gcm.IGcmIdService;
import me.lyft.android.infrastructure.notifications.InAppNotificationService;
import me.lyft.android.managers.ImageLoader;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideAppboyServiceProvidesAdapter
  extends ProvidesBinding<IAppboyService>
{
  private Binding<DialogFlow> dialogFlow;
  private Binding<IGcmIdService> gcmIdService;
  private Binding<ImageLoader> imageLoader;
  private Binding<InAppNotificationService> inAppNotificationService;
  private final InfrastructureServicesModule module;
  private Binding<IUserProvider> userProvider;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideAppboyServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.appboy.IAppboyService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideAppboyService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
    gcmIdService = paramLinker.requestBinding("me.lyft.android.infrastructure.gcm.IGcmIdService", InfrastructureServicesModule.class, getClass().getClassLoader());
    dialogFlow = paramLinker.requestBinding("me.lyft.android.common.DialogFlow", InfrastructureServicesModule.class, getClass().getClassLoader());
    imageLoader = paramLinker.requestBinding("me.lyft.android.managers.ImageLoader", InfrastructureServicesModule.class, getClass().getClassLoader());
    inAppNotificationService = paramLinker.requestBinding("me.lyft.android.infrastructure.notifications.InAppNotificationService", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public IAppboyService get()
  {
    return module.provideAppboyService((IUserProvider)userProvider.get(), (IGcmIdService)gcmIdService.get(), (DialogFlow)dialogFlow.get(), (ImageLoader)imageLoader.get(), (InAppNotificationService)inAppNotificationService.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(userProvider);
    paramSet1.add(gcmIdService);
    paramSet1.add(dialogFlow);
    paramSet1.add(imageLoader);
    paramSet1.add(inAppNotificationService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideAppboyServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */