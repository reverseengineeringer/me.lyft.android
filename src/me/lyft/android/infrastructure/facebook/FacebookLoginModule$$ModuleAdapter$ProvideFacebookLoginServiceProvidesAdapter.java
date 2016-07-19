package me.lyft.android.infrastructure.facebook;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.infrastructure.activity.IActivityLifecycleService;

public final class FacebookLoginModule$$ModuleAdapter$ProvideFacebookLoginServiceProvidesAdapter
  extends ProvidesBinding<IFacebookLoginService>
{
  private Binding<IActivityLifecycleService> activityLifecycleService;
  private final FacebookLoginModule module;
  
  public FacebookLoginModule$$ModuleAdapter$ProvideFacebookLoginServiceProvidesAdapter(FacebookLoginModule paramFacebookLoginModule)
  {
    super("me.lyft.android.infrastructure.facebook.IFacebookLoginService", false, "me.lyft.android.infrastructure.facebook.FacebookLoginModule", "provideFacebookLoginService");
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

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.facebook.FacebookLoginModule..ModuleAdapter.ProvideFacebookLoginServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */