package com.appboy.ui.inappmessage;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appboy.Constants;
import com.appboy.models.IInAppMessage;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import com.appboy.ui.inappmessage.listeners.IInAppMessageWebViewClientListener;
import com.appboy.ui.support.UriUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class InAppMessageWebViewClient
  extends WebViewClient
{
  private static final String APPBOY_INAPP_MESSAGE_SCHEME = "appboy";
  private static final String AUTHORITY_NAME_CLOSE = "close";
  private static final String AUTHORITY_NAME_CUSTOM_EVENT = "customEvent";
  private static final String AUTHORITY_NAME_NEWSFEED = "feed";
  public static final String QUERY_NAME_BUTTON_ID = "abButtonId";
  public static final String QUERY_NAME_EXTERNAL_OPEN = "abExternalOpen";
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, InAppMessageWebViewClient.class.getName() });
  private final IInAppMessage mInAppMessage;
  private IInAppMessageWebViewClientListener mInAppMessageWebViewClientListener;
  
  public InAppMessageWebViewClient(IInAppMessage paramIInAppMessage, IInAppMessageWebViewClientListener paramIInAppMessageWebViewClientListener)
  {
    mInAppMessageWebViewClientListener = paramIInAppMessageWebViewClientListener;
    mInAppMessage = paramIInAppMessage;
  }
  
  static Bundle getBundleFromUrl(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (StringUtils.isNullOrBlank(paramString)) {}
    for (;;)
    {
      return localBundle;
      paramString = UriUtils.getQueryParameters(Uri.parse(paramString));
      Iterator localIterator = paramString.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localBundle.putString(str, (String)paramString.get(str));
      }
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (mInAppMessageWebViewClientListener == null) {
      AppboyLogger.i(TAG, "InAppMessageWebViewClient was given null IInAppMessageWebViewClientListener listener. Returning true.");
    }
    Object localObject;
    do
    {
      return true;
      if (StringUtils.isNullOrBlank(paramString))
      {
        AppboyLogger.i(TAG, "InAppMessageWebViewClient.shouldOverrideUrlLoading was given null or blank url. Returning true.");
        return true;
      }
      localObject = Uri.parse(paramString);
      paramWebView = getBundleFromUrl(paramString);
      if (!((Uri)localObject).getScheme().equals("appboy")) {
        break;
      }
      localObject = ((Uri)localObject).getAuthority();
      if (((String)localObject).equals("close"))
      {
        mInAppMessageWebViewClientListener.onCloseAction(mInAppMessage, paramString, paramWebView);
        return true;
      }
      if (((String)localObject).equals("feed"))
      {
        mInAppMessageWebViewClientListener.onNewsfeedAction(mInAppMessage, paramString, paramWebView);
        return true;
      }
    } while (!((String)localObject).equals("customEvent"));
    mInAppMessageWebViewClientListener.onCustomEventAction(mInAppMessage, paramString, paramWebView);
    return true;
    mInAppMessageWebViewClientListener.onOtherUrlAction(mInAppMessage, paramString, paramWebView);
    return true;
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.InAppMessageWebViewClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */