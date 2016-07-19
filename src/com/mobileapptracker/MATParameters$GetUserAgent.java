package com.mobileapptracker;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.ref.WeakReference;

class MATParameters$GetUserAgent
  implements Runnable
{
  private final WeakReference<Context> weakContext;
  
  public MATParameters$GetUserAgent(MATParameters paramMATParameters, Context paramContext)
  {
    weakContext = new WeakReference(paramContext);
  }
  
  public void run()
  {
    try
    {
      WebView localWebView = new WebView((Context)weakContext.get());
      String str = localWebView.getSettings().getUserAgentString();
      localWebView.destroy();
      MATParameters.access$100(this$0, str);
      return;
    }
    catch (VerifyError localVerifyError) {}catch (Exception localException) {}
  }
}

/* Location:
 * Qualified Name:     com.mobileapptracker.MATParameters.GetUserAgent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */