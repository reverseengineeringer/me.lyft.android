package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.infrastructure.camera.CaptureImageSession;
import me.lyft.android.infrastructure.camera.ICaptureImageSession;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideICaptureImageSessionProvidesAdapter
  extends ProvidesBinding<ICaptureImageSession>
{
  private final InfrastructureServicesModule module;
  private Binding<CaptureImageSession> session;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideICaptureImageSessionProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.camera.ICaptureImageSession", false, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideICaptureImageSession");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    session = paramLinker.requestBinding("me.lyft.android.infrastructure.camera.CaptureImageSession", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public ICaptureImageSession get()
  {
    return module.provideICaptureImageSession((CaptureImageSession)session.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(session);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideICaptureImageSessionProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */