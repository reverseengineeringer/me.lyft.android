package me.lyft.android.common;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.LyftApplication;

public final class CommonModule$$ModuleAdapter$ProvideAppStoreProvidesAdapter
  extends ProvidesBinding<IAppStore>
{
  private Binding<LyftApplication> application;
  private final CommonModule module;
  
  public CommonModule$$ModuleAdapter$ProvideAppStoreProvidesAdapter(CommonModule paramCommonModule)
  {
    super("me.lyft.android.common.IAppStore", true, "me.lyft.android.common.CommonModule", "provideAppStore");
    module = paramCommonModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    application = paramLinker.requestBinding("me.lyft.android.LyftApplication", CommonModule.class, getClass().getClassLoader());
  }
  
  public IAppStore get()
  {
    return module.provideAppStore((LyftApplication)application.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(application);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.CommonModule..ModuleAdapter.ProvideAppStoreProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */