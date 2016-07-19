package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.LyftApplication;
import me.lyft.android.infrastructure.share.IShareService;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideIShareServiceProvidesAdapter
  extends ProvidesBinding<IShareService>
{
  private Binding<LyftApplication> application;
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideIShareServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.share.IShareService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideIShareService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    application = paramLinker.requestBinding("me.lyft.android.LyftApplication", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public IShareService get()
  {
    return module.provideIShareService((LyftApplication)application.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(application);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideIShareServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */