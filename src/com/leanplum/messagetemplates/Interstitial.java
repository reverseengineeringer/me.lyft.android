package com.leanplum.messagetemplates;

import android.app.Activity;
import android.content.Context;
import com.leanplum.Leanplum;

public class Interstitial
  extends BaseMessageDialog
{
  public Interstitial(Activity paramActivity, InterstitialOptions paramInterstitialOptions)
  {
    super(paramActivity, true, paramInterstitialOptions, null);
    options = paramInterstitialOptions;
  }
  
  public static void register(Context paramContext)
  {
    Leanplum.defineAction("Interstitial", Leanplum.ACTION_KIND_MESSAGE | Leanplum.ACTION_KIND_ACTION, InterstitialOptions.toArgs(paramContext), new r());
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.Interstitial
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */