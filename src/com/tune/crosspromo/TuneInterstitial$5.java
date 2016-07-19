package com.tune.crosspromo;

class TuneInterstitial$5
  implements Runnable
{
  TuneInterstitial$5(TuneInterstitial paramTuneInterstitial, String paramString) {}
  
  public void run()
  {
    if (TuneInterstitial.access$500(this$0) != null) {
      TuneInterstitial.access$500(this$0).onAdLoadFailed(this$0, val$error);
    }
  }
}

/* Location:
 * Qualified Name:     com.tune.crosspromo.TuneInterstitial.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */