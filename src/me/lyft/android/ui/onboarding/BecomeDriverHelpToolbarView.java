package me.lyft.android.ui.onboarding;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import javax.inject.Inject;
import me.lyft.android.common.AppFlow;
import me.lyft.android.controls.BackButtonToolbar;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.rx.Binder;

public class BecomeDriverHelpToolbarView
  extends BackButtonToolbar
{
  @Inject
  AppFlow appFlow;
  Binder binder;
  
  public BecomeDriverHelpToolbarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    binder.bind(observeItemClick(), new BecomeDriverHelpToolbarView.1(this));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setTitle(getResources().getString(2131165315)).addItem(2131558438, 2130838114);
  }
  
  public void showHelpButton(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      showItem(2131558438);
      return;
    }
    hideItem(2131558438);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.onboarding.BecomeDriverHelpToolbarView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */