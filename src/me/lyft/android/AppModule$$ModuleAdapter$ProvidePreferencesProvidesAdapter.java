package me.lyft.android;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.infrastructure.json.IJsonSerializer;

public final class AppModule$$ModuleAdapter$ProvidePreferencesProvidesAdapter
  extends ProvidesBinding<ILyftPreferences>
{
  private Binding<LyftApplication> app;
  private Binding<IJsonSerializer> jsonSerializer;
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvidePreferencesProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.ILyftPreferences", true, "me.lyft.android.AppModule", "providePreferences");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    app = paramLinker.requestBinding("me.lyft.android.LyftApplication", AppModule.class, getClass().getClassLoader());
    jsonSerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.json.IJsonSerializer", AppModule.class, getClass().getClassLoader());
  }
  
  public ILyftPreferences get()
  {
    return module.providePreferences((LyftApplication)app.get(), (IJsonSerializer)jsonSerializer.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(app);
    paramSet1.add(jsonSerializer);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvidePreferencesProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */