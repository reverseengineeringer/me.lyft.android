package com.paypal.android.sdk;

import java.util.Timer;
import java.util.TimerTask;

final class ac
  extends TimerTask
{
  ac(aa paramaa) {}
  
  public final void run()
  {
    aa.d(a);
    if (aa.e(a))
    {
      aa.f(a).cancel();
      return;
    }
    try
    {
      aa.g(a);
      return;
    }
    catch (Exception localException)
    {
      ao.a("RiskComponent", "Error in logRiskMetadataTask: ", localException);
    }
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.ac
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */