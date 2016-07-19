package bolts;

import android.webkit.WebView;
import android.webkit.WebViewClient;

class WebViewAppLinkResolver$2$1
  extends WebViewClient
{
  private boolean loaded = false;
  
  WebViewAppLinkResolver$2$1(WebViewAppLinkResolver.2 param2) {}
  
  private void runJavaScript(WebView paramWebView)
  {
    if (!loaded)
    {
      loaded = true;
      paramWebView.loadUrl("javascript:boltsWebViewAppLinkResolverResult.setValue((function() {  var metaTags = document.getElementsByTagName('meta');  var results = [];  for (var i = 0; i < metaTags.length; i++) {    var property = metaTags[i].getAttribute('property');    if (property && property.substring(0, 'al:'.length) === 'al:') {      var tag = { \"property\": metaTags[i].getAttribute('property') };      if (metaTags[i].hasAttribute('content')) {        tag['content'] = metaTags[i].getAttribute('content');      }      results.push(tag);    }  }  return JSON.stringify(results);})())");
    }
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    super.onLoadResource(paramWebView, paramString);
    runJavaScript(paramWebView);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    runJavaScript(paramWebView);
  }
}

/* Location:
 * Qualified Name:     bolts.WebViewAppLinkResolver.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */