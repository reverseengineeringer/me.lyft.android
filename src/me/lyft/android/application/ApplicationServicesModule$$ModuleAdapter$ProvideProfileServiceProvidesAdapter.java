package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.profile.IProfilePhotoFileRecipient;
import me.lyft.android.application.profile.IProfileService;
import me.lyft.android.infrastructure.environment.IS3Api;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideProfileServiceProvidesAdapter
  extends ProvidesBinding<IProfileService>
{
  private Binding<ILyftApi> api;
  private final ApplicationServicesModule module;
  private Binding<IProfilePhotoFileRecipient> profilePhotoFileRecipient;
  private Binding<IS3Api> s3Api;
  private Binding<IUserProvider> userProvider;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideProfileServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.profile.IProfileService", true, "me.lyft.android.application.ApplicationServicesModule", "provideProfileService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    s3Api = paramLinker.requestBinding("me.lyft.android.infrastructure.environment.IS3Api", ApplicationServicesModule.class, getClass().getClassLoader());
    api = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    profilePhotoFileRecipient = paramLinker.requestBinding("me.lyft.android.application.profile.IProfilePhotoFileRecipient", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IProfileService get()
  {
    return module.provideProfileService((IUserProvider)userProvider.get(), (IS3Api)s3Api.get(), (ILyftApi)api.get(), (IProfilePhotoFileRecipient)profilePhotoFileRecipient.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(userProvider);
    paramSet1.add(s3Api);
    paramSet1.add(api);
    paramSet1.add(profilePhotoFileRecipient);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideProfileServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */