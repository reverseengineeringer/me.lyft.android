package me.lyft.android.ui.enterprise;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.ui.MainScreensRouter;
import me.lyft.android.ui.SlideMenuController;

public class EnterpriseInviteCoworkersSelectScreenView
  extends LinearLayout
  implements HandleBack
{
  @Inject
  MainScreensRouter mainScreensRouter;
  @Inject
  SlideMenuController slideMenuController;
  Toolbar toolbar;
  
  public EnterpriseInviteCoworkersSelectScreenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    slideMenuController.enableMenu();
  }
  
  public boolean onBack()
  {
    mainScreensRouter.resetToHomeScreen();
    return true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    slideMenuController.disableMenu();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    toolbar.showTitle().setTitle(getContext().getString(2131166167));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.enterprise.EnterpriseInviteCoworkersSelectScreenView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */