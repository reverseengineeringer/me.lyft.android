package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.infrastructure.profile.IProfilePhotoLoader;
import me.lyft.android.infrastructure.profile.ProfilePhotoLoader;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideIProfilePhotoLoaderProvidesAdapter
  extends ProvidesBinding<IProfilePhotoLoader>
{
  private final InfrastructureServicesModule module;
  private Binding<ProfilePhotoLoader> myProfilePhotoLoader;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideIProfilePhotoLoaderProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.profile.IProfilePhotoLoader", false, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideIProfilePhotoLoader");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    myProfilePhotoLoader = paramLinker.requestBinding("me.lyft.android.infrastructure.profile.ProfilePhotoLoader", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public IProfilePhotoLoader get()
  {
    return module.provideIProfilePhotoLoader((ProfilePhotoLoader)myProfilePhotoLoader.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(myProfilePhotoLoader);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideIProfilePhotoLoaderProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */