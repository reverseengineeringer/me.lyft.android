package me.lyft.android.ui.onboarding;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.MainScreensRouter;

public class CarpoolDriverOnboardingToolbarView
  extends Toolbar
{
  private Binder binder;
  @Inject
  MainScreensRouter mainScreensRouter;
  
  public CarpoolDriverOnboardingToolbarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    binder.bind(observeItemClick(), new CarpoolDriverOnboardingToolbarView.1(this));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setTitle(getResources().getString(2131165404)).addItem(2131558446, getResources().getString(2131165403), 0, getResources().getColor(2131493004), 1);
    setHomeIconVisible(false);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.onboarding.CarpoolDriverOnboardingToolbarView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */