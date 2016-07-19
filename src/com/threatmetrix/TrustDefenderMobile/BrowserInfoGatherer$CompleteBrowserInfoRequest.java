package com.threatmetrix.TrustDefenderMobile;

import java.util.concurrent.CountDownLatch;

class BrowserInfoGatherer$CompleteBrowserInfoRequest
  implements Runnable
{
  BrowserInfoGatherer m_info = null;
  CountDownLatch m_latch = null;
  
  public BrowserInfoGatherer$CompleteBrowserInfoRequest(BrowserInfoGatherer paramBrowserInfoGatherer, CountDownLatch paramCountDownLatch)
  {
    m_info = paramBrowserInfoGatherer;
    m_latch = paramCountDownLatch;
  }
  
  public void run()
  {
    throw new NoSuchMethodError();
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.BrowserInfoGatherer.CompleteBrowserInfoRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */