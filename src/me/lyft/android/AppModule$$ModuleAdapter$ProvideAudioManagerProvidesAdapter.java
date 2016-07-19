package me.lyft.android;

import android.media.AudioManager;
import dagger.internal.ProvidesBinding;

public final class AppModule$$ModuleAdapter$ProvideAudioManagerProvidesAdapter
  extends ProvidesBinding<AudioManager>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideAudioManagerProvidesAdapter(AppModule paramAppModule)
  {
    super("android.media.AudioManager", true, "me.lyft.android.AppModule", "provideAudioManager");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public AudioManager get()
  {
    return module.provideAudioManager();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideAudioManagerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */