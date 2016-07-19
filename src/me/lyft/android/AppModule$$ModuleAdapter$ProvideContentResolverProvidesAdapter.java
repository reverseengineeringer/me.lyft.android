package me.lyft.android;

import android.content.ContentResolver;
import dagger.internal.ProvidesBinding;

public final class AppModule$$ModuleAdapter$ProvideContentResolverProvidesAdapter
  extends ProvidesBinding<ContentResolver>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideContentResolverProvidesAdapter(AppModule paramAppModule)
  {
    super("android.content.ContentResolver", false, "me.lyft.android.AppModule", "provideContentResolver");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public ContentResolver get()
  {
    return module.provideContentResolver();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideContentResolverProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */