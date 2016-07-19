package me.lyft.android;

import com.squareup.okhttp.OkHttpClient;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.managers.ImageLoader;

public final class AppModule$$ModuleAdapter$ProvideImageLoaderProvidesAdapter
  extends ProvidesBinding<ImageLoader>
{
  private final AppModule module;
  private Binding<OkHttpClient> okHttpClient;
  
  public AppModule$$ModuleAdapter$ProvideImageLoaderProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.managers.ImageLoader", true, "me.lyft.android.AppModule", "provideImageLoader");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    okHttpClient = paramLinker.requestBinding("com.squareup.okhttp.OkHttpClient", AppModule.class, getClass().getClassLoader());
  }
  
  public ImageLoader get()
  {
    return module.provideImageLoader((OkHttpClient)okHttpClient.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(okHttpClient);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideImageLoaderProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */