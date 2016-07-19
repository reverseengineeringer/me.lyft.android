package me.lyft.android.infrastructure;

import com.squareup.okhttp.OkHttpClient;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.infrastructure.api.IJsonBodySerializer;
import me.lyft.android.infrastructure.api.ILyftApiHeadersProvider;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.infrastructure.lyft.IAppStateHandler;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideLyftApiProvidesAdapter
  extends ProvidesBinding<ILyftApi>
{
  private Binding<IDevice> device;
  private Binding<IAppStateHandler> handler;
  private Binding<IJsonBodySerializer> jsonBodySerializer;
  private Binding<ILyftApiHeadersProvider> lyftApiHeadersProvider;
  private final InfrastructureServicesModule module;
  private Binding<OkHttpClient> okHttpClient;
  private Binding<ILyftPreferences> preferences;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideLyftApiProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.lyft.ILyftApi", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideLyftApi");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    okHttpClient = paramLinker.requestBinding("com.squareup.okhttp.OkHttpClient", InfrastructureServicesModule.class, getClass().getClassLoader());
    jsonBodySerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.api.IJsonBodySerializer", InfrastructureServicesModule.class, getClass().getClassLoader());
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
    device = paramLinker.requestBinding("me.lyft.android.infrastructure.device.IDevice", InfrastructureServicesModule.class, getClass().getClassLoader());
    handler = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.IAppStateHandler", InfrastructureServicesModule.class, getClass().getClassLoader());
    lyftApiHeadersProvider = paramLinker.requestBinding("me.lyft.android.infrastructure.api.ILyftApiHeadersProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public ILyftApi get()
  {
    return module.provideLyftApi((OkHttpClient)okHttpClient.get(), (IJsonBodySerializer)jsonBodySerializer.get(), (ILyftPreferences)preferences.get(), (IDevice)device.get(), (IAppStateHandler)handler.get(), (ILyftApiHeadersProvider)lyftApiHeadersProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(okHttpClient);
    paramSet1.add(jsonBodySerializer);
    paramSet1.add(preferences);
    paramSet1.add(device);
    paramSet1.add(handler);
    paramSet1.add(lyftApiHeadersProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideLyftApiProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */