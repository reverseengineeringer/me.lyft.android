package me.lyft.android.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.LyftApplication;
import me.lyft.android.analytics.studies.OnBoardingAnalytics;
import me.lyft.android.application.invite.IWarmWelcomeService;
import me.lyft.android.common.Strings;

public class ReferrerBroadcastReceiver
  extends BroadcastReceiver
{
  @Inject
  ILyftPreferences preferences;
  @Inject
  IWarmWelcomeService warmWelcomeService;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    LyftApplication.from(paramContext).inject(this);
    paramContext = paramIntent.getStringExtra("referrer");
    warmWelcomeService.checkForWarmWelcomeAssignment(paramContext);
    OnBoardingAnalytics.trackReceiveReferral(paramContext);
    if ((!Strings.isNullOrEmpty(paramContext)) && (Strings.isNullOrEmpty(preferences.getInstallReferrer()))) {
      preferences.setInstallReferrer(paramContext);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.receivers.ReferrerBroadcastReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */