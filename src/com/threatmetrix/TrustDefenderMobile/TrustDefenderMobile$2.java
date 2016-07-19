package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;

class TrustDefenderMobile$2
  extends CompleteProfile
{
  TrustDefenderMobile$2(TrustDefenderMobile paramTrustDefenderMobile1, TrustDefenderMobile paramTrustDefenderMobile2, long paramLong, int paramInt1, int paramInt2, TrustDefenderMobile.PackageScanCallSource paramPackageScanCallSource)
  {
    super(paramTrustDefenderMobile2);
  }
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if ((val$allowedScanOptions & 0x3000) != 0L) {
          i = 0x0 | 0x2;
        }
        if ((val$allowedScanOptions & 0x4000) == 0L)
        {
          j = i;
          if ((val$allowedScanOptions & 0x2000) == 0L)
          {
            NativeGatherer.getInstance().findPackages(TrustDefenderMobile.access$400(this$0), j, val$package_limit, val$timeout);
            return;
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        return;
      }
      finally
      {
        Log.d(TrustDefenderMobile.access$000(), "doPackageScan(" + val$source + "): complete");
        this$0.m_state.endScanning();
      }
      int j = i | 0x1;
    }
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.TrustDefenderMobile.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */