package me.lyft.android;

import com.squareup.okhttp.OkHttpClient;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.development.IDeveloperTools;
import me.lyft.android.infrastructure.device.IDevice;

public final class AppModule$$ModuleAdapter$OkHttpClientProvidesAdapter
  extends ProvidesBinding<OkHttpClient>
{
  private Binding<IConstantsProvider> constantsProvider;
  private Binding<IDeveloperTools> developerTools;
  private Binding<IDevice> device;
  private final AppModule module;
  private Binding<ILyftPreferences> preferences;
  
  public AppModule$$ModuleAdapter$OkHttpClientProvidesAdapter(AppModule paramAppModule)
  {
    super("com.squareup.okhttp.OkHttpClient", true, "me.lyft.android.AppModule", "okHttpClient");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", AppModule.class, getClass().getClassLoader());
    constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", AppModule.class, getClass().getClassLoader());
    device = paramLinker.requestBinding("me.lyft.android.infrastructure.device.IDevice", AppModule.class, getClass().getClassLoader());
    developerTools = paramLinker.requestBinding("me.lyft.android.development.IDeveloperTools", AppModule.class, getClass().getClassLoader());
  }
  
  public OkHttpClient get()
  {
    return module.okHttpClient((ILyftPreferences)preferences.get(), (IConstantsProvider)constantsProvider.get(), (IDevice)device.get(), (IDeveloperTools)developerTools.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(preferences);
    paramSet1.add(constantsProvider);
    paramSet1.add(device);
    paramSet1.add(developerTools);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.OkHttpClientProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */