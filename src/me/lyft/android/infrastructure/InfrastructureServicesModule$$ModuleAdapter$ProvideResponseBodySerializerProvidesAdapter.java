package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.infrastructure.api.IJsonBodySerializer;
import me.lyft.android.infrastructure.json.IJsonSerializer;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideResponseBodySerializerProvidesAdapter
  extends ProvidesBinding<IJsonBodySerializer>
{
  private Binding<IJsonSerializer> jsonSerializer;
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideResponseBodySerializerProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.api.IJsonBodySerializer", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideResponseBodySerializer");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    jsonSerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.json.IJsonSerializer", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public IJsonBodySerializer get()
  {
    return module.provideResponseBodySerializer((IJsonSerializer)jsonSerializer.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(jsonSerializer);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideResponseBodySerializerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */