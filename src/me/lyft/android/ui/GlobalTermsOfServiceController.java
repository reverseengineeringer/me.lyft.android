package me.lyft.android.ui;

import android.content.res.Resources;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import com.lyft.scoop.Screen;
import com.lyft.widgets.ProgressButton;
import java.util.regex.Pattern;
import javax.inject.Inject;
import me.lyft.android.application.terms.ITermsService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Spannables;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.webview.WebviewInitializer;

public class GlobalTermsOfServiceController
  extends RxViewController
{
  ProgressButton actionButton;
  private final AppFlow appFlow;
  View closeButton;
  private final IViewErrorHandler defaultErrorHandler;
  private final GlobalTermsOfServiceAnalytics globalTermsOfServiceAnalytics;
  TextView linkButton;
  private final ITermsService termsService;
  WebView webview;
  private final WebviewInitializer webviewInitializer;
  
  @Inject
  public GlobalTermsOfServiceController(AppFlow paramAppFlow, ITermsService paramITermsService, IViewErrorHandler paramIViewErrorHandler, WebviewInitializer paramWebviewInitializer, GlobalTermsOfServiceAnalytics paramGlobalTermsOfServiceAnalytics)
  {
    appFlow = paramAppFlow;
    termsService = paramITermsService;
    defaultErrorHandler = paramIViewErrorHandler;
    webviewInitializer = paramWebviewInitializer;
    globalTermsOfServiceAnalytics = paramGlobalTermsOfServiceAnalytics;
  }
  
  private void bindActionButton()
  {
    actionButton.setOnClickListener(new GlobalTermsOfServiceController.1(this));
  }
  
  private void bindCancelButton()
  {
    closeButton.setOnClickListener(new GlobalTermsOfServiceController.3(this));
  }
  
  private void onClickAcceptButton()
  {
    actionButton.showProgress();
    globalTermsOfServiceAnalytics.trackInitiation();
    binder.bindAsyncCall(termsService.acceptTermsOfService(), new GlobalTermsOfServiceController.2(this));
  }
  
  private void setupWebview(String paramString)
  {
    webviewInitializer.setupWebview(webview, paramString);
  }
  
  private void styleLinkText(String paramString)
  {
    Pattern localPattern = Pattern.compile(getResources().getString(2131165731), 2);
    paramString = new GlobalTermsOfServiceController.4(this, paramString);
    UnderlineSpan localUnderlineSpan = new UnderlineSpan();
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(getResources().getColor(2131493004));
    paramString = Spannables.scanAndSpan(linkButton.getText(), localPattern, new Object[] { paramString, localUnderlineSpan, localForegroundColorSpan });
    linkButton.setText(paramString);
    linkButton.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  protected int layoutId()
  {
    return 2130903240;
  }
  
  public void onAttach()
  {
    super.onAttach();
    MainScreens.GlobalTermsOfServiceScreen localGlobalTermsOfServiceScreen = (MainScreens.GlobalTermsOfServiceScreen)Screen.fromController(this);
    bindCancelButton();
    bindActionButton();
    styleLinkText(termsOfServiceUrl);
    setupWebview(onboardingUrl);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.GlobalTermsOfServiceController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */