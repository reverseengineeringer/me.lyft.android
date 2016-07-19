package com.threatmetrix.TrustDefenderMobile;

final class TrustDefenderMobile$1EndNotifierRunnable
  implements Runnable
{
  final EndNotifierBase notifier;
  final ProfilingResult result;
  
  TrustDefenderMobile$1EndNotifierRunnable(TrustDefenderMobile paramTrustDefenderMobile, ProfilingResult paramProfilingResult, EndNotifierBase paramEndNotifierBase)
  {
    result = paramProfilingResult;
    notifier = paramEndNotifierBase;
  }
  
  public void run()
  {
    if ((notifier != null) && ((notifier instanceof EndNotifier))) {
      ((EndNotifier)notifier).complete(result);
    }
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.TrustDefenderMobile.1EndNotifierRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */