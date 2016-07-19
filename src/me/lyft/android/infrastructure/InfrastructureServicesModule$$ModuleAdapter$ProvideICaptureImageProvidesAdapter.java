package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.infrastructure.camera.CaptureImageSession;
import me.lyft.android.infrastructure.camera.ICaptureImage;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideICaptureImageProvidesAdapter
  extends ProvidesBinding<ICaptureImage>
{
  private final InfrastructureServicesModule module;
  private Binding<CaptureImageSession> session;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideICaptureImageProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.camera.ICaptureImage", false, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideICaptureImage");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    session = paramLinker.requestBinding("me.lyft.android.infrastructure.camera.CaptureImageSession", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public ICaptureImage get()
  {
    return module.provideICaptureImage((CaptureImageSession)session.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(session);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideICaptureImageProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */