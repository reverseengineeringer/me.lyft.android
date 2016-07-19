package me.lyft.android.controls;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.profile.IProfileService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.driver.DriverOverflowMenuDisplayManager;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.ui.SlideMenuController;

public final class DriverToolbar$$InjectAdapter
  extends Binding<DriverToolbar>
{
  private Binding<DialogFlow> dialogFlow;
  private Binding<DriverOverflowMenuDisplayManager> driverOverflowMenuDisplayManager;
  private Binding<ImageLoader> imageLoader;
  private Binding<IProfileService> profileService;
  private Binding<SlideMenuController> slideMenuController;
  
  public DriverToolbar$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.controls.DriverToolbar", false, DriverToolbar.class);
  }
  
  public void attach(Linker paramLinker)
  {
    imageLoader = paramLinker.requestBinding("me.lyft.android.managers.ImageLoader", DriverToolbar.class, getClass().getClassLoader());
    profileService = paramLinker.requestBinding("me.lyft.android.application.profile.IProfileService", DriverToolbar.class, getClass().getClassLoader());
    slideMenuController = paramLinker.requestBinding("me.lyft.android.ui.SlideMenuController", DriverToolbar.class, getClass().getClassLoader());
    driverOverflowMenuDisplayManager = paramLinker.requestBinding("me.lyft.android.domain.driver.DriverOverflowMenuDisplayManager", DriverToolbar.class, getClass().getClassLoader());
    dialogFlow = paramLinker.requestBinding("me.lyft.android.common.DialogFlow", DriverToolbar.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(imageLoader);
    paramSet2.add(profileService);
    paramSet2.add(slideMenuController);
    paramSet2.add(driverOverflowMenuDisplayManager);
    paramSet2.add(dialogFlow);
  }
  
  public void injectMembers(DriverToolbar paramDriverToolbar)
  {
    imageLoader = ((ImageLoader)imageLoader.get());
    profileService = ((IProfileService)profileService.get());
    slideMenuController = ((SlideMenuController)slideMenuController.get());
    driverOverflowMenuDisplayManager = ((DriverOverflowMenuDisplayManager)driverOverflowMenuDisplayManager.get());
    dialogFlow = ((DialogFlow)dialogFlow.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.DriverToolbar..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */