package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import java.util.concurrent.CountDownLatch;

class BrowserInfoGatherer$2
  extends BrowserInfoGatherer.CompleteBrowserInfoRequest
{
  BrowserInfoGatherer$2(BrowserInfoGatherer paramBrowserInfoGatherer1, BrowserInfoGatherer paramBrowserInfoGatherer2, CountDownLatch paramCountDownLatch)
  {
    super(paramBrowserInfoGatherer2, paramCountDownLatch);
  }
  
  public void run()
  {
    try
    {
      Log.d(BrowserInfoGatherer.access$000(), "Calling getBrowserInfo() - on UI thread");
      BrowserInfoGatherer.access$500(m_info);
      if (m_latch != null)
      {
        Log.d(BrowserInfoGatherer.access$000(), "getBrowserInfo countdown using latch: " + m_latch.hashCode() + " with count: " + m_latch.getCount());
        m_latch.countDown();
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Log.d(BrowserInfoGatherer.access$000(), "getBrowserInfo interrupted", localInterruptedException);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.BrowserInfoGatherer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */