package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.LyftApplication;
import me.lyft.android.infrastructure.assets.IAssetLoadingService;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.managers.ImageLoader;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideLoadingServiceProvidesAdapter
  extends ProvidesBinding<IAssetLoadingService>
{
  private Binding<IDevice> device;
  private Binding<ImageLoader> imageLoader;
  private Binding<LyftApplication> lyftApplication;
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideLoadingServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.assets.IAssetLoadingService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideLoadingService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApplication = paramLinker.requestBinding("me.lyft.android.LyftApplication", InfrastructureServicesModule.class, getClass().getClassLoader());
    device = paramLinker.requestBinding("me.lyft.android.infrastructure.device.IDevice", InfrastructureServicesModule.class, getClass().getClassLoader());
    imageLoader = paramLinker.requestBinding("me.lyft.android.managers.ImageLoader", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public IAssetLoadingService get()
  {
    return module.provideLoadingService((LyftApplication)lyftApplication.get(), (IDevice)device.get(), (ImageLoader)imageLoader.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApplication);
    paramSet1.add(device);
    paramSet1.add(imageLoader);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideLoadingServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */