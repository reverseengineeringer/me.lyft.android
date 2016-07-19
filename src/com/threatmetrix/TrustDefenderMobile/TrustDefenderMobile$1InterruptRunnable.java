package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;

final class TrustDefenderMobile$1InterruptRunnable
  implements Runnable
{
  final Thread t;
  
  TrustDefenderMobile$1InterruptRunnable(TrustDefenderMobile paramTrustDefenderMobile, Thread paramThread)
  {
    t = paramThread;
  }
  
  public void run()
  {
    Log.d(TrustDefenderMobile.access$000(), "sending interrupt to TID: " + t.getId());
    t.interrupt();
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.TrustDefenderMobile.1InterruptRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */