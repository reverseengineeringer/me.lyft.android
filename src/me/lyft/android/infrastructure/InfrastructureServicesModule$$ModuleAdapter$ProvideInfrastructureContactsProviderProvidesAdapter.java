package me.lyft.android.infrastructure;

import android.content.ContentResolver;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.infrastructure.contacts.IAndroidContactsProvider;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideInfrastructureContactsProviderProvidesAdapter
  extends ProvidesBinding<IAndroidContactsProvider>
{
  private Binding<ContentResolver> contentResolver;
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideInfrastructureContactsProviderProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.contacts.IAndroidContactsProvider", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideInfrastructureContactsProvider");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    contentResolver = paramLinker.requestBinding("android.content.ContentResolver", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public IAndroidContactsProvider get()
  {
    return module.provideInfrastructureContactsProvider((ContentResolver)contentResolver.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(contentResolver);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideInfrastructureContactsProviderProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */