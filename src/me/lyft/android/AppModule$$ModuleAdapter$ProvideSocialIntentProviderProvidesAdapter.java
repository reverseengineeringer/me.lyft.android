package me.lyft.android;

import dagger.internal.ProvidesBinding;
import me.lyft.android.ui.invites.SocialIntentProvider;

public final class AppModule$$ModuleAdapter$ProvideSocialIntentProviderProvidesAdapter
  extends ProvidesBinding<SocialIntentProvider>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideSocialIntentProviderProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.ui.invites.SocialIntentProvider", true, "me.lyft.android.AppModule", "provideSocialIntentProvider");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public SocialIntentProvider get()
  {
    return module.provideSocialIntentProvider();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideSocialIntentProviderProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */