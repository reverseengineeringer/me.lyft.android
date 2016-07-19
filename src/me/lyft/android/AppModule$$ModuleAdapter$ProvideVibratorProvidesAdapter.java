package me.lyft.android;

import dagger.internal.ProvidesBinding;
import me.lyft.android.utils.Vibrator;

public final class AppModule$$ModuleAdapter$ProvideVibratorProvidesAdapter
  extends ProvidesBinding<Vibrator>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideVibratorProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.utils.Vibrator", true, "me.lyft.android.AppModule", "provideVibrator");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public Vibrator get()
  {
    return module.provideVibrator();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideVibratorProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */