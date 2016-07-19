package me.lyft.android.infrastructure.facebook;

import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.Linker;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.infrastructure.activity.IActivityLifecycleService;

public final class FacebookLoginModule$$ModuleAdapter
  extends ModuleAdapter<FacebookLoginModule>
{
  private static final Class<?>[] INCLUDES = new Class[0];
  private static final String[] INJECTS = new String[0];
  private static final Class<?>[] STATIC_INJECTIONS = new Class[0];
  
  public FacebookLoginModule$$ModuleAdapter()
  {
    super(FacebookLoginModule.class, INJECTS, STATIC_INJECTIONS, false, INCLUDES, false, true);
  }
  
  public void getBindings(BindingsGroup paramBindingsGroup, FacebookLoginModule paramFacebookLoginModule)
  {
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.facebook.IFacebookLoginService", new ProvideFacebookLoginServiceProvidesAdapter(paramFacebookLoginModule));
  }
  
  public FacebookLoginModule newModule()
  {
    return new FacebookLoginModule();
  }
  
  public static final class ProvideFacebookLoginServiceProvidesAdapter
    extends ProvidesBinding<IFacebookLoginService>
  {
    private Binding<IActivityLifecycleService> activityLifecycleService;
    private final FacebookLoginModule module;
    
    public ProvideFacebookLoginServiceProvidesAdapter(FacebookLoginModule paramFacebookLoginModule)
    {
      super(false, "me.lyft.android.infrastructure.facebook.FacebookLoginModule", "provideFacebookLoginService");
      module = paramFacebookLoginModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      activityLifecycleService = paramLinker.requestBinding("me.lyft.android.infrastructure.activity.IActivityLifecycleService", FacebookLoginModule.class, getClass().getClassLoader());
    }
    
    public IFacebookLoginService get()
    {
      return module.provideFacebookLoginService((IActivityLifecycleService)activityLifecycleService.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(activityLifecycleService);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.facebook.FacebookLoginModule..ModuleAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */