package me.lyft.android.notifications;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import butterknife.ButterKnife;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.deeplinks.DeepLinkManager;
import me.lyft.android.events.GeneralErrorDialogResultEvent;
import me.lyft.android.infrastructure.notifications.InAppNotificationService;
import me.lyft.android.ui.Dialogs.AlertDialog;
import me.lyft.android.ui.Dialogs.InAppNotificationDialog;
import me.lyft.android.ui.dialogs.DialogContainerView;
import me.lyft.android.utils.WebBrowser;

public class InAppNotificationDialogView
  extends DialogContainerView
{
  ImageView cancelButton;
  @Inject
  IConstantsProvider constantsProvider;
  @Inject
  DeepLinkManager deepLinkManager;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  InAppNotificationService inAppNotificationService;
  private final String targetUrl;
  @Inject
  WebBrowser webBrowser;
  WebView webView;
  
  public InAppNotificationDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    targetUrl = ((Dialogs.InAppNotificationDialog)Screen.fromView(this)).getTargetUrl();
  }
  
  private boolean isWhiteListed(String paramString)
  {
    Iterator localIterator = ((List)constantsProvider.get(Constants.WHITELISTED_URLS)).iterator();
    while (localIterator.hasNext()) {
      if (paramString.startsWith((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  private void showErrorDialog()
  {
    Object localObject = getResources().getString(2131166431);
    String str = getResources().getString(2131166430);
    localObject = new Dialogs.AlertDialog("generic_error_dialog").setDialogEventClass(GeneralErrorDialogResultEvent.class).setTitle((String)localObject).addPositiveButton(getResources().getString(2131165939)).setMessage(str);
    dialogFlow.show((Screen)localObject);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isWhiteListed(targetUrl))
    {
      dialogFlow.dismiss();
      return;
    }
    if (!dialogFlow.hasActiveDialog()) {
      dialogFlow.dismiss();
    }
    WebSettings localWebSettings = webView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setCacheMode(1);
    localWebSettings.setDefaultTextEncodingName("utf-8");
    webView.setBackgroundColor(getResources().getColor(2131493084));
    webView.setWebViewClient(new InAppNotificationDialogView.1(this));
    cancelButton.setOnClickListener(new InAppNotificationDialogView.2(this));
    webView.loadUrl(targetUrl);
  }
  
  public boolean onBack()
  {
    inAppNotificationService.markNotificationAsShown(targetUrl);
    return super.onBack();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    inAppNotificationService.resetDidShowNotificationForSession();
    webView.setWebViewClient(null);
    webView.loadUrl("about:blank");
    webView.destroy();
    webView = null;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.notifications.InAppNotificationDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */