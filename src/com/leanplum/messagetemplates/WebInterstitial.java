package com.leanplum.messagetemplates;

import android.app.Activity;
import android.content.Context;
import com.leanplum.Leanplum;

public class WebInterstitial
  extends BaseMessageDialog
{
  public WebInterstitial(Activity paramActivity, WebInterstitialOptions paramWebInterstitialOptions)
  {
    super(paramActivity, true, null, paramWebInterstitialOptions);
    webOptions = paramWebInterstitialOptions;
  }
  
  public static void register(Context paramContext)
  {
    Leanplum.defineAction("Web Interstitial", Leanplum.ACTION_KIND_MESSAGE | Leanplum.ACTION_KIND_ACTION, WebInterstitialOptions.toArgs(paramContext), new v());
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.WebInterstitial
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */