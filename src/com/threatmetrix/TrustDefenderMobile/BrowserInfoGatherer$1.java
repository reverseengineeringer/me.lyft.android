package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import java.util.concurrent.CountDownLatch;

class BrowserInfoGatherer$1
  extends BrowserInfoGatherer.CompleteBrowserInfoRequest
{
  BrowserInfoGatherer$1(BrowserInfoGatherer paramBrowserInfoGatherer1, BrowserInfoGatherer paramBrowserInfoGatherer2, CountDownLatch paramCountDownLatch)
  {
    super(paramBrowserInfoGatherer2, paramCountDownLatch);
  }
  
  public void run()
  {
    Log.d(BrowserInfoGatherer.access$000(), "Calling initJSExecutor() - on UI thread");
    BrowserInfoGatherer.access$102(m_info, new JSExecutor(BrowserInfoGatherer.access$200(this$0), BrowserInfoGatherer.access$300(this$0), BrowserInfoGatherer.access$400(this$0)));
    try
    {
      BrowserInfoGatherer.access$100(m_info).init();
      Log.d(BrowserInfoGatherer.access$000(), "js exec init complete");
      if (m_latch != null)
      {
        Log.d(BrowserInfoGatherer.access$000(), "js exec init countdown using latch: " + m_latch.hashCode() + " with count: " + m_latch.getCount());
        m_latch.countDown();
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Log.e(BrowserInfoGatherer.access$000(), "Interrupted initing js engine");
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.BrowserInfoGatherer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */