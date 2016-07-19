package me.lyft.android.controls;

import android.content.Context;
import android.util.AttributeSet;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.common.AppFlow;

public class BackButtonToolbar
  extends Toolbar
{
  @Inject
  AppFlow appFlow;
  
  public BackButtonToolbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BackButtonToolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BackButtonToolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode()) {
      return;
    }
    DaggerInjector.fromView(this).inject(this);
  }
  
  protected void onHomeClick()
  {
    super.onHomeClick();
    appFlow.goBack();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.BackButtonToolbar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */