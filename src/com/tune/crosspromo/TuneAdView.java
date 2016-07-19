package com.tune.crosspromo;

import android.webkit.WebView;
import java.net.URLEncoder;

public class TuneAdView
{
  public boolean loaded;
  public boolean loading;
  public TuneAdMetadata metadata;
  public String placement;
  public String requestId;
  public WebView webView;
  
  public TuneAdView(String paramString, TuneAdMetadata paramTuneAdMetadata, WebView paramWebView)
  {
    placement = paramString;
    metadata = paramTuneAdMetadata;
    webView = paramWebView;
  }
  
  public void loadView(String paramString)
  {
    try
    {
      webView.loadData(URLEncoder.encode(paramString, "utf-8").replaceAll("\\+", " "), "text/html", "utf-8");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}

/* Location:
 * Qualified Name:     com.tune.crosspromo.TuneAdView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */