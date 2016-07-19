package me.lyft.android.ui;

import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;

public class SlideMenuController
{
  private final DrawerLayout.DrawerListener drawerListener = new SlideMenuController.1(this);
  private final DrawerLayout menuDrawer;
  
  public SlideMenuController(DrawerLayout paramDrawerLayout)
  {
    menuDrawer = paramDrawerLayout;
    menuDrawer.setDrawerListener(drawerListener);
    disableMenu();
  }
  
  public void close()
  {
    if (menuDrawer.isDrawerOpen(8388611)) {
      menuDrawer.closeDrawer(8388611);
    }
  }
  
  public void disableMenu()
  {
    menuDrawer.setDrawerLockMode(1);
  }
  
  public void enableMenu()
  {
    menuDrawer.setDrawerLockMode(0);
  }
  
  public boolean isOpen()
  {
    return menuDrawer.isDrawerOpen(8388611);
  }
  
  public void open()
  {
    if (!menuDrawer.isDrawerOpen(8388611)) {
      menuDrawer.openDrawer(8388611);
    }
  }
  
  public void toggle()
  {
    if (isOpen())
    {
      close();
      return;
    }
    open();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.SlideMenuController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */