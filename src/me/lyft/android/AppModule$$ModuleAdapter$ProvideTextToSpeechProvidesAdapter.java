package me.lyft.android;

import dagger.internal.ProvidesBinding;
import me.lyft.android.utils.TextToSpeech;

public final class AppModule$$ModuleAdapter$ProvideTextToSpeechProvidesAdapter
  extends ProvidesBinding<TextToSpeech>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideTextToSpeechProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.utils.TextToSpeech", true, "me.lyft.android.AppModule", "provideTextToSpeech");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public TextToSpeech get()
  {
    return module.provideTextToSpeech();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideTextToSpeechProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */