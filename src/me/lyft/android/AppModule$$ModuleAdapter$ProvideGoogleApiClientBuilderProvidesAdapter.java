package me.lyft.android;

import com.google.android.gms.common.api.GoogleApiClient.Builder;
import dagger.internal.ProvidesBinding;

public final class AppModule$$ModuleAdapter$ProvideGoogleApiClientBuilderProvidesAdapter
  extends ProvidesBinding<GoogleApiClient.Builder>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideGoogleApiClientBuilderProvidesAdapter(AppModule paramAppModule)
  {
    super("com.google.android.gms.common.api.GoogleApiClient$Builder", false, "me.lyft.android.AppModule", "provideGoogleApiClientBuilder");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public GoogleApiClient.Builder get()
  {
    return module.provideGoogleApiClientBuilder();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideGoogleApiClientBuilderProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */