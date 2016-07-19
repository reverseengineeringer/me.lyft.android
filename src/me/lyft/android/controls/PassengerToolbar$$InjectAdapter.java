package me.lyft.android.controls;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.ui.SlideMenuController;

public final class PassengerToolbar$$InjectAdapter
  extends Binding<PassengerToolbar>
{
  private Binding<ImageLoader> imageLoader;
  private Binding<SlideMenuController> slideMenuController;
  private Binding<IUserProvider> userProvider;
  
  public PassengerToolbar$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.controls.PassengerToolbar", false, PassengerToolbar.class);
  }
  
  public void attach(Linker paramLinker)
  {
    imageLoader = paramLinker.requestBinding("me.lyft.android.managers.ImageLoader", PassengerToolbar.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", PassengerToolbar.class, getClass().getClassLoader());
    slideMenuController = paramLinker.requestBinding("me.lyft.android.ui.SlideMenuController", PassengerToolbar.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(imageLoader);
    paramSet2.add(userProvider);
    paramSet2.add(slideMenuController);
  }
  
  public void injectMembers(PassengerToolbar paramPassengerToolbar)
  {
    imageLoader = ((ImageLoader)imageLoader.get());
    userProvider = ((IUserProvider)userProvider.get());
    slideMenuController = ((SlideMenuController)slideMenuController.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.PassengerToolbar..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */