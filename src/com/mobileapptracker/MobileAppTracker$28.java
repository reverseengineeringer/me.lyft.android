package com.mobileapptracker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

class MobileAppTracker$28
  implements Runnable
{
  MobileAppTracker$28(MobileAppTracker paramMobileAppTracker, Activity paramActivity) {}
  
  public void run()
  {
    this$0.params.setReferralSource(val$act.getCallingPackage());
    Object localObject = val$act.getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getData();
      if (localObject != null) {
        this$0.params.setReferralUrl(((Uri)localObject).toString());
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.mobileapptracker.MobileAppTracker.28
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */