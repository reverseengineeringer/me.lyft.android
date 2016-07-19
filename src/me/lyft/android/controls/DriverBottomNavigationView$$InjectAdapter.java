package me.lyft.android.controls;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.common.AppFlow;

public final class DriverBottomNavigationView$$InjectAdapter
  extends Binding<DriverBottomNavigationView>
{
  private Binding<AppFlow> appFlow;
  private Binding<IFeaturesProvider> featuresProvider;
  
  public DriverBottomNavigationView$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.controls.DriverBottomNavigationView", false, DriverBottomNavigationView.class);
  }
  
  public void attach(Linker paramLinker)
  {
    appFlow = paramLinker.requestBinding("me.lyft.android.common.AppFlow", DriverBottomNavigationView.class, getClass().getClassLoader());
    featuresProvider = paramLinker.requestBinding("me.lyft.android.application.features.IFeaturesProvider", DriverBottomNavigationView.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(appFlow);
    paramSet2.add(featuresProvider);
  }
  
  public void injectMembers(DriverBottomNavigationView paramDriverBottomNavigationView)
  {
    appFlow = ((AppFlow)appFlow.get());
    featuresProvider = ((IFeaturesProvider)featuresProvider.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.DriverBottomNavigationView..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */