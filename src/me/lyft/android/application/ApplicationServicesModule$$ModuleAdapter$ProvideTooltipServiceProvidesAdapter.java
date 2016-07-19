package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.tooltip.ITooltipService;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideTooltipServiceProvidesAdapter
  extends ProvidesBinding<ITooltipService>
{
  private Binding<IConstantsProvider> constantsProvider;
  private Binding<ILyftPreferences> lyftPreferences;
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideTooltipServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.tooltip.ITooltipService", true, "me.lyft.android.application.ApplicationServicesModule", "provideTooltipService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", ApplicationServicesModule.class, getClass().getClassLoader());
    constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public ITooltipService get()
  {
    return module.provideTooltipService((ILyftPreferences)lyftPreferences.get(), (IConstantsProvider)constantsProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftPreferences);
    paramSet1.add(constantsProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideTooltipServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */