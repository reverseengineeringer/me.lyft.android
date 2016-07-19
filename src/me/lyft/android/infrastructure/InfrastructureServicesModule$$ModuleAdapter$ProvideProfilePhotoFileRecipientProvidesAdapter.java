package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.profile.IProfilePhotoFileRecipient;
import me.lyft.android.infrastructure.profile.ProfilePhotoLoader;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideProfilePhotoFileRecipientProvidesAdapter
  extends ProvidesBinding<IProfilePhotoFileRecipient>
{
  private final InfrastructureServicesModule module;
  private Binding<ProfilePhotoLoader> myProfilePhotoLoader;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideProfilePhotoFileRecipientProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.application.profile.IProfilePhotoFileRecipient", false, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideProfilePhotoFileRecipient");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    myProfilePhotoLoader = paramLinker.requestBinding("me.lyft.android.infrastructure.profile.ProfilePhotoLoader", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public IProfilePhotoFileRecipient get()
  {
    return module.provideProfilePhotoFileRecipient((ProfilePhotoLoader)myProfilePhotoLoader.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(myProfilePhotoLoader);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideProfilePhotoFileRecipientProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */