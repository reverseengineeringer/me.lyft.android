package me.lyft.android;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.development.IDeveloperTools;

public final class AppModule$$ModuleAdapter$ProvideDeveloperToolsProvidesAdapter
  extends ProvidesBinding<IDeveloperTools>
{
  private Binding<LyftApplication> lyftApplication;
  private Binding<ILyftPreferences> lyftPreferences;
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideDeveloperToolsProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.development.IDeveloperTools", true, "me.lyft.android.AppModule", "provideDeveloperTools");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", AppModule.class, getClass().getClassLoader());
    lyftApplication = paramLinker.requestBinding("me.lyft.android.LyftApplication", AppModule.class, getClass().getClassLoader());
  }
  
  public IDeveloperTools get()
  {
    return module.provideDeveloperTools((ILyftPreferences)lyftPreferences.get(), (LyftApplication)lyftApplication.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftPreferences);
    paramSet1.add(lyftApplication);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideDeveloperToolsProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */