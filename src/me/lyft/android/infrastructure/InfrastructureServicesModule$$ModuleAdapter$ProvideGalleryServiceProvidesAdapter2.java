package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.infrastructure.camera.ICaptureImage;
import me.lyft.android.infrastructure.photo.IPhotoPickerService;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideGalleryServiceProvidesAdapter2
  extends ProvidesBinding<IPhotoPickerService>
{
  private Binding<ICaptureImage> captureImage;
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideGalleryServiceProvidesAdapter2(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.photo.IPhotoPickerService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideGalleryService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    captureImage = paramLinker.requestBinding("me.lyft.android.infrastructure.camera.ICaptureImage", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public IPhotoPickerService get()
  {
    return module.provideGalleryService((ICaptureImage)captureImage.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(captureImage);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideGalleryServiceProvidesAdapter2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */