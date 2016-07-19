package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ProfileTracker$ProfileBroadcastReceiver
  extends BroadcastReceiver
{
  private ProfileTracker$ProfileBroadcastReceiver(ProfileTracker paramProfileTracker) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED".equals(paramIntent.getAction()))
    {
      paramContext = (Profile)paramIntent.getParcelableExtra("com.facebook.sdk.EXTRA_OLD_PROFILE");
      paramIntent = (Profile)paramIntent.getParcelableExtra("com.facebook.sdk.EXTRA_NEW_PROFILE");
      this$0.onCurrentProfileChanged(paramContext, paramIntent);
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.ProfileTracker.ProfileBroadcastReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */