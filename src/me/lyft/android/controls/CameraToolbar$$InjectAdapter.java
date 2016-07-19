package me.lyft.android.controls;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.common.AppFlow;

public final class CameraToolbar$$InjectAdapter
  extends Binding<CameraToolbar>
{
  private Binding<AppFlow> appFlow;
  private Binding<Toolbar> supertype;
  
  public CameraToolbar$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.controls.CameraToolbar", false, CameraToolbar.class);
  }
  
  public void attach(Linker paramLinker)
  {
    appFlow = paramLinker.requestBinding("me.lyft.android.common.AppFlow", CameraToolbar.class, getClass().getClassLoader());
    supertype = paramLinker.requestBinding("members/me.lyft.android.controls.Toolbar", CameraToolbar.class, getClass().getClassLoader(), false, true);
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(appFlow);
    paramSet2.add(supertype);
  }
  
  public void injectMembers(CameraToolbar paramCameraToolbar)
  {
    appFlow = ((AppFlow)appFlow.get());
    supertype.injectMembers(paramCameraToolbar);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.CameraToolbar..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */