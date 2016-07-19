package me.lyft.android;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.gcm.IGcmSerializer;
import me.lyft.android.infrastructure.json.IJsonSerializer;

public final class AppModule$$ModuleAdapter$ProvideGcmSerializerProvidesAdapter
  extends ProvidesBinding<IGcmSerializer>
{
  private Binding<IJsonSerializer> jsonSerializer;
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideGcmSerializerProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.gcm.IGcmSerializer", true, "me.lyft.android.AppModule", "provideGcmSerializer");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    jsonSerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.json.IJsonSerializer", AppModule.class, getClass().getClassLoader());
  }
  
  public IGcmSerializer get()
  {
    return module.provideGcmSerializer((IJsonSerializer)jsonSerializer.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(jsonSerializer);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideGcmSerializerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */