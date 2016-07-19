package me.lyft.android.ui;

import android.content.res.Resources;
import android.view.View;
import android.webkit.WebView;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.Screen;
import com.lyft.scoop.ViewController;
import javax.inject.Inject;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.ui.webview.WebviewInitializer;

public class GlobalTermsOfServiceDetailController
  extends ViewController
  implements HandleBack
{
  private final WebviewInitializer initializer;
  Toolbar toolbar;
  WebView webview;
  
  @Inject
  public GlobalTermsOfServiceDetailController(WebviewInitializer paramWebviewInitializer)
  {
    initializer = paramWebviewInitializer;
  }
  
  private void setToolbarTitle()
  {
    toolbar.setTitle(getView().getResources().getString(2131165729));
  }
  
  private void setupWebview(String paramString)
  {
    initializer.setupWebview(webview, paramString);
  }
  
  protected int layoutId()
  {
    return 2130903239;
  }
  
  public void onAttach()
  {
    super.onAttach();
    MainScreens.GlobalTermsOfServiceDetailScreen localGlobalTermsOfServiceDetailScreen = (MainScreens.GlobalTermsOfServiceDetailScreen)Screen.fromController(this);
    setToolbarTitle();
    setupWebview(termsOfServiceUrl);
  }
  
  public boolean onBack()
  {
    if (webview.canGoBack())
    {
      webview.goBack();
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.GlobalTermsOfServiceDetailController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */