package me.lyft.android.infrastructure;

import com.squareup.okhttp.OkHttpClient;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.LyftApplication;
import me.lyft.android.infrastructure.assets.IAssetPackagingService;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideAssetPackagingServiceProvidesAdapter
  extends ProvidesBinding<IAssetPackagingService>
{
  private Binding<LyftApplication> lyftApplication;
  private final InfrastructureServicesModule module;
  private Binding<OkHttpClient> okHttpClient;
  private Binding<ILyftPreferences> preferences;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideAssetPackagingServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.assets.IAssetPackagingService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideAssetPackagingService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApplication = paramLinker.requestBinding("me.lyft.android.LyftApplication", InfrastructureServicesModule.class, getClass().getClassLoader());
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
    okHttpClient = paramLinker.requestBinding("com.squareup.okhttp.OkHttpClient", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public IAssetPackagingService get()
  {
    return module.provideAssetPackagingService((LyftApplication)lyftApplication.get(), (ILyftPreferences)preferences.get(), (OkHttpClient)okHttpClient.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApplication);
    paramSet1.add(preferences);
    paramSet1.add(okHttpClient);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideAssetPackagingServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */