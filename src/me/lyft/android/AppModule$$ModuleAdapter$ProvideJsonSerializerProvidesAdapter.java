package me.lyft.android;

import dagger.internal.ProvidesBinding;
import me.lyft.android.infrastructure.json.IJsonSerializer;

public final class AppModule$$ModuleAdapter$ProvideJsonSerializerProvidesAdapter
  extends ProvidesBinding<IJsonSerializer>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideJsonSerializerProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.infrastructure.json.IJsonSerializer", true, "me.lyft.android.AppModule", "provideJsonSerializer");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public IJsonSerializer get()
  {
    return module.provideJsonSerializer();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideJsonSerializerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */