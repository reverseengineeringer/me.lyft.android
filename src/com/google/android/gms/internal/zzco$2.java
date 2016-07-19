package com.google.android.gms.internal;

import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;

class zzco$2
  implements Runnable
{
  ValueCallback<String> zzasq = new ValueCallback()
  {
    public void zzz(String paramAnonymousString)
    {
      zzasp.zza(zzasr, zzass, paramAnonymousString, zzast);
    }
  };
  
  zzco$2(zzco paramzzco, zzcl paramzzcl, WebView paramWebView, boolean paramBoolean) {}
  
  public void run()
  {
    if (zzass.getSettings().getJavaScriptEnabled()) {}
    try
    {
      zzass.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", zzasq);
      return;
    }
    catch (Throwable localThrowable)
    {
      zzasq.onReceiveValue("");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzco.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */