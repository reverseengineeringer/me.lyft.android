package com.threatmetrix.TrustDefenderMobile;

import java.util.concurrent.CountDownLatch;

class CompleteProfile
  implements Runnable
{
  private CountDownLatch latch = null;
  private TrustDefenderMobile profile = null;
  
  public CompleteProfile(TrustDefenderMobile paramTrustDefenderMobile)
  {
    profile = paramTrustDefenderMobile;
    latch = null;
  }
  
  public void run()
  {
    profile.completeProfileRequest();
    if (latch != null) {
      latch.countDown();
    }
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.CompleteProfile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */