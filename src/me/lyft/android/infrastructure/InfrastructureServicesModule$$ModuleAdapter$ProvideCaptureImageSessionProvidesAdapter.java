package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.common.AppFlow;
import me.lyft.android.infrastructure.camera.CaptureImageSession;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideCaptureImageSessionProvidesAdapter
  extends ProvidesBinding<CaptureImageSession>
{
  private Binding<AppFlow> appFlow;
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideCaptureImageSessionProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.camera.CaptureImageSession", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideCaptureImageSession");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    appFlow = paramLinker.requestBinding("me.lyft.android.common.AppFlow", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public CaptureImageSession get()
  {
    return module.provideCaptureImageSession((AppFlow)appFlow.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(appFlow);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideCaptureImageSessionProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */