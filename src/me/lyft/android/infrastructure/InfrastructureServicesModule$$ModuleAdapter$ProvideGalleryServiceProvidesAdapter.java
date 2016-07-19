package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.infrastructure.camera.ICaptureImageSession;
import me.lyft.android.infrastructure.gallery.IGalleryService;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideGalleryServiceProvidesAdapter
  extends ProvidesBinding<IGalleryService>
{
  private Binding<ICaptureImageSession> captureImageSession;
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideGalleryServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.gallery.IGalleryService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideGalleryService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    captureImageSession = paramLinker.requestBinding("me.lyft.android.infrastructure.camera.ICaptureImageSession", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public IGalleryService get()
  {
    return module.provideGalleryService((ICaptureImageSession)captureImageSession.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(captureImageSession);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideGalleryServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */