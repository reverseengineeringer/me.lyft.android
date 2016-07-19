package me.lyft.android.application.features;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.LyftApplication;

public final class FeaturesModule$$ModuleAdapter$ProvideFeatureFlagManagerProvidesAdapter
  extends ProvidesBinding<IFeatureFlagOverrideStorage>
{
  private Binding<LyftApplication> context;
  private final FeaturesModule module;
  
  public FeaturesModule$$ModuleAdapter$ProvideFeatureFlagManagerProvidesAdapter(FeaturesModule paramFeaturesModule)
  {
    super("me.lyft.android.application.features.IFeatureFlagOverrideStorage", true, "me.lyft.android.application.features.FeaturesModule", "provideFeatureFlagManager");
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

/* Location:
 * Qualified Name:     me.lyft.android.application.features.FeaturesModule..ModuleAdapter.ProvideFeatureFlagManagerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */