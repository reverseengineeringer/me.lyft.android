package com.appboy.ui;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

class AppboyWebViewActivity$2
  implements DownloadListener
{
  AppboyWebViewActivity$2(AppboyWebViewActivity paramAppboyWebViewActivity) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    paramString2 = new Intent("android.intent.action.VIEW");
    paramString2.setData(Uri.parse(paramString1));
    this$0.startActivity(paramString2);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.AppboyWebViewActivity.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */