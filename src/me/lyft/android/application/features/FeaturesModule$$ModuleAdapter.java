package me.lyft.android.application.features;

import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.Linker;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.LyftApplication;

public final class FeaturesModule$$ModuleAdapter
  extends ModuleAdapter<FeaturesModule>
{
  private static final Class<?>[] INCLUDES = new Class[0];
  private static final String[] INJECTS = new String[0];
  private static final Class<?>[] STATIC_INJECTIONS = new Class[0];
  
  public FeaturesModule$$ModuleAdapter()
  {
    super(FeaturesModule.class, INJECTS, STATIC_INJECTIONS, false, INCLUDES, false, true);
  }
  
  public void getBindings(BindingsGroup paramBindingsGroup, FeaturesModule paramFeaturesModule)
  {
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.features.IFeatureFlagOverrideStorage", new ProvideFeatureFlagManagerProvidesAdapter(paramFeaturesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.features.IFeatureFlagsOverrideManager", new ProvideFeatureFlagManagerProvidesAdapter2(paramFeaturesModule));
  }
  
  public FeaturesModule newModule()
  {
    return new FeaturesModule();
  }
  
  public static final class ProvideFeatureFlagManagerProvidesAdapter
    extends ProvidesBinding<IFeatureFlagOverrideStorage>
  {
    private Binding<LyftApplication> context;
    private final FeaturesModule module;
    
    public ProvideFeatureFlagManagerProvidesAdapter(FeaturesModule paramFeaturesModule)
    {
      super(true, "me.lyft.android.application.features.FeaturesModule", "provideFeatureFlagManager");
      module = paramFeaturesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      context = paramLinker.requestBinding("me.lyft.android.LyftApplication", FeaturesModule.class, getClass().getClassLoader());
    }
    
    public IFeatureFlagOverrideStorage get()
    {
      return module.provideFeatureFlagManager((LyftApplication)context.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(context);
    }
  }
  
  public static final class ProvideFeatureFlagManagerProvidesAdapter2
    extends ProvidesBinding<IFeatureFlagsOverrideManager>
  {
    private final FeaturesModule module;
    private Binding<IFeatureFlagOverrideStorage> storage;
    
    public ProvideFeatureFlagManagerProvidesAdapter2(FeaturesModule paramFeaturesModule)
    {
      super(true, "me.lyft.android.application.features.FeaturesModule", "provideFeatureFlagManager");
      module = paramFeaturesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      storage = paramLinker.requestBinding("me.lyft.android.application.features.IFeatureFlagOverrideStorage", FeaturesModule.class, getClass().getClassLoader());
    }
    
    public IFeatureFlagsOverrideManager get()
    {
      return module.provideFeatureFlagManager((IFeatureFlagOverrideStorage)storage.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(storage);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.features.FeaturesModule..ModuleAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */