package com.appboy.ui.inappmessage.factories;

import android.app.Activity;
import android.view.LayoutInflater;
import com.appboy.models.IInAppMessage;
import com.appboy.models.InAppMessageHtmlFull;
import com.appboy.ui.R.layout;
import com.appboy.ui.inappmessage.IInAppMessageViewFactory;
import com.appboy.ui.inappmessage.InAppMessageWebViewClient;
import com.appboy.ui.inappmessage.listeners.IInAppMessageWebViewClientListener;
import com.appboy.ui.inappmessage.views.AppboyInAppMessageHtmlFullView;

public class AppboyHtmlFullViewFactory
  implements IInAppMessageViewFactory
{
  private IInAppMessageWebViewClientListener mInAppMessageWebViewClientListener;
  
  public AppboyHtmlFullViewFactory(IInAppMessageWebViewClientListener paramIInAppMessageWebViewClientListener)
  {
    mInAppMessageWebViewClientListener = paramIInAppMessageWebViewClientListener;
  }
  
  public AppboyInAppMessageHtmlFullView createInAppMessageView(Activity paramActivity, IInAppMessage paramIInAppMessage)
  {
    InAppMessageHtmlFull localInAppMessageHtmlFull = (InAppMessageHtmlFull)paramIInAppMessage;
    paramActivity = (AppboyInAppMessageHtmlFullView)paramActivity.getLayoutInflater().inflate(R.layout.com_appboy_inappmessage_html_full, null);
    paramActivity.setWebViewContent(paramIInAppMessage.getMessage(), localInAppMessageHtmlFull.getLocalAssetsDirectoryUrl());
    paramActivity.setInAppMessageWebViewClient(new InAppMessageWebViewClient(paramIInAppMessage, mInAppMessageWebViewClientListener));
    return paramActivity;
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.factories.AppboyHtmlFullViewFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */