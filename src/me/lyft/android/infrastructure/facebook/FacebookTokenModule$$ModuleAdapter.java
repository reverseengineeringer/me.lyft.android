package me.lyft.android.infrastructure.facebook;

import dagger.internal.BindingsGroup;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;

public final class FacebookTokenModule$$ModuleAdapter
  extends ModuleAdapter<FacebookTokenModule>
{
  private static final Class<?>[] INCLUDES = new Class[0];
  private static final String[] INJECTS = new String[0];
  private static final Class<?>[] STATIC_INJECTIONS = new Class[0];
  
  public FacebookTokenModule$$ModuleAdapter()
  {
    super(FacebookTokenModule.class, INJECTS, STATIC_INJECTIONS, false, INCLUDES, false, true);
  }
  
  public void getBindings(BindingsGroup paramBindingsGroup, FacebookTokenModule paramFacebookTokenModule)
  {
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.facebook.IFacebookTokenService", new ProvideFacebookTokenServiceProvidesAdapter(paramFacebookTokenModule));
  }
  
  public FacebookTokenModule newModule()
  {
    return new FacebookTokenModule();
  }
  
  public static final class ProvideFacebookTokenServiceProvidesAdapter
    extends ProvidesBinding<IFacebookTokenService>
  {
    private final FacebookTokenModule module;
    
    public ProvideFacebookTokenServiceProvidesAdapter(FacebookTokenModule paramFacebookTokenModule)
    {
      super(false, "me.lyft.android.infrastructure.facebook.FacebookTokenModule", "provideFacebookTokenService");
      module = paramFacebookTokenModule;
      setLibrary(true);
    }
    
    public IFacebookTokenService get()
    {
      return module.provideFacebookTokenService();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.facebook.FacebookTokenModule..ModuleAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */