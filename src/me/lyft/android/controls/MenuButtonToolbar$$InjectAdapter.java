package me.lyft.android.controls;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.ui.SlideMenuController;

public final class MenuButtonToolbar$$InjectAdapter
  extends Binding<MenuButtonToolbar>
{
  private Binding<SlideMenuController> slideMenuController;
  private Binding<Toolbar> supertype;
  
  public MenuButtonToolbar$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.controls.MenuButtonToolbar", false, MenuButtonToolbar.class);
  }
  
  public void attach(Linker paramLinker)
  {
    slideMenuController = paramLinker.requestBinding("me.lyft.android.ui.SlideMenuController", MenuButtonToolbar.class, getClass().getClassLoader());
    supertype = paramLinker.requestBinding("members/me.lyft.android.controls.Toolbar", MenuButtonToolbar.class, getClass().getClassLoader(), false, true);
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(slideMenuController);
    paramSet2.add(supertype);
  }
  
  public void injectMembers(MenuButtonToolbar paramMenuButtonToolbar)
  {
    slideMenuController = ((SlideMenuController)slideMenuController.get());
    supertype.injectMembers(paramMenuButtonToolbar);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.MenuButtonToolbar..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */