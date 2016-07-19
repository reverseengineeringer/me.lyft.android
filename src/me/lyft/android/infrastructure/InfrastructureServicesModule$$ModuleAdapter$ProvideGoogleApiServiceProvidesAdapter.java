package me.lyft.android.infrastructure;

import com.squareup.okhttp.OkHttpClient;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.infrastructure.api.IJsonBodySerializer;
import me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideGoogleApiServiceProvidesAdapter
  extends ProvidesBinding<IGoogleGeoApi>
{
  private Binding<IJsonBodySerializer> jsonBodySerializer;
  private final InfrastructureServicesModule module;
  private Binding<OkHttpClient> okHttpClient;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideGoogleApiServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideGoogleApiService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    okHttpClient = paramLinker.requestBinding("com.squareup.okhttp.OkHttpClient", InfrastructureServicesModule.class, getClass().getClassLoader());
    jsonBodySerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.api.IJsonBodySerializer", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public IGoogleGeoApi get()
  {
    return module.provideGoogleApiService((OkHttpClient)okHttpClient.get(), (IJsonBodySerializer)jsonBodySerializer.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(okHttpClient);
    paramSet1.add(jsonBodySerializer);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideGoogleApiServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */