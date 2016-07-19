package me.lyft.android.ui.onboarding;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.ats.IAtsService;
import me.lyft.android.application.settings.ISignUrlService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.domain.ats.DriverApplication;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.utils.WebBrowser;

public class WebApplicationStatusView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  TextView applicationCompletenessTextView;
  @Inject
  IAtsService atsService;
  private Binder binder;
  TextView completeApplicationSubtitleTextView;
  LinearLayout contentLayout;
  @Inject
  ILyftPreferences lyftPreferences;
  @Inject
  IProgressController progressController;
  Button resumeApplicationButton;
  @Inject
  ISignUrlService signUrlService;
  @Inject
  IViewErrorHandler viewErrorHandler;
  @Inject
  WebBrowser webBrowser;
  
  public WebApplicationStatusView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void initView(DriverApplication paramDriverApplication)
  {
    int i = paramDriverApplication.getWebOnboardingCompleteness().intValue();
    String str = getResources().getString(2131165316, new Object[] { Integer.valueOf(i) });
    applicationCompletenessTextView.setText(str);
    if (paramDriverApplication.isWebOnboardingComplete())
    {
      completeApplicationSubtitleTextView.setText(2131165319);
      resumeApplicationButton.setText(2131165318);
      return;
    }
    completeApplicationSubtitleTextView.setText(2131165320);
    resumeApplicationButton.setText(2131165324);
  }
  
  private void loadDriverApplication()
  {
    contentLayout.setVisibility(4);
    progressController.showProgress();
    binder.bind(atsService.getDriverApplication(), new WebApplicationStatusView.2(this));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder = Binder.attach(this);
    loadDriverApplication();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
  
  void onResumeApplicationClicked()
  {
    progressController.showProgress();
    String str = lyftPreferences.getLyftWebRoot() + "/drivers?from_app=1";
    binder.bind(signUrlService.getSignedUrl(str), new WebApplicationStatusView.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.onboarding.WebApplicationStatusView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */