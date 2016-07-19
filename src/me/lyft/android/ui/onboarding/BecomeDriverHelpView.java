package me.lyft.android.ui.onboarding;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.ui.WebBrowserView;

public class BecomeDriverHelpView
  extends LinearLayout
{
  @Inject
  ILyftPreferences lyftPreferences;
  Toolbar toolbar;
  WebBrowserView webBrowserView;
  
  public BecomeDriverHelpView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private String getHelpUrl()
  {
    return lyftPreferences.getLyftWebRoot() + "/applicants/help?v2=true";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    webBrowserView.setTargetUrl(getHelpUrl());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this, this);
    toolbar.setTitle(getContext().getString(2131165322));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.onboarding.BecomeDriverHelpView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */