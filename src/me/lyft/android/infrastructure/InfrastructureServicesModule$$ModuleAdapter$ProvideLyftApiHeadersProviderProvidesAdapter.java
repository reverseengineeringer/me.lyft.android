package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.infrastructure.api.ILyftApiHeadersProvider;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.infrastructure.json.IJsonSerializer;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideLyftApiHeadersProviderProvidesAdapter
  extends ProvidesBinding<ILyftApiHeadersProvider>
{
  private Binding<IDevice> device;
  private Binding<IJsonSerializer> jsonSerializer;
  private Binding<ILyftPreferences> lyftPreferences;
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideLyftApiHeadersProviderProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.api.ILyftApiHeadersProvider", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideLyftApiHeadersProvider");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    device = paramLinker.requestBinding("me.lyft.android.infrastructure.device.IDevice", InfrastructureServicesModule.class, getClass().getClassLoader());
    lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
    jsonSerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.json.IJsonSerializer", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public ILyftApiHeadersProvider get()
  {
    return module.provideLyftApiHeadersProvider((IDevice)device.get(), (ILyftPreferences)lyftPreferences.get(), (IJsonSerializer)jsonSerializer.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(device);
    paramSet1.add(lyftPreferences);
    paramSet1.add(jsonSerializer);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideLyftApiHeadersProviderProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */