package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.WebView;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SingletonWebView
{
  private static final String TAG = StringUtils.getLogTag(SingletonWebView.class);
  private static Context m_context;
  private static final Lock s_lock;
  private static volatile WebView s_webView = null;
  
  static
  {
    s_lock = new ReentrantLock();
    m_context = null;
  }
  
  public static void clearWebView()
  {
    try
    {
      s_lock.lock();
      if (s_webView != null)
      {
        WebView localWebView = s_webView;
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            val$tempWebView.removeAllViews();
            val$tempWebView.destroy();
          }
        });
      }
      s_webView = null;
      return;
    }
    finally
    {
      s_lock.unlock();
    }
  }
  
  public static WebView getInstance(Context paramContext)
  {
    if ((m_context != null) && (m_context != paramContext))
    {
      Log.e(TAG, "Mismatched context: Only application context should be used, and it should always be consistent between calls");
      return null;
    }
    if (s_webView == null) {}
    for (;;)
    {
      try
      {
        s_lock.lock();
        if (s_webView == null)
        {
          s_webView = new WebView(paramContext);
          m_context = paramContext;
        }
        return s_webView;
      }
      finally
      {
        s_lock.unlock();
      }
      Log.d(TAG, "Reusing webview");
    }
  }
  
  /* Error */
  public static boolean hasWebView()
  {
    // Byte code:
    //   0: getstatic 25	com/threatmetrix/TrustDefenderMobile/SingletonWebView:s_lock	Ljava/util/concurrent/locks/Lock;
    //   3: invokeinterface 43 1 0
    //   8: getstatic 18	com/threatmetrix/TrustDefenderMobile/SingletonWebView:s_webView	Landroid/webkit/WebView;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnull +15 -> 28
    //   16: iconst_1
    //   17: istore_0
    //   18: getstatic 25	com/threatmetrix/TrustDefenderMobile/SingletonWebView:s_lock	Ljava/util/concurrent/locks/Lock;
    //   21: invokeinterface 64 1 0
    //   26: iload_0
    //   27: ireturn
    //   28: iconst_0
    //   29: istore_0
    //   30: goto -12 -> 18
    //   33: astore_1
    //   34: getstatic 25	com/threatmetrix/TrustDefenderMobile/SingletonWebView:s_lock	Ljava/util/concurrent/locks/Lock;
    //   37: invokeinterface 64 1 0
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	13	0	bool	boolean
    //   11	2	1	localWebView	WebView
    //   33	10	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	12	33	finally
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.SingletonWebView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */