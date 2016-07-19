package me.lyft.android.controls;

import android.content.Context;
import android.util.AttributeSet;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.ui.SlideMenuController;

public class MenuButtonToolbar
  extends Toolbar
{
  @Inject
  SlideMenuController slideMenuController;
  
  public MenuButtonToolbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MenuButtonToolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MenuButtonToolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode()) {
      return;
    }
    DaggerInjector.fromView(this).inject(this);
    setHomeIcon(2130838117);
  }
  
  protected void onHomeClick()
  {
    super.onHomeClick();
    slideMenuController.toggle();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.MenuButtonToolbar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */