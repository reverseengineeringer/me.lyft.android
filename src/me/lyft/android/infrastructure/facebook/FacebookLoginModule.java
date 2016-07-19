package me.lyft.android.infrastructure.facebook;

import dagger.Module;
import dagger.Provides;
import me.lyft.android.infrastructure.activity.IActivityLifecycleService;

@Module(complete=false, library=true)
public class FacebookLoginModule
{
  @Provides
  public IFacebookLoginService provideFacebookLoginService(IActivityLifecycleService paramIActivityLifecycleService)
  {
    return new FacebookLoginService(paramIActivityLifecycleService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.facebook.FacebookLoginModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */