package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.internal.zzaa;
import java.net.URI;
import java.net.URISyntaxException;

@zzir
public class zzlv
  extends WebViewClient
{
  private final zzll zzbgj;
  private final zzid zzbyk;
  private final String zzcqp = zzdg(paramString);
  private boolean zzcqq = false;
  
  public zzlv(zzid paramzzid, zzll paramzzll, String paramString)
  {
    zzbgj = paramzzll;
    zzbyk = paramzzid;
  }
  
  private String zzdg(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      try
      {
        if (paramString.endsWith("/"))
        {
          String str = paramString.substring(0, paramString.length() - 1);
          return str;
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        zzkh.e(localIndexOutOfBoundsException.getMessage());
      }
    }
    return paramString;
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    paramWebView = String.valueOf(paramString);
    if (paramWebView.length() != 0) {}
    for (paramWebView = "JavascriptAdWebViewClient::onLoadResource: ".concat(paramWebView);; paramWebView = new String("JavascriptAdWebViewClient::onLoadResource: "))
    {
      zzkh.zzcw(paramWebView);
      if (!zzdf(paramString)) {
        zzbgj.zzuk().onLoadResource(zzbgj.getWebView(), paramString);
      }
      return;
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    paramWebView = String.valueOf(paramString);
    if (paramWebView.length() != 0) {}
    for (paramWebView = "JavascriptAdWebViewClient::onPageFinished: ".concat(paramWebView);; paramWebView = new String("JavascriptAdWebViewClient::onPageFinished: "))
    {
      zzkh.zzcw(paramWebView);
      if (!zzcqq)
      {
        zzbyk.zzqa();
        zzcqq = true;
      }
      return;
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    paramWebView = String.valueOf(paramString);
    if (paramWebView.length() != 0) {}
    for (paramWebView = "JavascriptAdWebViewClient::shouldOverrideUrlLoading: ".concat(paramWebView);; paramWebView = new String("JavascriptAdWebViewClient::shouldOverrideUrlLoading: "))
    {
      zzkh.zzcw(paramWebView);
      if (!zzdf(paramString)) {
        break;
      }
      zzkh.zzcw("shouldOverrideUrlLoading: received passback url");
      return true;
    }
    return zzbgj.zzuk().shouldOverrideUrlLoading(zzbgj.getWebView(), paramString);
  }
  
  protected boolean zzdf(String paramString)
  {
    paramString = zzdg(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject1 = new URI(paramString);
        if ("passback".equals(((URI)localObject1).getScheme()))
        {
          zzkh.zzcw("Passback received");
          zzbyk.zzqb();
          return true;
        }
        if (!TextUtils.isEmpty(zzcqp))
        {
          Object localObject2 = new URI(zzcqp);
          paramString = ((URI)localObject2).getHost();
          String str = ((URI)localObject1).getHost();
          localObject2 = ((URI)localObject2).getPath();
          localObject1 = ((URI)localObject1).getPath();
          if ((zzaa.equal(paramString, str)) && (zzaa.equal(localObject2, localObject1)))
          {
            zzkh.zzcw("Passback received");
            zzbyk.zzqb();
            return true;
          }
        }
      }
      catch (URISyntaxException paramString)
      {
        zzkh.e(paramString.getMessage());
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */