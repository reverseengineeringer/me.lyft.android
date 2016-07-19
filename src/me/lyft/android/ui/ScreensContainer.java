package me.lyft.android.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.lyft.scoop.ScreenScooper;
import com.lyft.scoop.UiContainer;
import com.lyft.scoop.ViewControllerInflater;
import com.lyft.scoop.dagger.DaggerScreenScoopFactory;
import com.lyft.scoop.dagger.DaggerViewControllerInflater;

public class ScreensContainer
  extends UiContainer
{
  private final ScreenScooper screenScooper = new ScreenScooper(new DaggerScreenScoopFactory());
  private final ViewControllerInflater viewControllerInflater = new DaggerViewControllerInflater();
  
  public ScreensContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected ScreenScooper getScreenScooper()
  {
    return screenScooper;
  }
  
  protected ViewControllerInflater getViewControllerInflater()
  {
    return viewControllerInflater;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.ScreensContainer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */