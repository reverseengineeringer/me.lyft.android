package me.lyft.android.ui.onboarding;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.studies.CarpoolOnboardingAnalytics;
import me.lyft.android.application.settings.ISignUrlService;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.WebBrowserView;
import me.lyft.android.utils.WebBrowser;

public class CarpoolWebApplicationStatusView
  extends LinearLayout
{
  @Inject
  ILyftPreferences lyftPreferences;
  @Inject
  ISignUrlService signUrlService;
  Toolbar toolbar;
  private final String unsignedApplyUrl;
  @Inject
  WebBrowser webBrowser;
  WebBrowserView webBrowserView;
  
  public CarpoolWebApplicationStatusView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    CarpoolOnboardingAnalytics.trackResumeButtonShown();
    unsignedApplyUrl = (lyftPreferences.getLyftWebRoot() + "/carpool/drive/apply");
  }
  
  private void loadResumeUrl(String paramString)
  {
    webBrowserView.setOnOverrideUrlLoadingListener(new CarpoolWebApplicationStatusView.2(this, paramString));
    paramString = lyftPreferences.getLyftWebRoot() + "/carpool/drive/resume";
    webBrowserView.setTargetUrl(paramString);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Binder.attach(this).bind(signUrlService.getSignedUrl(unsignedApplyUrl), new CarpoolWebApplicationStatusView.1(this));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this, this);
    toolbar.setTitle(getContext().getString(2131166304));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.onboarding.CarpoolWebApplicationStatusView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */