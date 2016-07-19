package me.lyft.android.infrastructure.facebook;

import dagger.internal.ProvidesBinding;

public final class FacebookTokenModule$$ModuleAdapter$ProvideFacebookTokenServiceProvidesAdapter
  extends ProvidesBinding<IFacebookTokenService>
{
  private final FacebookTokenModule module;
  
  public FacebookTokenModule$$ModuleAdapter$ProvideFacebookTokenServiceProvidesAdapter(FacebookTokenModule paramFacebookTokenModule)
  {
    super("me.lyft.android.infrastructure.facebook.IFacebookTokenService", false, "me.lyft.android.infrastructure.facebook.FacebookTokenModule", "provideFacebookTokenService");
    module = paramFacebookTokenModule;
    setLibrary(true);
  }
  
  public IFacebookTokenService get()
  {
    return module.provideFacebookTokenService();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.facebook.FacebookTokenModule..ModuleAdapter.ProvideFacebookTokenServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */