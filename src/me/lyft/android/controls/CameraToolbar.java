package me.lyft.android.controls;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.common.AppFlow;

public class CameraToolbar
  extends Toolbar
{
  @Inject
  AppFlow appFlow;
  View toolbarContainer;
  
  public CameraToolbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CameraToolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CameraToolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    DaggerInjector.fromView(this).inject(this);
    init();
  }
  
  private void init()
  {
    setBackgroundColor(getResources().getColor(2131492865));
    toolbarContainer.setBackgroundColor(getResources().getColor(2131492865));
    homeView.setBackgroundResource(2130837510);
    homeImageView.setBackgroundResource(2130837510);
    setHomeIcon(2130838173);
    titleTextView.setTextColor(getResources().getColor(2131493083));
    dividerView.setVisibility(8);
  }
  
  protected void onHomeClick()
  {
    super.onHomeClick();
    appFlow.goBack();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.CameraToolbar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */