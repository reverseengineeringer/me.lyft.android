package com.appboy.ui.inappmessage.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.appboy.ui.inappmessage.IInAppMessageView;
import com.appboy.ui.inappmessage.InAppMessageWebViewClient;

public abstract class AppboyInAppMessageHtmlBaseView
  extends RelativeLayout
  implements IInAppMessageView
{
  private static final String FILE_URI_SCHEME_PREFIX = "file://";
  private static final String HTML_ENCODING = "utf-8";
  private static final String HTML_MIME_TYPE = "text/html";
  
  public AppboyInAppMessageHtmlBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public View getMessageClickableView()
  {
    return this;
  }
  
  public abstract WebView getMessageWebView();
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      InAppMessageViewUtils.closeInAppMessageOnKeycodeBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setInAppMessageWebViewClient(InAppMessageWebViewClient paramInAppMessageWebViewClient)
  {
    getMessageWebView().setWebViewClient(paramInAppMessageWebViewClient);
  }
  
  public void setWebViewContent(String paramString1, String paramString2)
  {
    getMessageWebView().loadDataWithBaseURL("file://" + paramString2 + "/", paramString1, "text/html", "utf-8", null);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.views.AppboyInAppMessageHtmlBaseView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */