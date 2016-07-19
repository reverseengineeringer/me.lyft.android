package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.constants.ILeanplumOverrideService;
import me.lyft.android.development.IDeveloperTools;
import me.lyft.android.infrastructure.json.IJsonSerializer;
import me.lyft.android.infrastructure.settings.IAutomationOverrideService;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideSettingsOverrideServiceProvidesAdapter
  extends ProvidesBinding<IAutomationOverrideService>
{
  private Binding<IConstantsProvider> constantsProvider;
  private Binding<IDeveloperTools> developerTools;
  private Binding<IJsonSerializer> jsonSerializer;
  private Binding<ILeanplumOverrideService> leanplumOverrideService;
  private final InfrastructureServicesModule module;
  private Binding<ILyftPreferences> preferences;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideSettingsOverrideServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.settings.IAutomationOverrideService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideSettingsOverrideService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
    constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
    leanplumOverrideService = paramLinker.requestBinding("me.lyft.android.application.constants.ILeanplumOverrideService", InfrastructureServicesModule.class, getClass().getClassLoader());
    jsonSerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.json.IJsonSerializer", InfrastructureServicesModule.class, getClass().getClassLoader());
    developerTools = paramLinker.requestBinding("me.lyft.android.development.IDeveloperTools", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public IAutomationOverrideService get()
  {
    return module.provideSettingsOverrideService((ILyftPreferences)preferences.get(), (IConstantsProvider)constantsProvider.get(), (ILeanplumOverrideService)leanplumOverrideService.get(), (IJsonSerializer)jsonSerializer.get(), (IDeveloperTools)developerTools.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(preferences);
    paramSet1.add(constantsProvider);
    paramSet1.add(leanplumOverrideService);
    paramSet1.add(jsonSerializer);
    paramSet1.add(developerTools);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideSettingsOverrideServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */