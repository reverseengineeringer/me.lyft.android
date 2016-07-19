package me.lyft.android.infrastructure.facebook;

import dagger.Module;
import dagger.Provides;

@Module(complete=false, library=true)
public class FacebookTokenModule
{
  @Provides
  public IFacebookTokenService provideFacebookTokenService()
  {
    return new FacebookTokenService();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.facebook.FacebookTokenModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */