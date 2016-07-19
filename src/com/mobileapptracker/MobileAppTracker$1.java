package com.mobileapptracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class MobileAppTracker$1
  extends BroadcastReceiver
{
  MobileAppTracker$1(MobileAppTracker paramMobileAppTracker) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this$0.isRegistered) {
      this$0.dumpQueue();
    }
  }
}

/* Location:
 * Qualified Name:     com.mobileapptracker.MobileAppTracker.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */