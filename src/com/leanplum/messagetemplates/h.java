package com.leanplum.messagetemplates;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.leanplum.Leanplum;

final class h
  extends WebViewClient
{
  h(BaseMessageDialog paramBaseMessageDialog) {}
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (paramString.contains(a.webOptions.getCloseUrl()))
    {
      a.cancel();
      paramWebView = paramString.split("\\?");
      int j;
      int i;
      if (paramWebView.length > 1)
      {
        paramWebView = paramWebView[1].split("&");
        j = paramWebView.length;
        i = 0;
      }
      for (;;)
      {
        if (i >= j) {
          return true;
        }
        paramString = paramWebView[i].split("=");
        if ((paramString.length > 1) && (paramString[0].equals("result"))) {
          Leanplum.track(paramString[1]);
        }
        i += 1;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */